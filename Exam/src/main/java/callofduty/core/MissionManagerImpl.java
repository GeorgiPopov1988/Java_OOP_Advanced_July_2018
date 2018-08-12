package callofduty.core;

import callofduty.domain.agents.MasterAgent;
import callofduty.domain.agents.NoviceAgent;
import callofduty.domain.missions.AbstractMission;
import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionControl;
import callofduty.interfaces.MissionManager;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MissionManagerImpl implements MissionManager {

    private Map<String, Agent> agents;
    private Map<String, Mission> missions;

    private MissionControl missionControl;

    public MissionManagerImpl () {

        this.agents = new LinkedHashMap<>();
        this.missions = new LinkedHashMap<>();
        this.missionControl = new MissionControlImpl();
    }

    @Override
    public String agent (List<String> arguments) {
        //•	Agent {id} {name}
        String id = arguments.get(0);
        String name = arguments.get(1);

        Agent noviceAgent = new NoviceAgent(id, name);
        this.agents.put(id, noviceAgent);

        return String
                .format("Registered Agent – %s:%s", noviceAgent.getName(), noviceAgent.getId());
    }

    @Override
    public String request (List<String> arguments) {
        //•	Request {agentId} {missionId} {missionRating} {missionBounty}
        String agentId = arguments.get(0);
        String missionId = arguments.get(1);
        Double missionRationg = Double.valueOf(arguments.get(2));
        Double missionBounty = Double.valueOf(arguments.get(3));

        Mission mission =
                this.missionControl.generateMission(missionId, missionRationg, missionBounty);

        this.missions.put(mission.getId(), mission);
        Agent agent = this.agents.get(agentId);
        agent.acceptMission(mission);

        //String missionType = mission.getClass().getSimpleName();
        //Assigned {missionType} Mission - {missionId} to Agent - {agentName}
        return String.format("Assigned %s Mission - %s to Agent - %s",
                             mission.getClass().getSimpleName(),
                             mission.getId(),
                             agent.getName());
    }

    @Override
    public String complete (List<String> arguments) {

        String agentId = arguments.get(0);
        Agent agent = this.agents.get(agentId);
        Agent master = null;

        agent.completeMissions();

        int completedMissionsSize = 0;

        try {

            Field completedMissions =
                    agent.getClass().getSuperclass().getDeclaredField("completedMissions");
            completedMissions.setAccessible(true);

            Object o = completedMissions.get(agent);

            List<Mission> list = (List<Mission>) o;

            completedMissionsSize = list.size();

            if (agent.getClass().getSimpleName().equals("NoviceAgent")) {
                if (completedMissionsSize >= 3) {
                    master = new MasterAgent(agent.getId(), agent.getName(), agent.getRating(),
                                             list);

                    this.agents.remove(agentId);
                    this.agents.put(agentId, master);
                }
            }


        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }


        //Agent - {name}:{id} has completed all assigned missions.
        agent = this.agents.get(agentId);


        return String.format("Agent - %s:%s has completed all assigned missions.",
                             agent.getName(), agent.getId());
    }


    @Override
    public String status (List<String> arguments) {

        String id = arguments.get(0);

        if (this.missions.containsKey(id)) {
            return this.missions.get(id).toString();
        } else {
            return this.agents.get(id).toString();
        }
    }

    @Override
    public String over (List<String> arguments) {
        long noviceCnt = this.agents.entrySet().stream().filter(a ->  a.getValue().getClass()
                .getSimpleName()
                .equals("NoviceAgent")).count();

        long masterCnt = this.agents.entrySet().stream().filter(a ->  a.getValue().getClass()
                .getSimpleName()
                .equals("MasterAgent")).count();

        int completedMissionsCnt = 0;
        for (Mission mission : missions.values()) {
            Field field = mission.getClass().getSuperclass().getDeclaredFields()[3];
            field.setAccessible(true);
            try {
                String o = (String) field.get(mission);
                if ("Closed".equals(o)) {
                    completedMissionsCnt ++;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        Double totalRating = 0.0D;
        Double totalBounty = 0.0D;
        for (Agent agent : agents.values()) {
            String simpleName = agent.getClass().getSimpleName();

            try {
                Field ratingField = agent.getClass().getSuperclass().getDeclaredField("rating");
                ratingField.setAccessible(true);
                Double agentRating = (Double) ratingField.get(agent);
                totalRating += agentRating;

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }

            if ("MasterAgent".equals(simpleName)) {
                try {
                    Field bountyField = agent.getClass().getDeclaredField("bounty");
                    bountyField.setAccessible(true);
                    Double agentBounty = (Double) bountyField.get(agent);
                    totalBounty += agentBounty;

                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }


        StringBuilder over = new StringBuilder();
        over
                .append(String.format("Novice Agents: %d", noviceCnt))
                .append(System.lineSeparator())
                .append(String.format("Master Agents: %d", masterCnt))
                .append(System.lineSeparator())
                .append(String.format("Assigned Missions: %d", this.missions.size()))
                .append(System.lineSeparator())
                .append(String.format("Completed Missions: %d", completedMissionsCnt))
                .append(System.lineSeparator())
        //Total Rating Given: {totalRatingEarned}
                .append(String.format("Total Rating Given: %.2f", totalRating))
                .append(System.lineSeparator())
        //Total Bounty Given: ${totalBountyEarned}
                .append(String.format("Total Bounty Given: $%.2f", totalBounty));

        return over.toString();
    }
}

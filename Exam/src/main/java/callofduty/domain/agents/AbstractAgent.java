package callofduty.domain.agents;

import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAgent implements Agent {

    private String id;
    private String name;
    private Double rating;

    private List<Mission> acceptedMissions;
    private List<Mission> completedMissions;

    AbstractAgent (String id, String name) {

        this.id = id;
        this.name = name;
        this.rating = 0.0D;
        this.acceptedMissions = new ArrayList<>();
        this.completedMissions = new ArrayList<>();
    }

    void addRating (Double value) {
        this.rating += value;
    }

    void addCompletedMissions (List<Mission> missions) {

        for (Mission mission : missions) {
            this.completedMissions.add(mission);
        }
    }

    @Override
    public void acceptMission (Mission mission) {
        this.acceptedMissions.add(mission);
    }

    @Override
    public void completeMissions () {

        for (Mission acceptedMission : this.acceptedMissions) {

            Class missionClass = acceptedMission.getClass().getSuperclass();
            try {

                Field status = missionClass.getDeclaredField("status");
                status.setAccessible(true);
                status.set(acceptedMission, "Closed");

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }

            this.completedMissions.add(acceptedMission);
            this.addRating(acceptedMission.getRating());
            if (this.getClass().getSimpleName().equals("MasterAgent")) {
                this.addBounty(acceptedMission.getBounty());
            }
        }
        this.acceptedMissions.clear();
    }

    @Override
    public String getId () {

        return this.id;
    }

    @Override
    public String getName () {

        return this.name;
    }

    @Override
    public Double getRating () {

        return this.rating;
    }

    @Override
    public String toString () {
        StringBuilder agent = new StringBuilder();
        agent
                .append(String.format("%s Agent – %s", this.getClass().getSimpleName(), this.getName()))
                .append(System.lineSeparator())
                .append(String.format("Personal Code: %s", this.getId()))
                .append(System.lineSeparator())
                .append(String.format("Assigned Missions: %d", this.acceptedMissions.size()))
                .append(System.lineSeparator())
                .append(String.format("Completed Missions: %d", this.completedMissions.size()))
                .append(System.lineSeparator())
                .append(String.format("Rating: %.2f", this.getRating()));

        return agent.toString();
    }

    protected abstract void addBounty (Double value);


}

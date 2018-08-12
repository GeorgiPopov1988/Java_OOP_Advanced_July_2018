package callofduty.domain.missions;

import callofduty.interfaces.Mission;

public abstract class AbstractMission implements Mission {

    private String id;
    private Double rating;
    private Double bounty;
    private String status;

    AbstractMission (String id, Double rating, Double bounty) {

        this.id = id;
        this.rating = rating;
        this.bounty = bounty;
        this.status = "Open";
    }

    @Override
    public Double getBounty () {

        return this.bounty;
    }

    @Override
    public String getId () {

        return this.id;
    }

    @Override
    public Double getRating () {

        return this.rating;
    }

    @Override
    public String toString () {
        StringBuilder mission = new StringBuilder();
        mission
                .append(String.format("%s Mission - %s", this.getClass().getSimpleName(), this.getId()))
                .append(System.lineSeparator())
                .append(String.format("Status: %s", this.status))
                .append(System.lineSeparator())
        //Status: {Open / Completed}
                .append(String.format("Rating: %.2f", this.getRating()))
                .append(System.lineSeparator())
        //Rating: {rating}
                .append(String.format("Bounty: %.2f", this.getBounty()));
        //Bounty: {bounty}

        return mission.toString();
    }
}

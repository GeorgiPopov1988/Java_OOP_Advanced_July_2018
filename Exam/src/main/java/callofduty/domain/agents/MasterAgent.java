package callofduty.domain.agents;

import callofduty.interfaces.BountyAgent;
import callofduty.interfaces.Mission;

import java.util.List;

public class MasterAgent extends AbstractAgent implements BountyAgent{

    private Double bounty;

    public MasterAgent (String id, String name, Double value, List<Mission> completed) {

        super(id, name);
        this.bounty = 0.0D;
        super.addRating(value);
        super.addCompletedMissions(completed);

    }

    @Override
    protected void addBounty (Double value) {
        this.bounty += bounty;
    }

    @Override
    public Double getBounty () {

        return this.bounty;
    }

    @Override
    public String toString () {
        StringBuilder master = new StringBuilder();
        master.append(super.toString())
                .append(System.lineSeparator())
                .append(String.format("Bounty Earned: $%.2f", this.getBounty()));

        return master.toString();
    }
}

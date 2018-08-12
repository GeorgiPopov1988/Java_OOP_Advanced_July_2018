package callofduty.domain.agents;

import callofduty.interfaces.BountyAgent;

public class NoviceAgent extends AbstractAgent{


    public NoviceAgent (String id, String name) {

        super(id, name);
    }

    @Override
    protected void addBounty (Double value) {

    }

}

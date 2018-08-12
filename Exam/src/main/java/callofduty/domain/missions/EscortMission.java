package callofduty.domain.missions;

public class EscortMission extends AbstractMission{

    private static final Double DECREASES_RATING = 0.75D;
    private static final Double INCREASES_BOUNTY = 1.25D;

    //•	Decreases its given rating by 25%.
    //•	Increases its given bounty by 25%.

     public EscortMission (String id, Double rating, Double bounty) {

        super(id, rating * DECREASES_RATING, bounty * INCREASES_BOUNTY);

    }



}

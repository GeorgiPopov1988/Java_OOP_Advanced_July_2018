package callofduty.domain.missions;

public class HuntMission extends AbstractMission{

    private static final Double INCREASES_RATING = 1.5D;
    private static final Double INCREASES_BOUNTY = 2D;

    //•	Increases its given rating by 50%.
    //•	Increases its given bounty by 100%.

    public HuntMission (String id, Double rating, Double bounty) {

        super(id, rating * INCREASES_RATING, bounty * INCREASES_BOUNTY);
    }
}

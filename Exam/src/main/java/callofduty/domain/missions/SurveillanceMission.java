package callofduty.domain.missions;

public class SurveillanceMission extends AbstractMission {

    private static final Double DECREASES_RATING = 0.25D;
    private static final Double INCREASES_BOUNTY = 1.5D;

    public SurveillanceMission (String id, Double rating, Double bounty) {

        super(id, rating * DECREASES_RATING, bounty * INCREASES_BOUNTY);
    }
}

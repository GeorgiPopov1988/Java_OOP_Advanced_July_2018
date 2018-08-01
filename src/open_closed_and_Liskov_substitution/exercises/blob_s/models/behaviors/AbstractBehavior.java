package open_closed_and_Liskov_substitution.exercises.blob_s.models.behaviors;

import open_closed_and_Liskov_substitution.exercises.blob_s.interfaces.Behavior;

public abstract class AbstractBehavior implements Behavior {

    private boolean isTriggered;
    private boolean toDelayRecurrentEffect;

    AbstractBehavior () {
        this.toDelayRecurrentEffect = true;
    }

    void setIsTriggered (boolean isTriggered) {
        this.isTriggered = isTriggered;
    }

    boolean toDelayRecurrentEffect () {
        return this.toDelayRecurrentEffect;
    }

    void setToDelayRecurrentEffect (boolean toDelayRecurrentEffect){
        this.toDelayRecurrentEffect = toDelayRecurrentEffect;
    }

    @Override
    public boolean isTriggered () {
        return this.isTriggered;
    }

}

package open_closed_and_Liskov_substitution.exercises.blob_s.observers;

public abstract class AbstractObserver {

    protected Subject subject;

    public abstract void update();

}

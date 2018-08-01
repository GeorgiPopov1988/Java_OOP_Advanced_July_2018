package open_closed_and_Liskov_substitution.exercises.blob_s.observers;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<AbstractObserver> observers = new ArrayList<>();

    public void attach (AbstractObserver observer) {

        this.observers.add(observer);
    }

    public void notifyAllObservers () {

        for (AbstractObserver observer : observers) {
            observer.update();
        }
    }

}

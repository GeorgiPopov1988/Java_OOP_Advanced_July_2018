package open_closed_and_Liskov_substitution.exercises.blob_s.factories;

import open_closed_and_Liskov_substitution.exercises.blob_s.interfaces.Attack;
import open_closed_and_Liskov_substitution.exercises.blob_s.interfaces.Behavior;
import open_closed_and_Liskov_substitution.exercises.blob_s.models.Blob;
import open_closed_and_Liskov_substitution.exercises.blob_s.observers.Subject;

public final class BlobFactory {

    private BlobFactory () {

    }

    public static Blob create (String name, int health, int damage, Behavior behavior, Attack attack,
                               Subject subject) {

        return new Blob(name, health, damage, behavior, attack, subject);
    }
}

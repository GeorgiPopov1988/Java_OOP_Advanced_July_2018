package open_closed_and_Liskov_substitution.exercises.blob_s.models.attacks;

import open_closed_and_Liskov_substitution.exercises.blob_s.interfaces.Attack;
import open_closed_and_Liskov_substitution.exercises.blob_s.models.Blob;

public class PutridFart implements Attack {

    @Override
    public void execute (Blob source, Blob target) {
        int currentHealth = target.getHealth();
        currentHealth -= source.getDamage();
        target.setHealth(currentHealth);
    }
}

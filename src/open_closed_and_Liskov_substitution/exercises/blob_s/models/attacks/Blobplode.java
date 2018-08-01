package open_closed_and_Liskov_substitution.exercises.blob_s.models.attacks;

import open_closed_and_Liskov_substitution.exercises.blob_s.interfaces.Attack;
import open_closed_and_Liskov_substitution.exercises.blob_s.models.Blob;

public class Blobplode implements Attack {

    @Override
    public void execute (Blob source, Blob target) {

        int sourceHealthAfterAttack = source.getHealth() - (source.getHealth() / 2);

        if (sourceHealthAfterAttack >= 1) {
            source.setHealth(sourceHealthAfterAttack);
        }
        target.setHealth(target.getHealth() - (source.getDamage() * 2));

    }
}

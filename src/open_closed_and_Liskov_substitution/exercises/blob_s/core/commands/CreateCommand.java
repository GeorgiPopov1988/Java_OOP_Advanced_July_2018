package open_closed_and_Liskov_substitution.exercises.blob_s.core.commands;

import open_closed_and_Liskov_substitution.exercises.blob_s.annotations.Inject;
import open_closed_and_Liskov_substitution.exercises.blob_s.factories.AttackFactory;
import open_closed_and_Liskov_substitution.exercises.blob_s.factories.BehaviorFactory;
import open_closed_and_Liskov_substitution.exercises.blob_s.factories.BlobFactory;
import open_closed_and_Liskov_substitution.exercises.blob_s.interfaces.Attack;
import open_closed_and_Liskov_substitution.exercises.blob_s.interfaces.Behavior;
import open_closed_and_Liskov_substitution.exercises.blob_s.interfaces.Executable;
import open_closed_and_Liskov_substitution.exercises.blob_s.interfaces.Repository;
import open_closed_and_Liskov_substitution.exercises.blob_s.models.Blob;
import open_closed_and_Liskov_substitution.exercises.blob_s.observers.Subject;

public class CreateCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private Repository<Blob> blobRepository;

    @Inject
    private Subject subject;

    @Override
    public void execute () {

        String name = this.data[0];
        int health = Integer.parseInt(this.data[1]);
        int damage = Integer.parseInt(this.data[2]);
        String behaviorType = this.data[3];
        String attackType = this.data[4];

        Behavior behavior = BehaviorFactory.create(behaviorType);
        Attack attack = AttackFactory.create(attackType);

        Blob blob = BlobFactory.create(name, health, damage, behavior, attack, this.subject);

        this.blobRepository.add(blob);
    }
}

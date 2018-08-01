package open_closed_and_Liskov_substitution.exercises.blob_s.core.commands;

import open_closed_and_Liskov_substitution.exercises.blob_s.annotations.Inject;
import open_closed_and_Liskov_substitution.exercises.blob_s.interfaces.Executable;
import open_closed_and_Liskov_substitution.exercises.blob_s.interfaces.Repository;
import open_closed_and_Liskov_substitution.exercises.blob_s.models.Blob;

public class AttackCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private Repository<Blob> blobRepository;


    @Override
    public void execute () {

        String sourceName = this.data[0];
        String targetName = this.data[1];

        Blob source = this.blobRepository.getByName(sourceName);
        Blob target = this.blobRepository.getByName(targetName);

        source.attack(target);
    }
}

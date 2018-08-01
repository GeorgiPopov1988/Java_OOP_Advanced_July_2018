package open_closed_and_Liskov_substitution.exercises.blob_s.core.commands;

import open_closed_and_Liskov_substitution.exercises.blob_s.annotations.Inject;
import open_closed_and_Liskov_substitution.exercises.blob_s.interfaces.Executable;
import open_closed_and_Liskov_substitution.exercises.blob_s.interfaces.Repository;
import open_closed_and_Liskov_substitution.exercises.blob_s.interfaces.Writer;
import open_closed_and_Liskov_substitution.exercises.blob_s.models.Blob;

public class StatusCommand implements Executable {

    @Inject
    private Repository<Blob> blobRepository;

    @Inject
    private Writer writer;

    @Override
    public void execute () {

        this.blobRepository.findAll().forEach(blob -> this.writer.writeLine(blob.toString()));
    }
}

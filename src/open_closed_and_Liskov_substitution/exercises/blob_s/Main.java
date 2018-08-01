package open_closed_and_Liskov_substitution.exercises.blob_s;

import open_closed_and_Liskov_substitution.exercises.blob_s.core.Engine;
import open_closed_and_Liskov_substitution.exercises.blob_s.interfaces.Reader;
import open_closed_and_Liskov_substitution.exercises.blob_s.interfaces.Repository;
import open_closed_and_Liskov_substitution.exercises.blob_s.interfaces.Runnable;
import open_closed_and_Liskov_substitution.exercises.blob_s.interfaces.Writer;
import open_closed_and_Liskov_substitution.exercises.blob_s.io.ConsoleInputReader;
import open_closed_and_Liskov_substitution.exercises.blob_s.io.ConsoleOutputWriter;
import open_closed_and_Liskov_substitution.exercises.blob_s.models.Blob;
import open_closed_and_Liskov_substitution.exercises.blob_s.observers.Subject;
import open_closed_and_Liskov_substitution.exercises.blob_s.repositories.BlobRepository;

public class Main {

    public static void main (String[] args) {

        Reader reader = new ConsoleInputReader();
        Writer writer = new ConsoleOutputWriter();
        Repository<Blob> blobRepository = new BlobRepository();
        Subject subject = new Subject();

        Runnable engine = new Engine(reader, writer, blobRepository, subject);

        engine.run();

    }

}

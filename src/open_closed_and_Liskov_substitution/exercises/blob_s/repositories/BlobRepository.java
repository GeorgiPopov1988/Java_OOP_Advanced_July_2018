package open_closed_and_Liskov_substitution.exercises.blob_s.repositories;

import open_closed_and_Liskov_substitution.exercises.blob_s.interfaces.Repository;
import open_closed_and_Liskov_substitution.exercises.blob_s.models.Blob;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class BlobRepository implements Repository<Blob> {

    private Map<String, Blob> blobs;

    public BlobRepository () {

        this.blobs = new LinkedHashMap<>();
    }

    @Override
    public Blob getByName(String name) {

        return this.blobs.get(name);
    }

    @Override
    public void add (Blob blob) {
        this.blobs.putIfAbsent(blob.getName(), blob);
    }

    @Override
    public Collection<Blob> findAll() {
        return this.blobs.values();
    }
}

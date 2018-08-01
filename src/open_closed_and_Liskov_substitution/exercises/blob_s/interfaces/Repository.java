package open_closed_and_Liskov_substitution.exercises.blob_s.interfaces;

import java.util.Collection;

public interface Repository<T> {

    void add(T t);

    T getByName (String name);

    Collection<T> findAll ();
}

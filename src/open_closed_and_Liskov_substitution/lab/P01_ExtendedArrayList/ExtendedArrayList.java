package open_closed_and_Liskov_substitution.lab.P01_ExtendedArrayList;

import java.util.ArrayList;
import java.util.ListIterator;

public class ExtendedArrayList<T extends Comparable<T>> extends ArrayList<T> {

    public T min() {
        int minIndex;

        if (super.isEmpty()) {
            minIndex = -1;
            return null;
        } else {
            ListIterator<T> iterator = super.listIterator();
            T min = iterator.next();
            minIndex = iterator.previousIndex();

            while (iterator.hasNext()) {
             T current = iterator.next();
             if (current.compareTo(min) < 0) {
                 min = current;
                 minIndex = iterator.previousIndex();
             }
            }
        }

        return super.get(minIndex);

    }

    public T max() {
        int maxIndex;

        if (super.isEmpty()) {
            maxIndex = -1;
            return null;
        } else {
            ListIterator<T> iterator = super.listIterator();
            T min = iterator.next();
            maxIndex = iterator.previousIndex();

            while (iterator.hasNext()) {
                T current = iterator.next();
                if (current.compareTo(min) > 0) {
                    min = current;
                    maxIndex = iterator.previousIndex();
                }
            }
        }

        return super.get(maxIndex);

    }

}

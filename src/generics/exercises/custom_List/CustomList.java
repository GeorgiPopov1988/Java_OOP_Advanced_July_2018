package generics.exercises.custom_List;

public interface CustomList<T extends Comparable<T>>{

 void add(T element);

 T remove(int index);

 boolean contains(T element);

 void swap(int firstIndex, int secondIndex);
 
 int countGreaterThan(T element);

 T getMax();

 T getMin();
 
 Iterable<T> getElements();
 
 void sort();
}

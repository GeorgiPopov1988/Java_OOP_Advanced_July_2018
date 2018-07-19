package iterators_and_comparatotrs.exercises.p06_Strategy_pattern.comparators;

import iterators_and_comparatotrs.exercises.p06_Strategy_pattern.Person;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {

@Override
public int compare(Person o1, Person o2) {
  
  int compareByNameLength = o1.getName().length() - o2.getName().length();
  if (compareByNameLength != 0) {
    return compareByNameLength;
  }
  return String.valueOf(o1.getName().charAt(0)).compareToIgnoreCase(
          String.valueOf(o2.getName().charAt(0)));
}
}

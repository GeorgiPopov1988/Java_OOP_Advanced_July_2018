package iterators_and_comparatotrs.exercises.p06_Strategy_pattern.comparators;

import iterators_and_comparatotrs.exercises.p06_Strategy_pattern.Person;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Person> {

@Override
public int compare(Person person1, Person person2) {
  
  return person1.getAge() - person2.getAge();
}
}

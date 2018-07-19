package iterators_and_comparatotrs.exercises.p05_Comparing_objects;

public class Person implements Comparable<Person>{
  
  private String name;
  private int age;
  private String town;
  
  public Person(String name, int age, String town) {
    this.name = name;
    this.age = age;
    this.town = town;
  }
  
@Override
public int compareTo(Person other) {
    int compareByName = this.name.compareTo(other.name);
    if (compareByName != 0) {
      return compareByName;
    }
    int compareByAge = this.age - other.age;
    if (compareByAge != 0) {
      return compareByAge;
    }
    
  return this.town.compareTo(other.town);
}
}

package iterators_and_comparatotrs.exercises.p06_Strategy_pattern;

import iterators_and_comparatotrs.exercises.p06_Strategy_pattern.comparators.ComparatorByAge;
import iterators_and_comparatotrs.exercises.p06_Strategy_pattern.comparators.ComparatorByName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {

public static void main(String[] args) throws IOException {
  
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  
  int peopleCnt = Integer.parseInt(reader.readLine());
  Set<Person> sortedByName = new TreeSet<>(new ComparatorByName());
  Set<Person> sortedByAge = new TreeSet<>(new ComparatorByAge());
  
  
  while (peopleCnt-- > 0) {
    String[] inTokens = reader.readLine().split("\\s+");
    String name = inTokens[0];
    int age = Integer.parseInt(inTokens[1]);
    
    Person person = new Person(name, age);
    sortedByName.add(person);
    sortedByAge.add(person);
  }
  
  for (Person person : sortedByName) {
    System.out.println(person);
  }
  for (Person person : sortedByAge) {
    System.out.println(person);
  }
  
}
  
}

package iterators_and_comparatotrs.exercises.p05_Comparing_objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
public static void main(String[] args) throws IOException {
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  
  //  {name} {age} {town}
  List<Person> people = new ArrayList<>();
  while (true) {
    
    String input = reader.readLine();
    
    if ("END".equals(input)) {
      break;
    }
    
    String[] inTokens = input.split("\\s+");
    String name = inTokens[0];
    int age = Integer.parseInt(inTokens[1]);
    String town = inTokens[2];
    Person person = new Person(name, age, town);
    people.add(person);
  }
  
  int position = Integer.parseInt(reader.readLine());
  
  if (position < 0 || position >= people.size()) {
    System.out.println("No matches");
    return;
  }
  
  Person person = people.get(position);
  long equalPeopleCnt = people.stream().filter(person1 -> person1.compareTo(person) == 0).count();
  
  if (equalPeopleCnt == 0) {
    System.out.println("No matches");
  } else {
    System.out.printf("%d %d %d", equalPeopleCnt, people.size() - equalPeopleCnt, people.size());
  }
  
}
}

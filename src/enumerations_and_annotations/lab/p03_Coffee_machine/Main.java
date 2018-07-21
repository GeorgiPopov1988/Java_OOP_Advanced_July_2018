package enumerations_and_annotations.lab.p03_Coffee_machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

public static void main(String[] args) throws IOException {
  
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  
  
  CoffeeMachine coffeeMachine = new CoffeeMachine();
  while (true) {
    String[] input = reader.readLine().split(" ");
    if ("END".equals(input[0])) {
      break;
    }
    
    if (input.length == 1) {
      coffeeMachine.insertCoin(input[0]);
    } else if (input.length == 2) {
      String size = input[0];
      String type = input[1];
      
      coffeeMachine.buyCoffee(size, type);
    }
    
  }
  
  for (Coffee coffee : coffeeMachine.coffeesSold()) {
    System.out.println(coffee);
  }
  
}
  
}

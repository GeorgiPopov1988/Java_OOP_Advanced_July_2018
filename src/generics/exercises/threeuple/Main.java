package generics.exercises.threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
 public static void main(String[] args) throws IOException {
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  
  List<Threeuple> threeuples = new ArrayList<>();
  
  // First input line = <<first name> <last name>> <address> <town>
  String[] input = reader.readLine().split("\\s+");
  String name = input[0] + " " + input[1];
  String address = input[2];
  String town = input[3];
  Threeuple<String, String, String> threeuple1 = new Threeuple<>(name, address, town);
  
  // Second input line = <name> <liters of beer> <drunk or not>
  input = reader.readLine().split("\\s+");
  name = input[0];
  int amountOfBeer = Integer.parseInt(input[1]);
  boolean isDrunk = false;
  if ("drunk".equals(input[2])) {
   isDrunk = true;
  }
  Threeuple<String, Integer, Boolean> threeuple2 = new Threeuple<>(name, amountOfBeer, isDrunk);
  
  // Third input line = <name> <account balance> <bank name>
  input = reader.readLine().split("\\s+");
  name = input[0];
  double accountBalance = Double.parseDouble(input[1]);
  String bankName = input[2];
  Threeuple<String, Double, String > threeuple3 = new Threeuple<>(name, accountBalance, bankName);
  
  threeuples.add(threeuple1);
  threeuples.add(threeuple2);
  threeuples.add(threeuple3);
 
  for (Threeuple threeuple : threeuples) {
   System.out.print(threeuple);
  }
  
 }
}

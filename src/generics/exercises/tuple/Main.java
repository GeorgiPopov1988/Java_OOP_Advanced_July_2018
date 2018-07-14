package generics.exercises.tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
 public static void main(String[] args) throws IOException {
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 
  List<Tuple> tuples = new ArrayList<>();
  
  // First input line = <<first name> <last name>> <address>
  String[] inLine = reader.readLine().split("\\s+");
  String keyTuple1 = inLine[0] + " " + inLine[1];
  String valueTuple1 = inLine[2];
  Tuple<String, String> tuple1 = new Tuple<>(keyTuple1, valueTuple1);
  
  // Second input line = <name> <liters of beer>
  inLine = reader.readLine().split("\\s+");
  String keyTuple2 = inLine[0];
  int valueTuple2 = Integer.parseInt(inLine[1]);
  Tuple<String , Integer> tuple2 = new Tuple<>(keyTuple2, valueTuple2);
  
  // Third input line = <Integer> <Double>
  inLine = reader.readLine().split("\\s+");
  int keyTuple3 = Integer.parseInt(inLine[0]);
  double valueTuple3 = Double.parseDouble(inLine[1]);
  Tuple<Integer, Double> tuple3 = new Tuple<>(keyTuple3, valueTuple3);
  
  tuples.add(tuple1);
  tuples.add(tuple2);
  tuples.add(tuple3);
 
  for (Tuple tuple : tuples) {
   System.out.print(tuple);
  }
  
 }
}

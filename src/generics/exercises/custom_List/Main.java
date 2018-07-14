package generics.exercises.custom_List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
 public static void main(String[] args) throws IOException {
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  
  CustomList<String> list = new MyArrayList<>();
  
  String inLine;
  
  while (true) {
   
   if ("END".equals(inLine = reader.readLine())) {
    break;
   }
   String[] inTokens = inLine.split("\\s+");
   
   
   executeCommands(list, inTokens);
   
  }
  
 }
 
 private static void executeCommands(CustomList<String> list, String[] inTokens) {
  
  String command = inTokens[0];
  String element;
  
  switch (command) {
   case "Add":
    element = inTokens[1];
    list.add(element);
    break;
   case "Remove":
    int index = Integer.parseInt(inTokens[1]);
    System.out.println(list.remove(index));
    break;
   case "Contains":
    element = inTokens[1];
    System.out.println(list.contains(element));
    break;
   case "Swap":
   int firstIndex = Integer.parseInt(inTokens[1]);
   int secondIndex = Integer.parseInt(inTokens[2]);
   list.swap(firstIndex, secondIndex);
    break;
   case "Greater":
    element = inTokens[1];
    System.out.println(list.countGreaterThan(element));
    break;
   case "Max":
    System.out.println(list.getMax());
    break;
   case "Min":
    System.out.println(list.getMin());
    break;
   case "Print":
    for (String currentElement : list.getElements()) {
     System.out.println(currentElement);
    }
    break;
  }
 }
}

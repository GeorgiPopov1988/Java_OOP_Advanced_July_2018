package iterators_and_comparatotrs.exercises.p01_ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
 public static void main(String[] args) throws IOException {
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  ListyIterator<String> listyIterator = null;
 
  while (true) {
   String inLine = reader.readLine();
 
   if ("END".equals(inLine)) {
    break;
   }
 
   String[] inTokens = inLine.split("\\s+");
   
   switch (inTokens[0]) {
    case "Create":
     String [] arguments = Arrays.stream(inTokens).skip(1).toArray(String[]::new);
     listyIterator = new ListyIterator<>(arguments);
     break;
    case "HasNext":
     System.out.println(listyIterator.hasNext());
     break;
    case "Move":
     System.out.println(listyIterator.move());
     break;
    case "Print":
     listyIterator.print();
     break;
    
   }
   
  }
  
 }
}

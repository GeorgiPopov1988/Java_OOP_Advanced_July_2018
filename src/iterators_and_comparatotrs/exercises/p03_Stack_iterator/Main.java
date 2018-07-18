package iterators_and_comparatotrs.exercises.p03_Stack_iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
public static void main(String[] args) throws IOException {
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  
  MyStack<Integer> stack = new MyStack<>();
  
  while (true) {
    String[] inLine = reader.readLine().split("[\\s,]+");
    String command = inLine[0];
    if ("END".equals(command)) {
      if (!stack.isEmpty()) {
        print(stack);
        print(stack);
      }
      break;
    }
    switch (command) {
      case "Push":
        for (int i = 1; i < inLine.length; i++) {
          stack.push(Integer.parseInt(inLine[i]));
        }
        break;
      case "Pop":
        try {
          stack.pop();
        } catch (IllegalAccessException e) {
          System.out.println(e.getMessage());
        }
        break;
    }
    
  }
}

private static void print(MyStack<Integer> stack) {
  for (Integer integer : stack) {
    System.out.println(integer);
  }
}
}

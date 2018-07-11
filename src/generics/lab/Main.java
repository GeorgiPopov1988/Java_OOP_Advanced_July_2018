package generics.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
 
 public static void main(String[] args) {
 
  List<Integer> ints = new ArrayList<Integer>();
  List<String> strings = new ArrayList<String>();
 
  Collections.addAll(ints, 1, 2, 3, 4, 5);
  Collections.addAll(strings, "Aaa", "bbb", "Vvv");
  
  
 String myStr =  ListUtils.getMax(strings);
 
 }
}

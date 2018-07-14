package generics.exercises.box_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
 public static void main(String[] args) throws IOException {
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  
  int cnt = Integer.parseInt(reader.readLine());

//  Problem 1.	Generic Box of Strings
//  List<Box<String>> listOFStrings = new ArrayList<Box<String>>();
//
//  while (cnt-- > 0) {
//   String input = reader.readLine();
//   Box<String> box = new Box<String>();
//   box.setValue(input);
//   listOFStrings.add(box);
//  }
//
//  for (Box<String> box : listOFStrings) {
//   System.out.println(box);
//  }
//
//  Problem 2.	Generic Box of Integer
//
//  List<Box<Integer>> listOfIntegers = new ArrayList<Box<Integer>>();
//
//  while (cnt-- > 0) {
//   int in = Integer.parseInt(reader.readLine());
//   Box<Integer> box = new Box<Integer>();
//   box.setValue(in);
//   listOfIntegers.add(box);
//  }
//  for (Box<Integer> box : listOfIntegers) {
//   System.out.println(box);
//  }

//  Problem 3.	Generic Swap Method Strings
//
//  List<Box<String>> listOFStrings = new ArrayList<Box<String>>();
//  while (cnt-- > 0) {
//   String input = reader.readLine();
//   Box<String> box = new Box<String>();
//   box.setValue(input);
//   listOFStrings.add(box);
//  }
//
//  int[] indexes = Stream.of(reader.readLine()
//          .split("\\s+"))
//          .mapToInt(Integer::parseInt).toArray();
//
//  swapMethod(listOFStrings, indexes[0], indexes[1]);
//
//  for (Box<String> box : listOFStrings) {
//   System.out.println(box);
//  }
 
// Problem 4.	Generic Swap Method Integers
//
//  List<Box<Integer>> listOfIntegers = new ArrayList<Box<Integer>>();
//
//  while (cnt-- > 0) {
//   int in = Integer.parseInt(reader.readLine());
//   Box<Integer> box = new Box<Integer>();
//   box.setValue(in);
//   listOfIntegers.add(box);
//  }
//
//  int[] indexes = Stream.of(reader.readLine()
//          .split("\\s+"))
//          .mapToInt(Integer::parseInt).toArray();
//
//  swapMethod(listOfIntegers, indexes[0], indexes[1]);
//
//  for (Box<Integer> box : listOfIntegers) {
//   System.out.println(box);
//  }

// Problem 5.	Generic Count Method Strings
//
  List<ComparableBox<String>> listOFStrings = new ArrayList<ComparableBox<String>>();

  while (cnt-- > 0) {
   String input = reader.readLine();
   ComparableBox<String> box = new ComparableBox<>();
   box.setValue(input);
   listOFStrings.add(box);
  }

  ComparableBox box = new ComparableBox();
  box.setValue(reader.readLine());
  System.out.println(getCountOfGreaterElements(listOFStrings, box));
 
//  Problem 6.	Generic Count Method Doubles
//
//  List<ComparableBox<Double>> listOfNumbers = new ArrayList<ComparableBox<Double>>();
//
//  while (cnt-- > 0) {
//   double in = Double.parseDouble(reader.readLine());
//   ComparableBox<Double> box = new ComparableBox<>();
//   box.setValue(in);
//   listOfNumbers.add(box);
//  }
//
//  ComparableBox<Double> box = new ComparableBox<>();
//  box.setValue(Double.parseDouble(reader.readLine()));
//  System.out.println(getCountOfGreaterElements(listOfNumbers, box));
//

 }
 
 private static <T extends Comparable<T>> int getCountOfGreaterElements
         (List<ComparableBox<T>> elements, ComparableBox<T> singleElement) {
  int cnt = 0;
 
  for (ComparableBox<T> element : elements) {
   if (element.compareTo(singleElement) > 0) {
    cnt++;
   }
  }
  return cnt;
 }
 
// private static <T> void
// swapMethod(List<Box<T>> boxes, int firstIndex, int secondIndex) {
//
//  Box<T> temp = boxes.get(firstIndex);
//  boxes.set(firstIndex, boxes.get(secondIndex));
//  boxes.set(secondIndex, temp);
// }
 
 
}

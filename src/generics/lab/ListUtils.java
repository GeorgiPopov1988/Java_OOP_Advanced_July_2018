package generics.lab;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
 
 public static <T extends Comparable<T>> T getMin(List<T> list) {
  
  if (list.isEmpty()) {
   throw new IllegalArgumentException("List is empty!");
  }
  
  T min = list.get(0);
  
  for (int i = 1; i < list.size(); i++) {
   if (min.compareTo(list.get(i)) > 0) {
    min = list.get(i);
   }
  }
  return min;
 }
 
 public static <T extends Comparable<T>> T getMax(List<T> list) {
  
  if (list.isEmpty()) {
   throw new IllegalArgumentException("List is empty!");
  }
  
  T max = list.get(0);
  
  for (int i = 1; i < list.size(); i++) {
   if (max.compareTo(list.get(i)) < 0) {
    max = list.get(i);
   }
  }
  
  
  return max;
 }
 
 public static <T extends Comparable<T>> List<Integer> getNullIndices(List<T> list) {
  
  List<Integer> result = new ArrayList<Integer>();
  
  for (int i = 0; i < list.size(); i++) {
   if (list.get(i) == null) {
    result.add(i);
   }
  }
  return result;
 }
 
 public static <T> void flatten(List<? super T> destination, List<List<? extends T>> src) {
  
  for (List<? extends T> list : src) {
   destination.addAll(list);
  }
  
 }
 
 public static <T> void addAll(List<? super T> destination, List<? extends T> source) {
 
  destination.addAll(source);
  
 }
 
}

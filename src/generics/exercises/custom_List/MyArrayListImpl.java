package generics.exercises.custom_List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyArrayListImpl<T extends Comparable<T>> implements CustomList<T>{
 
 private List<T> elements;
 
 public MyArrayListImpl() {
  this.elements = new ArrayList<>();
 }
 
 private boolean isValidIndex(int index) {
  return index >= 0 && index < this.elements.size();
 }
 
 @Override
 public void add(T element) {
  // •	Add <element> - Adds the given element to the end of the list
 this.elements.add(element);
 }
 
 @Override
 public T remove(int index) {
  // •	Remove <index> - Removes the element at the given index
  if (this.isValidIndex(index)) {
   return this.elements.remove(index);
  }
  return null;
 }
 
 @Override
 public boolean contains(T element) {
  // •	Contains <element> - Prints if the list contains the given element (true or false)
  return this.elements.contains(element);
 }
 
 @Override
 public void swap(int firstIndex, int secondIndex) {
  // •	Swap <index> <index> - Swaps the elements at the given indexes
  if (this.isValidIndex(firstIndex) && this.isValidIndex(secondIndex)) {
   T temp = this.elements.get(firstIndex);
   this.elements.set(firstIndex, this.elements.get(secondIndex));
   this.elements.set(secondIndex, temp);
  }
 
 }
 
 @Override
 public int countGreaterThan(T otherElement) {
  // •	Greater <element> -
  // Counts the elements that are greater than the given element and prints their count
  int cnt = 0;
  for (T thisElement : this.elements) {
   if (thisElement.compareTo(otherElement) > 0) {
    cnt++;
   }
  }
  return cnt;
 }
 
 @Override
 public T getMax() {
  // •	Max - Prints the maximum element in the list
  return this.elements.stream().max(Comparator.naturalOrder()).get();
 }
 
 @Override
 public T getMin() {
  return Collections.min(this.elements);
 }
 
 @Override
 public Iterable<T> getElements() {
  return this.elements;
 }
 
 @Override
 public void sort() {
  this.elements.sort((e1, e2) -> e1.compareTo(e2));
 }
}

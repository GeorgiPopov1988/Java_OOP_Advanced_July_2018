package iterators_and_comparatotrs.exercises.p01_ListyIterator;

public class ListyIterator<T> {
 private T[] items;
 private int index;
 
 
 @SafeVarargs
 ListyIterator(T... elements) {
  this.items = elements;
  this.index = 0;
 }
 
 public boolean move() {
  if (hasNext()) {
   this.index++;
   return true;
  } else {
   return false;
  }
 }
 
 public boolean hasNext() {
  return this.index < items.length - 1;
 }
 
 public void print() {
  if (items != null && items.length > 0) {
   System.out.println(items[this.index]);
  } else {
   System.out.println("Invalid Operation!");
  }
 }
 
}

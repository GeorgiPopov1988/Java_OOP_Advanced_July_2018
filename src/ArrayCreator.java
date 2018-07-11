import java.lang.reflect.Array;

public class ArrayCreator<T> {
 
 
 @SuppressWarnings("unchecked")
 public static <T> T[] create(int length, T item) {
  
  T[] elements = (T[]) new Object[length];
  
  for (int i = 0; i < elements.length; i++) {
   elements[i] = item;
  }
  
  return elements;
 }
 
 @SuppressWarnings("unchecked")
 public static <T> T[] create(Class<T> cl, int length, T item) {
  
  T[] elements = (T[]) Array.newInstance(cl, length);
  
  for (int i = 0; i < elements.length; i++) {
   elements[i] = item;
  }
  
  return elements;
 }
 
 
}

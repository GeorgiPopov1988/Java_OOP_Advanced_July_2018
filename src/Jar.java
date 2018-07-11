import java.util.ArrayDeque;

public class Jar<T> {
  
  private ArrayDeque<T> elemens;
  
  public Jar() {
    this.elemens = new ArrayDeque<T>();
  }
  
  public void add(T element) {
    this.elemens.addLast(element);
  }
  
  public T remove() {
     return this.elemens.removeLast();
  }

}

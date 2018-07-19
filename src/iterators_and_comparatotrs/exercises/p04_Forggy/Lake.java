package iterators_and_comparatotrs.exercises.p04_Forggy;

import java.util.Iterator;
import java.util.List;

public class Lake<T> implements Iterable<T> {
private List<T> numbers;

public Lake(List<T> numbers) {
  this.numbers = numbers;
}


@Override
public Iterator<T> iterator() {
  return new Frog();
}

private final class Frog implements Iterator<T> {
  private int index;
  private boolean isEven;
  
  private Frog() {
    this.index = 0;
    this.isEven = true;
  }
  
  @Override
  public boolean hasNext() {
    boolean hasNext =  this.index < numbers.size();
    if (!isEven && !hasNext) {
      return false;
    } else if (isEven && !hasNext) {
      if (numbers.size() == 1) {
        return false;
      }
      this.isEven = false;
      this.index = 1;
      return true;
    }
    return true;
  }
  
  
  @Override
  public T next() {
    T num = numbers.get(this.index);
    this.index += 2;
    return num;
  }
}
}

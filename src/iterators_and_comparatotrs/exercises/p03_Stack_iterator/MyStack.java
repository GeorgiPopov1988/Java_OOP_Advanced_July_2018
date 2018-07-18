package iterators_and_comparatotrs.exercises.p03_Stack_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyStack<T> implements Iterable<T> {
private List<T> elements;

public MyStack() {
  this.elements = new ArrayList<T>();
}

public void push(T element) {
  this.elements.add(element);
}

public T pop() throws IllegalAccessException {
  if (this.elements.size() == 0) {
	throw new IllegalAccessException("No elements");
  } else {
	return this.elements.remove(this.elements.size() - 1);
  }
}


@Override
public Iterator<T> iterator() {
  return new MyStackIterator();
}

public boolean isEmpty() {
  return this.elements.isEmpty();
}

private final class MyStackIterator implements Iterator<T> {

  private int index;

  private MyStackIterator() {
    this.index = elements.size()-1;
  }

  @Override
  public boolean hasNext() {
	return this.index >= 0;
  }

  @Override
  public T next() {
	return elements.get(this.index--);
  }
}

}

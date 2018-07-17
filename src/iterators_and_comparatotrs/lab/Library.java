package iterators_and_comparatotrs.lab;

import java.util.Iterator;

public class Library implements Iterable<Book> {
 
 private Book[] books;
 
 Library(Book... books) {
  this.setBooks(books);
 }
 
 private void setBooks(Book... books) {
  this.books = books;
 }
 
 public Book[] getBooks() {
  return this.books;
 }
 
 @Override
 public Iterator<Book> iterator() {
  return new LibIterator();
 }
 
 private final class LibIterator implements Iterator<Book> {
  private int index;
  
  private LibIterator() {
   this.index = 0;
  }
  
  @Override
  public boolean hasNext() {
   return this.index < books.length;
  }
 
  @Override
  public Book next() {
   return books[index++];
  }
 }
}

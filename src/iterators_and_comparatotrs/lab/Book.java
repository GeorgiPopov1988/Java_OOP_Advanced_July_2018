package iterators_and_comparatotrs.lab;

import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book>{

 private String title;
 private int year;
 private List<String> authors;
 
 public Book(String title, int year, String... authors) {
  this.setTitle(title);
  this.setYear(year);
  this.setAuthors(authors);
 }
 
 private void setYear(int year) {
  this.year = year;
 }
 
 private void setTitle(String title) {
  this.title = title;
 }
 
 private void setAuthors(String... authors) {
  this.authors = Arrays.asList(authors);
   // asList -> return new ArrayList.
 }
 
 public String getTitle() {
  return this.title;
 }
 
 public int getYear() {
  return this.year;
 }
 
 public List<String> getAuthors() {
  return this.authors;
 }
 
 @Override
 public String toString() {
  return String.format("%s -> %d -> %s", this.getTitle(), this.getYear(), this.getAuthors());
 }
 
 @Override
 public int compareTo(Book o) {
  if (this.getTitle().compareTo(o.getTitle()) == 0) {
   
   return Integer.compare(this.getYear(), o.getYear());
   
  }
  return this.getTitle().compareTo(o.getTitle());
 }
}

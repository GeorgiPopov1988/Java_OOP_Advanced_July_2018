package iterators_and_comparatotrs.exercises.p08_Pet_clinics.implementations;

import static iterators_and_comparatotrs.exercises.p08_Pet_clinics.Validations.*;

public class Pet {

private String name;
private int age;
private String kind;

public Pet(String name, int age, String kidn) throws IllegalAccessException {
  this.setName(name);
  this.setAge(age);
  this.setKind(kind);
}

private void setName(String name) throws IllegalAccessException {
  if (isValid(name)) {
    this.name = name;
  } else {
    throw new IllegalAccessException();
  }
}

private void setAge(int age) throws IllegalAccessException {
 if (isValidAge(age)) {
   this.age = age;
 } else {
   throw new IllegalAccessException();
 }
}

private void setKind(String kind) throws IllegalAccessException {
  if (isValid(kind)) {
    this.kind = kind;
  } else {
    throw new IllegalAccessException();
  }
}

}

package iterators_and_comparatotrs.exercises.p08_Pet_clinics;

import iterators_and_comparatotrs.exercises.p08_Pet_clinics.implementations.Clinic;
import iterators_and_comparatotrs.exercises.p08_Pet_clinics.implementations.Pet;

import java.util.LinkedHashMap;
import java.util.Map;

public class Manager {
  private Map<String, Pet> pets;
  private Map<String, Clinic> clinics;
  
  public Manager() {
    this.pets = new LinkedHashMap<>();
    this.clinics = new LinkedHashMap<>();
  }
  
  
  
  
}

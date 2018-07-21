package enumerations_and_annotations.lab.p03_Coffee_machine;

public enum CoffeeType {
  ESPRESSO, LATTE, IRISH;

@Override
public String toString() {
  
  return super.name().charAt(0) + super.name().substring(1).toLowerCase();
}
}

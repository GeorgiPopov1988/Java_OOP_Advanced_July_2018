package enumerations_and_annotations.lab.p01_Weekdays;

public enum Weekday {
  MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

@Override
public String toString() {
  
  return super.name().charAt(0) + super.name().substring(1).toLowerCase();
}

}
package enumerations_and_annotations.lab.p01_Weekdays;

public class WeeklyEntry implements Comparable<WeeklyEntry>{

private Weekday day;
private String note;

public WeeklyEntry(String day, String note) {
  
  this.day = Enum.valueOf(Weekday.class,day.toUpperCase());
  this.note = note;
}

@Override
public String toString() {
  
  return String.format("%s - %s", this.day, this.note);
}

@Override
public int compareTo(WeeklyEntry other) {
  
  return Integer.compare(this.day.ordinal(), other.day.ordinal());
}
}

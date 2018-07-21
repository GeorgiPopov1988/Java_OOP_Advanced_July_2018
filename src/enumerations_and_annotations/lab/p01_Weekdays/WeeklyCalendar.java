package enumerations_and_annotations.lab.p01_Weekdays;

import java.util.ArrayList;
import java.util.List;

public class WeeklyCalendar {

private List<WeeklyEntry> entries;

public WeeklyCalendar() {
  
  this.entries = new ArrayList<>();
}

public void addEntry(String weekday, String notes) {
  
  this.entries.add(new WeeklyEntry(weekday, notes));
}

public Iterable<WeeklyEntry> getWeeklySchedule() {
  
  this.entries.sort((e1, e2) -> e1.compareTo(e2));
  
  return this.entries;
}


}

package enumerations_and_annotations.lab.p01_Weekdays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

public static void main(String[] args) throws IOException {
  
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  
  WeeklyCalendar wc = new WeeklyCalendar();
  wc.addEntry("Friday", "sleep");
  wc.addEntry("Monday", "sport");
  
  Iterable<WeeklyEntry> shedule = wc.getWeeklySchedule();
  for (WeeklyEntry weeklyEntry : shedule) {
    System.out.println(weeklyEntry);
  }
  
}
  
}

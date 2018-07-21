package iterators_and_comparatotrs.exercises.p08_Pet_clinics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Validations {

public static boolean isValid(String name) {
  
  final String regex = "\\b[A-Za-z]*\\b";
  final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
  final Matcher matcher = pattern.matcher(name);
  
  if (matcher.find()) {
    return name.length() > 0 && name.length() <= 50;
  }
  return false;
}

public static boolean isValidRoomsCnt(int roomsCnt) {
  return roomsCnt % 2 != 0 & roomsCnt >= 1 & roomsCnt <= 101;
}

public static boolean isValidAge(int age) {
  return age > 0 & age <= 100;
}
}

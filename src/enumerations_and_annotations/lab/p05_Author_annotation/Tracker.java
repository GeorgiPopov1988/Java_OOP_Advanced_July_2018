package enumerations_and_annotations.lab.p05_Author_annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker {
  
  @Author(name = "Georgi Popov")
  public static void printMethodsByAuthor() {
  
    Map<String , List<String>> methodsByAuthor = new HashMap<>();
  
    Class<Tracker> trackerClass = Tracker.class;
    Method[] methods = trackerClass.getDeclaredMethods();
  
    for (Method method : methods) {
      Author annotation = method.getAnnotation(Author.class);
      
      if (annotation != null) {
        methodsByAuthor.putIfAbsent(annotation.name(), new ArrayList<>());
        methodsByAuthor.get(annotation.name()).add(method.getName());
      }
    }
  
    for (Map.Entry<String, List<String>> map : methodsByAuthor.entrySet()) {
      System.out.print(map.getKey() + ": ");
      System.out.println(String.join(", ", map.getValue()));
    }
  }
  
  @Author(name = "Svetlana Popova")
  public void method() {
  
    System.out.println("Test method");
  }
  
}

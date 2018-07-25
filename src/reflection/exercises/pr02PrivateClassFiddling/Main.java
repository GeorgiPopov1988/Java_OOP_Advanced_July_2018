package reflection.exercises.pr02PrivateClassFiddling;

import reflection.exercises.pr02PrivateClassFiddling.com.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
private static final String className = "BlackBoxInt";
private static final String classPath = "reflection.exercises.pr02PrivateClassFiddling.com.";
public static void main(String[] args)
        throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException,
        InstantiationException, ClassNotFoundException {
  
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  BlackBoxInt blackBoxInt;
  
  try {
    Class<?> aClass = Class.forName(classPath + className);
    Constructor constructor = aClass.getDeclaredConstructor();
    constructor.setAccessible(true);
    blackBoxInt = (BlackBoxInt) constructor.newInstance();
  
    String line;
    while (true) {
      if ("END".equals(line = reader.readLine())) {
        break;
      }
  
      String[] tokens = line.split("_");
      String methodName = tokens[0];
      int num = Integer.parseInt(tokens[1]);
      
      Method method = blackBoxInt.getClass().getDeclaredMethod(methodName, int.class);
      method.setAccessible(true);
      method.invoke(blackBoxInt, num);
  
      Field field = blackBoxInt.getClass().getDeclaredField("innerValue");
      field.setAccessible(true);
      System.out.println(field.get(blackBoxInt));
      
      
    }
  
  } catch (ClassNotFoundException | NoSuchFieldException e) {
    e.printStackTrace();
  }
  
}

}

package reflection.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

public static void main(String[] args)
        throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException,
        InstantiationException {
  
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  
  
  Class<?> clazz = Reflection.class;
//  System.out.println(clazz);
//  System.out.println(clazz.getSuperclass());
//
//  Class<?>[] interfaces = clazz.getInterfaces();
//
//  for (Class<?> anInterface : interfaces) {
//    System.out.println(anInterface);
//  }
//
//  // reflection.lab.Reflection reflection = clazz.newInstance(); Deprecated...
//
//  reflection.lab.Reflection reflection = (reflection.lab.Reflection) clazz.getConstructor().newInstance();
//  System.out.println(reflection);
  
//  Method[] methods = clazz.getDeclaredMethods();
//  Set<Method> getters = new TreeSet<>(Comparator.comparing(Method :: getName));
//  Set<Method> setters = new TreeSet<>((methd1, methd2) -> methd1.getName().compareTo(methd2.getName()));
//
//  for (Method method : methods) {
//    if (method.getName().startsWith("get") && method.getParameterTypes().length == 0) {
//      getters.add(method);
//    } else if (method.getName().startsWith("set")
//            && method.getParameterTypes().length == 1
//            && void.class.equals(method.getReturnType())) {
//      setters.add(method);
//    }
//  }
//
//  for (Method getter : getters) {
//    System.out.println(String.format("%s will return %s",
//            getter.getName(), getter.getReturnType().getSimpleName()));
//  }
//
//  for (Method setter : setters) {
//    System.out.println(String.format("%s and will set field of %s",
//            setter.getName(), setter.getParameterTypes()[0].getSimpleName()));
//  }
  
  List<Field> fields = Arrays.asList(clazz.getDeclaredFields());
  
  fields.sort(new Comparator<Field>() {
    @Override
    public int compare(Field o1, Field o2) {
    
      return o1.getName().compareTo(o2.getName());
    }
  });
  
  int errorsCnt = 0;
  
  for (Field field : fields) {
    if (!Modifier.isPrivate(field.getModifiers())) {
      System.out.println(field.getName() + " must be private!");
      errorsCnt++;
    }
  }
  
  List<Method> methods = Arrays.asList(clazz.getDeclaredMethods());
  methods.sort(new Comparator<Method>() {
    @Override
    public int compare(Method m1, Method m2) {
    
      return m1.getName().compareTo(m2.getName());
    }
  });
  
  
  for (Method method : methods) {
    if (method.getName().startsWith("get")
            && method.getParameterTypes().length == 0
            && !Modifier.isPublic(method.getModifiers())) {
  
      System.out.println(method.getName() + " have to be public!");
      errorsCnt++;
    
    } else if (method.getName().startsWith("set")
            && method.getParameterTypes().length == 1
            && void.class.equals(method.getReturnType())
            && !Modifier.isPrivate(method.getModifiers())) {
  
      System.out.println(method.getName() + " have to be private!");
      errorsCnt++;
      
    }
  }
  
  if (errorsCnt > 3) {
    System.out.println("Your code is full of bugs. You don’t understand encapsulation man");
  }
  
}
  
}

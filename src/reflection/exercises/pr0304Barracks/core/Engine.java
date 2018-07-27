package reflection.exercises.pr0304Barracks.core;

import jdk.jshell.spi.ExecutionControl;
import reflection.exercises.pr0304Barracks.annotations.Inject;
import reflection.exercises.pr0304Barracks.contracts.Executable;
import reflection.exercises.pr0304Barracks.contracts.Repository;
import reflection.exercises.pr0304Barracks.contracts.Runnable;
import reflection.exercises.pr0304Barracks.contracts.UnitFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

public static final String COMMAND_PATH = "reflection.exercises.pr0304Barracks.core.commands.";
public static final String COMMAND_SUFIX_NAME = "Command";

private String[] data;
private Repository repository;
private UnitFactory unitFactory;

public Engine(Repository repository, UnitFactory unitFactory) {
  
  this.repository = repository;
  this.unitFactory = unitFactory;
}

@Override
public void run() {
  
  BufferedReader reader = new BufferedReader(
          new InputStreamReader(System.in));
  while (true) {
    try {
      String input = reader.readLine();
      String[] data = input.split("\\s+");
      String commandName = data[0];
      String result = interpredCommand(data, commandName);
      if (result.equals("fight")) {
        break;
      }
      System.out.println(result);
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    } catch (IOException | ExecutionControl.NotImplementedException e) {
      e.printStackTrace();
    }
  }
}

private String interpredCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException {
  
  this.data = data;
  
  try {
    String commandClassName = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1);
    
    Class<?> commandClass = Class.forName(COMMAND_PATH + commandClassName + COMMAND_SUFIX_NAME);
    
    Constructor<?> declaredConstructor = commandClass.getDeclaredConstructor();
    
    Executable command = (Executable) declaredConstructor.newInstance();
    
    this.injectDependencies(command);
    
    return command.execute();
    
  } catch (ClassNotFoundException
          | NoSuchMethodException
          | InstantiationException
          | IllegalAccessException
          | InvocationTargetException e) {
    throw new RuntimeException("Invalid command!");
  }
}

private <T> void injectDependencies(T command) throws IllegalAccessException {
  
  Field[] commandFields = command.getClass().getDeclaredFields();
  Field[] engineFields = this.getClass().getDeclaredFields();
  
  
  for (Field commandField : commandFields) {
    commandField.setAccessible(true);
    if (commandField.isAnnotationPresent(Inject.class)) {
  
      for (Field engineField : engineFields) {
        engineField.setAccessible(true);
        
        if (commandField.getType().getSimpleName().equals(engineField.getType().getSimpleName()) &&
                commandField.getType().equals(engineField.getType())) {
          
          commandField.set(command, engineField.get(this));
        }
      }
    }
  }
}
}

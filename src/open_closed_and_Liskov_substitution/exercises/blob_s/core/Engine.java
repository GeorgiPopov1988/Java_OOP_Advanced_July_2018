package open_closed_and_Liskov_substitution.exercises.blob_s.core;

import open_closed_and_Liskov_substitution.exercises.blob_s.annotations.Inject;
import open_closed_and_Liskov_substitution.exercises.blob_s.interfaces.*;
import open_closed_and_Liskov_substitution.exercises.blob_s.interfaces.Runnable;
import open_closed_and_Liskov_substitution.exercises.blob_s.models.Blob;
import open_closed_and_Liskov_substitution.exercises.blob_s.observers.Subject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Engine implements Runnable {

    private static final String TERMINATE_COMMAND = "drop";
    private static final String COMMAND_PATH = "open_closed_and_Liskov_substitution.exercises.blob_s.core.commands.";
    private static final String COMMAND_SUFIX_NAME = "Command";

    private String[] data;
    private Reader reader;
    private Writer writer;
    private Repository<Blob> blobRepository;
    private Subject subject;

    public Engine (Reader reader, Writer writer,
                   Repository<Blob> blobRepository,
                   Subject subject) {

        this.reader = reader;
        this.writer = writer;
        this.blobRepository = blobRepository;
        this.subject = subject;
    }

    private String parseCommandName (String commandName) {

        return String.valueOf(commandName.charAt(0)).toUpperCase() + commandName.substring(1);
    }

    @Override
    public void run () {

        String line;
        while (true) {


            String input = reader.readLine();
            if (TERMINATE_COMMAND.equals(input)) {
                break;
            }

            String[] args = input.split("\\s+");
            this.interpredcommand(args, args[0]);

            this.subject.notifyAllObservers();
        }
    }

    private void interpredcommand (String[] data, String commandName) {

        this.data = Arrays.stream(data).skip(1).toArray(String[] ::new);

        try {
            String commandClassName = this.parseCommandName(commandName);

            Class<?> commandClass = Class.forName(COMMAND_PATH + commandClassName + COMMAND_SUFIX_NAME);

            Constructor<?> declaredConstructor = commandClass.getDeclaredConstructor();

            Executable command = (Executable) declaredConstructor.newInstance();

            this.injectDependencies(command);

            command.execute();

        } catch (ClassNotFoundException
                | NoSuchMethodException
                | InstantiationException
                | IllegalAccessException
                | InvocationTargetException e) {
            throw new RuntimeException("Invalid command!");
        }
    }

    private <T> void injectDependencies (T command) throws IllegalAccessException {

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

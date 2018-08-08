package cresla;

import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;
import cresla.io.Reader;
import cresla.io.Writer;
import cresla.manager.ManagerImpl;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main (String[] args) {

        Manager manager = new ManagerImpl();
        InputReader reader = new Reader();
        OutputWriter writer = new Writer();

        whileLoop:
        while (true) {

            List<String> arguments = Arrays.asList(reader.readLine().split("\\s+"));
            String command = arguments.get(0);

            switch (command) {
                case "Reactor":
                    writer.writeLine(manager.reactorCommand(arguments.subList(1, arguments.size())));
                    break;
                case "Module":
                    writer.writeLine(manager.moduleCommand(arguments.subList(1, arguments.size())));
                    break;
                case "Report":
                    writer.writeLine(manager.reportCommand(arguments.subList(1, arguments.size())));
                    break;
                default: // Exit
                    writer.writeLine(manager.exitCommand(arguments));
                    break whileLoop;
            }
        }
    }
}

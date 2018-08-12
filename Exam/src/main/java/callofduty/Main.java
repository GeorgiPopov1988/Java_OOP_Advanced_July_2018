package callofduty;

import callofduty.core.MissionManagerImpl;
import callofduty.interfaces.InputReader;
import callofduty.interfaces.MissionManager;
import callofduty.interfaces.OutputWriter;
import callofduty.io.ConsoleInputReader;
import callofduty.io.ConsoleOutputWriter;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args)  {

        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();

        MissionManager manager = new MissionManagerImpl();


        whileLoop:
        while (true) {

            List<String> arguments = Arrays.asList(reader.readLine().split("\\s+"));
            String command = arguments.get(0);

            switch (command) {

                case "Agent":
                    //manager.agent(arguments.subList(1, arguments.size()));
                    writer.println(manager.agent(arguments.subList(1, arguments.size())));
                    break;
                case "Request":
                    writer.println(manager.request(arguments.subList(1, arguments.size())));
                    break;
                case "Complete":
                    writer.println(manager.complete(arguments.subList(1, arguments.size())));
                    break;
                case "Status":
                    writer.println(manager.status(arguments.subList(1, arguments.size())));
                    break;
                case "Over":
                    writer.println(manager.over(arguments.subList(1, arguments.size())));
                    break whileLoop;
            }

        }
    }
}





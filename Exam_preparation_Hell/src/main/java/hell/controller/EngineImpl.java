package hell.controller;

import hell.interfaces.Engine;
import hell.interfaces.InputReader;
import hell.interfaces.Manager;
import hell.interfaces.OutputWriter;

import java.io.IOException;

public class EngineImpl implements Engine {

    private InputReader reader;
    private OutputWriter writer;
    private Manager manager;

    public EngineImpl (InputReader reader, OutputWriter writer) {

        this.reader = reader;
        this.writer = writer;
        this.manager = new CommandManager();
    }


    @Override
    public void run () throws IOException, IllegalAccessException {

        String line;
        while (true) {
            line = reader.readLine();

            String[] tokens = line.split("\\s+");

            this.manager.acceptData(tokens);

            if ("Quit".equals(tokens[0])) {
                break;
            }

        }
    }

}

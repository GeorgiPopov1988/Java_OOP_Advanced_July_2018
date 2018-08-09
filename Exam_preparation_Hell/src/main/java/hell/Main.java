package hell;

import hell.controller.EngineImpl;
import hell.interfaces.Engine;
import hell.interfaces.InputReader;
import hell.interfaces.OutputWriter;
import hell.io.ConsoleInputReader;
import hell.io.ConsoleOutputWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();

        Engine engine = new EngineImpl(reader, writer);

        try {
            engine.run();
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
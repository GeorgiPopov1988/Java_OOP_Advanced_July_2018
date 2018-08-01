package open_closed_and_Liskov_substitution.exercises.blob_s.io;

public class ConsoleOutputWriter implements open_closed_and_Liskov_substitution.exercises.blob_s.interfaces.Writer {

  @Override
  public void writeLine (String output) {
    System.out.println(output);
  }
}

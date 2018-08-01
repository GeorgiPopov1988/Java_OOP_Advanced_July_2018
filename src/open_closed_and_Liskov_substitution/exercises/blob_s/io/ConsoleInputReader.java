package open_closed_and_Liskov_substitution.exercises.blob_s.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputReader implements open_closed_and_Liskov_substitution.exercises.blob_s.interfaces.Reader {
  private BufferedReader reader;
  
  public ConsoleInputReader () {
    this.reader = new BufferedReader(new InputStreamReader(System.in));
  }

  @Override
  public String readLine () {
    String result = "";
    
    try {
      result = this.reader.readLine();
    } catch (IOException e) {
    
    }
    
    return result;
  }
}

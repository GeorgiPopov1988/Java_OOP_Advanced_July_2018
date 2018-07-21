package enumerations_and_annotations.lab.p02_Warning_levels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

public static void main(String[] args) throws IOException {
  
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  
  String line = reader.readLine();
  Logger logger = new Logger(line);
  
  
  while (! "END".equals(line = reader.readLine())) {
    
    String[] inTokens = line.split(": ");
    String messageImportanceLeve = inTokens[0];
    String messageContent = inTokens[1];
    Message message = new Message(messageImportanceLeve, messageContent);
    logger.addMessage(message);
  }
  
  for (Message message : logger.getMessages()) {
    System.out.println(message);
  }
  ;
  
}
  
}

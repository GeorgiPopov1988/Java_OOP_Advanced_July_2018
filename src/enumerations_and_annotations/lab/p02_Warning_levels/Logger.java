package enumerations_and_annotations.lab.p02_Warning_levels;

import java.util.ArrayList;
import java.util.List;

public class Logger {

private Importance minImportanceLevel;
private List<Message> messages;

public Logger(String minImportanceLevel) {
  
  this.minImportanceLevel = Enum.valueOf(Importance.class, minImportanceLevel.toUpperCase());
  this.messages = new ArrayList<>();
}

public void addMessage(Message message) {
  
  if (message.getImportanceLevel().compareTo(this.minImportanceLevel) >= 0) {
    this.messages.add(message);
  }
}

public Iterable<Message> getMessages() {
  
  return this.messages;
}


}

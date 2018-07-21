package enumerations_and_annotations.lab.p02_Warning_levels;

public class Message {
  
  private Importance importanceLevel;
  private String message;

public Message(String importanceLevel, String message) {
  
  this.importanceLevel = Enum.valueOf(Importance.class, importanceLevel.toUpperCase());
  this.message = message;
}

public Importance getImportanceLevel() {
  return this.importanceLevel;
}

@Override
public String toString() {
  
  return String.format("%s: %s", this.importanceLevel, this.message);
}
}

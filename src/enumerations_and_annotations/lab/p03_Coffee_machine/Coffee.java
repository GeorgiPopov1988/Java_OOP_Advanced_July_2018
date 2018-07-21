package enumerations_and_annotations.lab.p03_Coffee_machine;

public class Coffee {
  
  private CoffeeType type;
  private CoffeeSize size;

public Coffee(String type, String size) {
  
  this.type = Enum.valueOf(CoffeeType.class, type.toUpperCase());
  this.size = Enum.valueOf(CoffeeSize.class, size.toUpperCase());
}

@Override
public String toString() {
  
  return String.format("%s %s", this.size.toString(), this.type.toString());
}

public int getPrice() {
  
  return this.size.getPriceInCoins();
}
}

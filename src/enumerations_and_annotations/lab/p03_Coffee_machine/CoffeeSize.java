package enumerations_and_annotations.lab.p03_Coffee_machine;

public enum CoffeeSize {
  
  SMALL(50, 50), NORMAL(100, 75), DOUBLE(200, 100);

private int sizeInMl;
private int priceInCoins;

CoffeeSize(int sizeInMl, int priceInCoins) {
  
  this.sizeInMl = sizeInMl;
  this.priceInCoins = priceInCoins;
}

public int getSizeInMl() {
  
  return sizeInMl;
}

public int getPriceInCoins() {
  
  return priceInCoins;
}

@Override
public String toString() {
  
  return super.name().charAt(0) + super.name().substring(1).toLowerCase();
}
}

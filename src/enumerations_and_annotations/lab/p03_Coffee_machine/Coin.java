package enumerations_and_annotations.lab.p03_Coffee_machine;

public enum Coin {
  
  ONE(1), TWO(2), FIVE(5), TEN(10), TWENTY(20), FIFTY(50);

private int coinValue;

Coin(int value) {
  
  this.coinValue = value;
}

public int getCoinValue() {
  return this.coinValue;
}
}

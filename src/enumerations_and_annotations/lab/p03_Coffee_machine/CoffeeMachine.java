package enumerations_and_annotations.lab.p03_Coffee_machine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {

private List<Coffee> coffees;
private int money;

public CoffeeMachine() {
  
  this.coffees = new ArrayList<>();
}


public void buyCoffee(String size, String type) {
  
  Coffee coffee = new Coffee(type, size);
  int coffeePrice = coffee.getPrice();
  
  if (coffeePrice <= this.money) {
    this.coffees.add(coffee);
  }
}

public void insertCoin(String coinType) {
  
  this.money += Enum.valueOf(Coin.class, coinType.toUpperCase()).getCoinValue();
}

public Iterable<Coffee> coffeesSold() {
  
  return this.coffees;
}

}

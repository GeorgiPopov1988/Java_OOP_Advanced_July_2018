package enumerations_and_annotations.exercises.p01_Card_suit;

import java.util.ArrayList;
import java.util.List;

public class Player {

private String name;
private List<Card> hand;

public Player(String name) {
  
  this.name = name;
  this.hand = new ArrayList<>();
}

public String getName() {
  
  return this.name;
}

public int getHandSize() {
  
  return this.hand.size();
}

public Card getPowerfulCard() {
  
  return this.hand.stream().max(Card :: compareTo)
          .get();
}

public void addCard(Card card) {
  
  this.hand.add(card);
}

public boolean isHandFull() {
  
  return this.hand.size() == 5;
}
}

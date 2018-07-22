package enumerations_and_annotations.exercises.p01_Card_suit;

public class Card implements Comparable<Card>
{
 
 private CardRank rank;
 private CardSuit suit;

public Card(String rank, String suit) {
  
  this.rank = Enum.valueOf(CardRank.class, rank.toUpperCase());
  this.suit = Enum.valueOf(CardSuit.class, suit.toUpperCase());
}

public CardRank getRankType() {
  
  return this.rank;
}

public  CardSuit getSuitType() {
  return this.suit;
}

private int getTotalPower() {
  return this.rank.getPower() + this.suit.getPower();
}

//          this.rank.name(), this.suit.name(), this.getTotalPower());
//  return String.format("Card name: %s of %s; Card power: %d",
//  //Card name: ACE of SPADES; Card power: 53
//
//public String toString() {
//@Override

//}


@Override
public String toString() {
  
  return String.format("%s of %s", this.rank.name(), this.suit.name());
}

@Override
public int compareTo(Card other) {
  
  return this.getTotalPower() - other.getTotalPower();
}
}

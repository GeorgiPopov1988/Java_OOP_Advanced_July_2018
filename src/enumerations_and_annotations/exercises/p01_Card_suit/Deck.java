package enumerations_and_annotations.exercises.p01_Card_suit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Deck implements Iterable<Card> {

private List<Card> deck;

public Deck() {
  
  this.deck = new ArrayList<>();
  this.fillInDeck();
}

private void fillInDeck() {
  
  for (CardSuit suit : CardSuit.values()) {
    for (CardRank rank : CardRank.values()) {
      //System.out.println(suit.name());
      //System.out.println(rank.name());
      Card card = new Card(rank.name(), suit.name());
      this.deck.add(card);
    }
  }
}

public boolean contains(Card card) {
  
  return this.deck.stream().anyMatch(card1 -> card1.getRankType().equals(card.getRankType()) &&
  card1.getSuitType().equals(card.getSuitType()));
}

public void remove(Card card) {
  
  this.deck.removeIf(innerCard -> innerCard.getRankType().equals(card.getRankType()) &&
  innerCard.getSuitType().equals(card.getSuitType()));
}


@Override
public void forEach(Consumer<? super Card> action) {
  
  for (Card card : this) {
    action.accept(card);
  }
}

@Override
public Iterator<Card> iterator() {
  
  return new DeckIterator();
}

private final class DeckIterator implements Iterator<Card> {

private int index;

DeckIterator() {
  
  this.index = 0;
}

@Override
public boolean hasNext() {
  
  return deck.size() != this.index;
}

@Override
public Card next() {
  
  return deck.get(this.index++);
}
}
}

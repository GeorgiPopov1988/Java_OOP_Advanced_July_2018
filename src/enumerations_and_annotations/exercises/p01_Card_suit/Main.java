package enumerations_and_annotations.exercises.p01_Card_suit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

public static void main(String[] args) throws IOException {
  
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  
  // p01_
//  CardSuit[] cardSuits = CardSuit.values();
//  //Card Suits:
//  //Ordinal value: 0; Name value: CLUBS

//  System.out.println("Card Suits:");
//  for (CardSuit cardSuit: cardSuits) {
//    System.out.printf("Ordinal value: %d; Name value: %s%n", cardSuit.ordinal(), cardSuit.name());
//  }
  // p02_
//  CardRank[] cardsRanks = CardRank.values();
//  //Card Ranks:
//  //Ordinal value: 0; Name value: TWO
//
//  System.out.println("Card Ranks:");
//  for (CardRank cardsRank : cardsRanks) {
//    System.out.printf("Ordinal value: %d; Name value: %s%n", cardsRank.ordinal(), cardsRank.name());
//  }
  
  // p03_; p04_; p05
//  String rank = reader.readLine();
//  String suit = reader.readLine();
//
//  Card card1 = new Card(rank, suit);
//
//  rank = reader.readLine();
//  suit = reader.readLine();
//  Card card2 = new Card(rank, suit);
//
//  if (card1.compareTo(card2) > 0) {
//    System.out.println(card1);
//  } else {
//    System.out.println(card2);
//  }
  
  // p06_
//  String annotationType = reader.readLine();
//
//  if ("Rank".equals(annotationType)) {
//    Class<CardRank> rankClass = CardRank.class;
//    printCustomCardsAnnotation(rankClass);
//  } else if ("Suit".equals(annotationType)) {
//    Class<CardSuit> suitClass = CardSuit.class;
//    printCustomCardsAnnotation(suitClass);
//  }
  
  // p07_
//  String input = reader.readLine();
//
//  if ("Card Deck".equals(input)) {
//    Deck deck = new Deck();
//    deck.forEach(System.out :: println);
//  }
  
  // p08_
  
  Player player1 = new Player(reader.readLine());
  Player player2 = new Player(reader.readLine());
  
  CardGame game = new CardGame(player1, player2);
  
  Card card = null;
  Deck deck = new Deck();
  
  while (true) {
    if (player1.isHandFull() && player2.isHandFull()) {
      break;
    }
    String[] input = reader.readLine().split(" ");
    
    try {
      String rank = input[0];
      String suit = input[2];
      
      card = new Card(rank, suit);
    } catch (IllegalArgumentException iae) {
      System.out.println("No such card exists.");
      continue;
    }
    
    if (deck.contains(card)) {
      deck.remove(card);
    } else {
      System.out.println("Card is not in the deck.");
      continue;
    }
  
    if (player1.getHandSize() < 5) {
      player1.addCard(card);
    } else if (player2.getHandSize() < 5) {
      player2.addCard(card);
    }
  }
  
  
  Player winner = game.getWinner();
  System.out.println(String.format("%s wins with %s.",
          winner.getName(), winner.getPowerfulCard()));
  
  
}

private static void printCustomCardsAnnotation(Class<?> printClass) {
  
  if (printClass.isAnnotationPresent(CustomCardsAnnotation.class)) {
    CustomCardsAnnotation annotation = printClass.getAnnotation(CustomCardsAnnotation.class);
    //Type = Enumeration, Description = Provides rank constants for a Card class.
    System.out.println(String.format("Type = %s, Description = %s",
            annotation.type(), annotation.description()));
  }
  
}
  
}

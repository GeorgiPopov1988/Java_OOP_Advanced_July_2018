package enumerations_and_annotations.exercises.p01_Card_suit;

public class CardGame {
  
  private Player player1;
  private Player player2;
public CardGame(Player player1, Player player2) {
  
  this.player1 = player1;
  this.player2 = player2;
}


public Player getWinner() {
  
  return this.player1.getPowerfulCard()
          .compareTo(this.player2.getPowerfulCard()) > 0 ?
          this.player1 : this.player2;
}
}

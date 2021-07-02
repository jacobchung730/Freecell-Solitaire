package cs3500.freecell.controller;

import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.FreecellModelCreator;
import cs3500.freecell.model.FreecellModelCreator.GameType;
import cs3500.freecell.model.hw02.Card;
import java.io.InputStreamReader;
import java.util.List;

/**
 * MainFreecell is the class that houses the main method which is used to run the Freecell game. The
 * Freecell game consists of a standard 52 card deck and cascade, open, and foundation piles. The
 * objective of the game is to move all cards to the foundation piles in the correct ordering, which
 * is from Ace all the way up to King.
 */
public class MainFreecell {

  /**
   * Main method to run the Freecell game.
   *
   * @param args command line input is required to play this freecell game
   */
  public static void main(String[] args) {

    // SINGLEMOVE or MULTIMOVE model
    FreecellModel<Card> simpleModel = FreecellModelCreator.create(GameType.SINGLEMOVE);
    FreecellModel<Card> multiModel = FreecellModelCreator.create(GameType.MULTIMOVE);

    List<Card> simpleDeck = simpleModel.getDeck();
    List<Card> multiDeck = multiModel.getDeck();



    new SimpleFreecellController(multiModel, new InputStreamReader(System.in),
        System.out).playGame(multiDeck, 18, 10, true);
  }
}

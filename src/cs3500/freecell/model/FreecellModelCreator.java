package cs3500.freecell.model;

import cs3500.freecell.model.hw02.Card;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import cs3500.freecell.model.hw04.MultiFreecellModel;

/**
 * The FreecellModelCreator class represents a factory class which has the method create. This
 * method will create a Freecell game depending on the the input which can either be a SINGLEMOVE or
 * a MULTIMOVE.
 */
public class FreecellModelCreator {

  /**
   * The GameType can either be a SINGLEMOVE or a MULTIMOVE. A SINGLEMOVE allows the user to move at
   * MOST one card at a time. A MULTIMOVE allows the user to move multiple cards at once, but only
   * from cascade to cascade.
   */
  public enum GameType {
    SINGLEMOVE, MULTIMOVE;
  }

  /**
   * creates a FreecellModel game, based on a GameType input.
   *
   * @param type the type of game one can play, either SINGLEMOVE or MULTIMOVE
   * @return a FreecellModel game that is either a SINGLEMOVE or MULTIMOVE
   */
  public static FreecellModel<Card> create(GameType type) {

    if (type == null) {
      throw new IllegalArgumentException("GameType cannot be null!");
    } else if (type == GameType.SINGLEMOVE) {
      return new SimpleFreecellModel();
    } else if (type == GameType.MULTIMOVE) {
      return new MultiFreecellModel();
    } else {
      throw new IllegalArgumentException("Must be a SINGLEMOVE or a MULTIMOVE GameType!");
    }
  }

}



package cs3500.freecell.controller;

import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.PileType;
import cs3500.freecell.model.hw02.Card;
import cs3500.freecell.view.FreecellTextView;
import cs3500.freecell.view.FreecellView;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


/**
 * represents a controller for the {@code SimpleFreecellModel} class. The controller runs the
 * program and connects the model and the view. This class offers the playGame method which allows a
 * user to play this Freecell game.
 */
public class SimpleFreecellController implements FreecellController<Card> {

  private final FreecellModel<Card> model;
  private final Readable rd;
  private Appendable ap;
  private final FreecellView view;


  /**
   * Constructs a {@code SimpleFreecellController} object by initializing a new view using the
   * given model and appenadble.
   *
   * @param model the model for the freecell game
   * @param rd    rd is what the controller will read to
   * @param ap    ap is what the controller will output to
   * @throws IllegalArgumentException if model, rd, or ap, is null
   */
  public SimpleFreecellController(FreecellModel<Card> model, Readable rd, Appendable ap) throws
      IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("model cannot be null!");
    }
    if (rd == null) {
      throw new IllegalArgumentException("rd cannot be null!");
    }
    if (ap == null) {
      throw new IllegalArgumentException("ap cannot be null!");
    }

    this.model = model;
    this.rd = rd;
    this.ap = ap;
    this.view = new FreecellTextView(model, ap);
  }


  @Override
  public void playGame(List<Card> deck, int numCascades, int numOpens, boolean shuffle)
      throws IllegalStateException, IllegalArgumentException {

    if (deck == null) {
      throw new IllegalArgumentException("deck cannot be null!");
    }
    if (this.rd == null) {
      throw new IllegalStateException("rd cannot be null!");
    }
    if (this.ap == null) {
      this.ap = System.out;
    }

    try {
      model.startGame(deck, numCascades, numOpens, shuffle);
    } catch (IllegalArgumentException e) {
      try {
        this.view.renderMessage("Could not start game.");
        return;
      } catch (IOException ioException) {
        throw new IllegalStateException("writing to the Appendable object has failed!");
      }
    }

    try {
      this.view.renderBoard();
      this.view.renderMessage("\n");
    } catch (IOException e) {
      throw new IllegalStateException("writing to the Appendable object has failed!");
    }

    PileType sourcePile = null;
    Integer sourcePileIndex = null;
    Integer cardIndex = null;
    PileType destinationPile = null;
    Integer destinationPileIndex = null;
    int count = 0;

    Scanner scan = new Scanner(this.rd);

    while (scan.hasNext()) {

      if (nextIsQ(scan)) {
        try {
          this.view.renderMessage("\nGame quit prematurely.");
          return;
        } catch (IOException e) {
          throw new IllegalStateException("writing to the Appendable object has failed!");
        }
      }

      if (count == 0) {
        try {
          String nextString = scan.next();
          sourcePile = this.findPileType(nextString);
          sourcePileIndex = Integer.parseInt(nextString.substring(1));
          count++;

        } catch (IllegalArgumentException e) {
          try {
            this.view.renderMessage("Please enter a valid sourcePile, sourcePileIndex, cardIndex, "
                + "destinationPile, and destinationPileIndex:\n");
            continue;
          } catch (IOException ioException) {
            throw new IllegalStateException("writing to the Appendable object has failed!");
          }
        }
      }

      if (nextIsQ(scan)) {
        try {
          this.view.renderMessage("\nGame quit prematurely.");
          return;
        } catch (IOException e) {
          throw new IllegalStateException("writing to the Appendable object has failed!");
        }
      }

      if (count == 1) {
        try {
          String nextString = scan.next();
          cardIndex = Integer.parseInt(nextString);
          count++;

        } catch (IllegalArgumentException e) {
          try {
            this.view.renderMessage("Please enter a valid cardIndex, destinationPile, and "
                + "destinationPileIndex:\n");
            continue;
          } catch (IOException ioException) {
            throw new IllegalStateException("writing to the Appendable object has failed!");
          }
        }
      }

      if (nextIsQ(scan)) {
        try {
          this.view.renderMessage("\nGame quit prematurely.");
          return;
        } catch (IOException e) {
          throw new IllegalStateException("writing to the Appendable object has failed!");
        }
      }

      if (count == 2) {
        try {
          String nextString = scan.next();
          destinationPile = this.findPileType(nextString);
          destinationPileIndex = Integer.parseInt(nextString.substring(1));
          count++;

        } catch (IllegalArgumentException e) {
          try {
            this.view
                .renderMessage("Please enter a valid destinationPile and destinationPileIndex:\n");
            continue;
          } catch (IOException ioException) {
            throw new IllegalStateException("writing to the Appendable object has failed!");
          }
        }
      }

      if (count == 3) {
        count = 0;

        if ((sourcePile != null) && (sourcePileIndex > 0) && (cardIndex > 0)
            && (destinationPile != null) && (destinationPileIndex > 0)) {

          try {
            model.move(sourcePile, (sourcePileIndex - 1), (cardIndex - 1), destinationPile,
                (destinationPileIndex - 1));
            try {
              this.view.renderBoard();
              this.view.renderMessage("\n");
            } catch (IOException e) {
              throw new IllegalStateException("writing to the Appendable object has failed!");
            }
          } catch (IllegalArgumentException e) {
            try {
              this.view.renderMessage("Could not perform move! Please enter a valid sourcePile, "
                  + "sourcePileIndex, cardIndex, destinationPile, and destinationPileIndex:\n");
            } catch (IOException ioException) {
              throw new IllegalStateException("writing to the Appendable object has failed!");
            }
          }

          sourcePile = null;
          sourcePileIndex = null;
          cardIndex = null;
          destinationPile = null;
          destinationPileIndex = null;

        }
      }

      if (model.isGameOver()) {
        try {
          this.view.renderMessage("\nGame over.");
          return;
        } catch (IOException e) {
          throw new IllegalStateException("writing to the Appendable object has failed!");
        }
      }
    }

    if (!scan.hasNext()) {
      throw new IllegalStateException("the readable does not have a next!");
    }

  }


  // determines if the next string in the scanner is a "q" or "Q" which is used to quit the game
  private boolean nextIsQ(Scanner scan) {
    return (scan.hasNext("q") || scan.hasNext("Q"));
  }

  // returns a PileType based on the first letter of the given String
  private PileType findPileType(String nextString) {
    String firstLetter = nextString.substring(0, 1);

    switch (firstLetter) {
      case "C":
      case "c":
        return PileType.CASCADE;
      case "O":
      case "o":
        return PileType.OPEN;
      case "F":
      case "f":
        return PileType.FOUNDATION;
      default:
        throw new IllegalArgumentException("First letter does not correspond to a PileType!");
    }
  }

  // determines if the given sourcePileIndex is valid for the corresponding sourcePile
  // (either cascade or open)
  private boolean cardIndexValid(PileType sourcePile, int sourcePileIndex,
      int numCascades, int numOpens) {

    if (sourcePile.equals(PileType.CASCADE)) {
      return (sourcePileIndex > 0) && (sourcePileIndex <= numCascades);
    } else if (sourcePile.equals(PileType.OPEN)) {
      return (sourcePileIndex > 0) && (sourcePileIndex <= numOpens);
    } else if (sourcePile.equals(PileType.FOUNDATION)) {
      return (sourcePileIndex > 0) && (sourcePileIndex <= 4);
    } else {
      return false;
    }
  }

}

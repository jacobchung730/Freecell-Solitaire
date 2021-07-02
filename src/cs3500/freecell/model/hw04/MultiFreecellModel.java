package cs3500.freecell.model.hw04;

import cs3500.freecell.model.PileType;
import cs3500.freecell.model.hw02.Card;
import cs3500.freecell.model.hw02.Pile;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * This class represents a MultiFreecellModel which is like the SimpleFreecellModel class, but now
 * allows multi-card moves from a cascade pile to another cascade pile. This class still has
 * objective as the SimpleFreecellModel game which is to eventually move all cards to its
 * corresponding foundation piles.
 *
 */
public class MultiFreecellModel extends SimpleFreecellModel {


  @Override
  public void move(PileType source, int pileNumber, int cardIndex, PileType destination,
      int destPileNumber) throws IllegalArgumentException, IllegalStateException {

    // see if this is a cascade to cascade move
    if ((source == PileType.CASCADE) && (destination == PileType.CASCADE)) {

      // throws exception if any parameters are invalid
      if (!validateParameters(source, pileNumber, cardIndex, destination, destPileNumber)) {
        throw new IllegalArgumentException("parameters are not valid!");
      }

      // initializes the sourcePile and destinationPile
      Pile sourcePile = this.cascade.get(pileNumber);
      Pile destinationPile = this.cascade.get(destPileNumber);

      // there must be enough empty cascade and open piles to continue
      if (numEmptyCascadeAndOpenPiles() < (sourcePile.determineSize() - cardIndex)) {
        throw new IllegalArgumentException("moving too many cards without enough empty piles!");
      }

      // initializes the cards that will potentially be moved
      List<Card> cardsToBeMoved = createCardsToMoved(cardIndex, sourcePile.getCardsFromPile());

      // if the destination cascade pile is empty, then multi-card move will occur
      if (destinationPile.determineSize() == 0) {

        // moves the cards from the sourcePile to the destinationPile
        this.performMove(sourcePile, destinationPile, cardsToBeMoved);

        // checks to see if the card at the top of the destination pile is a different color and
        // one value higher than the bottom card of the cards that will be moved
      } else if ((destinationPile.getCardFromPile(destinationPile.determineSize() - 1))
          .differentColorAndOneValueMore(sourcePile.getCardFromPile(cardIndex))) {

        // makes sure that the correct number of cards is being moved
        if (sourcePile.determineSize() != (cardsToBeMoved.size() + cardIndex)) {
          throw new IllegalArgumentException("trying to move incorrect number of cards");
        }

        // moves the cards from the sourcePile to the destinationPile
        this.performMove(sourcePile, destinationPile, cardsToBeMoved);

      } else {
        throw new IllegalArgumentException("trying to move card even though it is not a different"
            + "color or one value less!");
      }
    } else {
      // calls move from SimpleFreecellModel is if it a single-card move
      super.move(source, pileNumber, cardIndex, destination, destPileNumber);
    }
  }


  // removes the cardsToBeMoved from the given sourcePile and then adds the cardsToBeMoved to
  // the given destinationPile
  private void performMove(Pile sourcePile, Pile destinationPile, List<Card> cardsToBeMoved) {
    sourcePile.removeAllCards(cardsToBeMoved);
    destinationPile.addAllCards(cardsToBeMoved);
  }


  // returns the cards to be moved based on the given cardIndex. The card index is used as the
  // start of the return list.
  private List<Card> createCardsToMoved(int cardIndex, List<Card> sourcePile) {
    List<Card> answer = new ArrayList<Card>(Arrays.asList(sourcePile.get(cardIndex)));

    for (int i = cardIndex; i < (sourcePile.size() - 1); i++) {
      if (sourcePile.get(i).differentColorAndOneValueMore(sourcePile.get(i + 1))) {
        answer.add(sourcePile.get(i + 1));
      } else {
        throw new IllegalArgumentException("Card being moved must be different color and one value "
            + "less than the card it is going onto!");
      }
    }
    return answer;
  }


  // determines if all of the parameters are valid for the freecell game
  private boolean validateParameters(PileType source, int pileNumber, int cardIndex, PileType
      destination, int destPileNumber) {
    return (source != null) && (destination != null)
        && (0 <= pileNumber) && (0 <= destPileNumber)
        && (this.cascade.size() > pileNumber) && (this.cascade.size() > destPileNumber)
        && (this.cascade.get(pileNumber).determineSize() > cardIndex) && (0 <= cardIndex);
  }


  // returns the total number of moves that can be made at a time from one cascade pile to another
  // cascade pile. formula is (N + 1) * (2^K) where n is open and k is cascade
  private int numEmptyCascadeAndOpenPiles() {

    int numEmptyCascadePiles = 0;
    int numEmptyOpenPiles = 0;

    for (int i = 0; i < this.cascade.size(); i++) {
      if (this.cascade.get(i).determineSize() == 0) {
        numEmptyCascadePiles++;
      }
    }

    for (int j = 0; j < this.open.size(); j++) {
      if (this.open.get(j).determineSize() == 0) {
        numEmptyOpenPiles++;
      }
    }

    return (int) ((numEmptyOpenPiles + 1) * Math.pow(2, numEmptyCascadePiles));
  }


}


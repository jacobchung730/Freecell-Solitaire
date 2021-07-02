package cs3500.freecell.model.hw02;

import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.PileType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
  Fields of the SimpleFreecellModel class were private. Now, there are protected because
  a new class called MultiFreecellModel was created that extends the SimpleFreecellModel class.
  The fields marked as protected now gives the MultiFreecellModel class access to these fields.
 */

/**
 * Represents a game of Freecell. In this game, a player can move cards between a foundation, open,
 * and cascade pile. The objective of the game is to successfully move all cards to the foundation
 * piles.
 */
public class SimpleFreecellModel implements FreecellModel<Card> {

  protected ArrayList<Pile> foundation;
  protected ArrayList<Pile> cascade;
  protected ArrayList<Pile> open;
  protected boolean started;

  /**
   * Constructs a {@code SimpleFreecellModel} object which initializes new ArrayLists of Piles
   * for the foundation, cascade, and open piles. The initial boolean for the started field is
   * equal to false because the game has not been started yet.
   */
  public SimpleFreecellModel() {
    this.foundation = new ArrayList<Pile>();
    this.cascade = new ArrayList<Pile>();
    this.open = new ArrayList<Pile>();
    this.started = false;
  }


  @Override
  public List<Card> getDeck() {
    List<Card> deck = new ArrayList<>();

    for (Value v : Value.values()) {
      for (Symbol s : Symbol.values()) {
        deck.add(new Card(v, s));
      }
    }
    return deck;
  }


  @Override
  public void startGame(List<Card> deck, int numCascadePiles, int numOpenPiles, boolean shuffle)
      throws IllegalArgumentException {

    // resets game if the game was played previously
    this.foundation = new ArrayList<Pile>();
    this.cascade = new ArrayList<Pile>();
    this.open = new ArrayList<Pile>();
    this.started = false;

    if (deck == null) {
      throw new IllegalArgumentException("Deck can't be null!");
    }

    if (!Utils.validateDeck(deck)) {
      throw new IllegalArgumentException("Deck is not a valid deck!");
    }
    if (numCascadePiles < 4) {
      throw new IllegalArgumentException("Must have at least 4 cascade piles!");
    }
    if (numOpenPiles < 1) {
      throw new IllegalArgumentException("Must have at least 1 open pile!");
    }
    if (shuffle) {
      Collections.shuffle(deck);
    }

    this.started = true;

    // adds empty Piles (Lists of cards) to foundation, cascade, open
    this.pileSetup(numCascadePiles, numOpenPiles);

    // disperses each card into a cascade Pile (list of cards)
    this.disperseIntoCascade(deck, numCascadePiles);
  }

  // determines which pile we want to add to and disperses (round robin style).
  private void disperseIntoCascade(List<Card> deck, int numCascadePiles) {
    int counter = 0;

    for (Card card : deck) {
      // resets the counter
      if (numCascadePiles == counter) {
        counter = 0;
      }
      cascade.get(counter).addToPile(card);
      counter++;
    }
  }

  // creates piles (list of cards) for foundation, cascade, and open.
  private void pileSetup(int numCascadePiles, int numOpenPiles) {

    // adds 4 piles (lists of cards) to this.foundation
    // every game always has 4 foundation piles
    for (int i = 0; i < 4; i++) {
      this.foundation.add(new Pile(new ArrayList<Card>()));
    }

    // adds numCascadePiles amount of piles to this.cascade
    // a game must have at least 4 cascade piles
    for (int j = 0; j < numCascadePiles; j++) {
      this.cascade.add(new Pile(new ArrayList<Card>()));
    }

    // adds numOpenPiles amount of piles to this.open
    // a game must have at least 1 open pile
    for (int k = 0; k < numOpenPiles; k++) {
      this.open.add(new Pile(new ArrayList<Card>()));
    }
  }

  @Override
  public String toString() {
    StringBuilder answer = new StringBuilder();

    if (!started) {
      return "";
    } else {

      for (int i = 0; i < 4; i++) {
        if (i == 0) {
          answer.append("F");
        } else {
          answer.append("\nF");
        }
        answer.append(i + 1).append(":").append(foundation.get(i).toString());
      }

      for (int j = 0; j < open.size(); j++) {
        answer.append("\nO");
        answer.append(j + 1).append(":").append(open.get(j).toString());
      }

      for (int k = 0; k < cascade.size(); k++) {
        answer.append("\nC");
        answer.append(k + 1).append(":").append(cascade.get(k).toString());
      }
    }
    return answer.toString();
  }


  @Override
  public void move(PileType source, int pileNumber, int cardIndex, PileType destination,
      int destPileNumber) throws IllegalArgumentException, IllegalStateException {

    if (started) {
      Card sourceCard;

      switch (source) {
        case FOUNDATION:
          throw new IllegalArgumentException("cannot remove card from foundation pile!");
        case CASCADE:
          if (cardIndex == (this.getNumCardsInCascadePile(pileNumber) - 1)) {
            sourceCard = this.getCascadeCardAt(pileNumber, cardIndex);
            this.cascade.get(pileNumber).deleteFromPile(cardIndex);
          } else {
            throw new IllegalArgumentException("Card must be at top of cascade pile");
          }
          break;
        case OPEN:
          if (cardIndex == (this.getNumCardsInOpenPile(pileNumber) - 1)) {
            sourceCard = this.getOpenCardAt(pileNumber);
            this.open.get(pileNumber).deleteFromPile(cardIndex);
          } else {
            throw new IllegalArgumentException("Card must be at top of open pile");
          }
          break;
        default:
          throw new IllegalArgumentException("Source must be a foundation, cascade, or open pile!");
      }

      if (sourceCard == null) {
        throw new IllegalArgumentException("Card can't be null!");
      }

      this.moveBecauseValid(sourceCard, destination, destPileNumber);

    } else {
      throw new IllegalStateException("cannot move if game has not started!");
    }
  }

  // moves the card to the destination pile if it is a valid move.
  private void moveBecauseValid(Card sourceCard, PileType destination, int destPileNumber) {

    switch (destination) {
      case FOUNDATION:
        this.addToFoundation(sourceCard, destPileNumber);
        break;
      case CASCADE:
        this.addToCascade(sourceCard, destPileNumber);
        break;
      case OPEN:
        this.addToOpen(sourceCard, destPileNumber);
        break;
      default:
        throw new IllegalArgumentException(
            "Destination must be a foundation, cascade, or open pile!");
    }
  }

  // adds the given sourceCard to the foundation pile.
  private void addToFoundation(Card sourceCard, int destPileNumber) {

    // check if there is nothing in foundation pile
    if (this.getNumCardsInFoundationPile(destPileNumber) == 0) {
      // make sure this card is not something other than an ace
      if (sourceCard.getValueIndex() != 0) {
        throw new IllegalArgumentException("card is not an ace!");
      } else {
        this.foundation.get(destPileNumber).addToPile(sourceCard);
      }
    } else {
      Card cardAtTopOfPile = getFoundationCardAt(destPileNumber,
          this.getNumCardsInFoundationPile(destPileNumber) - 1);

      // check to see if the sourceCard value is 1 higher than cardAtTopOfPile value
      // and check to see if the symbol is the same
      if ((sourceCard.getValueIndex() == (1 + cardAtTopOfPile.getValueIndex()))
          && (sourceCard.getSymbol() == (cardAtTopOfPile.getSymbol()))) {
        this.foundation.get(destPileNumber).addToPile(sourceCard);
      } else {
        throw new IllegalArgumentException(
            "card is not the same suit or card is not one value higher!");
      }
    }
  }

  // adds the given sourceCard to the cascade pile.
  private void addToCascade(Card sourceCard, int destPileNumber) {
    // check if there is nothing in cascade pile
    if (getNumCardsInCascadePile(destPileNumber) == 0) {
      this.cascade.get(destPileNumber).addToPile(sourceCard);
    } else {

      Card cardAtTopOfPile = this.getCascadeCardAt(destPileNumber,
          getNumCardsInCascadePile(destPileNumber) - 1);

      // check that card being put to cascade pile is value 1 less
      if (1 + (sourceCard.getValueIndex()) == cardAtTopOfPile.getValueIndex()) {
        // if cardAtTopOfPile symbol is red, then sourceCard symbol must be black
        if (((Symbol.HEARTS == cardAtTopOfPile.getSymbol()) || (Symbol.DIAMONDS == cardAtTopOfPile
            .getSymbol()))
            && ((Symbol.CLUBS == sourceCard.getSymbol()) || (Symbol.SPADES == sourceCard
            .getSymbol()))) {
          this.cascade.get(destPileNumber).addToPile(sourceCard);
        } else if ( // if cardAtTopOfPile symbol is black, then sourceCard symbol must be red
            ((Symbol.CLUBS == cardAtTopOfPile.getSymbol()) || (Symbol.SPADES == cardAtTopOfPile
                .getSymbol()))
                && ((Symbol.HEARTS == sourceCard.getSymbol()) || (Symbol.DIAMONDS == sourceCard
                .getSymbol()))) {
          this.cascade.get(destPileNumber).addToPile(sourceCard);
        } else {
          throw new IllegalArgumentException("Card symbols must be different colors!");
        }
      } else {
        throw new IllegalArgumentException("Card being put to pile must be 1 value less!");
      }
    }
  }

  // adds the given sourceCard to the open pile.
  private void addToOpen(Card sourceCard, int destPileNumber) {
    if (getNumCardsInOpenPile(destPileNumber) != 0) {
      throw new IllegalArgumentException("Card is already in open pile");
    } else {
      Pile openPile = this.open.get(destPileNumber);
      openPile.addToPile(sourceCard);
    }
  }

  @Override
  public boolean isGameOver() {
    int answer = 0;

    for (Pile p : this.foundation) {
      answer = answer + p.determineSize();
    }

    return (answer == 52);
  }


  @Override
  public int getNumCardsInFoundationPile(int index)
      throws IllegalArgumentException, IllegalStateException {
    if (started) {
      if ((this.foundation.size() > index) && (index >= 0)) {
        return this.foundation.get(index).determineSize();
      } else {
        throw new IllegalArgumentException("index for foundation pile is invalid");
      }
    } else {
      throw new IllegalStateException("game has not started!");
    }
  }

  @Override
  public int getNumCardsInCascadePile(int index)
      throws IllegalArgumentException, IllegalStateException {
    if (started) {
      if ((this.getNumCascadePiles() > index) && (index >= 0)) {
        return this.cascade.get(index).determineSize();
      } else {
        throw new IllegalArgumentException("index for cascade pile is invalid");
      }
    } else {
      throw new IllegalStateException("game has not started!");
    }
  }

  @Override
  public int getNumCardsInOpenPile(int index)
      throws IllegalArgumentException, IllegalStateException {
    if (started) {
      if ((this.getNumOpenPiles() > index) && (index >= 0)) {
        return this.open.get(index).determineSize();
      } else {
        throw new IllegalArgumentException("index for foundation pile is invalid");
      }
    } else {
      throw new IllegalStateException("game has not started!");
    }
  }


  @Override
  public int getNumCascadePiles() {
    if (this.cascade.size() < 4) {
      // return -1 if game has not started
      return -1;
    } else {
      // there are 4 or more cascade piles
      return this.cascade.size();
    }
  }

  @Override
  public int getNumOpenPiles() {
    if (this.open.size() < 1) {
      return -1;
    } else {
      return this.open.size();
    }
  }


  @Override
  public Card getFoundationCardAt(int pileIndex, int cardIndex)
      throws IllegalArgumentException, IllegalStateException {
    Card returnCard;

    if (!started) {
      throw new IllegalStateException("game has not started!");
    } else if (this.getNumCardsInFoundationPile(pileIndex) == 0) {
      throw new IllegalArgumentException("this foundation pile is empty");
    } else if ((this.foundation.size() <= pileIndex) && (pileIndex < 0)) {
      throw new IllegalArgumentException("index for foundation pile is invalid");
    } else if ((this.getNumCardsInFoundationPile(pileIndex) - 1) >= cardIndex) {
      returnCard = this.foundation.get(pileIndex).getCardFromPile(cardIndex);
    } else {
      throw new IllegalArgumentException("index for card is invalid");
    }

    return returnCard;
  }

  @Override
  public Card getCascadeCardAt(int pileIndex, int cardIndex)
      throws IllegalArgumentException, IllegalStateException {
    Card returnCard;

    if (!started) {
      throw new IllegalStateException("game has not started!");
    } else if (this.getNumCardsInCascadePile(pileIndex) == 0) {
      return null;
      //throw new IllegalArgumentException("this cascade pile is empty");
    } else if ((this.getNumCascadePiles() <= pileIndex) && (pileIndex < 0)) {
      throw new IllegalArgumentException("index for cascade pile is invalid");
    } else if ((this.getNumCardsInCascadePile(pileIndex) - 1) >= cardIndex) {
      returnCard = this.cascade.get(pileIndex).getCardFromPile(cardIndex);
    } else {
      throw new IllegalArgumentException("index for card is invalid");
    }

    return returnCard;
  }


  @Override
  public Card getOpenCardAt(int pileIndex) throws IllegalArgumentException, IllegalStateException {
    Card returnCard;

    if (!started) {
      throw new IllegalStateException("game has not started!");
    } else if (this.getNumCardsInOpenPile(pileIndex) == 0) {
      return null;
      //throw new IllegalArgumentException("this open pile is empty");
    } else if ((this.getNumOpenPiles() <= pileIndex) && (pileIndex < 0)) {
      throw new IllegalArgumentException("index for open pile is invalid");
    } else if (this.getNumCardsInOpenPile(pileIndex) == 1) {
      returnCard = this.open.get(pileIndex).getCardFromPile(0);
    } else {
      throw new IllegalArgumentException("index for card is invalid");
    }

    return returnCard;
  }


}
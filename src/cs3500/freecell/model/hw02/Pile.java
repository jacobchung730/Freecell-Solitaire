package cs3500.freecell.model.hw02;

import java.util.ArrayList;
import java.util.List;

/**
 * represents a pile, which is a list of cards. this Pile class has methods that relate to a card in
 * a Pile's list of cards.
 */
public class Pile {

  private final ArrayList<Card> listOfCards;

  /**
   * constructs a {@code Pile} object which is a list of cards.
   *
   * @param listOfCards the cards in this pile
   */
  public Pile(ArrayList<Card> listOfCards) {
    this.listOfCards = listOfCards;
  }

  /**
   * adds the given card to this Pile.
   *
   * @param card a playing card
   */
  public void addToPile(Card card) {
    this.listOfCards.add(card);
  }

  /**
   * deletes the card at the given index.
   *
   * @param index the index for the card to be deleted
   */
  public void deleteFromPile(int index) {
    this.listOfCards.remove(index);
  }


  /**
   * removes the given list of cards from this.listOfCards
   * @param cardsToBeRemoved the cards that will be removed
   */
  public void removeAllCards(List<Card> cardsToBeRemoved) {
    this.listOfCards.removeAll(cardsToBeRemoved);
  }

  /**
   * adds the given list of cards to this.listOfCards
   * @param cardsToBeAdded the cards that will be added
   */
  public void addAllCards(List<Card> cardsToBeAdded) {
    this.listOfCards.addAll(cardsToBeAdded);
  }

  /**
   * returns the size of this pile's list of cards.
   *
   * @return size of this.listOfCards
   */
  public int determineSize() {
    return this.listOfCards.size();
  }

  /**
   * retrieves the card at the given index.
   *
   * @param cardIndex the index for the desired card
   * @return card at the given index
   */
  public Card getCardFromPile(int cardIndex) {
    return this.listOfCards.get(cardIndex);
  }

  /**
   * gets this pile's list of cards.
   * @return the list of cards
   */
  public ArrayList<Card> getCardsFromPile() {
    return this.listOfCards;
  }


  @Override
  public String toString() {
    StringBuilder answer = new StringBuilder();

    // j is used to make the size eventually go to 1, without actually mutating the list
    int j = 0;

    for (int i = 0; i < listOfCards.size(); i++) {

      if (this.listOfCards.size() - j == 1) {
        // card is last in the list, so does not require a comma
        answer.append(" ").append(this.listOfCards.get(i));
      } else {
        answer.append(" ").append(this.listOfCards.get(i)).append(",");
        j++;
      }
    }
    return answer.toString();
  }


}

package cs3500.freecell.model.hw02;

import java.util.List;

/**
 * represents methods used to validate a deck (list of cards). These methods will take in a deck as
 * a parameter.
 */
public class Utils {

  /**
   * determines if the given deck is valid.
   *
   * @param deck the given playing deck
   * @return true if the deck has length of 52 and there are no duplicates
   */
  public static boolean validateDeck(List<Card> deck) {
    return (deck.size() == 52) && Utils.noDuplicates(deck);
  }

  /**
   * determines if the given deck has any duplicates.
   *
   * @param deck the given playing deck
   * @return true if the given deck has no duplicates
   */
  public static boolean noDuplicates(List<Card> deck) {
    int size = deck.size();
    Card card1;
    Card card2;

    for (int i = 0; i < size; i++) {
      card1 = deck.get(i);
      for (int j = i + 1; j < size; j++) {
        card2 = deck.get(j);
        if (card1.equals(card2)) {
          return false;
        }
      }
    }
    return true;
  }


}



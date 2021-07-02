

import static org.junit.Assert.assertEquals;

import cs3500.freecell.model.hw02.Card;
import cs3500.freecell.model.hw02.Pile;
import cs3500.freecell.model.hw02.Symbol;
import cs3500.freecell.model.hw02.Value;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

/**
 * tests for the {@code Pile} class.
 */
public class PileTest {

  Card aceClubs = new Card(Value.ACE, Symbol.CLUBS);
  Card aceHearts = new Card(Value.ACE, Symbol.HEARTS);
  Card aceDiamonds = new Card(Value.ACE, Symbol.DIAMONDS);

  Card twoHearts = new Card(Value.TWO, Symbol.HEARTS);
  Card twoDiamonds = new Card(Value.TWO, Symbol.DIAMONDS);

  Card threeClubs = new Card(Value.THREE, Symbol.CLUBS);
  Card threeHearts = new Card(Value.THREE, Symbol.HEARTS);
  Card threeDiamonds = new Card(Value.THREE, Symbol.DIAMONDS);

  Pile cascadePile = new Pile(new ArrayList<>(Arrays.asList(aceClubs, twoHearts,
      threeClubs, aceHearts)));

  Pile openPile = new Pile(new ArrayList<>(Arrays.asList(threeHearts)));

  Pile foundationPile = new Pile(new ArrayList<>(Arrays.asList(aceDiamonds,
      twoDiamonds)));

  ArrayList<Card> foundationPileAdd = new ArrayList<>(Arrays.asList(threeHearts,
      threeClubs));

  Pile removePile = new Pile(new ArrayList<>(Arrays.asList(aceDiamonds,
      twoDiamonds, threeHearts, threeClubs, threeDiamonds)));

  ArrayList<Card> toRemove = new ArrayList<>(Arrays.asList(threeClubs,
      threeDiamonds));



  @Test
  public void testAddAllCardsToPile() {

    assertEquals(2, foundationPile.determineSize());
    foundationPile.addAllCards(foundationPileAdd);
    assertEquals(4, foundationPile.determineSize());
  }

  @Test
  public void testRemoveAllCardsToPile() {

    assertEquals(5, removePile.determineSize());
    removePile.removeAllCards(toRemove);
    assertEquals(3, removePile.determineSize());
  }





  // adding a card to a pile
  @Test
  public void testAddToPile() {

    assertEquals(2, foundationPile.determineSize());
    foundationPile.addToPile(threeDiamonds);
    assertEquals(3, foundationPile.determineSize());
    assertEquals(threeDiamonds, foundationPile.getCardFromPile(2));
  }



  // remove a card from a pile
  @Test
  public void testDeleteFromPile() {

    assertEquals(1, openPile.determineSize());
    openPile.deleteFromPile(0);
    assertEquals(0, openPile.determineSize());
  }

  // returns a size of a list of cards
  @Test
  public void testDetermineSize() {
    assertEquals(4, cascadePile.determineSize());
  }

  // returns a card from a pile (no mutation)
  @Test
  public void testGetCardFromPile() {
    assertEquals(aceHearts, cascadePile.getCardFromPile(3));
    assertEquals(aceClubs, cascadePile.getCardFromPile(0));
  }

  @Test
  public void testToString() {
    assertEquals(" A♣, 2♥, 3♣, A♥", cascadePile.toString());
    assertEquals(" 3♥", openPile.toString());
    assertEquals(" A♦, 2♦", foundationPile.toString());
  }

}
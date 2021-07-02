

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cs3500.freecell.model.hw02.Card;
import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import cs3500.freecell.model.hw02.Symbol;
import cs3500.freecell.model.hw02.Utils;
import cs3500.freecell.model.hw02.Value;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * tests for the {@code Utils} class.
 */
public class UtilsTest {

  Card aceClubs = new Card(Value.ACE, Symbol.CLUBS);
  Card aceHearts = new Card(Value.ACE, Symbol.HEARTS);
  Card aceSpades = new Card(Value.ACE, Symbol.SPADES);
  Card aceDiamonds = new Card(Value.ACE, Symbol.DIAMONDS);

  Card twoClubs = new Card(Value.TWO, Symbol.CLUBS);
  Card twoHearts = new Card(Value.TWO, Symbol.HEARTS);
  Card twoSpades = new Card(Value.TWO, Symbol.SPADES);
  Card twoDiamonds = new Card(Value.TWO, Symbol.DIAMONDS);

  Card threeClubs = new Card(Value.THREE, Symbol.CLUBS);
  Card threeHearts = new Card(Value.THREE, Symbol.HEARTS);
  Card threeSpades = new Card(Value.THREE, Symbol.SPADES);
  Card threeDiamonds = new Card(Value.THREE, Symbol.DIAMONDS);

  Card fourClubs = new Card(Value.FOUR, Symbol.CLUBS);
  Card fourHearts = new Card(Value.FOUR, Symbol.HEARTS);
  Card fourSpades = new Card(Value.FOUR, Symbol.SPADES);
  Card fourDiamonds = new Card(Value.FOUR, Symbol.DIAMONDS);

  Card fiveClubs = new Card(Value.FIVE, Symbol.CLUBS);
  Card fiveHearts = new Card(Value.FIVE, Symbol.HEARTS);
  Card fiveSpades = new Card(Value.FIVE, Symbol.SPADES);
  Card fiveDiamonds = new Card(Value.FIVE, Symbol.DIAMONDS);

  Card sixClubs = new Card(Value.SIX, Symbol.CLUBS);
  Card sixHearts = new Card(Value.SIX, Symbol.HEARTS);
  Card sixSpades = new Card(Value.SIX, Symbol.SPADES);
  Card sixDiamonds = new Card(Value.SIX, Symbol.DIAMONDS);

  Card sevenClubs = new Card(Value.SEVEN, Symbol.CLUBS);
  Card sevenHearts = new Card(Value.SEVEN, Symbol.HEARTS);
  Card sevenSpades = new Card(Value.SEVEN, Symbol.SPADES);
  Card sevenDiamonds = new Card(Value.SEVEN, Symbol.DIAMONDS);

  Card eightClubs = new Card(Value.EIGHT, Symbol.CLUBS);
  Card eightHearts = new Card(Value.EIGHT, Symbol.HEARTS);
  Card eightSpades = new Card(Value.EIGHT, Symbol.SPADES);
  Card eightDiamonds = new Card(Value.EIGHT, Symbol.DIAMONDS);

  Card nineClubs = new Card(Value.NINE, Symbol.CLUBS);
  Card nineHearts = new Card(Value.NINE, Symbol.HEARTS);
  Card nineSpades = new Card(Value.NINE, Symbol.SPADES);
  Card nineDiamonds = new Card(Value.NINE, Symbol.DIAMONDS);

  Card tenClubs = new Card(Value.TEN, Symbol.CLUBS);
  Card tenHearts = new Card(Value.TEN, Symbol.HEARTS);
  Card tenSpades = new Card(Value.TEN, Symbol.SPADES);
  Card tenDiamonds = new Card(Value.TEN, Symbol.DIAMONDS);

  Card jackClubs = new Card(Value.JACK, Symbol.CLUBS);
  Card jackHearts = new Card(Value.JACK, Symbol.HEARTS);
  Card jackSpades = new Card(Value.JACK, Symbol.SPADES);
  Card jackDiamonds = new Card(Value.JACK, Symbol.DIAMONDS);

  Card queenClubs = new Card(Value.QUEEN, Symbol.CLUBS);
  Card queenHearts = new Card(Value.QUEEN, Symbol.HEARTS);
  Card queenSpades = new Card(Value.QUEEN, Symbol.SPADES);
  Card queenDiamonds = new Card(Value.QUEEN, Symbol.DIAMONDS);

  Card kingClubs = new Card(Value.KING, Symbol.CLUBS);
  Card kingHearts = new Card(Value.KING, Symbol.HEARTS);
  Card kingSpades = new Card(Value.KING, Symbol.SPADES);
  Card kingDiamonds = new Card(Value.KING, Symbol.DIAMONDS);

  List<Card> standardDeck = new ArrayList<Card>(Arrays.asList(aceClubs, aceHearts, aceSpades,
      aceDiamonds, twoClubs, twoHearts, twoSpades, twoDiamonds, threeClubs, threeHearts,
      threeSpades, threeDiamonds, fourClubs, fourHearts, fourSpades, fourDiamonds, fiveClubs,
      fiveHearts, fiveSpades, fiveDiamonds, sixClubs, sixHearts, sixSpades, sixDiamonds,
      sevenClubs, sevenHearts, sevenSpades, sevenDiamonds, eightClubs, eightHearts, eightSpades,
      eightDiamonds, nineClubs, nineHearts, nineSpades, nineDiamonds, tenClubs, tenHearts,
      tenSpades, tenDiamonds, jackClubs, jackHearts, jackSpades, jackDiamonds, queenClubs,
      queenHearts, queenSpades, queenDiamonds, kingClubs, kingHearts, kingSpades, kingDiamonds));

  List<Card> goodSizeButDupes = new ArrayList<Card>(Arrays.asList(aceClubs, aceClubs, aceSpades,
      aceDiamonds, twoClubs, twoHearts, twoSpades, twoDiamonds, threeClubs, threeHearts,
      threeSpades, threeDiamonds, fourClubs, fourHearts, fourSpades, fourDiamonds, fiveClubs,
      fiveHearts, fiveSpades, fiveDiamonds, sixClubs, sixHearts, sixSpades, sixDiamonds,
      sevenClubs, sevenHearts, sevenSpades, sevenDiamonds, eightClubs, eightHearts, eightSpades,
      eightDiamonds, nineClubs, nineHearts, nineSpades, nineDiamonds, tenClubs, tenHearts,
      tenSpades, tenDiamonds, jackClubs, jackHearts, jackSpades, jackDiamonds, queenClubs,
      queenHearts, queenSpades, queenDiamonds, kingClubs, kingHearts, kingSpades, kingDiamonds));

  List<Card> largeDeck = new ArrayList<Card>(Arrays.asList(aceClubs, aceHearts, aceSpades,
      aceDiamonds, twoClubs, twoHearts, twoSpades, twoDiamonds, threeClubs, threeHearts,
      threeSpades, threeDiamonds, fourClubs, fourHearts, fourSpades, fourDiamonds, fiveClubs,
      fiveHearts, fiveSpades, fiveDiamonds, sixClubs, sixHearts, sixSpades, sixDiamonds,
      sevenClubs, sevenHearts, sevenSpades, sevenDiamonds, eightClubs, eightHearts, eightSpades,
      eightDiamonds, nineClubs, nineHearts, nineSpades, nineDiamonds, tenClubs, tenHearts,
      tenSpades, tenDiamonds, jackClubs, jackHearts, jackSpades, jackDiamonds, queenClubs,
      queenHearts, queenSpades, queenDiamonds, kingClubs, kingHearts, kingSpades, kingDiamonds,
      kingDiamonds));

  List<Card> duplicatesDeck = new ArrayList<Card>(Arrays.asList(aceClubs, aceHearts, aceSpades,
      aceDiamonds, aceClubs));

  List<Card> smallDeck = new ArrayList<Card>(Arrays.asList(fiveSpades, fiveDiamonds, sixClubs));

  FreecellModel<Card> model = new SimpleFreecellModel();
  List<Card> deck = model.getDeck();


  // model.getDeck() is valid
  @Test
  public void testRandomDeckValid() {
    assertTrue(Utils.noDuplicates(deck));
  }

  // deck has no duplicates
  @Test
  public void testNoDuplicatesTrue() {
    assertTrue(Utils.noDuplicates(standardDeck));
  }

  // deck has duplicates
  @Test
  public void testNoDuplicatesFalse() {
    assertFalse(Utils.noDuplicates(duplicatesDeck));
  }

  // deck is valid
  @Test
  public void testValidateDeckTrue() {
    assertTrue(Utils.validateDeck(standardDeck));
  }

  // deck is too small
  @Test
  public void testDeckTooSmall() {
    assertFalse(Utils.validateDeck(smallDeck));
  }

  // deck is too large
  @Test
  public void testDeckTooLarge() {
    assertFalse(Utils.validateDeck(largeDeck));
  }

  // deck is correct size but has duplicates
  @Test
  public void testGoodSizeButDupes() {
    assertFalse(Utils.validateDeck(goodSizeButDupes));
  }


}
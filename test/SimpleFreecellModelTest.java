import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import cs3500.freecell.model.hw02.Card;
import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.PileType;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import cs3500.freecell.model.hw02.Symbol;
import cs3500.freecell.model.hw02.Value;
import cs3500.freecell.view.FreecellTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

/**
 * tests for the {@code SimpleFreecellModelTest} class.
 */
public class SimpleFreecellModelTest {

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

  List<Card> bigDeck = new ArrayList<Card>(Arrays.asList(aceClubs, aceHearts, aceSpades,
      aceDiamonds, twoClubs, twoHearts, twoSpades, twoDiamonds, threeClubs, threeHearts,
      threeSpades, threeDiamonds, fourClubs, fourHearts, fourSpades, fourDiamonds, fiveClubs,
      fiveHearts, fiveSpades, fiveDiamonds, sixClubs, sixHearts, sixSpades, sixDiamonds,
      sevenClubs, sevenHearts, sevenSpades, sevenDiamonds, eightClubs, eightHearts, eightSpades,
      eightDiamonds, nineClubs, nineHearts, nineSpades, nineDiamonds, tenClubs, tenHearts,
      tenSpades, tenDiamonds, jackClubs, jackHearts, jackSpades, jackDiamonds, queenClubs,
      queenHearts, queenSpades, queenDiamonds, kingClubs, kingHearts, kingSpades, kingDiamonds,
      kingDiamonds));

  List<Card> emptyDeck = new ArrayList<Card>();
  List<Card> oneCardDeck = new ArrayList<Card>(Arrays.asList(kingClubs));
  List<Card> multipleDeck = new ArrayList<Card>(Arrays.asList(kingClubs, kingClubs));

  FreecellModel<Card> model = new SimpleFreecellModel();
  FreecellModel<Card> model2 = new SimpleFreecellModel();
  List<Card> deck = model.getDeck();


  // trying to getNumCascadePiles but game has not started
  @Test
  public void testGetNumCascadePilesGameNotStarted() {
    assertEquals(-1, model.getNumCascadePiles());
  }

  // trying to getNumOpenPiles but game has not started
  @Test
  public void testGetNumOpenPilesGameNotStarted() {
    assertEquals(-1, model.getNumOpenPiles());
  }


  // get num cards in foundation pile but game not started
  @Test(expected = IllegalStateException.class)
  public void testGetNumCardInFoundationPileGameNotStarted() {
    model.getNumCardsInFoundationPile(0);
  }

  // get num cards in cascade pile but game not started
  @Test(expected = IllegalStateException.class)
  public void testGetNumCardInCascadePileGameNotStarted() {
    model.getNumCardsInCascadePile(0);
  }

  // get num cards in open pile but game not started
  @Test(expected = IllegalStateException.class)
  public void testGetNumCardInOpenPileGameNotStarted() {
    model.getNumCardsInOpenPile(0);
  }

  // get foundation card at given pile and card index but game not start
  @Test(expected = IllegalStateException.class)
  public void testGetFoundationCardAtGameNotStart() {
    model.getFoundationCardAt(0, 0);
  }

  // get cascade card at given pile and card index but game not start
  @Test(expected = IllegalStateException.class)
  public void testGetCascadeCardAtGameNotStart() {
    model.getCascadeCardAt(0, 0);
  }

  // get open card at given pile and card index but game not start
  @Test(expected = IllegalStateException.class)
  public void testGetOpenCardAtGameNotStart() {
    model.getOpenCardAt(0);
  }


  // get the number of cards in foundation pile with wrong card index
  @Test(expected = IllegalArgumentException.class)
  public void testGetFoundationCardAtWithInvalidCardIndex() {
    model.startGame(standardDeck, 52, 2, false);
    model.getFoundationCardAt(0, 110);
  }

  // get the number of cards in cascade pile with wrong card index
  @Test(expected = IllegalArgumentException.class)
  public void testGetCascadeCardAtWithInvalidCardIndex() {
    model.startGame(standardDeck, 52, 2, false);
    model.getCascadeCardAt(0, 110);
  }


  // get the number of cards in foundation pile with wrong pile index
  @Test(expected = IllegalArgumentException.class)
  public void testGetFoundationCardAtWithInvalidIndex() {
    model.startGame(standardDeck, 52, 2, false);
    model.getFoundationCardAt(100, 0);
  }

  // get the number of cards in cascade pile with wrong pile index
  @Test(expected = IllegalArgumentException.class)
  public void testGetCascadeCardAtWithInvalidIndex() {
    model.startGame(standardDeck, 52, 2, false);
    model.getCascadeCardAt(100, 0);
  }

  // get the number of cards in open pile with wrong pile index
  @Test(expected = IllegalArgumentException.class)
  public void testGetOpenCardAtWithInvalidIndex() {
    model.startGame(standardDeck, 52, 2, false);
    model.getOpenCardAt(100);
  }


  // get foundation card at given pile index and given card index
  @Test
  public void testGetFoundationCardAt() {
    model.startGame(standardDeck, 52, 2, false);
    model.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 0);
    assertEquals(aceClubs, model.getFoundationCardAt(0, 0));

  }

  // get cascade card at given pile index and given card index
  @Test
  public void testGetCascadeCardAt() {
    model.startGame(standardDeck, 52, 2, false);
    assertEquals(aceClubs, model.getCascadeCardAt(0, 0));

  }

  // get open card at given pile index
  @Test
  public void testGetOpenCardAt() {
    model.startGame(standardDeck, 52, 2, false);
    model.move(PileType.CASCADE, 0, 0, PileType.OPEN, 0);
    assertEquals(aceClubs, model.getOpenCardAt(0));

  }


  // get the number of cards in foundation pile but with index
  @Test(expected = IllegalArgumentException.class)
  public void testGetNumCardsInFoundationPileInvalidIndex() {
    model.startGame(standardDeck, 52, 2, false);
    model.getNumCardsInFoundationPile(100);
  }

  // get the number of cards in cascade pile but with index
  @Test(expected = IllegalArgumentException.class)
  public void testGetNumCardsInCascadePileInvalidIndex() {
    model.startGame(standardDeck, 52, 2, false);
    model.getNumCardsInFoundationPile(100);
  }

  // get the number of cards in open pile but with index
  @Test(expected = IllegalArgumentException.class)
  public void testGetNumCardsInOpenPileInvalidIndex() {
    model.startGame(standardDeck, 52, 2, false);
    model.getNumCardsInFoundationPile(100);
  }


  // get the number of cards in foundation pile
  @Test
  public void testGetNumCardsInFoundationPile() {
    model.startGame(standardDeck, 52, 2, false);
    assertEquals(0, model.getNumCardsInFoundationPile(0));
  }

  // get the number of cards in cascade pile
  @Test
  public void testGetNumCardsInCascadePile() {
    model.startGame(standardDeck, 52, 2, false);
    assertEquals(1, model.getNumCardsInCascadePile(0));
  }

  // get the number of cards in open pile
  @Test
  public void testGetNumCardsInOpenPile() {
    model.startGame(standardDeck, 52, 2, false);
    assertEquals(0, model.getNumCardsInOpenPile(0));
  }


  // get the number of cascade piles
  @Test
  public void testGetNumCascadePiles() {
    model.startGame(standardDeck, 52, 2, false);
    assertEquals(52, model.getNumCascadePiles());
  }

  // get the number of open piles
  @Test
  public void testGetNumOpenPiles() {
    model.startGame(standardDeck, 52, 2, false);
    assertEquals(2, model.getNumOpenPiles());
  }


  // view for a game that hasn't started
  @Test
  public void testToStringNotStarted() {
    FreecellTextView view = new FreecellTextView(model);
    assertEquals(view.toString(), "");
  }

  // standard game toString
  @Test
  public void testToString() {
    model.startGame(standardDeck, 4, 2, false);
    String game = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "C2: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "C3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n"
        + "C4: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦";

    assertEquals(model.toString(), game);
  }


  // trying to move a card from a pile where that pile is empty
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidEmpty() {
    model.startGame(standardDeck, 52, 5, false);
    model.move(PileType.OPEN, 0, 0, PileType.OPEN, 1);
  }

  // a move where cascade pileNumber is too high
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidCascadePileNumber() {
    model.startGame(standardDeck, 52, 1, false);
    model.move(PileType.CASCADE, 100, 0, PileType.OPEN, 0);
  }

  // a move where open pile number is too high
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidOpenPileNumber() {
    model.startGame(standardDeck, 52, 1, false);
    model.move(PileType.OPEN, 31, 0, PileType.OPEN, 0);
  }

  // a move where destPileNumber is too high
  @Test(expected = IllegalArgumentException.class)
  public void testDestinationTooHigh() {
    model.startGame(standardDeck, 52, 1, false);
    model.move(PileType.OPEN, 0, 0, PileType.OPEN, 100);
  }

  // call move without starting game
  @Test(expected = IllegalStateException.class)
  public void testMoveWithoutStarting() {
    model.move(PileType.CASCADE, 0, 0, PileType.OPEN, 0);
  }


  // a move to a full foundation
  @Test(expected = IllegalArgumentException.class)
  public void testMoveToFullCascade() {
    FreecellModel<Card> fullModel = new SimpleFreecellModel();
    Collections.reverse(standardDeck);

    fullModel.startGame(standardDeck, 4, 1, false);

    fullModel.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 11, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 10, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 9, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 8, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 7, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 6, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 5, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 4, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 3, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 2, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 1, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 0);

    // trying to add card to the foundation pile (already full)
    fullModel.move(PileType.CASCADE, 1, 12, PileType.FOUNDATION, 0);
  }


  // toString returns an empty string after a call to startGame has thrown an exception
  @Test
  public void testEmptyToStringAfterStartGameException() {
    FreecellTextView fullView = new FreecellTextView(model);

    try {
      model.startGame(standardDeck, 1, 4, false);
    } catch (IllegalArgumentException e) {
      assertEquals("", fullView.toString());
    }

  }


  // valid move from cascade to foundation, and then another cascade to foundation
  @Test
  public void testValidDoubleToFoundation() {
    model.startGame(standardDeck, 52, 2, false);
    model.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 0);
    model.move(PileType.CASCADE, 4, 0, PileType.FOUNDATION, 0);
    FreecellTextView fullView = new FreecellTextView(model);

    String view = "F1: A♣, 2♣\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "C1:\n"
        + "C2: A♥\n"
        + "C3: A♠\n"
        + "C4: A♦\n"
        + "C5:\n"
        + "C6: 2♥\n"
        + "C7: 2♠\n"
        + "C8: 2♦\n"
        + "C9: 3♣\n"
        + "C10: 3♥\n"
        + "C11: 3♠\n"
        + "C12: 3♦\n"
        + "C13: 4♣\n"
        + "C14: 4♥\n"
        + "C15: 4♠\n"
        + "C16: 4♦\n"
        + "C17: 5♣\n"
        + "C18: 5♥\n"
        + "C19: 5♠\n"
        + "C20: 5♦\n"
        + "C21: 6♣\n"
        + "C22: 6♥\n"
        + "C23: 6♠\n"
        + "C24: 6♦\n"
        + "C25: 7♣\n"
        + "C26: 7♥\n"
        + "C27: 7♠\n"
        + "C28: 7♦\n"
        + "C29: 8♣\n"
        + "C30: 8♥\n"
        + "C31: 8♠\n"
        + "C32: 8♦\n"
        + "C33: 9♣\n"
        + "C34: 9♥\n"
        + "C35: 9♠\n"
        + "C36: 9♦\n"
        + "C37: 10♣\n"
        + "C38: 10♥\n"
        + "C39: 10♠\n"
        + "C40: 10♦\n"
        + "C41: J♣\n"
        + "C42: J♥\n"
        + "C43: J♠\n"
        + "C44: J♦\n"
        + "C45: Q♣\n"
        + "C46: Q♥\n"
        + "C47: Q♠\n"
        + "C48: Q♦\n"
        + "C49: K♣\n"
        + "C50: K♥\n"
        + "C51: K♠\n"
        + "C52: K♦";

    String view2 = fullView.toString();

    assertTrue(view.equals(view2));

  }

  // valid move from open to foundation
  @Test
  public void testValidOpenFoundation() {
    model.startGame(standardDeck, 52, 2, false);
    model.move(PileType.CASCADE, 0, 0, PileType.OPEN, 0);
    model.move(PileType.OPEN, 0, 0, PileType.OPEN, 1);
    model.move(PileType.OPEN, 1, 0, PileType.FOUNDATION, 0);
    FreecellTextView fullView = new FreecellTextView(model);

    String view = "F1: A♣\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "C1:\n"
        + "C2: A♥\n"
        + "C3: A♠\n"
        + "C4: A♦\n"
        + "C5: 2♣\n"
        + "C6: 2♥\n"
        + "C7: 2♠\n"
        + "C8: 2♦\n"
        + "C9: 3♣\n"
        + "C10: 3♥\n"
        + "C11: 3♠\n"
        + "C12: 3♦\n"
        + "C13: 4♣\n"
        + "C14: 4♥\n"
        + "C15: 4♠\n"
        + "C16: 4♦\n"
        + "C17: 5♣\n"
        + "C18: 5♥\n"
        + "C19: 5♠\n"
        + "C20: 5♦\n"
        + "C21: 6♣\n"
        + "C22: 6♥\n"
        + "C23: 6♠\n"
        + "C24: 6♦\n"
        + "C25: 7♣\n"
        + "C26: 7♥\n"
        + "C27: 7♠\n"
        + "C28: 7♦\n"
        + "C29: 8♣\n"
        + "C30: 8♥\n"
        + "C31: 8♠\n"
        + "C32: 8♦\n"
        + "C33: 9♣\n"
        + "C34: 9♥\n"
        + "C35: 9♠\n"
        + "C36: 9♦\n"
        + "C37: 10♣\n"
        + "C38: 10♥\n"
        + "C39: 10♠\n"
        + "C40: 10♦\n"
        + "C41: J♣\n"
        + "C42: J♥\n"
        + "C43: J♠\n"
        + "C44: J♦\n"
        + "C45: Q♣\n"
        + "C46: Q♥\n"
        + "C47: Q♠\n"
        + "C48: Q♦\n"
        + "C49: K♣\n"
        + "C50: K♥\n"
        + "C51: K♠\n"
        + "C52: K♦";

    String view2 = fullView.toString();

    assertTrue(view.equals(view2));

  }

  // moving the card to the same pile it is already in (essentially not moving it at all)
  @Test
  public void testMoveToSame() {
    model.startGame(standardDeck, 52, 2, false);
    model.move(PileType.CASCADE, 0, 0, PileType.CASCADE, 0);
    FreecellTextView fullView = new FreecellTextView(model);

    String view = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "C1: A♣\n"
        + "C2: A♥\n"
        + "C3: A♠\n"
        + "C4: A♦\n"
        + "C5: 2♣\n"
        + "C6: 2♥\n"
        + "C7: 2♠\n"
        + "C8: 2♦\n"
        + "C9: 3♣\n"
        + "C10: 3♥\n"
        + "C11: 3♠\n"
        + "C12: 3♦\n"
        + "C13: 4♣\n"
        + "C14: 4♥\n"
        + "C15: 4♠\n"
        + "C16: 4♦\n"
        + "C17: 5♣\n"
        + "C18: 5♥\n"
        + "C19: 5♠\n"
        + "C20: 5♦\n"
        + "C21: 6♣\n"
        + "C22: 6♥\n"
        + "C23: 6♠\n"
        + "C24: 6♦\n"
        + "C25: 7♣\n"
        + "C26: 7♥\n"
        + "C27: 7♠\n"
        + "C28: 7♦\n"
        + "C29: 8♣\n"
        + "C30: 8♥\n"
        + "C31: 8♠\n"
        + "C32: 8♦\n"
        + "C33: 9♣\n"
        + "C34: 9♥\n"
        + "C35: 9♠\n"
        + "C36: 9♦\n"
        + "C37: 10♣\n"
        + "C38: 10♥\n"
        + "C39: 10♠\n"
        + "C40: 10♦\n"
        + "C41: J♣\n"
        + "C42: J♥\n"
        + "C43: J♠\n"
        + "C44: J♦\n"
        + "C45: Q♣\n"
        + "C46: Q♥\n"
        + "C47: Q♠\n"
        + "C48: Q♦\n"
        + "C49: K♣\n"
        + "C50: K♥\n"
        + "C51: K♠\n"
        + "C52: K♦";

    String view2 = fullView.toString();

    assertTrue(view.equals(view2));

  }


  // valid move from open to cascade
  @Test
  public void testValidOpenCascade() {
    model.startGame(standardDeck, 52, 2, false);
    model.move(PileType.CASCADE, 0, 0, PileType.OPEN, 0);
    model.move(PileType.OPEN, 0, 0, PileType.CASCADE, 5);
    FreecellTextView fullView = new FreecellTextView(model);

    String view = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "C1:\n"
        + "C2: A♥\n"
        + "C3: A♠\n"
        + "C4: A♦\n"
        + "C5: 2♣\n"
        + "C6: 2♥, A♣\n"
        + "C7: 2♠\n"
        + "C8: 2♦\n"
        + "C9: 3♣\n"
        + "C10: 3♥\n"
        + "C11: 3♠\n"
        + "C12: 3♦\n"
        + "C13: 4♣\n"
        + "C14: 4♥\n"
        + "C15: 4♠\n"
        + "C16: 4♦\n"
        + "C17: 5♣\n"
        + "C18: 5♥\n"
        + "C19: 5♠\n"
        + "C20: 5♦\n"
        + "C21: 6♣\n"
        + "C22: 6♥\n"
        + "C23: 6♠\n"
        + "C24: 6♦\n"
        + "C25: 7♣\n"
        + "C26: 7♥\n"
        + "C27: 7♠\n"
        + "C28: 7♦\n"
        + "C29: 8♣\n"
        + "C30: 8♥\n"
        + "C31: 8♠\n"
        + "C32: 8♦\n"
        + "C33: 9♣\n"
        + "C34: 9♥\n"
        + "C35: 9♠\n"
        + "C36: 9♦\n"
        + "C37: 10♣\n"
        + "C38: 10♥\n"
        + "C39: 10♠\n"
        + "C40: 10♦\n"
        + "C41: J♣\n"
        + "C42: J♥\n"
        + "C43: J♠\n"
        + "C44: J♦\n"
        + "C45: Q♣\n"
        + "C46: Q♥\n"
        + "C47: Q♠\n"
        + "C48: Q♦\n"
        + "C49: K♣\n"
        + "C50: K♥\n"
        + "C51: K♠\n"
        + "C52: K♦";

    String view2 = fullView.toString();

    assertTrue(view.equals(view2));

  }

  // valid move from open to open
  @Test
  public void testValidOpenOpen() {
    model.startGame(standardDeck, 52, 2, false);
    model.move(PileType.CASCADE, 0, 0, PileType.OPEN, 0);
    model.move(PileType.OPEN, 0, 0, PileType.OPEN, 1);
    FreecellTextView fullView = new FreecellTextView(model);

    String view = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2: A♣\n"
        + "C1:\n"
        + "C2: A♥\n"
        + "C3: A♠\n"
        + "C4: A♦\n"
        + "C5: 2♣\n"
        + "C6: 2♥\n"
        + "C7: 2♠\n"
        + "C8: 2♦\n"
        + "C9: 3♣\n"
        + "C10: 3♥\n"
        + "C11: 3♠\n"
        + "C12: 3♦\n"
        + "C13: 4♣\n"
        + "C14: 4♥\n"
        + "C15: 4♠\n"
        + "C16: 4♦\n"
        + "C17: 5♣\n"
        + "C18: 5♥\n"
        + "C19: 5♠\n"
        + "C20: 5♦\n"
        + "C21: 6♣\n"
        + "C22: 6♥\n"
        + "C23: 6♠\n"
        + "C24: 6♦\n"
        + "C25: 7♣\n"
        + "C26: 7♥\n"
        + "C27: 7♠\n"
        + "C28: 7♦\n"
        + "C29: 8♣\n"
        + "C30: 8♥\n"
        + "C31: 8♠\n"
        + "C32: 8♦\n"
        + "C33: 9♣\n"
        + "C34: 9♥\n"
        + "C35: 9♠\n"
        + "C36: 9♦\n"
        + "C37: 10♣\n"
        + "C38: 10♥\n"
        + "C39: 10♠\n"
        + "C40: 10♦\n"
        + "C41: J♣\n"
        + "C42: J♥\n"
        + "C43: J♠\n"
        + "C44: J♦\n"
        + "C45: Q♣\n"
        + "C46: Q♥\n"
        + "C47: Q♠\n"
        + "C48: Q♦\n"
        + "C49: K♣\n"
        + "C50: K♥\n"
        + "C51: K♠\n"
        + "C52: K♦";

    String view2 = fullView.toString();

    assertTrue(view.equals(view2));

  }


  // valid move from cascade to open
  @Test
  public void testValidCascadeOpen() {
    model.startGame(standardDeck, 52, 1, false);
    model.move(PileType.CASCADE, 0, 0, PileType.OPEN, 0);
    FreecellTextView fullView = new FreecellTextView(model);

    String view = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: A♣\n"
        + "C1:\n"
        + "C2: A♥\n"
        + "C3: A♠\n"
        + "C4: A♦\n"
        + "C5: 2♣\n"
        + "C6: 2♥\n"
        + "C7: 2♠\n"
        + "C8: 2♦\n"
        + "C9: 3♣\n"
        + "C10: 3♥\n"
        + "C11: 3♠\n"
        + "C12: 3♦\n"
        + "C13: 4♣\n"
        + "C14: 4♥\n"
        + "C15: 4♠\n"
        + "C16: 4♦\n"
        + "C17: 5♣\n"
        + "C18: 5♥\n"
        + "C19: 5♠\n"
        + "C20: 5♦\n"
        + "C21: 6♣\n"
        + "C22: 6♥\n"
        + "C23: 6♠\n"
        + "C24: 6♦\n"
        + "C25: 7♣\n"
        + "C26: 7♥\n"
        + "C27: 7♠\n"
        + "C28: 7♦\n"
        + "C29: 8♣\n"
        + "C30: 8♥\n"
        + "C31: 8♠\n"
        + "C32: 8♦\n"
        + "C33: 9♣\n"
        + "C34: 9♥\n"
        + "C35: 9♠\n"
        + "C36: 9♦\n"
        + "C37: 10♣\n"
        + "C38: 10♥\n"
        + "C39: 10♠\n"
        + "C40: 10♦\n"
        + "C41: J♣\n"
        + "C42: J♥\n"
        + "C43: J♠\n"
        + "C44: J♦\n"
        + "C45: Q♣\n"
        + "C46: Q♥\n"
        + "C47: Q♠\n"
        + "C48: Q♦\n"
        + "C49: K♣\n"
        + "C50: K♥\n"
        + "C51: K♠\n"
        + "C52: K♦";

    String view2 = fullView.toString();

    assertTrue(view.equals(view2));

  }

  // invalid move from cascade to open  when open already has a card in it
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidCascadeToOpen() {
    model.startGame(standardDeck, 52, 1, false);
    model.move(PileType.CASCADE, 0, 0, PileType.OPEN, 0);
    model.move(PileType.CASCADE, 1, 0, PileType.OPEN, 0);
  }

  // valid move from cascade to cascade
  @Test
  public void testValidMoveCascadeToCascade() {
    model.startGame(standardDeck, 52, 1, false);
    model.move(PileType.CASCADE, 0, 0, PileType.CASCADE, 5);
    FreecellTextView fullView = new FreecellTextView(model);

    String view = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1:\n"
        + "C2: A♥\n"
        + "C3: A♠\n"
        + "C4: A♦\n"
        + "C5: 2♣\n"
        + "C6: 2♥, A♣\n"
        + "C7: 2♠\n"
        + "C8: 2♦\n"
        + "C9: 3♣\n"
        + "C10: 3♥\n"
        + "C11: 3♠\n"
        + "C12: 3♦\n"
        + "C13: 4♣\n"
        + "C14: 4♥\n"
        + "C15: 4♠\n"
        + "C16: 4♦\n"
        + "C17: 5♣\n"
        + "C18: 5♥\n"
        + "C19: 5♠\n"
        + "C20: 5♦\n"
        + "C21: 6♣\n"
        + "C22: 6♥\n"
        + "C23: 6♠\n"
        + "C24: 6♦\n"
        + "C25: 7♣\n"
        + "C26: 7♥\n"
        + "C27: 7♠\n"
        + "C28: 7♦\n"
        + "C29: 8♣\n"
        + "C30: 8♥\n"
        + "C31: 8♠\n"
        + "C32: 8♦\n"
        + "C33: 9♣\n"
        + "C34: 9♥\n"
        + "C35: 9♠\n"
        + "C36: 9♦\n"
        + "C37: 10♣\n"
        + "C38: 10♥\n"
        + "C39: 10♠\n"
        + "C40: 10♦\n"
        + "C41: J♣\n"
        + "C42: J♥\n"
        + "C43: J♠\n"
        + "C44: J♦\n"
        + "C45: Q♣\n"
        + "C46: Q♥\n"
        + "C47: Q♠\n"
        + "C48: Q♦\n"
        + "C49: K♣\n"
        + "C50: K♥\n"
        + "C51: K♠\n"
        + "C52: K♦";

    String view2 = fullView.toString();

    assertTrue(view.equals(view2));

  }


  // invalid move from cascade to cascade because destPile (cascade) already has a card in it,
  // and the card being moved is not a value lower and diff color
  @Test(expected = IllegalArgumentException.class)
  public void testInValidMoveOpenToCascade() {
    model.startGame(standardDeck, 52, 1, false);
    model.move(PileType.CASCADE, 24, 0, PileType.OPEN, 0);
    model.move(PileType.CASCADE, 3, 0, PileType.CASCADE, 0);
  }

  // invalid move because low index
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidLowIndex() {
    model.startGame(standardDeck, 4, 4, false);
    model.move(PileType.CASCADE, 0, 4, PileType.CASCADE, 1);
  }

  // invalid move because high index
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidHighIndex() {
    model.startGame(standardDeck, 4, 4, false);
    model.move(PileType.CASCADE, 0, 9999, PileType.CASCADE, 1);
  }




  // move an Ace from cascade to foundation, where foundation is currently empty
  @Test
  public void testValidMoveToFoundation() {
    model.startGame(standardDeck, 52, 1, false);
    model.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 0);
    FreecellTextView fullView = new FreecellTextView(model);

    String view = "F1: A♣\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1:\n"
        + "C2: A♥\n"
        + "C3: A♠\n"
        + "C4: A♦\n"
        + "C5: 2♣\n"
        + "C6: 2♥\n"
        + "C7: 2♠\n"
        + "C8: 2♦\n"
        + "C9: 3♣\n"
        + "C10: 3♥\n"
        + "C11: 3♠\n"
        + "C12: 3♦\n"
        + "C13: 4♣\n"
        + "C14: 4♥\n"
        + "C15: 4♠\n"
        + "C16: 4♦\n"
        + "C17: 5♣\n"
        + "C18: 5♥\n"
        + "C19: 5♠\n"
        + "C20: 5♦\n"
        + "C21: 6♣\n"
        + "C22: 6♥\n"
        + "C23: 6♠\n"
        + "C24: 6♦\n"
        + "C25: 7♣\n"
        + "C26: 7♥\n"
        + "C27: 7♠\n"
        + "C28: 7♦\n"
        + "C29: 8♣\n"
        + "C30: 8♥\n"
        + "C31: 8♠\n"
        + "C32: 8♦\n"
        + "C33: 9♣\n"
        + "C34: 9♥\n"
        + "C35: 9♠\n"
        + "C36: 9♦\n"
        + "C37: 10♣\n"
        + "C38: 10♥\n"
        + "C39: 10♠\n"
        + "C40: 10♦\n"
        + "C41: J♣\n"
        + "C42: J♥\n"
        + "C43: J♠\n"
        + "C44: J♦\n"
        + "C45: Q♣\n"
        + "C46: Q♥\n"
        + "C47: Q♠\n"
        + "C48: Q♦\n"
        + "C49: K♣\n"
        + "C50: K♥\n"
        + "C51: K♠\n"
        + "C52: K♦";

    String view2 = fullView.toString();

    assertTrue(view.equals(view2));

  }


  // move a king from Open to Foundation when foundation is currently empty
  @Test(expected = IllegalArgumentException.class)
  public void testInValidMoveOpenFoundation() {
    model.startGame(standardDeck, 4, 1, false);
    model.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);
    model.move(PileType.OPEN, 0, 0, PileType.FOUNDATION, 0);
  }


  // move a king from Cascade to Foundation when foundation is currently empty
  @Test(expected = IllegalArgumentException.class)
  public void testInValidMove() {
    model.startGame(standardDeck, 4, 1, false);
    model.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 0);
  }

  // invalid move to foundation because wrong color
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveToFoundationBecauseWrongColor() {
    model.startGame(standardDeck, 52, 1, false);
    model.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 0);
    model.move(PileType.CASCADE, 5, 0, PileType.FOUNDATION, 0);
    model.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 1);
  }

  // both decks not shuffled
  @Test
  public void testNoShuffle() {

    model.startGame(standardDeck, 4, 1, false);
    FreecellTextView view = new FreecellTextView(model);
    String s1 = view.toString();

    model2.startGame(standardDeck, 4, 1, false);
    FreecellTextView view2 = new FreecellTextView(model2);
    String s2 = view2.toString();

    assertTrue(s1.equals(s2));
  }


  // deck looks different when shuffled vs not shuffled
  // note: there is an extreme edge case where shuffled
  // can technically return the same deck, but that is
  // extremely unlikely
  @Test
  public void testShuffleTrue() {

    model.startGame(standardDeck, 4, 1, true);
    FreecellTextView view = new FreecellTextView(model);

    model2.startGame(standardDeck, 4, 1, false);
    FreecellTextView view2 = new FreecellTextView(model2);

    assertNotEquals(view, view2);
  }


  // game gets reset after startGame is called again
  @Test
  public void testStartAgain() {

    model.startGame(standardDeck, 4, 1, false);
    model.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);

    String game = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: K♣\n"
        + "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣\n"
        + "C2: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "C3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n"
        + "C4: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦";

    model.startGame(standardDeck, 4, 1, false);

    String gameAfterStart = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "C2: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "C3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n"
        + "C4: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦";

    assertNotEquals(game, gameAfterStart);
  }


  // invalid because trying to move out of a foundation
  @Test(expected = IllegalArgumentException.class)
  public void testMoveOutFoundation() {
    model.startGame(standardDeck, 52, 1, false);
    model.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 0);
    model.move(PileType.FOUNDATION, 0, 0, PileType.FOUNDATION, 0);
  }


  // deck has multiple of same card
  @Test(expected = IllegalArgumentException.class)
  public void testMultipleSameCard() {
    model.startGame(multipleDeck, 5, 3, false);
  }

  // deck has less than 52 cards
  @Test(expected = IllegalArgumentException.class)
  public void testOneCardDeck() {
    model.startGame(oneCardDeck, 5, 3, false);
  }

  // deck has more than 52 cards
  @Test(expected = IllegalArgumentException.class)
  public void testBigDeck() {
    model.startGame(bigDeck, 5, 3, false);
  }

  // deck is empty
  @Test(expected = IllegalArgumentException.class)
  public void testDeckEmpty() {
    model.startGame(emptyDeck, 5, 3, false);
  }

  // not enough open piles
  @Test(expected = IllegalArgumentException.class)
  public void testStartGameNoOpen() {
    model.startGame(standardDeck, 5, 0, false);
  }

  // not enough cascade piles
  @Test(expected = IllegalArgumentException.class)
  public void testStartGameLittleCascade() {
    model.startGame(standardDeck, 3, 4, false);
  }

  // deck is null
  @Test(expected = IllegalArgumentException.class)
  public void testStartGameDeckNull() {
    model.startGame(null, 4, 4, false);
  }

  @Test
  public void testGetDeckEquivalent() {
    assertEquals(true, deck.equals(standardDeck));
  }

  @Test
  public void testGetDeckSize() {
    assertEquals(52, deck.size());
  }


  // all 52 cards are correctly in foundation pile
  @Test
  public void testIsGameOverTrue() {
    FreecellModel<Card> fullModel = new SimpleFreecellModel();
    Collections.reverse(standardDeck);

    fullModel.startGame(standardDeck, 4, 1, false);

    fullModel.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 11, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 10, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 9, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 8, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 7, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 6, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 5, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 4, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 3, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 2, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 1, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 0);

    fullModel.move(PileType.CASCADE, 1, 12, PileType.FOUNDATION, 1);
    fullModel.move(PileType.CASCADE, 1, 11, PileType.FOUNDATION, 1);
    fullModel.move(PileType.CASCADE, 1, 10, PileType.FOUNDATION, 1);
    fullModel.move(PileType.CASCADE, 1, 9, PileType.FOUNDATION, 1);
    fullModel.move(PileType.CASCADE, 1, 8, PileType.FOUNDATION, 1);
    fullModel.move(PileType.CASCADE, 1, 7, PileType.FOUNDATION, 1);
    fullModel.move(PileType.CASCADE, 1, 6, PileType.FOUNDATION, 1);
    fullModel.move(PileType.CASCADE, 1, 5, PileType.FOUNDATION, 1);
    fullModel.move(PileType.CASCADE, 1, 4, PileType.FOUNDATION, 1);
    fullModel.move(PileType.CASCADE, 1, 3, PileType.FOUNDATION, 1);
    fullModel.move(PileType.CASCADE, 1, 2, PileType.FOUNDATION, 1);
    fullModel.move(PileType.CASCADE, 1, 1, PileType.FOUNDATION, 1);
    fullModel.move(PileType.CASCADE, 1, 0, PileType.FOUNDATION, 1);

    fullModel.move(PileType.CASCADE, 2, 12, PileType.FOUNDATION, 2);
    fullModel.move(PileType.CASCADE, 2, 11, PileType.FOUNDATION, 2);
    fullModel.move(PileType.CASCADE, 2, 10, PileType.FOUNDATION, 2);
    fullModel.move(PileType.CASCADE, 2, 9, PileType.FOUNDATION, 2);
    fullModel.move(PileType.CASCADE, 2, 8, PileType.FOUNDATION, 2);
    fullModel.move(PileType.CASCADE, 2, 7, PileType.FOUNDATION, 2);
    fullModel.move(PileType.CASCADE, 2, 6, PileType.FOUNDATION, 2);
    fullModel.move(PileType.CASCADE, 2, 5, PileType.FOUNDATION, 2);
    fullModel.move(PileType.CASCADE, 2, 4, PileType.FOUNDATION, 2);
    fullModel.move(PileType.CASCADE, 2, 3, PileType.FOUNDATION, 2);
    fullModel.move(PileType.CASCADE, 2, 2, PileType.FOUNDATION, 2);
    fullModel.move(PileType.CASCADE, 2, 1, PileType.FOUNDATION, 2);
    fullModel.move(PileType.CASCADE, 2, 0, PileType.FOUNDATION, 2);

    fullModel.move(PileType.CASCADE, 3, 12, PileType.FOUNDATION, 3);
    fullModel.move(PileType.CASCADE, 3, 11, PileType.FOUNDATION, 3);
    fullModel.move(PileType.CASCADE, 3, 10, PileType.FOUNDATION, 3);
    fullModel.move(PileType.CASCADE, 3, 9, PileType.FOUNDATION, 3);
    fullModel.move(PileType.CASCADE, 3, 8, PileType.FOUNDATION, 3);
    fullModel.move(PileType.CASCADE, 3, 7, PileType.FOUNDATION, 3);
    fullModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 3);
    fullModel.move(PileType.CASCADE, 3, 5, PileType.FOUNDATION, 3);
    fullModel.move(PileType.CASCADE, 3, 4, PileType.FOUNDATION, 3);
    fullModel.move(PileType.CASCADE, 3, 3, PileType.FOUNDATION, 3);
    fullModel.move(PileType.CASCADE, 3, 2, PileType.FOUNDATION, 3);
    fullModel.move(PileType.CASCADE, 3, 1, PileType.FOUNDATION, 3);
    fullModel.move(PileType.CASCADE, 3, 0, PileType.FOUNDATION, 3);

    assertTrue(fullModel.isGameOver());
  }

  // not all 52 cards are in foundation pile
  @Test
  public void testIsGameOverFalse() {
    FreecellModel<Card> fullModel = new SimpleFreecellModel();
    Collections.reverse(standardDeck);

    fullModel.startGame(standardDeck, 4, 1, false);

    fullModel.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 11, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 10, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 9, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 8, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 7, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 6, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 5, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 4, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 3, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 2, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 1, PileType.FOUNDATION, 0);
    fullModel.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 0);

    fullModel.move(PileType.CASCADE, 1, 12, PileType.FOUNDATION, 1);
    fullModel.move(PileType.CASCADE, 1, 11, PileType.FOUNDATION, 1);
    fullModel.move(PileType.CASCADE, 1, 10, PileType.FOUNDATION, 1);
    fullModel.move(PileType.CASCADE, 1, 9, PileType.FOUNDATION, 1);
    fullModel.move(PileType.CASCADE, 1, 8, PileType.FOUNDATION, 1);
    fullModel.move(PileType.CASCADE, 1, 7, PileType.FOUNDATION, 1);
    fullModel.move(PileType.CASCADE, 1, 6, PileType.FOUNDATION, 1);
    fullModel.move(PileType.CASCADE, 1, 5, PileType.FOUNDATION, 1);
    fullModel.move(PileType.CASCADE, 1, 4, PileType.FOUNDATION, 1);
    fullModel.move(PileType.CASCADE, 1, 3, PileType.FOUNDATION, 1);
    fullModel.move(PileType.CASCADE, 1, 2, PileType.FOUNDATION, 1);
    fullModel.move(PileType.CASCADE, 1, 1, PileType.FOUNDATION, 1);
    fullModel.move(PileType.CASCADE, 1, 0, PileType.FOUNDATION, 1);

    fullModel.move(PileType.CASCADE, 2, 12, PileType.FOUNDATION, 2);
    fullModel.move(PileType.CASCADE, 2, 11, PileType.FOUNDATION, 2);
    fullModel.move(PileType.CASCADE, 2, 10, PileType.FOUNDATION, 2);
    fullModel.move(PileType.CASCADE, 2, 9, PileType.FOUNDATION, 2);
    fullModel.move(PileType.CASCADE, 2, 8, PileType.FOUNDATION, 2);
    fullModel.move(PileType.CASCADE, 2, 7, PileType.FOUNDATION, 2);
    fullModel.move(PileType.CASCADE, 2, 6, PileType.FOUNDATION, 2);
    fullModel.move(PileType.CASCADE, 2, 5, PileType.FOUNDATION, 2);
    fullModel.move(PileType.CASCADE, 2, 4, PileType.FOUNDATION, 2);
    fullModel.move(PileType.CASCADE, 2, 3, PileType.FOUNDATION, 2);
    fullModel.move(PileType.CASCADE, 2, 2, PileType.FOUNDATION, 2);
    fullModel.move(PileType.CASCADE, 2, 1, PileType.FOUNDATION, 2);
    fullModel.move(PileType.CASCADE, 2, 0, PileType.FOUNDATION, 2);

    fullModel.move(PileType.CASCADE, 3, 12, PileType.FOUNDATION, 3);
    fullModel.move(PileType.CASCADE, 3, 11, PileType.FOUNDATION, 3);
    fullModel.move(PileType.CASCADE, 3, 10, PileType.FOUNDATION, 3);
    fullModel.move(PileType.CASCADE, 3, 9, PileType.FOUNDATION, 3);
    fullModel.move(PileType.CASCADE, 3, 8, PileType.FOUNDATION, 3);
    fullModel.move(PileType.CASCADE, 3, 7, PileType.FOUNDATION, 3);
    fullModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 3);
    fullModel.move(PileType.CASCADE, 3, 5, PileType.FOUNDATION, 3);
    fullModel.move(PileType.CASCADE, 3, 4, PileType.FOUNDATION, 3);
    fullModel.move(PileType.CASCADE, 3, 3, PileType.FOUNDATION, 3);
    fullModel.move(PileType.CASCADE, 3, 2, PileType.FOUNDATION, 3);
    fullModel.move(PileType.CASCADE, 3, 1, PileType.FOUNDATION, 3);

    // this 52nd card is not in one of the foundation piles
    //fullModel.move(PileType.CASCADE, 3, 0, PileType.FOUNDATION, 3);

    assertFalse(fullModel.isGameOver());
  }


}
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.FreecellModelCreator;
import cs3500.freecell.model.FreecellModelCreator.GameType;
import cs3500.freecell.model.PileType;
import cs3500.freecell.model.hw02.Card;
import cs3500.freecell.model.hw02.Symbol;
import cs3500.freecell.model.hw02.Value;
import cs3500.freecell.view.FreecellTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * tests for the {@code MultiFreecellModel} class.
 */
public class MultiFreecellModelTest {

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

  List<Card> reverseDeck = new ArrayList<Card>(Arrays.asList(aceClubs, aceHearts, aceSpades,
      aceDiamonds, twoClubs, twoHearts, twoSpades, twoDiamonds, threeClubs, threeHearts,
      threeSpades, threeDiamonds, fourClubs, fourHearts, fourSpades, fourDiamonds, fiveClubs,
      fiveHearts, fiveSpades, fiveDiamonds, sixClubs, sixHearts, sixSpades, sixDiamonds,
      sevenClubs, sevenHearts, sevenSpades, sevenDiamonds, eightClubs, eightHearts, eightSpades,
      eightDiamonds, nineClubs, nineHearts, nineSpades, nineDiamonds, tenClubs, tenHearts,
      tenSpades, tenDiamonds, jackClubs, jackHearts, jackSpades, jackDiamonds, queenClubs,
      queenHearts, queenSpades, queenDiamonds, kingClubs, kingHearts, kingSpades, kingDiamonds));

  FreecellModelCreator creator;
  FreecellModel<Card> multiModel = creator.create(GameType.MULTIMOVE);
  List<Card> deck = multiModel.getDeck();

  List<Card> oneCardDeck = new ArrayList<Card>(Arrays.asList(kingClubs));

  @Before
  public void initData() {
    Collections.reverse(reverseDeck);
  }


  // moving a card from one cascade pile to another cascade pile (not empty)
  @Test
  public void testOneCardCascadeToCascade() {
    multiModel.startGame(reverseDeck, 4, 4, false);
    multiModel.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);
    multiModel.move(PileType.CASCADE, 1, 12, PileType.CASCADE, 0);
    FreecellTextView fullView = new FreecellTextView(multiModel);

    String view = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: A♦\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♠\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣";

    String view2 = fullView.toString();

    assertEquals(view, view2);

  }

  // moving a card from open to open with multi model
  @Test
  public void testValidOpenToOpenMulti() {
    multiModel.startGame(reverseDeck, 4, 4, false);
    multiModel.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);
    multiModel.move(PileType.OPEN, 0, 0, PileType.OPEN, 1);
    FreecellTextView fullView = new FreecellTextView(multiModel);

    String view = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2: A♦\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣";

    String view2 = fullView.toString();

    assertEquals(view, view2);

  }

  // moving a card from open to cascade with multi model
  @Test
  public void testValidOpenToCascadeMulti() {
    multiModel.startGame(reverseDeck, 4, 4, false);
    multiModel.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);
    multiModel.move(PileType.CASCADE, 1, 12, PileType.OPEN, 1);
    multiModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 1);
    FreecellTextView fullView = new FreecellTextView(multiModel);

    String view = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2: A♠\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♦\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣";

    String view2 = fullView.toString();

    assertEquals(view, view2);

  }

  // moving a card from open to foundation with multi model
  @Test
  public void testValidOpenToFoundationMulti() {
    multiModel.startGame(reverseDeck, 4, 4, false);
    multiModel.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);
    multiModel.move(PileType.OPEN, 0, 0, PileType.FOUNDATION, 1);
    FreecellTextView fullView = new FreecellTextView(multiModel);

    String view = "F1:\n"
        + "F2: A♦\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣";

    String view2 = fullView.toString();

    assertEquals(view, view2);

  }

  // moving a card from cascade to foundation with multi model
  @Test
  public void testValidCascadeToFoundationMulti() {
    multiModel.startGame(reverseDeck, 4, 4, false);
    multiModel.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 0);
    FreecellTextView fullView = new FreecellTextView(multiModel);

    String view = "F1: A♦\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣";

    String view2 = fullView.toString();

    assertEquals(view, view2);

  }

  // moving a card from cascade to open with multi model
  @Test
  public void testValidCascadeToOpenMulti() {
    multiModel.startGame(reverseDeck, 4, 4, false);
    multiModel.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);
    FreecellTextView fullView = new FreecellTextView(multiModel);

    String view = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: A♦\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣";

    String view2 = fullView.toString();

    assertEquals(view, view2);

  }

  // moving two cards from one cascade pile to another cascade pile (not empty)
  @Test
  public void testTwoCardsCascadeToCascade() {
    multiModel.startGame(reverseDeck, 4, 4, false);
    multiModel.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);
    multiModel.move(PileType.CASCADE, 1, 12, PileType.CASCADE, 0);
    multiModel.move(PileType.CASCADE, 1, 11, PileType.OPEN, 1);
    multiModel.move(PileType.CASCADE, 0, 11, PileType.CASCADE, 1);
    FreecellTextView fullView = new FreecellTextView(multiModel);

    String view = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: A♦\n"
        + "O2: 2♠\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♦, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣";

    String view2 = fullView.toString();

    assertEquals(view, view2);

  }


  // moving two cards from one cascade pile to an empty cascade pile
  @Test
  public void testTwoCardsMoveToItselfSamePile() {
    multiModel.startGame(reverseDeck, 52, 4, false);
    multiModel.move(PileType.CASCADE, 8, 0, PileType.CASCADE, 7);
    multiModel.move(PileType.CASCADE, 0, 0, PileType.OPEN, 0);
    multiModel.move(PileType.CASCADE, 7, 0, PileType.CASCADE, 0);
    FreecellTextView fullView = new FreecellTextView(multiModel);

    String view = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: K♦\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: Q♣, J♦\n"
        + "C2: K♠\n"
        + "C3: K♥\n"
        + "C4: K♣\n"
        + "C5: Q♦\n"
        + "C6: Q♠\n"
        + "C7: Q♥\n"
        + "C8:\n"
        + "C9:\n"
        + "C10: J♠\n"
        + "C11: J♥\n"
        + "C12: J♣\n"
        + "C13: 10♦\n"
        + "C14: 10♠\n"
        + "C15: 10♥\n"
        + "C16: 10♣\n"
        + "C17: 9♦\n"
        + "C18: 9♠\n"
        + "C19: 9♥\n"
        + "C20: 9♣\n"
        + "C21: 8♦\n"
        + "C22: 8♠\n"
        + "C23: 8♥\n"
        + "C24: 8♣\n"
        + "C25: 7♦\n"
        + "C26: 7♠\n"
        + "C27: 7♥\n"
        + "C28: 7♣\n"
        + "C29: 6♦\n"
        + "C30: 6♠\n"
        + "C31: 6♥\n"
        + "C32: 6♣\n"
        + "C33: 5♦\n"
        + "C34: 5♠\n"
        + "C35: 5♥\n"
        + "C36: 5♣\n"
        + "C37: 4♦\n"
        + "C38: 4♠\n"
        + "C39: 4♥\n"
        + "C40: 4♣\n"
        + "C41: 3♦\n"
        + "C42: 3♠\n"
        + "C43: 3♥\n"
        + "C44: 3♣\n"
        + "C45: 2♦\n"
        + "C46: 2♠\n"
        + "C47: 2♥\n"
        + "C48: 2♣\n"
        + "C49: A♦\n"
        + "C50: A♠\n"
        + "C51: A♥\n"
        + "C52: A♣";

    String view2 = fullView.toString();

    assertEquals(view, view2);

  }

  // moving 13 cards from one cascade pile to another cascade pile (non empty)
  // requires atleast n=4 empty cascade piles, where 2^n > 13 cards
  @Test
  public void testMove13Cards() {
    multiModel.startGame(reverseDeck, 52, 4, false);
    multiModel.move(PileType.CASCADE, 50, 0, PileType.CASCADE, 47);
    multiModel.move(PileType.CASCADE, 47, 0, PileType.CASCADE, 42);
    multiModel.move(PileType.CASCADE, 42, 0, PileType.CASCADE, 39);
    multiModel.move(PileType.CASCADE, 39, 0, PileType.CASCADE, 34);
    multiModel.move(PileType.CASCADE, 34, 0, PileType.CASCADE, 31);
    multiModel.move(PileType.CASCADE, 31, 0, PileType.CASCADE, 26);
    multiModel.move(PileType.CASCADE, 26, 0, PileType.CASCADE, 21);
    multiModel.move(PileType.CASCADE, 21, 0, PileType.CASCADE, 18);
    multiModel.move(PileType.CASCADE, 18, 0, PileType.CASCADE, 13);
    multiModel.move(PileType.CASCADE, 13, 0, PileType.CASCADE, 10);
    multiModel.move(PileType.CASCADE, 10, 0, PileType.CASCADE, 5);
    multiModel.move(PileType.CASCADE, 5, 0, PileType.CASCADE, 2);
    multiModel.move(PileType.CASCADE, 2, 0, PileType.CASCADE, 50);

    FreecellTextView fullView = new FreecellTextView(multiModel);

    String view = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: K♦\n"
        + "C2: K♠\n"
        + "C3:\n"
        + "C4: K♣\n"
        + "C5: Q♦\n"
        + "C6:\n"
        + "C7: Q♥\n"
        + "C8: Q♣\n"
        + "C9: J♦\n"
        + "C10: J♠\n"
        + "C11:\n"
        + "C12: J♣\n"
        + "C13: 10♦\n"
        + "C14:\n"
        + "C15: 10♥\n"
        + "C16: 10♣\n"
        + "C17: 9♦\n"
        + "C18: 9♠\n"
        + "C19:\n"
        + "C20: 9♣\n"
        + "C21: 8♦\n"
        + "C22:\n"
        + "C23: 8♥\n"
        + "C24: 8♣\n"
        + "C25: 7♦\n"
        + "C26: 7♠\n"
        + "C27:\n"
        + "C28: 7♣\n"
        + "C29: 6♦\n"
        + "C30: 6♠\n"
        + "C31: 6♥\n"
        + "C32:\n"
        + "C33: 5♦\n"
        + "C34: 5♠\n"
        + "C35:\n"
        + "C36: 5♣\n"
        + "C37: 4♦\n"
        + "C38: 4♠\n"
        + "C39: 4♥\n"
        + "C40:\n"
        + "C41: 3♦\n"
        + "C42: 3♠\n"
        + "C43:\n"
        + "C44: 3♣\n"
        + "C45: 2♦\n"
        + "C46: 2♠\n"
        + "C47: 2♥\n"
        + "C48:\n"
        + "C49: A♦\n"
        + "C50: A♠\n"
        + "C51: K♥, Q♠, J♥, 10♠, 9♥, 8♠, 7♥, 6♣, 5♥, 4♣, 3♥, 2♣, A♥\n"
        + "C52: A♣";

    String view2 = fullView.toString();

    assertEquals(view, view2);

  }

  // getDeck has each of the correct cards
  @Test
  public void testGetDeckEquivalent() {
    assertEquals(true, deck.equals(standardDeck));
  }

  // getDeck has a total of 52 cards
  @Test
  public void testGetDeckSize() {
    assertEquals(52, deck.size());
  }

  // start game but with a large deck
  @Test(expected = IllegalArgumentException.class)
  public void testStartGameWithLargeDeck() {
    deck.add(aceClubs);
    multiModel.startGame(deck, 52, 4, false);
  }



  // moving a partial stack of an already full valid cascade pile to another cascade pile
  @Test
  public void testMoveHalfOfFullStackToOtherValidPile() {
    multiModel.startGame(reverseDeck, 52, 4, false);
    multiModel.move(PileType.CASCADE, 50, 0, PileType.CASCADE, 47);
    multiModel.move(PileType.CASCADE, 47, 0, PileType.CASCADE, 42);
    multiModel.move(PileType.CASCADE, 42, 0, PileType.CASCADE, 39);
    multiModel.move(PileType.CASCADE, 39, 0, PileType.CASCADE, 34);
    multiModel.move(PileType.CASCADE, 34, 0, PileType.CASCADE, 31);
    multiModel.move(PileType.CASCADE, 31, 0, PileType.CASCADE, 26);
    multiModel.move(PileType.CASCADE, 26, 0, PileType.CASCADE, 21);
    multiModel.move(PileType.CASCADE, 21, 0, PileType.CASCADE, 18);
    multiModel.move(PileType.CASCADE, 18, 0, PileType.CASCADE, 13);
    multiModel.move(PileType.CASCADE, 13, 0, PileType.CASCADE, 10);
    multiModel.move(PileType.CASCADE, 10, 0, PileType.CASCADE, 5);
    multiModel.move(PileType.CASCADE, 5, 0, PileType.CASCADE, 2);
    multiModel.move(PileType.CASCADE, 2, 0, PileType.CASCADE, 50);
    multiModel.move(PileType.CASCADE, 50, 7, PileType.CASCADE, 24);

    FreecellTextView fullView = new FreecellTextView(multiModel);

    String view = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: K♦\n"
        + "C2: K♠\n"
        + "C3:\n"
        + "C4: K♣\n"
        + "C5: Q♦\n"
        + "C6:\n"
        + "C7: Q♥\n"
        + "C8: Q♣\n"
        + "C9: J♦\n"
        + "C10: J♠\n"
        + "C11:\n"
        + "C12: J♣\n"
        + "C13: 10♦\n"
        + "C14:\n"
        + "C15: 10♥\n"
        + "C16: 10♣\n"
        + "C17: 9♦\n"
        + "C18: 9♠\n"
        + "C19:\n"
        + "C20: 9♣\n"
        + "C21: 8♦\n"
        + "C22:\n"
        + "C23: 8♥\n"
        + "C24: 8♣\n"
        + "C25: 7♦, 6♣, 5♥, 4♣, 3♥, 2♣, A♥\n"
        + "C26: 7♠\n"
        + "C27:\n"
        + "C28: 7♣\n"
        + "C29: 6♦\n"
        + "C30: 6♠\n"
        + "C31: 6♥\n"
        + "C32:\n"
        + "C33: 5♦\n"
        + "C34: 5♠\n"
        + "C35:\n"
        + "C36: 5♣\n"
        + "C37: 4♦\n"
        + "C38: 4♠\n"
        + "C39: 4♥\n"
        + "C40:\n"
        + "C41: 3♦\n"
        + "C42: 3♠\n"
        + "C43:\n"
        + "C44: 3♣\n"
        + "C45: 2♦\n"
        + "C46: 2♠\n"
        + "C47: 2♥\n"
        + "C48:\n"
        + "C49: A♦\n"
        + "C50: A♠\n"
        + "C51: K♥, Q♠, J♥, 10♠, 9♥, 8♠, 7♥\n"
        + "C52: A♣";

    String view2 = fullView.toString();

    assertEquals(view, view2);

  }


  // decks will be different when shuffled
  @Test
  public void testShuffleDeckDifferent() {

    multiModel.startGame(standardDeck, 4, 1, true);
    FreecellTextView view = new FreecellTextView(multiModel);

    multiModel.startGame(standardDeck, 4, 1, false);
    FreecellTextView view2 = new FreecellTextView(multiModel);

    assertNotEquals(view, view2);
  }


  // all 52 cards are correctly in foundation pile
  @Test
  public void testIsGameOverTrue() {

    multiModel.startGame(reverseDeck, 4, 1, false);

    multiModel.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 0);
    multiModel.move(PileType.CASCADE, 0, 11, PileType.FOUNDATION, 0);
    multiModel.move(PileType.CASCADE, 0, 10, PileType.FOUNDATION, 0);
    multiModel.move(PileType.CASCADE, 0, 9, PileType.FOUNDATION, 0);
    multiModel.move(PileType.CASCADE, 0, 8, PileType.FOUNDATION, 0);
    multiModel.move(PileType.CASCADE, 0, 7, PileType.FOUNDATION, 0);
    multiModel.move(PileType.CASCADE, 0, 6, PileType.FOUNDATION, 0);
    multiModel.move(PileType.CASCADE, 0, 5, PileType.FOUNDATION, 0);
    multiModel.move(PileType.CASCADE, 0, 4, PileType.FOUNDATION, 0);
    multiModel.move(PileType.CASCADE, 0, 3, PileType.FOUNDATION, 0);
    multiModel.move(PileType.CASCADE, 0, 2, PileType.FOUNDATION, 0);
    multiModel.move(PileType.CASCADE, 0, 1, PileType.FOUNDATION, 0);
    multiModel.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 0);

    multiModel.move(PileType.CASCADE, 1, 12, PileType.FOUNDATION, 1);
    multiModel.move(PileType.CASCADE, 1, 11, PileType.FOUNDATION, 1);
    multiModel.move(PileType.CASCADE, 1, 10, PileType.FOUNDATION, 1);
    multiModel.move(PileType.CASCADE, 1, 9, PileType.FOUNDATION, 1);
    multiModel.move(PileType.CASCADE, 1, 8, PileType.FOUNDATION, 1);
    multiModel.move(PileType.CASCADE, 1, 7, PileType.FOUNDATION, 1);
    multiModel.move(PileType.CASCADE, 1, 6, PileType.FOUNDATION, 1);
    multiModel.move(PileType.CASCADE, 1, 5, PileType.FOUNDATION, 1);
    multiModel.move(PileType.CASCADE, 1, 4, PileType.FOUNDATION, 1);
    multiModel.move(PileType.CASCADE, 1, 3, PileType.FOUNDATION, 1);
    multiModel.move(PileType.CASCADE, 1, 2, PileType.FOUNDATION, 1);
    multiModel.move(PileType.CASCADE, 1, 1, PileType.FOUNDATION, 1);
    multiModel.move(PileType.CASCADE, 1, 0, PileType.FOUNDATION, 1);

    multiModel.move(PileType.CASCADE, 2, 12, PileType.FOUNDATION, 2);
    multiModel.move(PileType.CASCADE, 2, 11, PileType.FOUNDATION, 2);
    multiModel.move(PileType.CASCADE, 2, 10, PileType.FOUNDATION, 2);
    multiModel.move(PileType.CASCADE, 2, 9, PileType.FOUNDATION, 2);
    multiModel.move(PileType.CASCADE, 2, 8, PileType.FOUNDATION, 2);
    multiModel.move(PileType.CASCADE, 2, 7, PileType.FOUNDATION, 2);
    multiModel.move(PileType.CASCADE, 2, 6, PileType.FOUNDATION, 2);
    multiModel.move(PileType.CASCADE, 2, 5, PileType.FOUNDATION, 2);
    multiModel.move(PileType.CASCADE, 2, 4, PileType.FOUNDATION, 2);
    multiModel.move(PileType.CASCADE, 2, 3, PileType.FOUNDATION, 2);
    multiModel.move(PileType.CASCADE, 2, 2, PileType.FOUNDATION, 2);
    multiModel.move(PileType.CASCADE, 2, 1, PileType.FOUNDATION, 2);
    multiModel.move(PileType.CASCADE, 2, 0, PileType.FOUNDATION, 2);

    multiModel.move(PileType.CASCADE, 3, 12, PileType.FOUNDATION, 3);
    multiModel.move(PileType.CASCADE, 3, 11, PileType.FOUNDATION, 3);
    multiModel.move(PileType.CASCADE, 3, 10, PileType.FOUNDATION, 3);
    multiModel.move(PileType.CASCADE, 3, 9, PileType.FOUNDATION, 3);
    multiModel.move(PileType.CASCADE, 3, 8, PileType.FOUNDATION, 3);
    multiModel.move(PileType.CASCADE, 3, 7, PileType.FOUNDATION, 3);
    multiModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 3);
    multiModel.move(PileType.CASCADE, 3, 5, PileType.FOUNDATION, 3);
    multiModel.move(PileType.CASCADE, 3, 4, PileType.FOUNDATION, 3);
    multiModel.move(PileType.CASCADE, 3, 3, PileType.FOUNDATION, 3);
    multiModel.move(PileType.CASCADE, 3, 2, PileType.FOUNDATION, 3);
    multiModel.move(PileType.CASCADE, 3, 1, PileType.FOUNDATION, 3);
    multiModel.move(PileType.CASCADE, 3, 0, PileType.FOUNDATION, 3);

    assertTrue(multiModel.isGameOver());
  }

  // only 51 cards are in foundation pile so isGameOver will be false
  @Test
  public void testIsGameOverFalse() {

    multiModel.startGame(reverseDeck, 4, 1, false);

    multiModel.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 0);
    multiModel.move(PileType.CASCADE, 0, 11, PileType.FOUNDATION, 0);
    multiModel.move(PileType.CASCADE, 0, 10, PileType.FOUNDATION, 0);
    multiModel.move(PileType.CASCADE, 0, 9, PileType.FOUNDATION, 0);
    multiModel.move(PileType.CASCADE, 0, 8, PileType.FOUNDATION, 0);
    multiModel.move(PileType.CASCADE, 0, 7, PileType.FOUNDATION, 0);
    multiModel.move(PileType.CASCADE, 0, 6, PileType.FOUNDATION, 0);
    multiModel.move(PileType.CASCADE, 0, 5, PileType.FOUNDATION, 0);
    multiModel.move(PileType.CASCADE, 0, 4, PileType.FOUNDATION, 0);
    multiModel.move(PileType.CASCADE, 0, 3, PileType.FOUNDATION, 0);
    multiModel.move(PileType.CASCADE, 0, 2, PileType.FOUNDATION, 0);
    multiModel.move(PileType.CASCADE, 0, 1, PileType.FOUNDATION, 0);
    multiModel.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 0);

    multiModel.move(PileType.CASCADE, 1, 12, PileType.FOUNDATION, 1);
    multiModel.move(PileType.CASCADE, 1, 11, PileType.FOUNDATION, 1);
    multiModel.move(PileType.CASCADE, 1, 10, PileType.FOUNDATION, 1);
    multiModel.move(PileType.CASCADE, 1, 9, PileType.FOUNDATION, 1);
    multiModel.move(PileType.CASCADE, 1, 8, PileType.FOUNDATION, 1);
    multiModel.move(PileType.CASCADE, 1, 7, PileType.FOUNDATION, 1);
    multiModel.move(PileType.CASCADE, 1, 6, PileType.FOUNDATION, 1);
    multiModel.move(PileType.CASCADE, 1, 5, PileType.FOUNDATION, 1);
    multiModel.move(PileType.CASCADE, 1, 4, PileType.FOUNDATION, 1);
    multiModel.move(PileType.CASCADE, 1, 3, PileType.FOUNDATION, 1);
    multiModel.move(PileType.CASCADE, 1, 2, PileType.FOUNDATION, 1);
    multiModel.move(PileType.CASCADE, 1, 1, PileType.FOUNDATION, 1);
    multiModel.move(PileType.CASCADE, 1, 0, PileType.FOUNDATION, 1);

    multiModel.move(PileType.CASCADE, 2, 12, PileType.FOUNDATION, 2);
    multiModel.move(PileType.CASCADE, 2, 11, PileType.FOUNDATION, 2);
    multiModel.move(PileType.CASCADE, 2, 10, PileType.FOUNDATION, 2);
    multiModel.move(PileType.CASCADE, 2, 9, PileType.FOUNDATION, 2);
    multiModel.move(PileType.CASCADE, 2, 8, PileType.FOUNDATION, 2);
    multiModel.move(PileType.CASCADE, 2, 7, PileType.FOUNDATION, 2);
    multiModel.move(PileType.CASCADE, 2, 6, PileType.FOUNDATION, 2);
    multiModel.move(PileType.CASCADE, 2, 5, PileType.FOUNDATION, 2);
    multiModel.move(PileType.CASCADE, 2, 4, PileType.FOUNDATION, 2);
    multiModel.move(PileType.CASCADE, 2, 3, PileType.FOUNDATION, 2);
    multiModel.move(PileType.CASCADE, 2, 2, PileType.FOUNDATION, 2);
    multiModel.move(PileType.CASCADE, 2, 1, PileType.FOUNDATION, 2);
    multiModel.move(PileType.CASCADE, 2, 0, PileType.FOUNDATION, 2);

    multiModel.move(PileType.CASCADE, 3, 12, PileType.FOUNDATION, 3);
    multiModel.move(PileType.CASCADE, 3, 11, PileType.FOUNDATION, 3);
    multiModel.move(PileType.CASCADE, 3, 10, PileType.FOUNDATION, 3);
    multiModel.move(PileType.CASCADE, 3, 9, PileType.FOUNDATION, 3);
    multiModel.move(PileType.CASCADE, 3, 8, PileType.FOUNDATION, 3);
    multiModel.move(PileType.CASCADE, 3, 7, PileType.FOUNDATION, 3);
    multiModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 3);
    multiModel.move(PileType.CASCADE, 3, 5, PileType.FOUNDATION, 3);
    multiModel.move(PileType.CASCADE, 3, 4, PileType.FOUNDATION, 3);
    multiModel.move(PileType.CASCADE, 3, 3, PileType.FOUNDATION, 3);
    multiModel.move(PileType.CASCADE, 3, 2, PileType.FOUNDATION, 3);
    multiModel.move(PileType.CASCADE, 3, 1, PileType.FOUNDATION, 3);
    //multiModel.move(PileType.CASCADE, 3, 0, PileType.FOUNDATION, 3);

    assertFalse(multiModel.isGameOver());
  }

  // game gets reset after startGame is called again
  @Test
  public void testStartAgain() {

    multiModel.startGame(standardDeck, 4, 1, false);
    multiModel.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);

    String game = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: K♣\n"
        + "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣\n"
        + "C2: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "C3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n"
        + "C4: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦";

    multiModel.startGame(standardDeck, 4, 1, false);

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

  // view for a game that hasn't started
  @Test
  public void testToStringNotStarted() {
    FreecellTextView view = new FreecellTextView(multiModel);
    assertEquals(view.toString(), "");
  }


  // start game with a multiModel but there are not enough open piles
  @Test(expected = IllegalArgumentException.class)
  public void testMultiStartGameNoOpen() {
    multiModel.startGame(standardDeck, 5, 0, false);
  }

  // start game with a multiModel but there are not enough cascade piles
  @Test(expected = IllegalArgumentException.class)
  public void testMultiStartGameNoCascade() {
    multiModel.startGame(standardDeck, 2, 4, false);
  }

  // start game with a multiModel where start game has a null deck
  @Test(expected = IllegalArgumentException.class)
  public void testMultiStartGameDeckNull() {
    multiModel.startGame(null, 4, 4, false);
  }

  // start game with a multiModel where start game has an invalid deck
  @Test(expected = IllegalArgumentException.class)
  public void testMultiStartGameDeckInvalid() {
    multiModel.startGame(oneCardDeck, 4, 4, false);
  }

  // trying to move two cards from one cascade pile to another but not enough intermediate slots
  @Test(expected = IllegalArgumentException.class)
  public void testTwoCardsNotEnoughIntermediateSlots() {
    multiModel.startGame(reverseDeck, 4, 2, false);
    multiModel.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);
    multiModel.move(PileType.CASCADE, 1, 12, PileType.CASCADE, 0);
    multiModel.move(PileType.CASCADE, 1, 11, PileType.OPEN, 1);
    multiModel.move(PileType.CASCADE, 0, 11, PileType.CASCADE, 1);

  }

  // trying to move two cards from one cascade pile to a foundation pile
  @Test(expected = IllegalArgumentException.class)
  public void testTwoCardsTryToMoveToFoundation() {
    multiModel.startGame(reverseDeck, 4, 10, false);
    multiModel.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);
    multiModel.move(PileType.CASCADE, 1, 12, PileType.CASCADE, 0);
    multiModel.move(PileType.CASCADE, 1, 11, PileType.OPEN, 1);
    multiModel.move(PileType.CASCADE, 0, 11, PileType.FOUNDATION, 0);

  }

  // trying to move two cards from one cascade pile to a open pile
  @Test(expected = IllegalArgumentException.class)
  public void testTwoCardsTryToMoveToOpen() {
    multiModel.startGame(reverseDeck, 4, 10, false);
    multiModel.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);
    multiModel.move(PileType.CASCADE, 1, 12, PileType.CASCADE, 0);
    multiModel.move(PileType.CASCADE, 1, 11, PileType.OPEN, 1);
    multiModel.move(PileType.CASCADE, 0, 11, PileType.OPEN, 0);

  }

  // moving but doesn't follow rules because card on top is either not 1 value less or
  // is the same color
  @Test(expected = IllegalArgumentException.class)
  public void testDoesntFollowRules() {
    multiModel.startGame(reverseDeck, 4, 4, false);
    multiModel.move(PileType.CASCADE, 0, 5, PileType.CASCADE, 2);

  }


  // moving two cards from one cascade pile to a another but its the same color as destination
  @Test(expected = IllegalArgumentException.class)
  public void testAttemptMoveToSameColor() {
    multiModel.startGame(reverseDeck, 52, 4, false);
    multiModel.move(PileType.CASCADE, 8, 0, PileType.CASCADE, 7);
    multiModel.move(PileType.CASCADE, 0, 0, PileType.OPEN, 0);
    multiModel.move(PileType.CASCADE, 7, 0, PileType.CASCADE, 0);
    multiModel.move(PileType.CASCADE, 0, 0, PileType.CASCADE, 1);

  }

  // trying to move two cards from one cascade pile to a another but wrong cardIndex
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveCascadeToCascadeIndex() {
    multiModel.startGame(reverseDeck, 4, 4, false);
    multiModel.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);
    multiModel.move(PileType.CASCADE, 1, 12, PileType.CASCADE, 0);
    multiModel.move(PileType.CASCADE, 1, 11, PileType.OPEN, 1);
    multiModel.move(PileType.CASCADE, 0, 12, PileType.CASCADE, 1);

  }

  // moving two cards from one cascade pile to a another but its not the correct value
  @Test(expected = IllegalArgumentException.class)
  public void testAttemptMoveToWrongValue() {
    multiModel.startGame(reverseDeck, 52, 4, false);
    multiModel.move(PileType.CASCADE, 8, 0, PileType.CASCADE, 7);
    multiModel.move(PileType.CASCADE, 0, 0, PileType.OPEN, 0);
    multiModel.move(PileType.CASCADE, 7, 0, PileType.CASCADE, 0);
    multiModel.move(PileType.CASCADE, 0, 0, PileType.CASCADE, 40);

  }

  // trying to move a card before the game even starts
  @Test(expected = IllegalStateException.class)
  public void testMoveBeforeStartGame() {
    //multiModel.startGame(reverseDeck, 52, 4, false);
    multiModel.move(PileType.CASCADE, 0, 0, PileType.OPEN, 1);

  }







}

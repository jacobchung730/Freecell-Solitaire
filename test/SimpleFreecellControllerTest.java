import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import cs3500.freecell.controller.FreecellController;
import cs3500.freecell.controller.SimpleFreecellController;
import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.PileType;
import cs3500.freecell.model.hw02.Card;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import cs3500.freecell.model.hw02.Symbol;
import cs3500.freecell.model.hw02.Value;
import cs3500.freecell.model.hw04.MultiFreecellModel;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * tests for the {@code SimpleFreecellControllerTest} class.
 */
public class SimpleFreecellControllerTest {

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

  FreecellModel<Card> model = new SimpleFreecellModel();
  List<Card> deck = model.getDeck();

  FreecellModel<Card> multiModel = new MultiFreecellModel();

  @Before
  public void initData() {
    Collections.reverse(reverseDeck);
  }


  // test using the mock model where we can see it correctly outputs the checks that the model has
  // received inputs that we expect from the controller, using startGame method
  @Test
  public void testMockModelStartGame() throws IOException {

    StringBuilder log = new StringBuilder();
    FreecellModel<Card> mockModel = new MockFreecellModel(log);

    mockModel.startGame(deck, 4, 1, false);
    // we see that the output is as expected (numCascadePiles * 10) then (numOpenPiles + 10) then
    // the boolean then the numbers 123
    // this string formula was what i created in my mock model
    assertEquals("4014false123", log.toString());
  }

  // test using the mock model where we can see it correctly outputs the checks that the model has
  // received inputs that we expect from the controller, using move method
  @Test
  public void testMockModelMove() throws IOException {

    StringBuilder log = new StringBuilder();
    FreecellModel<Card> mockModel = new MockFreecellModel(log);

    mockModel.move(PileType.CASCADE, 1, 12, PileType.OPEN, 1);
    assertEquals("102210", log.toString());
  }


  // using a bad appendable so that playGame will throw an IllegalStateException because it could
  // not append to this bad appendable
  @Test(expected = IllegalStateException.class)
  public void testAppendingToBadAppendable() {
    Reader in = new StringReader("C1 13 O1 q");
    BadAppendable out = new BadAppendable();
    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);
  }

  // test to show that a negative card index is invalid
  @Test
  public void testNegativeCardIndex() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: A♥\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C3 -1 O1 c3 13 o1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }



  // is game over is false so the view does not contain the string "Game Over."
  @Test
  public void testIsGameOverFalse() {

    String answer = "";

    Reader in = new StringReader("C1 13 O1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertFalse(model.isGameOver());
    assertFalse(out.toString().contains("Game over."));
  }


  // is game over is true and the view contains the string "Game Over."
  @Test
  public void testIsGameOverTrue() {

    String answer = "";

    for (int i = 1; i < 5; i++) {
      for (int j = 13; j > 0; j--) {
        answer = answer + "C" + i + " " + j + " " + "F" + i + "\n";
      }
    }

    Reader in = new StringReader(answer + " q ");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertTrue(model.isGameOver());
    assertTrue(out.toString().contains("C1"));
  }


  // new line around the valid inputs
  @Test
  public void testNewLineAroundValidInputs() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "F1: A♣\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C4 \n \n \n 13 \n      \n       f1    \n \n \n \n \n q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 2, false);

    assertEquals(answer, out.toString());
  }

  // whitespace around the valid inputs
  @Test
  public void testValidWhiteSpace() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2: A♣\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C4     13                o2      q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 2, false);

    assertEquals(answer, out.toString());
  }


  //Multiple whitespace around the q
  @Test
  public void testWhiteSpaceQ() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C1      q       q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 2, false);

    assertEquals(answer, out.toString());
  }


  // valid move from open to foundation
  @Test
  public void testValidOpenToFoundation() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: A♦\n"
        + "O2:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "F1: A♦\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C1 13 O1 o1 1 f1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 2, false);

    assertEquals(answer, out.toString());
  }

  // valid move from open to cascade using MultiFreecellModel
  @Test
  public void testValidOpenToCascadeMulti() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: A♦\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: A♦\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♠\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C1 13 O1 C2 13 C1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(multiModel, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // valid move from open to cascade
  @Test
  public void testValidOpenToCascade() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: A♦\n"
        + "O2:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: A♦\n"
        + "O2:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♠\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C1 13 O1 c2 13 c1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 2, false);

    assertEquals(answer, out.toString());
  }

  // valid move from open to open
  @Test
  public void testValidOpenToOpen() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: A♦\n"
        + "O2:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2: A♦\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C1 13 O1 O1 1 O2 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 2, false);

    assertEquals(answer, out.toString());
  }


  // valid move from cascade to open
  @Test
  public void testValidCascadeToOpen() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: A♠\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C2 13 o1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // valid move from cascade to foundation
  @Test
  public void testValidCascadeToFoundation() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4: A♦\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C1 13 f4 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // valid move from cascade to cascade
  @Test
  public void testValidCascadeToCascade() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: A♦\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: A♦\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♠\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C1 13 O1 C2 13 c1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // scan does not have next which throws an illegalStateException
  @Test(expected = IllegalStateException.class)
  public void testScanDoesNotHaveNext() {

    Reader in = new StringReader("C1 13 O1");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);
    controller.playGame(deck, 4, 1, false);

  }


  // waiting for some valid input
  @Test
  public void testWaitingForInput() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "Please enter a valid sourcePile, sourcePileIndex, cardIndex, destinationPile, and "
        + "destinationPileIndex:\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("hey q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // invalid move to an already open pile
  @Test
  public void testMovetoAnAlreadyOpenPile() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: A♦\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "Could not perform move! Please enter a valid sourcePile, sourcePileIndex, cardIndex, "
        + "destinationPile, and destinationPileIndex:\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C1 13 O1 c1 12 O1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // invalid destination but then becomes valid because of the inputs later
  @Test
  public void testInvalidDestinationButIsGivenLater() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "Please enter a valid destinationPile and destinationPileIndex:\n"
        + "Please enter a valid destinationPile and destinationPileIndex:\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C1 13 hi Q1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }

  // invalid cardIndex but then becomes valid because of the inputs later
  @Test
  public void testInvalidCardIndexButIsGivenLater() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "Please enter a valid cardIndex, destinationPile, and destinationPileIndex:\n"
        + "Please enter a valid destinationPile and destinationPileIndex:\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C1 hi 13 Q1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // invalid source but then becomes valid because of the inputs later
  @Test
  public void testInvalidSourceButIsGivenLater() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "Please enter a valid sourcePile, sourcePileIndex, cardIndex, destinationPile, and "
        + "destinationPileIndex:\n"
        + "Please enter a valid destinationPile and destinationPileIndex:\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("hi C1 13 Q1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // q that is grouped with a letter
  @Test
  public void testQWithNoWhiteSpace() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "Please enter a valid destinationPile and destinationPileIndex:\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C1 13 Q1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // trying to use a lowercase letter for foundation pile
  @Test
  public void testUseLowercaseLetterFoundation() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "F1: A♦\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C1 13 f1 Q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // trying to use a lowercase letter for open pile
  @Test
  public void testUseLowercaseLetterOpen() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: A♦\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C1 13 o1 Q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // trying to use a lowercase letter for cascade pile
  @Test
  public void testUseLowercaseLetterCascade() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "F1: A♦\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("c1 13 F1 Q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // Q is the only input
  @Test
  public void testQByItself() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("Q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // valid move but with gibberish in between
  @Test
  public void testValidMoveButWithGibberishInBetween() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "Please enter a valid sourcePile, sourcePileIndex, cardIndex, destinationPile, and "
        + "destinationPileIndex:\n"
        + "Please enter a valid cardIndex, destinationPile, and destinationPileIndex:\n"
        + "Please enter a valid cardIndex, destinationPile, and destinationPileIndex:\n"
        + "Please enter a valid destinationPile and destinationPileIndex:\n"
        + "Please enter a valid destinationPile and destinationPileIndex:\n"
        + "Please enter a valid destinationPile and destinationPileIndex:\n"
        + "F1: A♦\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "Please enter a valid sourcePile, sourcePileIndex, cardIndex, destinationPile, and "
        + "destinationPileIndex:\n"
        + "Please enter a valid sourcePile, sourcePileIndex, cardIndex, destinationPile, and "
        + "destinationPileIndex:\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("hi C1 hi hello 13 hi hey sup F1 yo hi q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // Invalid source and valid cardIndex and valid destination
  @Test
  public void testInvalidSourceValidCardIndexValidDestination() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "Please enter a valid sourcePile, sourcePileIndex, cardIndex, destinationPile, and "
        + "destinationPileIndex:\n"
        + "Please enter a valid sourcePile, sourcePileIndex, cardIndex, destinationPile, and "
        + "destinationPileIndex:\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("hi 13 F1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // valid source and invalid cardIndex and valid destination
  @Test
  public void testValidSourceInvalidCardIndexValidDestination() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "Please enter a valid cardIndex, destinationPile, and destinationPileIndex:\n"
        + "Please enter a valid cardIndex, destinationPile, and destinationPileIndex:\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C1 hi F1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }

  // valid source and valid cardIndex but invalid destination
  @Test
  public void testValidSourceValidCardIndexInvalidDestination() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "Please enter a valid destinationPile and destinationPileIndex:\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C1 13 hi q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // two valid moves
  @Test
  public void testTwoValidMoves() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "F1: A♦\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "F1: A♦, 2♦\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C1 13 F1 C1 12 F1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // a valid move
  @Test
  public void testValidMove() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "F1: A♦\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C1 13 F1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // the input is wrong multiple times
  @Test
  public void testSameThingWrong() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "Please enter a valid sourcePile, sourcePileIndex, cardIndex, destinationPile, and "
        + "destinationPileIndex:\n"
        + "Please enter a valid sourcePile, sourcePileIndex, cardIndex, destinationPile, and "
        + "destinationPileIndex:\n"
        + "Please enter a valid sourcePile, sourcePileIndex, cardIndex, destinationPile, and "
        + "destinationPileIndex:\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("hi hi hi q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // q is typed in the middle of a valid move
  @Test
  public void testQMiddleOfValidMove() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C1 13 q O1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // q that is typed before a valid move
  @Test
  public void testQBeforeAMoveHappens() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("q C1 13 O1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // move occurs and then quit happens after
  @Test
  public void testMoveOccursThenQuit() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "O5:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3: A♥\n"
        + "O4:\n"
        + "O5:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C3 13 O3 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 5, false);

    assertEquals(answer, out.toString());
  }


  // q that is not surrounded by whitespace, so it doesn't quit
  @Test
  public void testQNotSurroundedByWhitespace() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "Please enter a valid cardIndex, destinationPile, and destinationPileIndex:\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: A♣\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C4 qq 13 O1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // controller model is null
  @Test(expected = IllegalArgumentException.class)
  public void testModelNullForController() {
    Reader in = new StringReader("C1 13 O1 q");
    StringBuffer out = new StringBuffer();
    FreecellController<Card> controller = new SimpleFreecellController(null, in, out);
  }


  // controller rd is null
  @Test(expected = IllegalArgumentException.class)
  public void testRdNull() {
    StringBuffer out = new StringBuffer();
    FreecellController<Card> controller = new SimpleFreecellController(model, null, out);
  }

  // controller ap is null
  @Test(expected = IllegalArgumentException.class)
  public void testApNull() {
    Reader in = new StringReader("C1 13 O1 q");
    FreecellController<Card> controller = new SimpleFreecellController(model, in, null);
  }


  // test that the deck gets shuffled (there is an extreme edge case where the shuffled deck
  // could be the same as the original deck)
  @Test
  public void testDeckGetsShuffled() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "Could not perform move! Please enter a valid sourcePile, sourcePileIndex, cardIndex, "
        + "destinationPile, and destinationPileIndex:\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C1 99 O1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, true);

    assertNotEquals(answer, out.toString());
  }


  // playGame invalid card Index
  @Test
  public void testWithInvalidCardIndex() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "Could not perform move! Please enter a valid sourcePile, sourcePileIndex, cardIndex, "
        + "destinationPile, and destinationPileIndex:\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C1 99 O1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // trying to play game but the numOpen is invalid
  @Test
  public void testStartGameButNumOpenInvalid() {

    String answer = "Could not start game.";

    Reader in = new StringReader("C1 13 O1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 0, false);

    assertEquals(answer, out.toString());
  }


  // trying to play game but the numCascades is invalid
  @Test
  public void testStartGameButNumCascadeInvalid() {

    String answer = "Could not start game.";

    Reader in = new StringReader("C1 13 O1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 2, 1, false);

    assertEquals(answer, out.toString());
  }


  // trying to play game but the deck is null
  @Test(expected = IllegalArgumentException.class)
  public void testStartGameButDeckNull() {

    Reader in = new StringReader("C1 13 O1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);
    controller.playGame(null, 4, 1, false);

  }


  // trying to play game but the deck is invalid
  @Test
  public void testStartGameButDeckInvalid() {

    String answer = "Could not start game.";

    Reader in = new StringReader("C1 13 O1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    reverseDeck.add(aceClubs);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // playGame where the source index is out of bounds
  @Test
  public void testSourceIndexOutOfBounds() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "Could not perform move! Please enter a valid sourcePile, sourcePileIndex, cardIndex, "
        + "destinationPile, and destinationPileIndex:\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C99 13 O1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // a card from cascade to cascade where it is invalid because the color is the same
  @Test
  public void testMoveFromCascadeToCascadeWhereColorIsSame() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: A♠\n"
        + "C1: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C2: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "Could not perform move! Please enter a valid sourcePile, sourcePileIndex, cardIndex, "
        + "destinationPile, and destinationPileIndex:\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C2 13 O1 C4 13 C2 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverseDeck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // moving to an open pile where there is already a card
  @Test
  public void testMoveToOpenPileWithCardAlready() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "C2: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "C3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n"
        + "C4: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: K♣\n"
        + "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣\n"
        + "C2: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "C3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n"
        + "C4: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "Could not perform move! Please enter a valid sourcePile, sourcePileIndex, cardIndex, "
        + "destinationPile, and destinationPileIndex:\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C1 13 O1 C1 12 O1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(deck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // trying to move a king to an empty foundation
  @Test
  public void testBadMoveToFoundation() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "C2: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "C3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n"
        + "C4: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "Could not perform move! Please enter a valid sourcePile, sourcePileIndex, cardIndex, "
        + "destinationPile, and destinationPileIndex:\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C1 13 F1 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(deck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // starting the game multiple times
  @Test
  public void testStartGameMultipleTimes() {

    model.startGame(deck, 4, 1, false);
    model.startGame(deck, 4, 1, false);

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "C2: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "C3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n"
        + "C4: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "Could not perform move! Please enter a valid sourcePile, sourcePileIndex, cardIndex, "
        + "destinationPile, and destinationPileIndex:\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C1 13 O99 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(deck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


  // playGame with the destination pile index out of bounds
  @Test
  public void testPlayGameWithDestinationPileOutOfBounds() {

    String answer = "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "C2: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "C3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n"
        + "C4: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "Could not perform move! Please enter a valid sourcePile, sourcePileIndex, cardIndex, "
        + "destinationPile, and destinationPileIndex:\n"
        + "\n"
        + "Game quit prematurely.";

    Reader in = new StringReader("C4 13 O9 q");
    StringBuffer out = new StringBuffer();

    FreecellController<Card> controller = new SimpleFreecellController(model, in, out);

    controller.playGame(deck, 4, 1, false);

    assertEquals(answer, out.toString());
  }


}
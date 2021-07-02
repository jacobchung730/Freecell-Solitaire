

import static org.junit.Assert.assertEquals;


import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.hw02.Card;
import cs3500.freecell.model.PileType;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import cs3500.freecell.model.hw02.Symbol;
import cs3500.freecell.model.hw02.Value;
import cs3500.freecell.view.FreecellTextView;
import cs3500.freecell.view.FreecellView;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

/**
 * tests for the {@code FreecellTextViewTest} class.
 */
public class FreecellTextViewTest {

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


  // controller receives board input from the view
  @Test
  public void testRenderBoard() throws IOException {

    StringBuilder log = new StringBuilder();
    FreecellView view = new MockFreecellView(log);

    view.renderBoard();

    assertEquals("board rendered", log.toString());

  }

  // controller receives message input from the view
  @Test
  public void testRenderMessage() throws IOException {

    StringBuilder log = new StringBuilder();
    FreecellView view = new MockFreecellView(log);

    view.renderMessage("hi friends!");

    assertEquals("this is the message: hi friends!", log.toString());
  }


  // throws and exception when trying to call renderBoard on a bad appendable
  @Test(expected = IOException.class)
  public void testIOExceptionInRenderBoard() throws IOException {

    FreecellModel<Card> model = new SimpleFreecellModel();
    new FreecellTextView(model, new BadAppendable()).renderBoard();
  }

  // throws and exception when trying to call renderMessage on a bad appendable
  @Test(expected = IOException.class)
  public void testIOExceptionInRenderMessage() throws IOException {

    FreecellModel<Card> model = new SimpleFreecellModel();
    new FreecellTextView(model, new BadAppendable()).renderMessage("sup bro");
  }


  // model in view constructor is null
  @Test(expected = IllegalArgumentException.class)
  public void testModelInViewConstructorIsNull() {

    new FreecellTextView(null, System.out);

  }


  // the given model for this view is null
  @Test(expected = IllegalArgumentException.class)
  public void testCardValueNull() {
    new FreecellTextView(null);
  }

  // cards all all in cascade, and also tests which move cards from cascade pile to other piles
  @Test
  public void testViewFullCascade() {
    FreecellModel<Card> model = new SimpleFreecellModel();
    List<Card> deck = model.getDeck();

    model.startGame(deck, 4, 4, false);

    FreecellTextView view = new FreecellTextView(model);

    assertEquals("F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "C2: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "C3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n"
        + "C4: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦", view.toString());

    // move card from cascade to open pile
    model.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);

    assertEquals("F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: K♣\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣\n"
        + "C2: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "C3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n"
        + "C4: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦", view.toString());

  }

  // view is "" if game has not started
  @Test
  public void testGameNotStart() {
    FreecellModel<Card> model = new SimpleFreecellModel();
    List<Card> deck = model.getDeck();

    FreecellTextView view = new FreecellTextView(model);

    assertEquals("", view.toString());
  }


  // cards all all in foundation, game is over
  @Test
  public void testViewFullFoundation() {

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

    FreecellTextView view = new FreecellTextView(fullModel);

    assertEquals("F1: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F2: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n"
        + "F3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "F4: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "O1:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4:", view.toString());
  }


}
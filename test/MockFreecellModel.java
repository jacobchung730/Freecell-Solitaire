import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.PileType;
import cs3500.freecell.model.hw02.Card;
import java.util.List;
import java.util.Objects;

/**
 * This MockFreecellModel class is used to show that the model's inputs are correctly outputted
 * by the controller. This class is used in testing.
 */
public class MockFreecellModel implements FreecellModel<Card> {

  private final StringBuilder log;

  /**
   * Constructs a {@code MockFreecellModel} object.
   * @param log a log of the strings that will get added
   */
  public MockFreecellModel(StringBuilder log) {
    this.log = Objects.requireNonNull(log);
  }

  @Override
  public List<Card> getDeck() {
    return null;
  }

  @Override
  public void startGame(List<Card> deck, int numCascadePiles, int numOpenPiles, boolean shuffle)
      throws IllegalArgumentException {
    log.append(Integer.toString(numCascadePiles * 10) + Integer.toString(numCascadePiles + 10)
        + Boolean.toString(shuffle) + "123");

  }

  @Override
  public void move(PileType source, int pileNumber, int cardIndex, PileType destination,
      int destPileNumber) throws IllegalArgumentException, IllegalStateException {
    log.append(Integer.toString(pileNumber * 10) + Integer.toString(cardIndex + 10)
        + Integer.toString(destPileNumber * 10));
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public int getNumCardsInFoundationPile(int index)
      throws IllegalArgumentException, IllegalStateException {
    return 0;
  }

  @Override
  public int getNumCascadePiles() {
    return 0;
  }

  @Override
  public int getNumCardsInCascadePile(int index)
      throws IllegalArgumentException, IllegalStateException {
    return 0;
  }

  @Override
  public int getNumCardsInOpenPile(int index)
      throws IllegalArgumentException, IllegalStateException {
    return 0;
  }

  @Override
  public int getNumOpenPiles() {
    return 0;
  }

  @Override
  public Card getFoundationCardAt(int pileIndex, int cardIndex)
      throws IllegalArgumentException, IllegalStateException {
    return null;
  }

  @Override
  public Card getCascadeCardAt(int pileIndex, int cardIndex)
      throws IllegalArgumentException, IllegalStateException {
    return null;
  }

  @Override
  public Card getOpenCardAt(int pileIndex) throws IllegalArgumentException, IllegalStateException {
    return null;
  }
}

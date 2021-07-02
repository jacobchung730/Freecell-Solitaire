package cs3500.freecell.model.hw02;

/**
 * represents a card symbol that can be one of CLUBS, HEARTS, SPADES, or DIAMONDS. Each symbol has a
 * corresponding string.
 */
public enum Symbol {
  CLUBS, HEARTS, SPADES, DIAMONDS;

  @Override
  public String toString() {
    switch (this) {
      case CLUBS:
        return "♣";
      case HEARTS:
        return "♥";
      case SPADES:
        return "♠";
      case DIAMONDS:
        return "♦";
      default:
        throw new AssertionError("Invalid Symbol enum");
    }
  }
}
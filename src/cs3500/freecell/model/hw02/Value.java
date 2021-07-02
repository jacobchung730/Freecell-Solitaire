package cs3500.freecell.model.hw02;

/**
 * represents a card's value that can be either ACE(0), TWO(1), THREE(2), FOUR(3), FIVE(4), SIX(5),
 * SEVEN(6), EIGHT(7), NINE(8), TEN(9), JACK(10), QUEEN(11), KING(12). All cards have a
 * corresponding index which is used to determine ordering. Each value has a corresponding string.
 */
public enum Value {
  ACE(0), TWO(1), THREE(2), FOUR(3), FIVE(4), SIX(5),
  SEVEN(6), EIGHT(7), NINE(8), TEN(9), JACK(10), QUEEN(11),
  KING(12);

  // used for ordering of the cards
  private final int index;

  /**
   * constructs a {@code Value} object.
   *
   * @param index used to tell which card has a higher value
   */
  Value(int index) {
    this.index = index;
  }

  /**
   * returns the index of this card value.
   *
   * @return the index of this card value
   */
  public int getIndex() {
    return this.index;
  }


  @Override
  public String toString() {
    switch (this) {
      case ACE:
        return "A";
      case TWO:
        return "2";
      case THREE:
        return "3";
      case FOUR:
        return "4";
      case FIVE:
        return "5";
      case SIX:
        return "6";
      case SEVEN:
        return "7";
      case EIGHT:
        return "8";
      case NINE:
        return "9";
      case TEN:
        return "10";
      case JACK:
        return "J";
      case QUEEN:
        return "Q";
      case KING:
        return "K";
      default:
        throw new AssertionError("Invalid Value enum");
    }
  }


}
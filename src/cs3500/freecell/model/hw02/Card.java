package cs3500.freecell.model.hw02;

/**
 * represents a playing card, which has a value and a symbol.
 */
public class Card {

  private final Value value;
  private final Symbol symbol;

  /**
   * constructs a {@code Card} object with a value and symbol.
   *
   * @param value  the value of this card
   * @param symbol the symbol on this card
   */
  public Card(Value value, Symbol symbol) {
    if (value == null || symbol == null) {
      throw new IllegalArgumentException("value or symbol can't be null!");
    } else {
      this.value = value;
      this.symbol = symbol;
    }
  }

  /**
   * determines if this card color is different than the given card color
   * also determines if this card value is one more than the other card value.
   * @param other the card that is being used for comparison
   * @return if this card is different color and one value higher
   */
  public boolean differentColorAndOneValueMore(Card other) {

    boolean oppositeColor = false;
    boolean oneValueMore;

    if (this.symbol == Symbol.HEARTS || this.symbol == Symbol.DIAMONDS) {
      oppositeColor = other.symbol == Symbol.CLUBS || other.symbol == Symbol.SPADES;
    } else if (this.symbol == Symbol.CLUBS || this.symbol == Symbol.SPADES) {
      oppositeColor = other.symbol == Symbol.HEARTS || other.symbol == Symbol.DIAMONDS;
    }

    oneValueMore = this.getValueIndex() == other.getValueIndex() + 1;

    return oppositeColor && oneValueMore;
  }

  @Override
  public String toString() {
    return this.value.toString() + this.symbol.toString();
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Card)) {
      return false;
    }
    Card that = (Card) other;
    return this.value == that.value
        && this.symbol == that.symbol;
  }

  @Override
  public int hashCode() {
    return this.value.hashCode() * 797 + this.symbol.hashCode() * 797;
  }


  /**
   * returns the index of this card's value (used to determine correct ordering of cards).
   *
   * @return the index of this card's value
   */
  public int getValueIndex() {
    return this.value.getIndex();
  }

  /**
   * returns the symbol of this card.
   *
   * @return the symbol of this card
   */
  public Symbol getSymbol() {
    return this.symbol;
  }

}



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cs3500.freecell.model.hw02.Card;
import cs3500.freecell.model.hw02.Symbol;
import cs3500.freecell.model.hw02.Value;
import org.junit.Test;

/**
 * tests for the {@code Card} class.
 */
public class CardTest {

  Card aceClubs = new Card(Value.ACE, Symbol.CLUBS);
  Card aceClubsDuplicate = new Card(Value.ACE, Symbol.CLUBS);

  Card eightClubs = new Card(Value.EIGHT, Symbol.CLUBS);
  Card eightHearts = new Card(Value.EIGHT, Symbol.HEARTS);
  Card eightSpades = new Card(Value.EIGHT, Symbol.SPADES);
  Card eightDiamonds = new Card(Value.EIGHT, Symbol.DIAMONDS);

  Card nineClubs = new Card(Value.NINE, Symbol.CLUBS);
  Card nineHearts = new Card(Value.NINE, Symbol.HEARTS);
  Card nineSpades = new Card(Value.NINE, Symbol.SPADES);
  Card nineDiamonds = new Card(Value.NINE, Symbol.DIAMONDS);



  @Test
  public void testDifferentColorAndOneValueMoreTrue() {
    assertTrue(nineHearts.differentColorAndOneValueMore(eightClubs));
    assertTrue(nineHearts.differentColorAndOneValueMore(eightSpades));
    assertTrue(nineSpades.differentColorAndOneValueMore(eightDiamonds));
    assertTrue(nineSpades.differentColorAndOneValueMore(eightHearts));
  }

  @Test
  public void testDifferentColorAndOneValueMoreFalse() {
    assertFalse(nineSpades.differentColorAndOneValueMore(nineClubs));
    assertFalse(aceClubs.differentColorAndOneValueMore(nineDiamonds));
  }



  @Test(expected = IllegalArgumentException.class)
  public void testCardValueNull() {
    new Card(null, Symbol.CLUBS);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCardSymbolNull() {
    new Card(Value.NINE, null);
  }


  @Test
  public void testGetSymbol() {
    assertEquals(Symbol.CLUBS, aceClubs.getSymbol());
    assertEquals(Symbol.HEARTS, nineHearts.getSymbol());
  }

  @Test
  public void testGetValueIndex() {
    assertEquals(0, aceClubs.getValueIndex());
    assertEquals(8, nineHearts.getValueIndex());
  }

  @Test
  public void testToStringAceClubs() {
    assertEquals("A♣", aceClubs.toString());
  }

  @Test
  public void testToStringNineHearts() {
    assertEquals("9♥", nineHearts.toString());
  }

  @Test
  public void testEqualsTrue() {
    assertTrue(aceClubs.equals(aceClubsDuplicate));
  }

  @Test
  public void testEqualsFalse() {
    assertFalse(aceClubs.equals(nineHearts));
  }

  @Test
  public void testHashCodeTrue() {
    assertTrue(aceClubs.hashCode() == aceClubsDuplicate.hashCode());
  }

  @Test
  public void testHashCodeFalse() {
    assertFalse(aceClubs.hashCode() == nineHearts.hashCode());
  }


}
import static org.junit.Assert.assertEquals;
import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.FreecellModelCreator;
import cs3500.freecell.model.FreecellModelCreator.GameType;
import cs3500.freecell.model.hw02.Card;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import cs3500.freecell.model.hw04.MultiFreecellModel;
import org.junit.Test;

/**
 * tests for the {@code FreecellModelCreator} class.
 */
public class FreecellModelCreatorTest {

  FreecellModelCreator creator;




  // creator will create a SimpleFreecellModel
  @Test
  public void testCreatorSingleMove() {
    FreecellModel<Card> singleModel = creator.create(GameType.SINGLEMOVE);
    FreecellModel<Card> single = new SimpleFreecellModel();

    assertEquals(single.getClass(), singleModel.getClass());
  }


  // creator will create a MultiFreecellModel
  @Test
  public void testCreatorMultiMove() {
    FreecellModel<Card> multiModel = creator.create(GameType.MULTIMOVE);
    FreecellModel<Card> multi = new MultiFreecellModel();

    assertEquals(multi.getClass(), multiModel.getClass());
  }


  // cannot create a game with a null GameType
  @Test(expected = IllegalArgumentException.class)
  public void testCreatorNull() {
    creator.create(null);
  }





}

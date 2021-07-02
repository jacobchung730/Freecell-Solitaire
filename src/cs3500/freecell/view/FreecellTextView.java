package cs3500.freecell.view;

import cs3500.freecell.model.FreecellModelState;
import java.io.IOException;

/**
 * represents a view for the Freecell game. The toString method offers a view for the each of the
 * open, foundation, and cascade piles, and also any cards that are apart of that pile.
 */
public class FreecellTextView implements FreecellView {

  private final FreecellModelState<?> model;
  private Appendable ap;

  /**
   * constructs a {@code FreecellTextView} object using the given model. (model cannot be null).
   *
   * @param model the model for our Freecell game
   */
  public FreecellTextView(FreecellModelState<?> model) {
    if (model == null) {
      throw new IllegalArgumentException("model can't be null!");
    } else {
      this.model = model;
    }
  }

  /**
   * constructs a {@code FreecellTextView} object using the given model and appendable. If the
   * given appendable is null, then this view will display to System.out.
   * @param model the model for our Freecell game
   * @param ap the Appendable for the view
   * @throws IllegalArgumentException if model is null
   */
  public FreecellTextView(FreecellModelState<?> model, Appendable ap) throws
      IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("model can't be null!");
    } else {
      this.model = model;
    }

    if (ap == null) {
      this.ap = System.out;
    } else {
      this.ap = ap;
    }
  }


  @Override
  public void renderBoard() throws IOException {

    if (this.ap == null) {
      this.ap = System.out;
    }

    try {
      this.ap.append(this.toString());
    } catch (IOException e) {
      throw new IOException("transmission to the provided data destination fails");
    }

  }

  @Override
  public void renderMessage(String message) throws IOException {

    if (this.ap == null) {
      this.ap = System.out;
    }

    try {
      this.ap.append(message);
    } catch (IOException e) {
      throw new IOException("transmission to the provided data destination fails");
    }

  }

  @Override
  public String toString() {
    return this.model.toString();
  }


}

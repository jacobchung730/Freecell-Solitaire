import cs3500.freecell.view.FreecellView;
import java.io.IOException;
import java.util.Objects;

/**
 * This MockFreecellView class is used to show that the view is outputted correctly when used by the
 * controller. This class is used in testing.
 */
public class MockFreecellView implements FreecellView {

  final StringBuilder log;

  /**
   * Constructs a {@code MockFreecellView} object.
   *
   * @param log a log of the strings that will get added
   */
  public MockFreecellView(StringBuilder log) {
    this.log = Objects.requireNonNull(log);
  }


  @Override
  public void renderBoard() throws IOException {
    this.log.append("board rendered");
  }

  @Override
  public void renderMessage(String message) throws IOException {
    this.log.append("this is the message: " + message);
  }
}
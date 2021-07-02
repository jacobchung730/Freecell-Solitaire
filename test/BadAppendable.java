import java.io.IOException;


/**
 * This {@code BadAppendable} class is used for testing the renderBoard and renderMessage methods.
 * This class is a bad appendable that will where these methods will try to append to, but it will
 * not work and end up throwing an exception.
 */
public class BadAppendable implements Appendable {

  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException();
  }

  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException();
  }

  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException();
  }
}

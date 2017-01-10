package javaconcurrenyinpractice.chapter3;

/**
 * if one thread call set, other threads calling get
 * may or may not see that update.
 *
 * @see SynchronizedInteger
 * Created by ssselim on 9/30/16.
 */
//@NotThreadSafe
public class MutableInteger {
  private int value;

  public int  get() { return value; }
  public void set(int value) { this.value = value; }
}

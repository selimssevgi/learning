package javaconcurrenyinpractice.chapter3;

/**
 * Created by ssselim on 9/30/16.
 */
//@ThreadSafe
public class SynchronizedInteger {
  private int value; // @GuardedBy("this")

  public synchronized int  get() { return value; }
  public synchronized void set(int value) { this.value = value; }
}

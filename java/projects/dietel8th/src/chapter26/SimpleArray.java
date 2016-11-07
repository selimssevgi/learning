package chapter26;

import java.util.Arrays;
import java.util.Random;

/**
 * Class that manages an integer array to be shared by multiple threads.
 * Created by ssselim on 9/25/16.
 */
public class SimpleArray { // CAUTION: NOT THREAD-SAFE!

  private final int[] array;
  private int writeIndex = 0;
  private final static Random rand = new Random();

  public SimpleArray(int size) {
    array = new int[size];
  }

  /**
   * public void add(int value) {
   * method like this is not thread safe.
   * Three operations :
   *  - retrieving writeIndex
   *  - putting a value in the array
   *  - incrementing writeIndex
   *
   * There is no guarantee that while one thread doing
   * one of this three operations, another thread may change something too.
   * Therefore either stale value(invalid value), or overwriting to the same pos.
   *
   * The solution is to make these three operations an atomic one.
   * In this way we can ensure that another thread will not work on the same data
   * while one thread is already busy doing so.
   *
   * OUTPUT OF NOT THREAD-SAFE METHOD:
   pool-1-thread-1 wrote  1 to element 0.
   Next write index: 1
   pool-1-thread-1 wrote  2 to element 1.
   Next write index: 2
   pool-1-thread-2 wrote 11 to element 0.
   Next write index: 3
   pool-1-thread-2 wrote 12 to element 3.
   Next write index: 4
   pool-1-thread-1 wrote  3 to element 2.
   Next write index: 5
   pool-1-thread-2 wrote 13 to element 4.
   Next write index: 6

   Contents of SimpleArray:
   [11, 2, 3, 12, 13, 0]

   * public synchronized void add(int value)
   **/

  public synchronized void add(int value) {
    int positon = writeIndex;

    try {
      Thread.sleep(rand.nextInt(500));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    array[positon] = value;
    System.out.printf("%s wrote %2d to element %d.\n",
            Thread.currentThread().getName(), value, positon);

    ++writeIndex;
    System.out.printf("Next write index: %d\n", writeIndex);
  }

  @Override
  public String toString() {
    return "\nContents of SimpleArray:\n" + Arrays.toString(array);
  }
}

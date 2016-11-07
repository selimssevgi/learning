package chapter26.producerconsumer;

import java.util.Random;

/**
 * Created by ssselim on 9/25/16.
 */
public class Consumer implements Runnable {
  private final static Random rand = new Random();
  private final Buffer sharedLocation; // reference to shared object

  public Consumer(Buffer shared) {
    sharedLocation = shared;
  }

  @Override
  public void run() {

    int sum = 0;

    for (int count=1; count <=10; count++) {
      try {
        Thread.sleep(rand.nextInt(3000));
        sharedLocation.set(count);
        sum += count;
        System.out.printf("\t\t\t%2d\n", sum);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.printf("\n%s %d\n%s\n",
            "Consumer read values totaling", sum, "Terminating Consumer");
  }
}

package chapter26;


import java.util.Random;

/**
 * sleeps for a random time from 0 to 5 seconds
 * Created by ssselim on 9/24/16.
 */

public class PrintTask implements Runnable{
  private final int sleepTime;
  private final String taskName;
  private final static Random rand = new Random();

  public PrintTask(String name) {
    taskName = name;
    sleepTime = rand.nextInt(5000); // in milliseconds
  }


  @Override
  public void run() {
    try {
      System.out.printf("%s going to sleep for %d milliseconds.\n",
              taskName, sleepTime);
      Thread.sleep(sleepTime);
    } catch (InterruptedException exception) {
      System.out.printf("%s %s\n", taskName,
              "terminated prematurely due to interruption");
    }

    System.out.printf("%s done sleeping\n", taskName);
  }
}

package chapter26;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Executes two Runnables to add elements to a shared SimpleArray
 * Created by ssselim on 9/25/16.
 */
public class SharedArrayTest {

  public static void main(String[] args) {
    SimpleArray sharedSimpleArray = new SimpleArray(6);

    // create two tasks to write to the shared SimpleArray
    ArrayWriter writer1 = new ArrayWriter(1, sharedSimpleArray);
    ArrayWriter writer2 = new ArrayWriter(11, sharedSimpleArray);

    // execute the tasks with an executorService
    ExecutorService executor = Executors.newCachedThreadPool();
    executor.execute(writer1);
    executor.execute(writer2);

    // dont accept any new tasks
    executor.shutdown();

    try {
      // wait 1 minute for both writers to finish executing
      // returns true if they finish their tasks
      // return false cus of timeout
      boolean tasksEnded = executor.awaitTermination(1, TimeUnit.MINUTES);

      if (tasksEnded) {
        System.out.println(sharedSimpleArray);
      } else {
        System.out.println("Timed out while waiting for tasks to finish.");
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

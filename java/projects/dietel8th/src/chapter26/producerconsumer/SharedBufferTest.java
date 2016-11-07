package chapter26.producerconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ssselim on 9/25/16.
 */
public class SharedBufferTest {
  public static void main(String[] args) {
    ExecutorService application = Executors.newCachedThreadPool();

    Buffer sharedLocation = new UnsynchronizedBuffer();

    System.out.println(
            "Action\t\tValue\tSum of Produced\tSum of Consumed" );
    System.out.println(
            "------\t\t-----\t---------------\t---------------\n" );

    application.execute(new Producer(sharedLocation));
    application.execute(new Consumer(sharedLocation));

    application.shutdown();
  }
}

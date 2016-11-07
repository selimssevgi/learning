package trywithresources;

import java.io.IOException;

/**
 * Created by ssselim on 9/17/16.
 */
public class MyAutoCloseable implements AutoCloseable {
  public void saySomething() throws IOException {
    throw new IOException("Exception from saysomething");
//    System.out.println("something");
  }

  @Override
  public void close() throws IOException {
    throw new IOException("Exception from close");
//    System.out.println("close");
  }
}

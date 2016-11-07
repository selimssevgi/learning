package trywithresources;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * Created by ssselim on 9/17/16.
 */
public class TWResources {

  public static void main(String[] args) {
//    doTryCatchFinally();
//    doTryWithResources();
//    doTryWithResourcesMulti();
    doCloseThing();
  }

  public static void doTryCatchFinally() {
    char[] buff = new char[8];
    int length;
    Reader reader = null;

    try {
      reader = Helper.openReader("A-Z.txt");
      while ((length = reader.read(buff)) >= 0) {
        System.out.println("\nLength: " + length);
        for (int i = 0; i < length; i++) {
          System.out.print(buff[i]);
        }
      }
    } catch (IOException e) {
      System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
    } finally {
      try {
        if (reader != null) {
          reader.close();
        }
      } catch (IOException e2) {
        System.out.println(e2.getClass().getSimpleName() + " - " + e2.getMessage());
      }
    }
  }

  public static void doTryWithResources() {
    char[] buff = new char[8];
    int length;

    try (Reader reader = Helper.openReader("A-Z.txt")) {
      while ((length = reader.read(buff)) >= 0) {
        System.out.println("\nLength: " + length);
        for (int i = 0; i < length; i++) {
          System.out.print(buff[i]);
        }
      }
    } catch (IOException e) {
      System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
    }
  }

  public static void doTryWithResourcesMulti() {
    char[] buff = new char[8];
    int length;

    try (Reader reader = Helper.openReader("A-Z.txt");
         Writer writer = Helper.openWriter("A-Z_copy.txt")) {
      while ((length = reader.read(buff)) >= 0) {
        System.out.println("\nLength: " + length);
        writer.write(buff, 0, length);
      }
    } catch (IOException e) {
      System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
    }
  }

  /**
   * there is no call to close method
   * it is called implicitly
   *
   * Catch block handles the exception from close method
   */
  private static void doCloseThing() {
    try ( MyAutoCloseable ac = new MyAutoCloseable()) {
      ac.saySomething();
    } catch (IOException e) {
      System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());

      // multiple IOExceptions will be suppressed

      for (Throwable t:e.getSuppressed()) {
        System.out.println("Suppressed: " + t.getMessage());
      }
    }
  }
}

package com.selimssevgi.examples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ssselim on 9/17/16.
 */
public class BufferedStreams {
  void doBuffering() {
    try (BufferedReader br =
                 new BufferedReader(new FileReader("A-Z.txt"))) {
      int intVal;

      while ((intVal = br.read()) >= 0) {
        char charVal = (char) intVal;

        // do something with charVal
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

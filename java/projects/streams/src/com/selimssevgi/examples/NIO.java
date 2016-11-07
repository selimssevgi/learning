package com.selimssevgi.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by ssselim on 9/17/16.
 */
public class NIO {
  void readData() throws IOException {
    try (BufferedReader br =
                 Files.newBufferedReader(Paths.get("A-Z.txt"))) {
      String inValue;
      while ((inValue = br.readLine()) != null) {
        // do smth with inValue
      }
    }
  }

  void readThemAll() throws IOException {
    List<String> lines =
            Files.readAllLines(Paths.get("A-Z.txt"));
      for (String line:lines) {
        System.out.println(line);
      }
  }
}

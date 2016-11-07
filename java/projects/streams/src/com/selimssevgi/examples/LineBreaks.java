package com.selimssevgi.examples;

import java.io.*;

/**
 * Created by ssselim on 9/17/16.
 */
public class LineBreaks {
  void writeData(String[] data) throws IOException {
    try (BufferedWriter bw =
         new BufferedWriter(new FileWriter("data.txt"))) {
      for (String d:data) {
        bw.write(d);
        bw.newLine();
      }
    }
  }

  void readData() throws IOException {
    try (BufferedReader br =
         new BufferedReader(new FileReader("data.txt"))) {
      String inValue;
      while ((inValue = br.readLine()) != null) {
        System.out.println(inValue);
      }
    }
  }
}

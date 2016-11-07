package com.selimssevgi.examples;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by ssselim on 9/17/16.
 */
public class Chaining {

  void doChain(InputStream in) throws IOException {
    int length;
    char[] charBuff = new char[128];

    try (InputStreamReader rdr = new InputStreamReader(in)) {
      while ((length = rdr.read(charBuff)) >= 0) {
        // do smth with charBuff
      }
    }

    // try-with-resources closes inputstreamreader
    // also closes inputstream
  }
}

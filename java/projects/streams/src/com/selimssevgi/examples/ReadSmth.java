package com.selimssevgi.examples;

import java.io.*;

/**
 * Created by ssselim on 9/17/16.
 */
public class ReadSmth {

  // read one byte at a time
  public void readOneByte(InputStream input) throws IOException {
//    InputStream input = // create input stream
    int intVal;

    // read method returns -1 to indicate its end-of-stream
    while ((intVal = input.read()) >= 0) {
      byte byteVal = (byte) intVal;
      // do something with byteVal
    }
  }

  // reading one character at a time
  public void readOneCharacter(Reader reader) throws IOException {
//    Reader reader = // create reader
    int intVal;
    // read method returns -1 to indicate that it was end-of-stream
    while ((intVal = reader.read()) >= 0) {
      char charVal = (char) intVal;
      // do smth with charVal
    }
  }

  // reading array of bytes
  public void readArrayOfBytes(InputStream input) throws IOException {
//    InputStream input = // create input stream
    int length;
    byte[] byteBuff = new byte[10];

    // read method returns the number of bytes read
    // or -1 if is eof
    while ((length = input.read(byteBuff)) >= 0) {
      for (int i = 0; i < length; i++) {
        byte byteVal = byteBuff[i];
        // do something with byteVal
      }
    }
  }

  // reading array of characters
  public void readArrayOfCharacters(Reader reader) throws IOException {
//    Reader reader = // create reader
    int length;
    char[] charBuff = new char[10];

    // read method returns the number of characters read
    // or -1 if is eof
    while ((length = reader.read(charBuff)) >= 0) {
      for (int i = 0; i < length; i++) {
        char charVal = charBuff[i];
        // do smth with charVal
      }
    }
  }

  // Writing bytes
  public void writeBytes(OutputStream output) throws IOException {
//    OutputStream output = // create output stream

    byte byteVal = 100;
    output.write(byteVal); // implicit conversion from byte to int

    // write an array of bytes
    byte[] byteBuff = { 0, 63, 127};
    output.write(byteBuff);
  }


  // Writing characters
  public void writeCharacters(Writer writer) throws IOException {
//    Writer writer = // create writer

    char charVal = 'a';
    writer.write(charVal);

    char[] charBuff = {'a', 'b', 'c'};
    writer.write(charBuff);

    String stringVal = "Hello World";
    writer.write(stringVal);
  }






















}

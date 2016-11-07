# Streams
Stream is an ordered sequence of data
* Provides a common I/O model
* Abstracts details of underlying source or destination(memory, disk, network)
* Stream types are unidirectional(either write or read, not both) 

# 2 categories of streams
* Byte streams (interact as binary data)
* Text streams (interact as Unicode characters)

In general interaction is the same for both stream types.

Byte Steams                      Text Streams
InputStream                   Reader
int read()                    int read()
int read(byte[] buff)         int read(char[] buff)

OutputStream                  Writer
void write(int b)             void write(int ch)
void write(byte[] buff)       void write(char[] buff)
                              void write(String str)


# Common I/O Stream Derived Classes
InputStream
  - ByteArrayInputStream
  - PipedInputStream
  - FileInputStream

Reader
  - CharArrayReader
  - StringReader
  - PipedReader
  - InputStreamReader ( creating a reader over inputstream, layering )
    - FileReader

# Stream Realities
- Error Handling
- Cleanup (Java runtime may not reliably clean up)

## Cleanup 
Cannot rely on standard Java resource recovery

Streams are backed by physical storage
* Often exis outside Java runtime
* Runtime may not reliably clean up

Providing reliable cleanup
* Streams implement Closeable interface
  - 1 method : close

finally {
  reader.close(); // what if reader is null?  
}

finally {
  if (reader != null) {
    reader.close(); // close also throws exception?
                    // another try-catch. it is ugly!!
  }
}

### AutoCloseable interface
- 1 method: close
- base interface of Closeable interface
- Provides support for try-with-resources

#### Try-with-resource
- Automates cleanup of 1 or more resources
  - A "resource" is any type that implements AutoCloseable
- Syntax similar to traditional try statement
- Optionally includes catch block(s)
  - Handle try block
  - Handle close method call

# Chaining Streams
Streams are often chained together
- One stream instance leverages another
- Creates higher-level functionality
- simplifies reusability
- Chain using constructor

InputStreamReader leverages chaining
- Reader behavior over InputStream
- Character behavior over binary

# Accessing Files
Often use streams for file-based I/O
Class for each stream type in java.io package
- FileReader
- FileWriter
- FileInputStream
- FileOutputStream

The java.io classes are now DEPRECATED!!!

# Buffered Streams
Direct file access can be inefficient
Buffered streams can improve efficiency
- Buffers content in memory
- Performs reads/writes in large chunks
- Reduces underlying stream interaction

Buffering available for all 4 stream types
- BufferedReader
- BufferedWriter
- BufferInputStream
- BufferOutputStream

## Line Breaks
Line breaks vary across platforms
Buffered streams add line break support
- Uses correct value for current platform
- BufferedWriter
  - Generate line breaks: newLine()
- BufferedReader
  - Line based read: readLine()

# java.nio.file Package
preferred package for files
  - java.io FileXXX streams are deprecated!!
provides a number of benefits over java.io
  - Better exception reporting
  - Greater scalability
  - More file system feature support
  - Simplifies common tasks

# Path & Paths Type
## Path 
- used to locate a file system item
- can be a file or directory

## Paths
- static Path factory methods
- From string-based hierarchical path
- From URI

# Files Type
- Static methods for interacting with files
- Create, copy, delete etc
- Open file streams
  - newBufferedReader
  - newBufferedWriter
  - newInputStream
  - newOutputtream
- Read/write file contents
  - readAllLines
  - write

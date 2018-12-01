# Java IO History

### Java 1.0 to 1.3

* There was a lack of comprehensive IO support.

- There was no concept of buffers and channel abstractions for data, meaning
  lots of detailed low-level programming for developers.

- IO operations would get blocked, limiting scalability.

- There was limited character set encoding support, leading to a plethore of
  hand-coded solutions to support certain types of hardware.

- There was no regular expression support, making data manipulation difficult.


### Java 1.4 and NIO

- To overcome problems, Java began to implement nonblocking IO support, as well
  as other IO features.

- There have been two major advancements:

1. nonblocking IO as part of Java 1.4
2. An overhaul of nonblocking IO as part of Java 7

#### NIO in Java 1.4

- Buffer and channel abstraction layers for IO operations
- The ability to encode and decode character sets
- An interface that can map files to data held in memory
- The capability to write nonblocking IO
- A new regular expression library based on the popular Perl implementation

#### java.io.File

- It didnot deal with filnames consistently across all platforms
- It failed to have a unified model for file attributes(rwx)
- It was difficult to traverse directories
- It didnt allow to use OS-specific features(symbolic linking)
- It didnt support nonblocking operations for filesystems

### NIO2 in Java 7

- It had three major goals:

1. A new fs interface that supports bulk access to file attributes, escape to
   fs-specific APIs, and a service provider interface for pluggable fs implementations.

2. An API for asynchronous(as opposed to polled, nonblocking) IO operations on
   both sockets and files.

3. The completion of the socket-channel functionality.

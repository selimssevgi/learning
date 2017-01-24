# New IO (NIO.2)

- Java 7, more New I/O, or NIO.2
- a set of new classes and methods, that primarily live in the java.io package

Providing new powerful asynchronous capabilities. Changes:

- A new Path construct in order to reference files and file-like entities.
- A Files utility class that simplifies creating, copying, moving, deleting files
- Built-in directory tree navigation
- Future and callback asynchronous I/O to deal with large IO in the background

## Problems with Java 6

- There is no direct class or method support for navigating directory trees.
- There is no way of detecting and dealing with symbolic links.
- It is not possible to read the attributes(rwx) of a file in one easy operation.

## Java 7

- Files.walkFileTree()
- Files.isSymbolicLink()
- Files.readFileAttributes()
- AsynchronousFileChannel() : no dealing with thread pools or worker queues

## Key Classes in NIO.2

- Path
- Paths
- FileSystem
- FileSystems

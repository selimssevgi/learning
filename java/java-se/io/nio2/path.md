# Path

- A foundation of file-based IO
- Path is one of the key classes under NIO.2
- Represents a location in the filesystem(/usr/bin/vim)

### Relative Path

- Application is running from /javanio/src/test directory
- to travel to /javanio/src/main, relative path ../main
- what if app is running from /javanio/src/test/java/com/selimssevgi/
- Relavetive path(../main) wouldnt go to intented directory
- Insted absolute path could be used(javanio/src/main)

### Absolute Path

- If the directory application runs change from /javanio/ to D:\ws\javanio
- Absolute path wouldnt work as expected, then relative path had to be used


- A Path in NIO.2 is an abstract construct.
- It is not immediately bound to a corresponding physical location.
- JVM only binds a Path to the physical location at runtime.
- Path isnt limited to traditional filesystems. It can also cover fs such as a
  zip or jar filesystem.

#### Creating a Path

- Paths.get(String first, String... more);
- Paths.get("usr/bin/zip");
- Paths.get("../relativepathfile");

#### Retrieving information from a Path

- aPath.getFileName();
- aPath.getParent();
- aPath.getFileName();
- aPath.normalize();   // removes redundent information from path
- aPath.toRealPath();  // follows symbolic links, toAbsolutePath() + normalize()
- aPath.resolve(anotherPath);
- aPath.relativize(AnotherPath);
- aPath.startsWith(Path/String);
- aPath.endsWith(Path/String);

## Path based and File based IO

- toPath() method in java.util.File class.
- toFile() method in Path class.

```java
File file = new File("/afile");
Path listing = file.toPath();
listing.toAbsolutePath();
file = listing.toFile();
```

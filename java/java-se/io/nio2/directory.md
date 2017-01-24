# Directories and Directory Trees

- A directory is just a Path with special attributes.
- A compelling new feature in J7 is ability to navigate to directories.

### DirectoryStream

- java.nio.file.DirectoryStream<T> interface and its implementing classes:

* Iterate over entries in a directory, to find files in a directory
* Filter entries in a directory using glob expressions
* MIME-based content detection
* Perform recursive mv,cp,rm operations via walkFileTree method

```java
Path vimDir = Paths.get("/home/ssselim/repos/learning/vim");

try (DirectoryStream<Path> stream = Files.newDirectoryStream(vimDir, "*.md")) {
  stream.forEach(p -> System.out.println(p.getFileName()));
} catch (IOException e) {
  e.printStackTrace();
}
```

### walkFileTree

- Files.walkFileTree(Path startingDir, FileVisitor<? extends Path> visitor);
- FileVisitor is an interface with 5 methods to be implemented
- SimpleFileVisitor is a default implementation comes out of box
- Instead of implementing the interface, one should extend the SimpleFileVisitor

- walkFileTree doesnt automatically follow symbolic links.

```java
printAllMdFilesIn(Paths.get("/home/ssselim/repos/learning"));

private static void printAllMDFilesIn(Path startingDir) {
  try {
    Files.walkFileTree(startingDir, new FindMdVisitor());
  } catch (IOException e) {
    e.printStackTrace();
  }
}

private static class FindMdVisitor extends SimpleFileVisitor<Path> {
  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
    if (file.toString().endsWith(".md")) {
      System.out.println(file.getFileName());
    }

    return FileVisitResult.CONTINUE;
  }
}
```

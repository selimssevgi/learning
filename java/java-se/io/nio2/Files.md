# Files Utility Class


### Files

- The major utility class that contains all of the methods for cp,mv,rm and manipulation of files.

- Files.createFile(Paths.get("/tmp/testfile");
- Files.delete(Paths.get("/tmp/testfile");

```java
Path source = Paths.get("/tmp/existing.txt");
Path target = Paths.get("/tmp/target.txt");
Files.copy(source, target);
Files.copy(source, target, StandartCopyOption.REPLACE_EXISTING);
Files.move(source, target, SCO.REPLACE_EXISTING, SCO.COPY_ATTRIBUTES, SCO_ATOMIC_MOVE);
```

```java
Path target = Paths.get("/tmp/testfile");
Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-rw-rw-");
FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);
Files.createFile(target, attr);
```

### Directories

- Files.newDirectoryStream(Path dir, String patternMatch); // "\*.md"
- Files.walkFileTree(Path startingDir, FileVisitor<? extends Path> visitor);

### File Attributes


```java
Path source = Paths.get("/tmp/existing.txt");
System.out.println("Last Modified: " + Files.getLastModifiedTime(source));
System.out.println("Size: " + Files.size(source));
System.out.println("isSymbolic: " + Files.isSymbolicLink(source));
System.out.println("isDirectory: " + Files.isDirectory(source));
System.out.println("Attributes: " + Files.readAttributes(source, "*"));
```

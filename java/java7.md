# Java 7

## nio

### Paths

```java
// using Paths.get(...) to create a path
Path dictionary = Paths.get("/", "usr", "share", "dict", "web2");
Path home = Paths.get("/home/ssselim");

// using resolve to find nested paths
Path docs = home.resolve("Documents");

// can resolve siblings as well
Path downloads = docs.resolveSiblings("Downloads");

// project directory
Path project - Paths.get(".");
System.out.println(project.toAbsolutePath());
```
## Exceptions

### Try-catch with Resources

* before java 7

```java
BufferedReader reader = null;
try {
  reader = new BufferedReader(new FileReader(file));
  // do smth with reader
} catch (FileNotFoundException ex) {
  // handle FileNotFoundException
} catch (IOException ex) {
  // handle IOException
} finally { // ugly part
  if (reader != null) {
    try {
      reader.close();
    } catch (IOException ex) {
      // handle IOException }
  }
}
```

* with java 7, there is no need for ugly finally block, because reader will be
  closed automatically. Classes are used with try-catch with resources must
  implement AutoCloseable(I).

```java
try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
  // do smth with reader
} catch (FileNotFoundException ex) {
  // handle FileNotFoundException
} catch (IOException ex) {
  // handle IOException
} 
```

### Multi-catch Exceptions

* before java 7

```java
  try {
    Arithmetic.class.newInstance();
  } catch (InstantiationException e) {
    e.printStackTrace();  
  } catch (IllegalAccessException e) {
    e.printStackTrace();  
  }
```
* with java 7, the exception types must be siblings to be used in this way.

```java
  try {
    Arithmetic.class.newInstance();
  } catch (InstantiationException e | IllegalAccessException e) {
    e.printStackTrace();  
  }
```

## Diamond Operator

* Before Java 7, things inside <> can get ugly.
```java
List<Integer> list = new ArrayList<Integer>();
```

* with Java 7, the type on right side is inferred.

```java
List<Integer> list = new ArrayList<>();
```

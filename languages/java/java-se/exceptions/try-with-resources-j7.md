# Try with Resources

* before java 7
- Virtually no one gets manual resource closing %100 right. Even there were
  mistakes in how-tos from Sun.

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
  closed automatically.
- Classes are used with try-catch with resources must implement AutoCloseable(I).

```java
try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
  // do smth with reader
} catch (FileNotFoundException ex) {
  // handle FileNotFoundException
} catch (IOException ex) {
  // handle IOException
}
```
### Watchout

- Even in some cases resources may not closed.
- In the following code wouldnot close its FileInputStream properly if there was 
  an error creating the ObjectInputStream from the file (someFile.bin).

```java
try ( ObjectInputStream in = new ObjectInputStream(new
      FileInputStream("someFile.bin")) ) {
 //...
}
```

- The correct way to ensure that try-with-resources always works for you is to 
  slplit the resources into separate variables.

```java
try ( FileInputStream fin = new FileInputStream("someFile.bin");
     ObjectInputStream in = new ObjectInputStream(fin) ) {
...
}
```

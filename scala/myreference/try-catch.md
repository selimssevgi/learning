# Try-Catch

- Catch block is different than Java's
- All exceptions in Scala are RuntimeException
- No checked exception


```scala
try {
  new Employee("", "lastName")  
} catch {
  case iae:IllegalArgumentException => println(iae.getMessage)  
}
```

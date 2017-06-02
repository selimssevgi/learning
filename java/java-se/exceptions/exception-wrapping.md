# Exception Wrapping

- Catch an exception
- wrap it in a different exception
- throw that exception

```java
try {
   throwException();
} catch (Exception e) {
   throw new MyException("error text", e);
}
```

- Exception wrapping is a standard feature in Java since JDK 1.4
- Most of Java's built-in exceptions has constructors that can take a "cause"
- There is also a getCause() method that return the wrapped exception

## Why use it?

- to prevent the code further up the call stack from having to know about every
  possible exception in the system

- declared exceptioons aggregate towards the top of the call stack
- not wrapping but pass them on by declaring your methods to throw them, may end
  up with the top level methods that declare many different exceptions

- may not want top level components to know anything about the bottom level
  components, nor the exceptions they throw
- changing implementation may require changes in types of exceptions too

- read from db: SQLException
- read from ws: RemoteException
- read from fl: IOException
- each exception is bound to their own DAO implementation

- to avoid such problem, DAO interface methods can throw DaoException
- now there is no need to know what data access technology is being used in
  various implementations

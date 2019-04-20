# Binary Literals

- Before Java 7.

```java
int x= Integer.parseInt("1100110", 2);
```

* Problems with the above code:

- It is really verbose.
- There is a performance hit for that method call.
- You'd have to know about the two-argument form of parseInt().
- Have to remember details of how parseInt() work when it has two-arguments.
- It makes life hard for JIT compiler.
- It represents a compile-time constant as a rumtime expression, which means the
  constant can't be used as a value in a switch statement.
  - It will give a RuntimeException(but no compile-time exception) if there is a
    type in binary value.

- After Java 7

```java
int x = 0b1100110;
```

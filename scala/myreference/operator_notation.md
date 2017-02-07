# Operator Notation

- Scala has the ability to treat methods as operators.

```scala
// a method of no arguments can be treated as a postfix operator
x.foo()
x foo

// A method of one argument can be treated as an infix operator
x.foo(y)
x foo y

// Certain characters at the end of a method name reverse the order of a method call
x.::(y)
y :: x
```

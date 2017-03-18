# Defining Functions

- In Java, it is return type. In Scala, it is result type.
- Scala compiler requires you to specify result type if the function is recursive

- One important characteristic of method parameters in Scala is that they are
  vals, not vars.

```scala
def add (b: Byte): Unit = {
  b = 1 // this wont compile, because b is a val
}
```

- Method with a result type of Unit are executed for their side-effects.

```scala
// class method
def add(b: Byte): Unit = { sum += b}
```

- Another way to express such methods is to leave off the result type and the
  equals sign, and enclose the body of the method in curly braces. In this way,
  method looks like a procedure, which is executed only for its side effects.

```scala
// no equals sign always mean that the result type is Unit.
def add(b: Byte) {sum += b }
```

## Parameterless Method

```scala
def height: Int = contents.length
def width:  Int = if (height == 0) 0 else contents(0).length
```

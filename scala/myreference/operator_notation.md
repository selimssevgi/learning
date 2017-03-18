# Operator Notation

- Scala has the ability to treat methods as operators.
- Operators are methods

```scala
// a method of no arguments can be treated as a postfix operator
x.foo()
x foo

// A method of one argument can be treated as an infix operator
x.foo(y)
x foo y

val s = "Hello, World!"
s indexOf 'o'
s indexOf (5, 'o')

// Certain characters at the end of a method name reverse the order of a method call
x.::(y)
y :: x
```
## Prefix Operators/Notation

- You put the name before the object on which you are invoking the method
- Unlike infix operator, prefix is unary, takes only one operand.
- +, -, ~, ! can be used to create prefix operators.
- unary\_! can be called !p.

```scala
-7           // 7.unary_-
!found
~0xFF
```

## Infix Operators/Notation

- Infix operators allow a method to be invoked without the dot or parenthesis
- Infix operators will work if the method has one parameter
- Mathematical operations in Scala use infix operators

```scala
class Foo(x:Int) {
    def bar(y:Int)         = x + y
    def baz(a:Int, b: Int) = x + a + b
    def qux(y:Int)         = new Foo(y)
}

object InfixOperatorsRunner extends App {
    val foo = new Foo(10)
    println(foo.bar(20))
    println(foo bar 5))         // foo.bar(5)
    println(foo baz (5, 10))    // more than one arguments need parentheses

    println(3 + 5)
    println(3.+(5))

    println(foo bar 5 + 19)  // 33

    println(foo qux 15) // foo.qux(15)
}
```

## Postfix Operators/Notation

- You put method name after the object
- Unlike infix operator, postfix is unary, takes only one operand.
- Are methods that take no arguments
- Empty parentheses can be leave off if method doesnt have side-effects
- println(), toLowerCase

```scala
7 toLong
```

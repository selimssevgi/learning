# Infix Operators

- Infix operators allow a method to be invoked without the dot or parenthesis
- Infix operators will work if the method has one parameter
- Mathematical operations in Scala use infix operators 
```scala
class Foo(x:Int) {
    def bar(y:Int) = x + y
    def baz(a:Int, b: Int) = x + a + b
    def qux(y:Int) = new Foo(y)
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


# Scala Functions

- Functions are a trait(pure abstract) that is instantiated anonymously
- 'apply' method in the function means that you dont have to call it explicitly
- 


```scala
// trait Function1[T, R]

// EXPLICIT

object Functions extends App {
  val f0: Function0[Int] = new Function0[Int] {
    def apply() = 1
  }

  val f1: Function1[Int, Int] = new Function1[Int, Int] {
    def apply(x:Int):Int = x + 1
  }

  val f2: Function2[Int, String, String] = new Function2[Int, String, String] {
    def apply(x:Int, y:String) = x + y
  }

  println(f1.apply(3))
  println(f1(3)) // implicit apply call
  pritnln(f0())
  println(f2(3, "abc"))
}
```

```scala
// shortening method signature

object Functions extends App {
  val f0: (() => Int) = new Function0[Int] {
    def apply() = 1
  }

  val f1: (Int => Int) = new Function1[Int, Int] {
    def apply(x:Int)  = x + 1
  }

  val f2: (Int,String => String) = new Function2[Int, String, String] {
    def apply(x:Int, y:String) = x + y
  }
}
```

```scala
// shortening function trait implementation

object Functions extends App {
  val f0: (() => Int) = () => 1

  val f1: (Int => Int) = (x:Int) => x + 1

  val f2: (Int, String => String) = (x:Int, y:String) => x + y
}
```

```scala
// adding some type inference

object Functions extends App {
  val f0 = () => 1

  val f1 = (x:Int) => x + 1

  val f2 = (x:Int, y:String) => x + y
}
```

*NOTE:* While you can only return one item, that one item can be a tuple if you
need to return multiple items

```scala
val f3: String => (String, Int) = (x:String) => (x, x.length)
println(f3("Selim"))  // ("Selim", 5)

// type inference
val f4 = (x:String) => (x, x.length)
println(f4("Scala"))  // ("Scala", 5)
```

## Methods or Functions

- Functions are their own objects
- Methods are not functions
- Methods belong to a context

## Converting Methods to Functions

- Methods can be converted to functions using partially applied functions
- Use an underscore to turn method parameters into function parameters
- If an underscore is the last character in a method parameter, you can remove it
```scala
class Foo(x:Int) {
  def bar(y:Int) = x + y
}

class Baz(z:Int) {
  def qux(f:Int => Int) = f(z)
}
object DefToFunc extends App {
  val foo = new Foo(10)
  val f = foo.bar _       // partially applied function

  println(f.apply(20))
  println(f(20))

  val baz = new Baz(20)
  println(z.qux(f))     // 30

  println(z.qux(foo.bar _))  // 30
  println(z.quzfoo.bar)      // 30, can drop _ if it is only parameter

}
```

## Functions with Functions

- Functions can take other functions in as parameter, *highher order functions*
- HOF, the term is used to also describe when a method can take a function
- Functions can also return other functions, useful for applying functions in parts

```scala
object FuncWithFunc extends App {
  val f:(Int, Int => Int) => Int = (x:Int, y:Int => Int) =>  y(x)

  // type inference
  val f2 = (x:Int, y:Int => Int) =>  y(x)

  println(f(3, (m:Int) => m + 1)) // 4
  println(f(3, m => m + 1))       // 4
  println(f(3, _ + 1))            // 4

  val g = (x:Int) => (y:Int) => x + y
  println(g(4)(5))
  println(g.apply(4).apply(5))
}
```

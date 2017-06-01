# Scala Closures

- Closures are functions that close around the environment
- Closures are used to make up functions from the environment
- It is best to enclose around something that is stable(val)

- normally functions referred to passed parameters, they are called closure when
  they refer to other variables defined elsewhere

```scala
(x: Int) => x + more   // how much more?
```

- 'more' is a 'free' variable cus function literal does not itself give a meaning to it
- x variable is a 'bound' variable because it does have a meaning in the context of the function
- using aboe func literal without any 'more' defined in its scope, the compiler will complain

```scala
var more = 1
(x: Int) => x + more
```

- the func value(object) that's created at runtime from this func literal is called a closure
- 'closing' the function literal by 'capturing' the bindings of its free variables

- (x: Int) => x + 1 is called closed term
- any function with free variable is an open term

- In Scala, closure sees the change made to 'more' after the closure is created
- Scala's closures captures variables themselves, not the value to which variables refer
- outside changes are visible inside, inside changes are visible outside

```scala
val nums = List(1, 2, 3, 4)

var sum = 0

nums.foreach(sum += _)

println(sum) //10
```

- what if a closure accesses some variable that has several different copies as the program runs?
- what if a closure uses a local variable of some function, and func is invoked my times?
- the instanc is used the one that was active at the time the closure was created

```scala
def makeIncreaser(more: Int) = (x: Int) => x + more

val inc1 = makeIncreaser(1)
println(inc1(10)) // 11

val inc999 = makeIncreaser(999)
println(inc999(10)) // 1009
```

-  Scalac rearranges things in cases like these so that the captured parameter
   lieves out on the heap, instead of the stack. done automatically


## Lambda vs Closure

```scala
List(100, 200, 300) map { _ * 10/100 }          // a lambda

var percentage = 10
val applyPercentage = (amount: Int) =>          // a closure
  amount * percentage/100
percentage = 20
List(100, 200, 300) map { applyPercentage }
```

# High Order Methods

- takes a functions as an argument or returns a function as a result

* a function takes another function as an argument

```scala
class List[+A] ... {
  def map[B](f: A => B): List[B]
}
```

* a function returns another function as a result

```scala
def addOne(num: Int) = {
  def ++ = (x: Int) => x + 1
  ++(num)
}
```

```scala
val xs = List(1, 2, 3)

xs map { (x: Int) => x + 1 }           // anonymous function

xs map { _ + 1 }                       // function literal

def addOne(num: Int) = num + 1

xs map addOne
```


```scala
val arr  = Array(1,2,3,4,5)
val list = List(5,2,8,1,9)
val vec  = Vector.tabulate(10)(i => i * i)

arr.map(i => i * 2) // Array(2, 4, 6, 8, 10)
arr.map(_ * 2)      // Array(2, 4, 6, 8, 10)

arr.map(i => list.take(i)) // Array(List(5), List(5, 2), List(5, 2, 8), List(5, 2, 8, 1), List(5, 2, 8, 1, 9))
arr.map(i => list.take(i)) // Array(5, 5, 2, 5, 2, 8, 5, 2, 8, 1, 5, 2, 8, 1, 9)
arr.flatMap(i => list.take(i)) // Array(5, 5, 2, 5, 2, 8, 5, 2, 8, 1, 5, 2, 8, 1, 9)

vec.exist(i => i > 50) // true
vec.exist(_ > 50)      // true

arr.reduceLeft((x, y) => x + y)  // 15
arr.reduceLeft(_+_)              // 15

arr.foldLeft(0)(_+_)             // 15
arr.foldLeft("0")(_+_)           // 012345

arr.find(_ == 8) // Option[Int] = None
arr.find(_ == 5) // Option[Int] = Some(5)

```

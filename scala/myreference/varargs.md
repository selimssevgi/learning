# Varargs in Scala

- Repeated Parameters use an Array to hold possible extra parameters
- functions using varargs are called variadic functions

- vararg will be bound to a Seq[A]

- special ' \_: * ' type annotation allows use to pass a Seq to a variadic method


```scala

def apply[A](as: A*): List[A] =
  if (as.isEmpty) Nil
  else Cons(as.head, apply(as.tail: _*))

def repeatedParamMethod(x:Int, y:String, z:Any*) {
  println(z)   // WrappedArray
  "%d. %s and %s".format(x, y, z.mkString(","))
}

repeatedParamMethod(1, "smth", "another", "one more")
repeatedParamMethod(3, "smth")
```

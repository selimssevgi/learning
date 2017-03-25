# Reduce in Scala

- Applies a binary operator to all elements of collection, no seed value

```scala
//TraversableOnce.scala

def reduceLeft[B >: A](op: (B, A) => B): B = {
  if (isEmpty)
    throw new UnsupportedOperationException("empty.reduceLeft")

  var first = true
  var acc: B = 0.asInstanceOf[B]

  for (x <- self) {
    if (first) {
      acc = x
      first = false
    }
    else acc = op(acc, x)
  }
  acc
}

def reduceRight[B >: A](op: (A, B) => B): B = {
  if (isEmpty)
    throw new UnsupportedOperationException("empty.reduceRight")

  reserved.reduceLeft((x, y) => op(y, x))
}

def reduceLeftOption[B >: A](op: (B, A) => B): Option[B] =
  if (isEmpty) None else Some(reduceLeft(op))

def reduceRightOption[B >: A](op: (A, B) => B): Option[B] =
  if (isEmpty) None else Some(reduceRight(op))

def reduce[A1 >: A](op: (A1, A1) => A1): A1 = reduceLeft(op)

def reduceOption[A1 >: A](op: (A1, A1) => A1): Option[A1] = reduceLeftOption(op)
```

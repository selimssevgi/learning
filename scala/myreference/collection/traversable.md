# Traversable

- the root of the collection hierarchy
- base trait implements the behavior common to all collection types

- only abstract method in Traversable trait is 'foreach'


- use a java collection in scala

```scala
import java.util.{Collection => JCollection, ArrayList}

class JavaToTraversable[E](javaCollection: JCollection[E]) extends Traversable[E] {
  
  def foreach[U](f: E => U): Unit = {
    val iterator = javaCollection.iterator
    while(iterator.hasNext) {
      f(iterator.next)
    }
  }
}

```

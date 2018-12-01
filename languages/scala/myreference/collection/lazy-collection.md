# Lazy Collections: views and streams

- lazy collections vs strict collections
- strict collections evaluate their elements eagerly


## Views

- almost all collections expose a method called view
- view method return a non-strict view of the collection


```scala
def strictProcessing = List(-1, 0, 1, 2) map { 2 / _ }

strictProcessing(0) // reaching just head: AE: / by zero

def nonStrictProcessing = List(-1, 0, 1, 2).view map { 2 / _ }

nonStrictProcessing(0) // -2
```

## Streams

- implement lazy lists in Scala
- elements are evaluated only when they are needed
- Stream is like List, elements are stored in two parts: head and tail
- tail for Stream isn't computed until it's needed
- extends LinearSeq

```scala
List("zero", "two", "three").zip(Stream.from(0))
```

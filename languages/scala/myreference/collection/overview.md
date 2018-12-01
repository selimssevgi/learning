# Scala Collections

- scala.collection
- scala.collection.mutable
- scala.collection.immutable
- scala.collection.generic
* scala.collection.Gen\*

## scala.collection

- a class in this package can be either mutable or immutable
- scala.collection.Map is a super class for both mutable and immutable map
- generally root collections define the same interface as immutable collections
- mutable collection add additional methods on top of immutable collections
- use collections in either mutable or immutable packages to be clear


## scala.collection.mutable

- defines collection classes that provide side-effect operations
- these operations could change the state of the collection on place
- need to be explicitly be imported


## scala.collection.immutable

- guaranteed to be immutable for everyone
- sometimes called 'persisten data structures'
- can be certain that accessing the same collection will yield the same result
- here persistent has nothing to do with a database
- over time an immutable collection stays unchanged during the current program execution
- default ones in a scala program are immutable collection

## scala.collection.generic

- provides building blocks for implementing various collections
- mutable and immutable packages use it for implementation of some of their ops
- no need to deal it if there is no plan to create custom collections

## scala.collection.Gen\*

- implement operations that could be implemented both in a seq and par collections

- If you want your code to not care whether it receives a parallel or sequential
  collection, you should prefix it with Gen:
  - GenTraversable
  - GenIterable
  - GenSeq

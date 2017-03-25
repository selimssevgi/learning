# Internal versus External Iterators

- Iterators can either be internal or external.

- *An iternal iterator* is one where the collection or owner of the iterator is
  responsible for walking it through the collection.

- *An external iterator* is one where the client code can decide when and how to
  iterate.

- Scala supports both types of iterators with the *Traversable* and *Iterable* types.

- The Traversable trait provides the foreach method for iteration, where a
  client will pass a function for the collection to use when iterating.

- The Iterable trait provides an iterator method, where a client can obtain an
  iterator and use it to walk through the collection.

- Scala also defines Iterable as a subclass of Traversable.

- The downside is that any collections that only support internal iterators must
  extend Traversable and nothing else.

# Working Hard to Keep It Simple

- Moore's law now achieved by increasing # of cores not clock cycles

- *Parallel programming:* execute programs faster on parallel hardware

- *Concurrent programming:* manage concurrent execution threads explicitly

- Both parallel and concurrent programming are too hard!

## The Root of The Problem


```shell
var x = 0
async { x = x + 1 }
async { x = x * 1 }
// can give 0,1,2
```

- Non-determinism caused by concurrent threads accessing shared mutable state
- It helps to encapsulate state in actors or transactions, but the fundamental
  problem stays the same.

- non-determinism = parallel processing + mutable state

- To get deterministic processing, avoid the mutable state!
- Avoiding mutable state means programming *functionally*

## Scala is a Unifier

- Agile, with lightweight syntax(+y)
- Object-Oriented(-x)
- Functional(+x)
- Safe and performant, with strong static typing(-y)

## Different Tools for Different Purposes

* Parallelism:
  - Collections (Parallel Collections, Distributed Collections)
  - Parallel DSLs

* Concurrency:
  - Actors
  - Software transactional memory
  - Futures
  - (Under umbrella of Akka)

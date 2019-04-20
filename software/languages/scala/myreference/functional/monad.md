# Monads

- they provide a nice abstraction layer (like design patterns) to help structure code

- List and Option are monads

- List monad abstracts out the computation that might return 0, 1, or more possible results
- Option monad abstract out the computation that may not return anything (Some or None)

- The most two important benefits are:
  1. Monads let you compose functions that don't compose well, impure functions
  2. Monads let you order computation within FP so that you can model sequences of actions

- Scalaz library provides implementations of lots of monads

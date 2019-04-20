# Scala vs Java

Feature           | Java                  | Scala
------------------|-----------------------|------------------------------------
Type system       | Static, quite verbose | Static, heavily type-inferred
Polyglot layer    | Stable                | Stable, dynamic
Concurrency model | Lock-based            | Actor-based
FP                | Add-on                | Built-in support, natural part of lan
Surface area      | Small/medium          | Large/very large
Syntax style      | Smple, rqlr, r. vrbse | Flexible, concise, many special cases


- if statements return values. They are expressions, evaluates to a value. In
  java ?: returns value. But in Scala there is just usual if structure and each
  block evaluates to a value.

- In Scala there is no need for return statements.

## In Scala

- All types are objects.
- Type inference
- Nested functions
- Functions are objects.
- DSL support
- Traits
- Closures (Java8 has it)
- Concurrency support inspired by Erlang

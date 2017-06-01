# Scala Timeline

- 2003: 0.8, 0.9
- 2004: 1.0, 1.1, 1.2, 1.3
- 2005: 1.4
- 2006: 2.0, 2.1, 2.2, 2.3  (scalac written in scala)
- 2007: 2.4, 2.5, 2.6 (Lift framework)
- 2008: 2.7
- 2010: 2.8 (important version) [play 1.1: scala support via plugin, Akka]
- 2011: 2.9 (Typesafe)
- 2012:     (Play 2.0: native scala)
- 2013: 2.10
- 2014: 2.11
- 2016: 2.12

## What was new in 2.8?

- redesigned collection library (CanBuildFrom)
- Named and default parameters
  - copy method for case classes
- package objects
- nested annotations
- type specialization (boxed primitives)
- JavaConverters (asScala, asJava)
- revamped REPL
  - enhanced tab-completion
  - searchable history (C-R)

- Scaladoc 2
  - new look-and-feel
  - wiki-like syntax

- binary compalibility (for minor revisions)

## What is new in 2.9, 2.10, 2.11?

- DelayedInit and App trait(2.9)

```scala
object Hello extends Application {
   println("Hello World!")
}
```

- not thread safe, not optimized by the JVM

```scala
object Hello extends App {  // val args
   println("Hello World!")
}
```

- Range.foreach optimization (2.10)

```scala
// makes code like
0 to 100 foreach (x += _)
// as fast as a while loop
```

- Parallel collections (2.9)
  - concurrent, out-of-order semantics
  - the order in which funcs are applied to the elements is arbitrary
  - side effects are prone to race conditions
  - side effects and non-associative ops can lead to a non-determinism
  - non-communicative ops, however, are deterministic

```scala
// associative and commutative: addition
(1 + 2) + 3 == 1 + (2 + 3) == (2 + 1) + 3 // works

// associative, non- commutative: string concat
("a" + "b") + "c" == "a" + ("b" + "c") != ("b" + "a") + "c" // works

// non-associative: substraction
(1 - 2) - 3 != 1 - (2 - 3) != (2 - 1) - 3 // does work
```

- Generalized try-catch-finaLy (2.9) -- exceptions are not functional!

- Error handling with Try (2.10)
  - Try represents a computation that may either result in an exception, or
    return a successfully computed value

  - Try does for exceptions what Option does for null
  - instances of Try[T] are either Success[T], Failure[T]
  - only non-fatal exceptions are caught, system errors are thrown
  - map, flatMap, recover, recoverWith, filter, getOrElse, toOption

- Value classes, implicit classes, and extension methods (2.10)

- String interpolation(2.10): s"", f"", $$ to escape, f"${match.Pi}%f", sql"", json""

- Futures and Promises (2.10)

- Dynamic trait (2.10)

- Akka actors (2.10)
  - since Scala 2.10, Akka is the default actor library
  - the legacy Actors library is deprecated in 2.11

- Modularization (2.10)
  - some of the more advanced language features have to be explicitly enabled
  - import language.x
  - dynamic
  - existentials
  - higherKinds
  - implicitConversions
  - postfixOps
  - reflectiveCalls
  - experimental.macros
  - scalac -language:dynamic
  - import language.\_
  - scalac -languge:\_

- Reclection, macros, and quasiquotes (2.10, experimental)

- case classes with more than 22 parameters (2.11)

- new methods in collections

- sbt incremental compilation (2.11)

- Predef.??? (2.10)

- repl colors (2.11.4)

- java 8 supports (2.12)
  - j8 style closures and lambdas using handles
  - java streams and functional interfaces
  - @interface trait
  - seamless bidirectional interoperability
  - j8+ only

- improved lazy vals initialization, (can deadlock)
- Spores: safer closures for concurrent and distributed envs
- async & await (improvement on futures)
-  collections library cleanup and simplication
- scala.meta
- compiler-based code style checker
- deprecations:
  - procedure syntax: def a {}, // requires =
  - XML literals, (xml string interpolation)
  - scala.swing and scala.util.continuations

- scala.js
- scala compiler forks: Dotty, Typelevel, Policy

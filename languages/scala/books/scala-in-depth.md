# Scala in Depth

## Chapter 3 - Modicum of style -- coding conventions

- Coding conventions can be boiled down into three categories:
  1. code discovery
  2. uniformity
  3. error prevention

- The block debacle

```scala
class FooHolder
{
  def foo()

  {
    println("foo was called")
  }
}

// PROBLEM: code block will be executed as part of constructor
// SOLUTION: use = for all methods/functions
```

- Dangling operator

```scala
object Test {
  val x = 5
  def foo = "HAI"
    + x
    + "ZOMG"
    + "\n"
}

// PROBLEM: fail to compile. No clear indication for end of line
// SOLUTION: either use parentheses or dangling operator

object Test {
  val x = 5
  def foo = ("HAI"
    + x
    + "ZOMG"
    + "\n")
}

object Test {
  val x = 5
  def foo = "HAI" +
    x +
    "ZOMG" +
    "\n"
}
```

- Avoid $ in names: the $ character is used heavily when creating real JVM classes for advanced Scala features.

- In Scala, parameter names are part of the API and should follow all the conding conventions used for method and variable names.

- Argument names become confusing with inheritance in the mix.

- Scala doesnt require the override keyword when implementing abstract methods. This was done to help multiple inheritance.

- In Scala, the last trait "wins" when it comes to class linearization and method delegation.

#### Annotate for expected optimizations

1. Using tableswitch optimization

- Treating pattern matching as a switch statement.
- What this optimization does it try to compile a pattern match into a branch table rather than a decision tree.
- The annotation for forcing this optimization is "@switch"

```scala
// will be optimizated 
def unannotated(x: Int) = x match {
  case 1 => "One"
  case 2 => "Two!"
  case z => z + "?"
}

// because of extra type checking
def notOptimised(x: Int) = (x: @switch) match {
  case 1 => "One"
  case 2 => "Two!"
  case i: Int => "Other"
}
```
2. Using the tail recursion optimization

- The JVM doesnt support TCO(tail call optimization) natively, so tail recursive
  methods will need to rely on the Scala compiler performing the optimization.

- Tail recursion is easy to mix up in Scala, by annotating tail recursive methods,
  we can guarantee expected runtime performance.

- To optimize tail calls, Scalac requires the following:
  1. Method must be final or private: It can't be polymorphic
  2. Method must have its return type annotated.
  3. Method must call itself as the "end" of one of its branches.


```scala
case class Node(name: String, edges: List[Node] = Nil)

def search(start: Node, predicate: Node => Boolean): Option[Node] = {
  @tailrec
  def loop(nodeQueue: List[Node], visited: Set[Node]): Option[Node] = {
    nodeQueue match {
      case head :: tail if p(head) => Some(head)
      case head :: tail if !visited.contains(head) => loop(tail ++ head.edges, visited + head)
      case head :: tail => loop(tail, visited)
      case Nil => None
    }
  }
  loop(List(start), Set())
}
```

## Chapter 4 - Utilizing object orientation

- Scala offers mixin inheritance through the use of traits.

- In Scala, the code inside an object, trait, or class's body is the constructor.

#### Delayed construction

```scala
trait DelayedInit {
  def delayedInit(x: => Unit): Unit
}
```

- DelayedInit trait can be dangerous because it delays the construction of the
  object until a later time; methods that expect a fully initialized object may
  fail subtly at runtime.

- The DelayedInit trait is ideal for situations where object construction and
  initialization are delayed.

- DelayedInit trait solves the problem where construction and initialization of
  object required, due to external constraints, to happen at different times.

- Scala traits are composable in flexible ways.

- To help avoid confusion or leaking implementation details, it's best to
  provide explicit return types on public methods in your API.

## Chapter 5 - Using implicits to write expressive code

- The Scala compiler can infer one of two situations:
  1. A method call or constructor with a missing parameter
  2. Missing conversion from one type to another type. This also applies to
     method calls on an object that would require a conversion.

#### Introduction to implicits

- Scala provides an 'implicit' keyword that can be used in two ways:
  1. Method or variable definitions
  2. Method parameter lists


```shell
scala> def findAnInt(implicit x: Int) = x

scala> findAnInt
error: could not find implicit value for parameter x: Int

scala> implicit val test = 5

scala> findAnInt
res1: Int = 5

scala> findAnInt(2)
res2: Int = 2
```

To understand how the compiler determines if a variable is available for
implicit resolution, it's important to dig into how the compiler deals with
identifiers and scope.

#### Identifiers: A digression

- Scala defines the term 'entity' to mean types, values, methods, or classes.

- We refer to entities using identifiers, or names.

- In Scala this is called 'binding'.


```scala
class Foo {
  def x = 5
}
```

- The Foo class itself is an entity, we've given the name 'Foo', which is binding.

```shell
scala> val y = new Foo
```

```scala
package test

class Foo {
  def x = 5
}
```

- The Foo class is now a member of the package 'test'. If we try to access it
  with the name Foo, it will fail on the REPL.

```shell
scala> new Foo # ERROR
```

- Trying to call new Foo fails because the name Foo isn't bound in our scope.

- To access it, we must either use the name test.Foo or create a binding of the
  name Foo to test.Foo class in current scope. For the latter, 'import'

```scala
scala> import test.Foo

scala> new Foo
```

- The import statement takes test.Foo entity and binds it in the local scope
  with the name Foo.

- In Scala, things are a bit more flexible. The import statement can be used
  anywhere in the source file and it will only create a binding in the local
  scope.

- In Java, test.Foo can only be imported locally with the name Foo.
- The Scala import statement can give arbitrary names to imported entities using
  the {OriginalBinding=>NewBinding} syntax.

```scala
import test.{Foo=>Bar}
```
- This import statement binds the test.Foo class to the current scope using the name Bar.

- This renaming can be used to avoid conficts in classes imported from different
  packages. java.util.List and scala.List.

```scala
import java.util.{List=>JList}
import java.{io=>jio} // can be used to rename packages too
```

#### Scopes and bindings

- A scope is a lexical boundary in which bindings are available.

- In Scala, scopes can be nested.

- Scala defines the following precedence on bindings:

1. Definitions and declarations that are local, inherited, or made available by
   package clause in the same source file where the definition occurs have
   highest precedence.

2. Explicit imports have next highest precedence.

3. Wildcard imports (import foo.\_) have next highest precedence.

4. Definitions made available by a package clause not in the source file where
   the definition occurs have lowest precedence.

Why all the emphasis on name resolution within compiler? Implicit resolution is
intimately tied to name resolution, so these intricate rules become important
when using implicits.

#### Implicit resolution

- The SLS declares two rules for looking up entities marked as entities:
  1. The implicit entity binding is available at the lookup site with no prefix,
     that is, not as foo.x but only x.
  2. If there are no availabe entities from this rule, then all implicit members
     on objects belong to the implicit scope of an implicit parameter's type.

**[Read this chapter again]**

- When coding in Scala, it is a good idea to know the implicits are available in
  the scala.Predef object.

- Scala supports two types of implicits:
  1. implicit value (provides arguments to methods)
  2. implicit views (convert between types)

## Chapter 6 - The type system

### Types

- In Scala, types can be defined in two ways:
  1. Defining a class, trait or object
  2. Directly defining a type using the 'type' keyword

```scala
def foo(x: ClassName)

def bar(x: TraitName)

def baz(x: ObjectName.type)
```

- Types within Scala are referred to via two mechanisms:
  1. hash(#) operator
  2. dot(.) operator

- The hash operator is a looser restriction than the dot operator. It's known as
  a type projection, which is a means of referring to a nested type without
  requiring a path of object instances. This means that you can reference a
  nested type as if it weren't nested.

*Path-dependent vs type projection:* All path-dependent types are
type projections. A path-dependent type foo.Bar is rewritten as foo.type#Bar
by the compiler. The expression foo.type refers to the singleton type of Foo.
This singleton type can only be satisfied by the entity referenced by the name
foo . The path-dependent type ( foo.Bar ) requires the Bar instances to be gen-
erated from the same foo instance, while a type projection Foo#Bar would
match any Bar instances generated from any Foo instances, not necessarily the
entity referred to by the name Foo.)

- The type scala.String is shorthand for scala.type#String.

### The type keyword

```scala
type AbstractType
type ConcreteType = SomeFooType
type ConcreteType2= SomeFooType with SomeBarType  // compound type
```

### The structural types

- AVOID structural types: reflection, performance issuies

```scala
object Resources {
  type Resource = {
    def close(): Unit
  }

  def closeResource(r: Resource) = r.close()
}

// Resources.close(System.in)
```

### Type constraints

- Type constraints take the following two forms:
  1. Lower bounds(subtype restrictions)
  2. Upper bounds(supertype restrictions, also known as Conformance relations)


```scala
class A {
  type B >: List[Int]         // lower bound restriction
  def foo(a: B) = a
}

val x = new A { type B = Traversable[Int] }
```

- type B is stabilized at Traversable[Int]. Traversable is a parent class of List.

- Scala is a polymorphic object-oriented language.
- It is important to understand the diff between the compile-time tpye
  constraints and runtime type constraints.

- Upper bound restrictions are far more common in Scala.

```scala
class A {
  type B <: Traversable[Int]
  def count(b: B) = b.foldLeft(0)(_+_)
}
```

- In Scala, all types have a maximum upper bound of Any and lower bound of Nothing.

- All types in Scala descend from Any, while all types are extended by Nothing.

** AVOID useless <: Constraints: **

- In Scala, expressions are polymorphic.
- If a method accepts an argument of type Any , it can be passed an expression of type Int.
- When enforcing type constraints on method parameters it may not be necessary to use a type constraint but instead accept the subtype.

```scala
def sum[T <: List[Int]](t: T) = t.foldLeft(0)(_+_)
```

- The sum method has a redundant type constraint. Because the type T doesn’t
  occur in the resulting value, the method could be written as without any changes to the meaning.

```scala
def sum(t: List[Int]) = t.foldLeft(0)(_+_)
```

### Type parameters

- Type parameters are defined within ([]) before any normal parameters are defined.

```scala
def randomElement[A](x: Seq[A]): A
                //^ type parameter

// when calling the method:
def randomElement[Int](List(1, 2, 3))

def randomElement[Int](List("1", "2", "3")) // ERROR: type mismatch

def randomElement[String](List("1", "2", "3"))
```

### Higher-kinded types

- Higher-kinded types are those that use other types to construct a new type.

```scala
type Callback[T] = Function1[T, Unit]

val x: Callback[Int] = y => println(y + 2)

x(1)
```

- Higher-kinded types are also called 'type constructors' because they are used
  to construct types.

### Variance

- Variance takes three forms:
  1. invariance(default)
  2. covariance
  3. contravariance

*RULE17: Mutable class must be invariant*
It is impossible, and unsafe, to define them otherwise. If we want to make use
of covariance or contravariance, stick to immutable classes, or expose your
mutable classes in an immutable interface.

- Invariance refers to the unchanging nature of a higher-kinded type
  parameter. The default for any higher-kinded type parameter.

- Covariance refers to the ability to substitute a type parameter with its parent type.

- Creating a Covariant parameter is as easy as adding a + symbol before the type
  parameter.

```scala
class T[+A] {}              // type-parameter A is covariant

val x = new T[AnyRef]

val y: T[Any] = x           // Any is parent of AnyRef, Upcast

val z: T[String] = x        // ERROR: String is not parent of AnyRef, Downcast
```

- Contravariance is the opposite of covariance.

```scala
trait Function[-Arg, +Return]  // -: contravariant, +: covariant
```

*NOTE: variance is hard*
- In Scala, the choice of making something variant or not is important.
- The variance annotation can affect a lot of meachanics in Scala, inlcuding type inference.
- The safest bet when working with variance is to start with everything
  invariant and mark variance as needed.

### Existential types

- Existential types were introduced into Scala as a means to interoperate with
  Java's generic types.

- Java has existential types to: List and List<\Object\>

- Scala provides a convenience syntax for creating existential types that uses
  the underscore in the place of a type parameter. java.util.List[\_]

- 'forSome' keyword!!

## Chapter 7 - Using implicits and types together

### Conditional execution using the type system

- The downside to overloading is that it prevents you from using named/default
  parameters, and it can suffer at compile time due to type erasure.

**Type Erasure:**
Type erasure refers to the runtime encoding of parameterized class in Scala.
Type types used in parameters are erased at runtime into a lower type. This
means that functions that operate on parameterized types can erase to the same
bytecode on the JVM causing conflict. For example:

```scala
def sum(x: List[Int]): Unit
def sum(x: List[Double]): Unit

// will have the same runtime encoding
def sum(x: List[_]): Unit
```
This is one of the reasons to avoid overloading in Scala.

- The downside to overriding is that the type signatures must be the same and
  there must be an inheritance relationship between the classes owning a method.

- Overriding seems like a better option than overloading but imposes some strict
  limitations, especially the inheritance relationship. The inheritance
  restriction prevent external methods from using overriding behavior, limiting
  them to overloading and its drawbacks.

- The solution is to use the implicit system to associate a type class with the
  external types.

- The mechanism of encoding logic into the type system can be useful at times.
  One example is heterogeneous list.

## Chapter 8 - Using the right collection

- Scala's collections split into three dichotomies:
  1. Immutable and mutable collections
  2. Eager and delayed evaluation
  3. Sequential and parallel evaluation

### Use the right collection

- Choosing the right collection is important
- Each Scala collection has different runtime characteristics and is suited for
  different style of algorithms.
- For ex: Scala's List collection is a single linked-list and is suited for
  recursive algorithms.
- Scala's Vector class is implemented as a set of nested arrays that is
  efficient at splitting and joining.

- In Scala, there are two places to worry about collection types:
  1. Creating generic methods that work against multiple collections
  2. Choosing a collection for a datatype.

### The collection hierarchy

- The collection hierarchy starts with the trait TraversableOnce.
- TraversableOnce represents a collection that can be traversed at least once.
- TraversableOnce trait abstracts between Traversable and Iterator.

- *An Iterator* is a stream of incoming items where advancing to the next item
  consumes the current item.

- *A Traversable*  represents a collection that defines a mechanism to traverse
  the entire collection but can be traversed repeatedly.

- *The Iterable* trait is similar to Traversable but allows the repeated
  creation of an Iterator.

**NOTE:** The Gen\* Traits

In reality, the collection hierarchy has a duplicate generic variant. Every
trait in the hierarchy has a Gen\* trait that it inherits from, such as
GenTraversableOnce, GenIterator, and GenSeq. The generic variant of collections
offer no guarantees on serial or parallel execution, while the traits discussed
here enforce sequential execution. The principles behind each collection are the
same, but traversal ordering isn't guaranteed for parallel collections.


#### Traversable

- Traversable trait is defined in terms of the 'foreach' method.
- foreach method is an internal iterator
- Traversable collections dont provide any way to stop traversing inside foreach
- To make certain operations efficient, the library uses preinitialized
  exceptions to break out of the iteration early and prevent wasted cycles.

- Traversable is one of the most abstract and powerful traits in the collection hierarchy.
- The foreach method is the easiest method to implement for any collection type.
- Because of one extra stop before termination, it isnt suboptimal for many algorithms.
- It doesnt support random access efficiently and it requires one extra iteration.

- Iterable solves the extran iteration problem by using external iterator.

### Iterable

- Iterable trait is defined in terms of the 'iterator' method.
- This returns an external iterator that you can use to walk through the items
- It improves slightly on Traversable performance by allowing methods that need
  to parse a portion of a collection stop sooner than Traversable would allow.

- The Iterable trait's iterator method returns an external iterator of type Iterator.

- The major benefit of the Iterable interface is the ability to coiterate two
  collections efficiently.

```scala
val languages = Iterable("Scala", "Java")
val versions = Iterable(2.12, 9)
val it1 = languages.iterator
val it2 = versions.iterator
while (it1.hasNext && it2.hasNext) {
  println(it1.next + " : " +  it2.next.toString)
}

```

- When joining information between two collections, requiring the Iterable trait
  can greatly improve the efficiency of the operation.

- An issue with using external iterators on mutable collections is that the
  collection could change without the external iterator being aware of the change.

- We should use the Iterable trait when explicit external iteration is required
  for a collection, but random access is not required.

### Seq

- The Seq trait is defined in terms of the 'length' and 'apply' method.
- It represents collections that have a sequential ordering.
- 'apply' method can be used to index into the collection by its ordering.
- We should use the Seq trait only to differentiate Sets and Maps from sequential collections.
- If the order in which things are placed into a collections is important and
  duplicates should be allowed, then the Seq trait should be required.

- It's two subclasses: LinearSeq and IndexedSeq

#### LinearSeq

- The LinearSeq trait is used to denote that a collection can be split into a
  'head' and 'tail' component.

- LinearSeq is defined in terms of three "assumed to be efficient" abstract methods:
  1. isEmpty
  2. head
  3. tail

- This type of collection is ideal for tail recursive algorithms.
- The canonical example of a LinearSeq is Stack.

[BinaryTree example]

- When using a functional style with tail recursion, the LinearSeq trait is the
  right collection to use.

#### IndexedSeq

- It implies that random access of collection elements is efficient.

- IndexedSeq is ideal for most general-purpose algorithms that don't involve
  head-tail decomposition.

```shell
scala> IndexedSeq(1, 2, 3)
res0: IndexedSeq[Int] = Vector(1, 2, 3)

scala> res0.updated(1, 5)
res1: IndexedSeq[Int] = Vector(1, 5, 3)

scala> res1(2)
res3: Int = 3
```

### Set

- Set trait denotes a collection where each element is unique(according to ==)

- Ideal for testing for existence of an element and ensure there are no duplicates

- Scala supports three types of immutable and mutable sets:
  1. TreeSet (red-black tree)
  2. HashSet
  3. BitSet

### Map


### Immutable Collections

- Immutable collections are the default in Scala and have many benefits over
  mutable collections in general purpose programming.

- Three most commonly used immutable collections: Vector, List, Stream

#### Vector

- Its efficiency combined with thread-safety gained from immutability make it
  the most powerful sequence in the library.

*RULE 19: When in doubt, use Vector*
Vector is the most flexible, efficient collection in the Scala collections
library. Being immutable, it’s safe to share across threads. Its indexing performance is excellent,
as are append and prepend. Vector can also become a parallel collection efficiently. When unsure
of the runtime characteristics of an algorithm, it’s best to use a Vector .

#### List

- List collection extends from LinearSeq
- Best for prepends and head/tail decomposition.

- List is an eagerly evaluated collection.
- The head and tail components of a list are known when the list is constructed.
- Scala provides a different type of linked list where the values arent computed
  until needed. This collection is called Stream.

#### Stream

- Stream is a lazy persistent collection.

- Stream is a lazy persistent collection.
- A Stream could represent an infinite sequence without overflowing memory constraints.

```scala
List("a", "b", "c") zip (Stream from 1)
```

- Constructing a stream can be done similary to list, except the cons (::) cell
  is constructed with the #:: method
- An empty stream is referred to as Stream.empty.

```shell
scala> val s = 1 #:: {
     |   println("Hi")
     |   2
     | } #:: {
     |   println("BAI")
     |   3
     | } #:: Stream.empty
s: scala.collection.immutable.Stream[Int] = Stream(1, ?)

scala> s(0)
res0: Int = 1

scala> s(1)
HI
res1: Int = 2

scala> s(2)
BAI
res2: Int = 3

scala> s
res3: scala.collection.immutable.Stream[Int] = Stream(1, 2, 3)
```

*Lists in Haskell vs Scala*

One area of confusion when coming to Scala from Haskell is the List class. The
Haskell language has lazy evaluation by default while Scala has eager evaluation
by default. When looking something from a lazily evaluated list, like Haskell's
list, use Scala's Stream, not its List.


```scala
val fibs = {
  def f(a: Int, b: Int): Stream[Int] = a #:: f(b, a + b)
  f(0, 1)
}

fibs drop 3 take 5 toList

// it’s better to use a TraversableView to avoid performing work
// until necessary while allowing memory to be reclaimed
val fibs2 = new Traversable[Int] {
  def foreach[U](f: Int => U): Unit = {
    def next(a: Int, b: Int): Unit = {
      f(a)
      next(b, a+b)
    }
    next(0,1)
  }
} view
```

### Mutable Collections

#### ArrayBuffer

- The ArrayBuffer collection is a mutable Array that may or may not be the same
  size as that of the collection.

- ArrayBuffer allows elements to be added without requiring the entire array to be copied.

- Internally, an ArrayBuffer is an Array of elements, as well as the stored current size.

- When an element is added to an ArrayBuffer, the size is checked.
- If underlying array isnt full, then the element is directly added to the array
- If underlying array is full, then a large array is constructed

- ArrayBuffer collection is similar to java.util.ArrayList

- ArrayList tries to amortize the cost of removing and appending to the front and back
- ArrayBuffer is only optimized for adding and removing to the end of the sequence.

- ArrayBuffer is ideal for most situations where mutable sequences are required
- ArrayBuffer is mutable equivalent of the Vector class.

#### Mixin mutation event publishing

- Used to listen to mutation events on collections.
- API is designed for advanced use cases such as data binding.
- This is common in UI programming.

#### Mixin synchronization

- Although this is neat trick to aid in thread-safety, these traits are little
  used in practice.

- It is better to use mutable collections in single threaded scenarios and
  promote immutable collections for cross thread data sharing.

### Changing evaluation with views and parallel collections

- The base collection in the collection hierarchy defaults to strict and sequential evalution.

- Seq           // strict + sequential
- SeqView       // lazy + sequential
- ParSeq        // strict + parallel
- ParSeqView    // lazy + parallel

- The 'view' method can take any collection and efficiently create a new
  collection that will have lazy evaluation.

- The 'force' method is the inverse of the view method.

- 'par' method is used to create a collection that uses parallel execution.

- The inverse of par method is 'view' method.

#### Views
#### Parallel collections

- When using parallel collections, there are two things to worry about:
  1. The efficiency of converting from a sequential to a parallel collection
  2. The parallelizability of a task

- One method that doesnt have an parallelism is the 'foldLeft' method.
- The association requires that the operations be performed in sequence.

## Chapter 9 - Actors

- Actors are an abstraction on a synchronous processes.
- They communicate to the external world by sending and receiving messages.
- An actor will process received messages sequentially in the order they'are received.
- Actors handle only one message at a time.
- Actors can maintain state without explicit locks.
- Actors can be asynchronous or synchronous.
- The default behavior for actors is to share threads among each other when handling messages.

- Actors are great state machines.
- They accept a limited number of input msgs and update their internal state.
- All communication is done through messages and each actor stands alone.

### Know when to use actors

- Actors and IO should be interleaved carefully.
- Asynch IO and actors are a natural pairing, as the execution models for these are similar.
- Using an actor to perform blocking IO is asking for trouble.
- The architecture of a system designed to use actors will also change fundamentally.
- Rather than relying on the classic MVC and client-based parallelism, an actors
  system parallelize pieces of the architecture and performs all communication
  asynchronously.

#### Using actors to search

- reach vs receive

[could be read again!]

## Chapter 10 - Integrating Scala with Java

- Java compiler uses some trick to compile java code for JVM.
- Scala compiler also uses some tricks to compile scala code for JVM.

### Four big issues

1. Scala treats all types as objects, Java supports primitve types

2. Implicit conversions

3. Java serialization.

4. Annotations.

### The language mismatch between Scala and Java

- Primivite boxing
- Visibility differences
- Inexpressible language features (curried methods, implicit parameters, higher-kinded types)

- the special treatment of primitives, things created directly on the stack and
  passed by value, and objects, things created on the heap and passed by reference.

- In Java, primitives are isolated from objects.
- In Scala, boxing is done behind the scene on the behalf of the developer.

- Scalac tries to optimize the usage of scala.Int such that it remains in
  primitve form throughout the life of a program.

- Java's 'protected' modifier differs from Scala's.

*Scala/Java Integration Tip:*

Construct interfaces in Java that define all types that will be passed between
Java and Scala. Place these interfaces into a project that can be shared between
the Java portions of the code and the Scala portions of code. By limiting the
features used in the intergration points, there wont be any feature mismatch
issues.

- Impilicit conversion can be hidden problem in case of identity and equality.

- Serialization in Scala is more stable in 2.8.x and later.
- Just anonymous classes can cause issues.

### Summary

- Boxing: simplify this mismatch by preffering primitie types on the Java side.

- Collections: Java colls in Scala lacks many method, Scala colls in Java isnt friendly. Use implicits.

- For short-term is not problem, for long-term persistence more care needed.

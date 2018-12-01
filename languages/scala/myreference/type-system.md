# Type System

- The type system is tractable syntactic method for proving the absence of
  certain program behaviors by classifying phrases according to the kinds of
  values they compute

- Why is the type system is important?
  - Error detection -- compiler can detect common type and other errors
  - Abstractions    -- provides abstractions to build components
  - Documentation   -- signature of a function or a method
  - Efficiency      -- helps compiler generate optimized binary code

- Scala provides three abstraction techniques:
  - modular mixin composition
  - abstract type members
  - self type

## Abstract type members

- Abstract types are those whose identity is unknown at the time of declaration

- Unlike concrete types, the type of an abstract type member is specified during
  the concrete implementation of the enclosing class

```scala
trait Calculator { type S }

class SomeCalculator extends Calculator { type S = String }
```

- DbConnection knows how to retrieve data from a database
- problem with the following impl is that it's hard-wired to a DAO, and a
  calculator that uses a different kind of data source won't be able to use the
  calculator

```scala
// Template Method Pattern
trait Calculator {
  def initialize: DbConnection
  def close(s: DbConnection): Unit
  def calculate(productId: String): Double = {
    val s = initialize
    val price = calculate(s, productId)
    close(s)
    price
  }

  def calculate(s: DbConnection, productId: String): Double
}
```

- remove the hard-link to DbConnection
- create an abstract type member that hides the type of component

```scala
package abstractMember {
  trait Calculator {
    type S
    def initialize: S
    def close(s: S): Unit
    def calculate(prodecutId: String): Double = {
      val s = initialize
      val price = calculate(s, productId)
      close(s)
      price
    }
    def calculate(s: S, productId: String): Double
  }  
}
```

- now any concrete calculator implementation, along with implementing all the
  abstract methods, needs to provide type information for S

```scala
class CostPlusCalculator extends Calculator {
  type S = MongoClient  
  def initialize = new MongoClient
  def close(dao: MongoClient) = dao.close
  def calculate(source: MongoClient, productId: String) = {...}
}
```

## Self type members

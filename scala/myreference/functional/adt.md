# Algebraic Data Types

- ADT is a classification

- A data type in general is a set of values

- think of Int as a type that identifies all the integer values

- can define an algebraic type by enumerating all the values of the set

- each value could have its own constructor

- also allows to decompose the type using pattern matching

- ADT is a kind of type that represents a set of values

- ADT could represent a finite or infinite set of values

- A closed ADT is a finite set of values

```scala
sealed trait Account

case class CheckingAccount(accountId: String) extends Account
case class SavingAccount(accountId: String, limit: Double) extends Account
case class PremiumAccount(corporateId: String, accountHolder: String) extends Account

def printAccountDetails(account: Account): Unit = account match {
  case CheckingAccount(accountId) =>
    println("Account id " + accountId)
  case SavingAccount(accountId, limit) =>
    println("Account id " + accountId + ", " + limit)
}
```

- case classes are a good implementation choice for ADTs is pattern matching

- total function is one that knows how to handle all values of an algebraic data
  type and always produces a result

- A couple of well-known examples of ADT in Scala: scala.Either, scala.Option

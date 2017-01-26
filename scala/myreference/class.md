# Scala Classes

- Classes are public by default
- A class may have auxiliary constructors, denoted using this()
- Auxiliary constructos act like provides of default parameters to the primary constructor


```scala
// private constructor
// class CashFlow private (_amount: Double, _currency: String) {

class CashFlow(_amount: Double, _currency: String) {
  def this(amount: Double) = this(amount, "GBP")
  def this(currency: String) = this(0, currency)

  def amount = _amount;
  def currency = _currency
}


// val wages = new CashFlow(200.0)
// println(wages.amount)
// println(wages.currency)
```


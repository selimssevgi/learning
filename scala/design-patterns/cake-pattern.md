# Cake Pattern

- is a technique to build multiple layers of indirection to help with managing
  dependencies

- is built on the three abstraction techniques:
  1. Abstract members
  2. Self type annotation
  3. Mixin composition


```scala
trait Calculators {
  
  val costPlusCalculator: CostPlusCalculator
  val externalPriceSourceCalculator: ExternalPriceSourceCalculator

  trait Calculator {
    def calculate(productId: String): Double
  }

  class CostPlusCalculator extends Calculator {
    def calculate(productId: String) = { //... }
  }

  class ExternalPriceSourceCalculator extends Calculator {
    def calculate(productId: String) = { //... }
  }
}
```


```scala
trait CalculatePriceServiceComponent { this: Calculators =>
  
  class CalculatePriceService {
    val calculators = Map(
      "costPlus" -> calculate(costPlusCalculator) _
      "externalPriceSource" -> calculate(externalPriceSourceCalculator) _
    )

    def calculate(priceType: String, productId: String): Double = {
      calculators(priceType)(productId)
    }
    private[this] def calculate(c: Calculator)(productId: String): Double =
      c.calculate(productId)
  }
}
```


```scala
object PricingSystem extends CalculatePriceServiceComponent
                     with Calculators {

  val costPlusCalculator = new CostPlusCalculator
  val externalPriceSourceCalculator = new ExternalPriceSourceCalculator
}
```


```scala
trait TestPricingSystem extends CalculatePriceServiceComponent with Calculators
{
  class StubCostPlusCalculator extends CostPlusCalculator {
    override def calculate(productId: String) = 0.0
  }

  class StubExternalPriceSourceCalculator extends ExternalPriceSourceCalculator {
    override def calculate(productId: String) = 0.0
  }

  val costPlusCalculator = new StubCostPlusCalculator
  val externalPriceSourceCalculator = new StubExternalPriceSourceCalculator
}
```

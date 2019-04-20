# Value Objects

- It may surprise you to learn that we should strive to model using VO instead
  of Entities whereever possible.

When you care only about the attributes of an element of the model, classify it
as a VALUE OBJECT. Make it express the meaning of the attributes it conveys and
give it related functionality. Treat the VALUE OBJECT as immutable. Don't give
it any identity and avoid the design complexities necessary to maintain ENTITIES.

## Value Characteristics

- It measures, quantifies, or describes a thing in the domain

- It can be maintained as immutable.

- It models a conceptual whole by composing related attributes as a integral unit

- It is completely replaceable when the measurement or description changes.

- It can be compared with others using Value equality.

- It supplies its collaborators with Side-Effect-Free Behavior

## Measures, Quantifies, or Describes

- The age is not really a thing but measures or quantifies the number

- The name is not a thing but describes what the person (thing) is called.

## Immutable

## Whole Value

```java
// incorrectly modeled
public class ThingOfWorth {
  private String name;         // attribute
  private BigDecimal amount;   // attribute
  private String currency;     // attribute
}
```

```java
public final class MonetaryValue {
   private BigDecimal amount;
   private String currency; // can have Currency
}

public class ThingOfWorth {
  private ThingName name;       // property
  private MonetaryValue worth;  // property
}
```

## Replaceability

- An immutable Value should be held as a reference by an Entity as long as its
  constant state describes the currently correct Whole Value. If that is no
  longer true, the entire Value is completely replaced with a new Value that
  does represent the currently correct whole.

- Replacing like Integer value of 3 with 4.

## Side-Effect-Free Behavior

- The methods of an immutable VO must all be SEFree functions.

* To make the Value robust, you'd pass only Values as parameters to Value
  methods. This way you react the greatest level of SEFree behavior(sending
  Entity as parameter, no guarantee if is modified)

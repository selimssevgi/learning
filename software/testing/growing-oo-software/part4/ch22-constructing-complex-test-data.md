# ch22 - constructing complex test data

#### object mother pattern

- the object mother is class that contains a number of factory methods that
  create objects for use in tests

```java
Order order = ExampleOrders.newDeerstalkerAndCapeOrder();
```

- more readable: move uninteresting details behind a method
- helps with maintaince since its features can be reused between tests

- the object matter pattern does not cope well with variation in the test data
- every minor difference requires a new factory method

#### test data builders

- use the builder pattern to build instances in tests, most often for values

- builder with static factory methods (withOrder, withCustomer)
- methods to override sensible default values, and build final object


```java
new OrderBuilder()
  .fromCustomer(
    new CustomerBuilder()
      .withAddress(newe AddressBuilder().withNoPostCode().build())
      .build()
  .build();)
```

- test data builders keep tests expressive and resilient to change
- they wrap up most of the syntax noise when creating new objects
- they make the default case simple, and special cases not much more complicated
- they protect the test against changes in the structure of its objects

#### creating similar objects

```java
OrderBuilder hatAndCape = new OrderBuilder()
  .withLine("Deerstalker Hat", 1)
  .withLine("Tweed Cape", 1);

Order orderWithSmallDiscount = hatAndCape.withDiscount(0.10).build();
Order orderWithLargeDiscount = hatAndCape.withDiscount(0.25).build();
```

- if we manipulate different properties, that may no be so obvious

```java
Order orderWithDiscount = hatAndCape.withDiscount(0.10).build();
Order orderWithGiftVoucher = hatAndCape.withGiftVoucher("abc").build(); // this one can have the above change as well

// use copy constructor when using for different property
Order orderWithDiscount = new OrderBuilder(hatAndCape)
  .withDiscount(0.10)
  .build();

Order orderWithGiftVoucher = new OrderBuilder(hatAndCape)
  .withGiftVoucher("abc")
  .build();

// or a factory method that returns a copy
Order orderWithDiscount = hatAndCape.but().withDiscount(0.10).build();
Order orderWithGiftVoucher = hatAndCape.but().withGiftVoucher("abc").build();
```

- for complex setups, the safest option is to make the "with" methods functional
  and have each return a new copy of the builder instead of itself

#### combining builders
""
```java
Order orderWithNoPostcode = new OrderBuilder()
  .fromCustomer(
    new CustomerBuilder()
      .withAddress(new AddressBuilder().withNoPostcode().build())
      .build())
  .build();

// We can remove much of the noise by passing around builders:

Order order = new OrderBuilder()
  .fromCustomer(
    new CustomerBuilder()
    .withAddress(new AddressBuilder().withNoPostcode())))
  .build();
```

#### emphasizing the domain model with factory method

- wrap the construction of builders in factory methods

```java
Order order =
  anOrder().fromCustomer(
              aCustomer().withAddress(anAddress().withNoPostcode())).build();
```

- we can remove the name of the constructed type if is one of the domain models

```java
Order order =
  anOrder().from(aCustomer().with(anAddress().withNoPostcode())).build();
```

- thanks to overloading that is not a issue

#### removing duplication at the point of use

- extract common logic to parameterized methods, passing builder itself can
  reduce the duplication even more

#### then, raise the game

- with the supporting code behind the other objects, we can use better naming
  that the test will be declarative description of the feature, like we would
  talk to someone about it

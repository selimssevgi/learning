# ch24 - test flexibility

- make sure that each test fails only when its relevant code is broken
- otherwise, we end up with brittle tests that slow down development and inhibit refactoring

- there is a virtuous relationship with test readability and resilience

- "specify precisely what should happen and no more"

#### test for information, not representation

- return maybe(optional) instead of null
- when refactoring the change will be in many placed

- it would be easier if test has its own representation for null

```shell
public static final Customer NO_CUSTOMER_FOUND = null;
// change it to
public static final Optional<Customer> NO_CUSTOMER_FOUND = Optional.empty();
// test will not be changed
```

- tests should be written in terms of information passed between objects, not of
  how that information is represented

#### precise assertions/expectations/parameter matching

- avoid asserting values that aren't driven by the test inputs
- avoid reasserting behavior that is covered in other tests

- instead of asserting equality of whole object, we may just check the related property equality

- full string matching, or partially(contains)

- allow queries; expect commands while preparing mock context

- only enforce invocation order when it matters

#### "guinea pig" objects

- most adapter implementations we see are generic
  - they often use reflection to move values between domains

- we can apply such mappings to any type of object, which means we can change
  our domain model without touching the mapping code

- the easiest approach when writing tests for the adapter code is to use types
  from the application domain model, but this makes the test brittle because it
  binds together the application and adapter domains(no separation of concerns)

- writing test for XmlMarshaller for AuctionClosedEvent

- later on we decide that our system won't send an AuctionClosedEvent after all,
  so we should be able to delete the class(though it is still used by test)

- Also AuctionClosedEvent will change based on requirements, those requirement
  changes will break the tests unnecesserially

- we should write tests for XmlMarshaller using types that are unrelated to the real system

```java
public class XmlMarshallerTest {
  public static class MarshalledObject {
    private String privateField = "private";
    public final String publicFinalField = "public final";
    public int primitiveField;
    // constructors, accessors for private field, etc.
  }

  public static class WithTransient extends MarshalledObject {
    public transient String transientField = "transient";
  }

  // other tests
}
```

- WithTransient acts as a "guniea pig", allowing us to exhaustively exercise the
  behavior of XmlMarshallerTest before we let it loose on production domain model

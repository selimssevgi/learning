# ch23 - test diagnostics

#### design to fail

- the point of a test is not to pass but to fail

- we want to avoid the situation that when we can't diagnose a test failure

- the last thing we should have to do is crack open the debugger and step
  through the tested code to find the point of disagreement (how long?)

* explanatory assertion messages

```java
// include meaningul messages to assertions
assertEquals("account id", "573242", customer.getAccountId());
assertEquals("outstanding balance", 16301, customer.getOustandingBalance());
```

* highlight detail with matchers

* self-describing value (on fail, domain-model, toString etc)

* obviously canned value (negative value, max value, too old date, less digits than production)

* tracer object

- simple three-step TDD cycle: fail, pass, refactor
- the four-step TDD cycle: fail, report, pass, refactor

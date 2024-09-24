# ch05 - bend or break

## decoupling and the law of demeter

- "shy" code is beneficial
  - dont reveal yourself to others
  - dont interact with too many people

- eliminating interactions between cells protects everyone

### minimize coupling

- fixing house -> general contractor -> subcontractor

- when we ask an object for a particular service, we'd like the service to be
  performed on our behalf. we dont want the object to give us a 3th party object
  that we have to deal with to get the required service

```shell
public void plotDate(Date aDate, Selection aSelection) {
  TimeZone tz = ...aSelection.getRecorder().getLocation().getTimeZone();
}
```

- the method depends on other classes, creating coupling
- it would cause issiees the interface of those dependencies would change
- ask and accept what you need, not the wrappers around that

```shell
public void plotDate(Date aDate, TimeZone aTz) { ...
}
```

* symptoms of complicated dependency relations
  - where the command to link a unit test is longer than the test program itself
  - "simple" changes to one module that propagate through unrelated modules in the system
  - developers who are afraid to change code becuase they are not sure what might be affected

### the law of demeter for functions

- attempts to minimize the coupling between modules in any given program

- using the law of demeter will make your code more adaptable and robust

- the cost: as a "general contractor", your module must delegate and manage any
  and all subcontractors directly (wrapper methods)

### metaprogramming

- changing code each time comes with a risk

- get such details out of the code

- specify what is to be done, not how

- you can customize the application without recompiling it

- spring configuration, ejb configurations

- without metada, your code is not as adaptable or flexible as it could be

- species that dont adapt die!

### temporal coupling

- is about time

- two aspects of time:
  1. concurrency
  2. ordering

- we need to allow for concurrency and to think about decoupling any time or order dependencies

- we'd like to find out what can happen at the same time, and what must happen in a strict order

### it's just a view

- using events minimizes coupling between objects

- pub/sub
  - receive only objects you asked for

### blackboards

- consider how detectives might use a "blackboard" to coordinate and solve a murder investigation

- kafka?

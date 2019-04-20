# ch20 - listening to the tests

- TDD is about testing code, verifying its externally visible qualities such as functionality and performance

- TDD is also about feedback on the code's internal qualities:
  - the coupling and cohesion of its classes
  - dependencies that are expicit or hidden
  - effective information hiding
  - the qualities that keep code maintainable

- when we find a feature that's difficult to test, we don't just ask ourselves
  'how' to test it, but also 'why' is it difficult to test

- there are two categories of test smell to consider:

1. the test itself is not well written, it may be unclear or brittle (Meszaros - test smells)
2. a test is highlighting that the target code is the problem

- things that sign that the problem is the target code

### i need to mock an object i can't replace (without magic)

* Singletons are dependencies

```java
Date now = new Date(); // call System.currentTimeMillis()
```

```java
public boolean acceptRequest(Request request) {
  final Date now = new Date();
  if (dateOfFirstRequest == null) {
    dateOfFirstRequest = now;
  } else if (firstDateIsDifferentFrom(now)) {
    return false;
  }
  // process the request
  return true;
}
```

- to test this timeout, we must either make the test wait overnight or do
  something clever (perhaps with aspect or byte-code manipultation)

- to make the test easier, we need to control how Date objects are created

- new Receiver(new Clock()): now we expicilty say object is dependent
  on time, and we can mock the behavior

```java
public boolean acceptRequest(Request request) {
  final Date now = clock.now();
  if (dateOfFirstRequest == null) {
    dateOfFirstRequest = now;
  } else if (firstDateIsDifferentFrom(now)) {
    return false;
  }
  // process the request
  return true;
}
```

* from procedures to objects

- Receiver should be responsible for 'firstDateIsDifferentFrom' logic?

- can we move that into Clock?

```java
public boolean acceptRequest(Request request) {
  if (dateOfFirstRequest == null) {
    dateOfFirstRequest = clock.now();
  } else if (clock.dayHasChangedFrom(dateOfFirstRequest)) {
    return false;
  }
  // process the request
  return true;
}
```

- this version is more focused: it does not need to know how to distinguish one date from another

- can we even push further and delegate all the date functionality to another object?

```java
public boolean acceptRequest(Request request) {
  if (sameDayChecker.hasExpired()) {
    return false;
  }
  // process the request
  return true;
}
```

* implicit dependencies are still dependencies

- one goal of OO as a technique for structuring code is to make the boundaries of an object clearly visible

- an object should only deal with values and instances that are either local,
  created and managed within its scope, or passed in explicitly (Context Independence)

- we can use tools for manipulating class loaders or bytecode to allow unit
  tests to break dependencies without changing the target code, this is NOT
  recommended as that means to ignore the valueable feedback from the tests

* logging is a feature


```java
log.error("lost touch with Reality after {} seconds", timeut);
log.trace("distance traveled in the wilderness: {}", distance);
```

- these are two separate features that happen to share an implementation

- support logging (error and info): is part of the UI of the app. these messages
  are intended to be tracked by support staff, administrators, operators

- diagnostic logging (debug and trace): is infrastructure for programmers. these
  messages should not be turned on in production, they just help programmers
  undertand what is going on inside the system

- support logging should be test-driven
- the tests will also protect us from breaking any tools and scripts that analyze logs

- do we have to pass log object in every other object? Logging too much?

* mocking concrete classes

- the technique is to inherit from the class you want mock and override the
  methods that will be called within the test, either manually or with any of
  the mocking framewors

- this technique should be used only when you really have no other options

```java
public class MusicCentreTest {
  @Test public void startsCdPlayerAtTimeRequested() {
      final MutableTime scheduledTime = new MutableTime();

      CdPlayer player = new CdPlayer() {
        @Override public void scheduleToStartAt(Time startTime) {
          scheduledTime.set(startTime);
        }
      }

      MusicCentre centre = new MusicCentre(player);
      centre.startMediaAt(LATER);
      assertEquals(LATER, scheduledTime.get());
    }
}
```

- the problem with this approach is that it leaves the relationship between the
  CdPlayer and MusicCentre implicit

- our intention in TDD is to use mock objects to bring out relationships between objects

- if we subclass, there's nothing in the domain code to make such a relationship visible

- MusicCentre uses just two methods on the CdPlayer
- we would be overspecifying the MusicCentre by requiring to talk to a CdPlayer
- what it actually needs is ScheduledDevice
- Interface Segregation Principle: clients should not be forced to depend upon interfaces that they do not use
- but that's exactly what we do when we mock a concrete class

* "Break glass in case of emergency"

* Don't mock values

* Bloated constructor

- in time we added one more and one more, we got there somehow

- the process helped us sort out the design of the class and its neighbors

- we should see if there is any implicit structure that we can tease out

- one possibility is that some of the arguments together define a concept that
  should be packaged up and replaced with a new object to represent it

```java
public class MessageProcessor {
  public MessageProcessor(MessageUnpacker unpacker,
                          AuditTrail auditor,
                          CounterPartyFinder counterpartyFinder,
                          LocationFinder locationFinder,
                          DomesticNotifier domesticNotifier,
                          ImportedNotifier importedNotifier)
  {
    // set the fields here
  }
}
```

- just the thought of writing expectations for all these objects makes us wilt,
  which suggests that things are too complicated

- we can push together the ones that are being used together in our code

```java
public class MessageProcessor {
  public MessageProcessor(MessageUnpacker unpacker,
                          AuditTrail auditor,
                          MessageDispatcher dispatcher)
  {
    // set the fields here
  }
}
```

- when extracting implicit components, we start by looking for two conditions:
  - arguments that are always used together in the class
  - those that have the same lifetime

* confused object

- another diagnosis for a "bloated constructor" might be that the object itself
  is too large because it has too many responsibilities

* too many dependencies

- a third diagnosis for a bloated constructor might be that not all of the arguments are dependencies

- object peer stereotypes: we insist on dependencies being passed in to the
  constructor, but 'notifications' and 'adjustments' can be set to defaults and
  reconfigured later

* too many expectations

- when a test has too many expections, it is hard to see what's important and what's really under test

- we can make our intentions clearer by distinguishing between 'stubs',
  simulations of real behavior that help us get the test to pass, and
  'expectations', assertions we want to make about how an object interacts with
  its neighbors

#### what the tests will tell us (if we are listening)

* keep knowledge local

* if it is explicit, we can name it

* more names mean more domain information

* pass behavior rather than data

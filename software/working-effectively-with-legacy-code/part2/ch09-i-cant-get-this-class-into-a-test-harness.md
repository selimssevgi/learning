# I can't get this class into a test harness

- here are the four most common problems:

1. objects of the class can't be created easily
2. the test harness won't easily build with the class in it
3. the constructor we need to use has bad side effects
4. significant work happens in the constructor, and we need to sense it

## the case of the irritating parameter

- "gee, it looks like the simplest constructor on this class accepts three parameters"

* The best way to see if you will have trouble instantiating a class in a test
  harness it to just try to do it. Write a test case and attempt to create an
  object in it. The compiler will tell you what you need to make it really work.

- the thing that is really getting in our way when we want to create the
  validator(class under test) is the RGHConnection object(connect to an external
  system), it is an *irritating parameter*

- extract the interface from RGHConnection class, then create a FakeRGHConnection implementation

- The rules are different for classes that we use to make testing possible

- Production code vs test code

- Pass Null: in test instead of consstructing an object just send null if is not
  used in the code path, in worst case there will be NPE, then you can fix it.

- Pass Null and Extract Interface are two ways of approaching irritating parameters.

- if the problematic dep in a parameter isn't hard-coded into its constructor,
  we can Subclass and Override Method (overriding connect())

## the case of the hidden dependency

```java
class MailService {

  public MailService() {
    mailDispatcher = new MailDispatcher();
  }

}
```

- can be easily constructor, but it may use real mailing service.(not good for test)

- we can Parameterize Constructor

```java
class MailService {

  public MailService() {
    this(new MailDispatcher());
  }

  public MailService(MailDispatcher mailDispatcher) {
    this.mailDispatcher = mailDispatcher;
  }

}
```

## the case of construction blob

- Parameterize Constructor will not work if a constructor constructs a large
  number of objects internally or accesses a large number of globals, we would
  end up with a very large parameter list

- even worse when constructor creates a few objects and then uses them to create other objects

- Extracting a Method and overriding it may not work, (super class variables are not initialzed)

- another option is Supersede Instance Variable

```java
void supersedeADependency(DependencyA mockImplemention) {
  this.aDependency = mockImplemention;
}
```

- we should be careful that this method will not be used in production

## the case of irritating global dependency

```java
public class Facility {
  public Facility(int facilitycode, String owner, PermitNotice notice) {
    //...
    Permit assicatedPermit =
      PermitRepository.getInstance().findAssociatedPermit(notice);
    //...
  }
}
```

- add setForTesting or resetForTesting methods for testebility of Signleton

- or make constructor at least protected so it can be subclassed

## the case of the horrible include dependencies

- C/C++, #include, slow compilation if not careful, harder to test

## the case of the onion parameter

- to create objects to create objects to create a parameter fora constructor of a class that we want to test

- we can just Pass Null if none of the pieces needed

- or use Extract Interface if some faking is needed

## the case of the aliased parameter

- Subclass and Override Method

```java
public void testHasPermits() {
  class AlwaysValidPermit extends FakeOriginationPermit {
    public void validate() {
      // set the validation flag
      becomeValid();
    }
  }

  Facility facility = new IndustrialFacility(Facility.HT_!, "b", new
  AlwaysValidPermit());

  assertTrue(facility.hasPermits());
}
```

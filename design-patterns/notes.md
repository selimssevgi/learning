# HFSD Notes

## OO Basics

- Abstraction
- Encapsulation
- Polymorphism
- Inheritance

## OO Principles

- Encapsulate what varies.
- Favor composition over inheritance.
- Program to an interface, not an implementation.
- Strive for loosely coupled designs between objects that interact.
- Classes should be open for extension, but closed for modification.(O/C)
- Depend upon abstractions, do not depend upon concrete classes.(DI)
- Principle of Least Knowledge - talk only to your immediate friends.(Facade)

## OO Patterns

- Strategy Pattern
- Observer Pattern
- Decorator Pattern (Open/Closed)
- Factory Pattern (Dependency Inversion)
- Singleton Pattern




- Identify the aspects of your application that vary and separate them from what
  stays the same.

- The one constant in software development is "CHANGE"

- Take what varies and "encapsulate" it so it wont affect the rest of your code.

- Programming to an implementation:

```java
Dog dog = new Dog();
d.bark();
```

- Programming to an interface/supertype:

```java
Animal animal = new Dog();
animal.makeSound();
```

- Creating system using composition gives you a lot more flexibility. Not only
  does it let you encapsulate a family of algorithms into their own set of
  classes, but it also lets you *change behavior at runtime* as long as the
  object you're composing with implements the correct behavior interface.

## Strategy Pattern

- Defines a family of algorithms, encaplulates each one, and makes them
  interchangeable. Strategy lets the algorithm vary independently from clients
  that use it.

- One of the secrets to creating maintainable OO systems is thinking about how
  they might change in the future and these principles address those issues.

## Chapter 2 - the Observer Pattern

- Newspaper, subscription and publication

- Publishers + Subscribers = Observer Pattern

- Publisher -> the Subject, subscribers -> Observers

- Defines a one-to-many dependency between objects so that when one object
  changes state, all of its dependents are notified and updated automatically.

- Subject is the object that contains that state and controls it.

- Observers are dependent on the subject to update them when data changes. This
  lieads to a cleaner OO design than allowing many objects to control the same
  data.

### Java Built-in Observer Pattern

- java.util.Observer;   // interface
- java.util.Observable; // class

- Observable being designed as a class brings some problems with it.

## Chapter 3 - Decorator Pattern

- A great pattern for creating flexible designs and staying true to Open-Closed
  Principle.

- Think of decorator objects as "wrappers"

- Decorators have the same supertype as the objects they decorate.

- You can use one or more objects to decorate an object.

- The decorator adds its own behavior either before and/or after delegating to
  the object it decorates to do the rest of the job.

- *Decorator Pattern* attaches additional responsibilities to an object
  dynamically. Decorators provide a flexible alternative to subclassing for
  extending functionality.

- java.io package is largely based on Decorator

```shell
FileInputStream       -> The base component
BufferedInputStream   -> concrete decorator
LineNumberInputStream -> concrete decorator
```

*PROBLEM:*
- Java IO also points out one of the downsides of the Decorator Pattern:
  desigs using this pattern often result in a large number of small classes that
  can be overwhelming to a developer trying to use the Decorator-based API.

```java
public class LowerCaseInputStream extends FilterInputStream {
  public LowerCaseInputStream(InputStream in) {
    super(in);
  }

  public int read() throws IOException {
    int c = super.read();
    return (c == -1 ? c : Character.toLowerCase((char)c));
  }
  public int read(byte[] b, int offset, int len) throws IOException {
    int result = super.read(b, offset, len);
    for (int i = offset; i < offset+result; i++) {
      b[i] = (byte)Character.toLowerCase((char)b[i]);
    }
    return result;
  }
}
```

## Chapter 4 - Factory Pattern

### Simple Factory Pattern
```java
// we donot know until runtime which one we need to instantiate.

if (picnic) {
  duck = new MallardDuck();
} else if (hunting) {
  duck = new DecoyDuck();
} else if (inBathTub) {
  duck = new RubberDuck();
}
```

- Factory method might be static, we will advantage of not instantiating the
  class but then we will lose the change of subclassing.

- "Implementing an interface" could be a concrete class implementing a method
  from a supertype(which could be a class(abstract) or interface).

### Factory Method Pattern

```java
abstract class PizzaStore {
  Pizza orderPizza() {} // call createPizza()
  abstract Pizza createPizza();
}

class ShopA extends PizzaStore {
  @Override Pizza createPizza() {} // factor method
}

class ShopB extends PizzaStore {
  @Override Pizza createPizza() {} // factor method
}

// subclass will decide how to create the objects
abstract Product factoryMethod(String type);
```

- *Factory Method Pattern* defines an interface for creating an object, but lets
  subclasses decide which class to instantiate. Factory Method lets a class
  defer instantiation to subclasses.

- Depend upon abstractions, do not depend upon concrete classes.(DI)

* No variable should hold a reference to a concrete class(no new, factory)
* No class shoul derive from a concrete class.(no dependency, use AC or I)
* No method should override an implementation method of any its base class.

### Abstract Factory Pattern

- *Abstract Factory Pattern* provides an interface for creating families of
  related or dependent objects without specifying their concrete classes.

- Often methods of an Abstract Factory are implemented as factory methods.

```java
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
  public Dough createDough() {
    return new ThinCrustDough();
  }

  public Sauce createSauce() {
    return new MarinaraSauce();
  }

  public Cheese createCheese() {
    return new ReggianoCheese();
  }
  //...
}
```

**Factory Method vs Abstract Factory Pattern**

- Both create objects, 
  - Factory Method do it through inheritance,(NYPizzaStore extends PizzaStore) 
  - Abstract Factory do it object composition.(NYStylePizza(NyIngredientFactory)

- Abstract Factory Pattern uses an interface with lots of factory methods to
  create a family of products. New product means adding new method to interface.

## Chapter 5 - Singleton Pattern

**Global static variable vs Singletion**
What if object is resource intensive and your application never ends up using
it, with singleton pattern we can lazily initialize that object.

Global variable cannot guareente that the object will be initialized once and
only once.


```java
public class Singleton {
  private static Singleton uniqueInstance;
  // other useful instance variables

  private Singleton() {} // only the class can instantiate itself

  public static Signleton getInstance() {
    if (uniqueInstance == null) {
      uniqueInstance = new Signleton();  // lazy initialization
    }
    return uniqueInstance;
  }

  // other useful methods here
}
```

- *Signleton Pattern* ensures a class has only one instance, and provides a
  global point of access to it.

*PROBLEM:* If there are more than one thread and use the signleton object, there
will be some problems. Our lazy initialization uses check-then-act combound
operation which is not atomic. Two different threads can create two different
uniqueInstance objects. Lets synchronize.

```java
public class Singleton {
  private static Singleton uniqueInstance;
  // other useful instance variables

  private Singleton() {} // only the class can instantiate itself

  public static synchronized Signleton getInstance() { // OVERHEAD!
    if (uniqueInstance == null) {
      uniqueInstance = new Signleton();  // lazy initialization
    }
    return uniqueInstance;
  }
}
```

*PROBLEM:* It solves the problem stated above. But after the signleton object is
initialized, synchronized keyword cause some overhead. We just needed that in
the first time.

1. Overhead is there, but is not the end of the world. It solves the problem, if
   the performance is not depends so much on that method, just leave it.

2. Eagerly initialize the object, instead of lazily. JVM guareentes the object
   will be initialized(class loading), before any thread reaches.

```java
public class Singleton {
  private static Singleton uniqueInstance = new Singleton(); // EAGER

  private Singleton() {} // only the class can instantiate itself

  public static Signleton getInstance() {
    return uniqueInstance;
  }
}
```

3. Double-check locking
```java
public class Singleton {
  private static volatile Singleton uniqueInstance;

  private Singleton() {}

  public static Signleton getInstance() {
    if (uniqueInstance == null) {       // synchronizing just for the 1st time!
      synchronized(Singleton.class) {
        if (uniqueInstance == null) {
          uniqueInstance = new Singleton();
        }
      }
    }

    return uniqueInstance;
  }
}
```

*NOTE:* Multiple classloader in application can create problems with Signleton
Pattern, as each would have its own class of Signleton class.

(Island of Isolation, only reference is inside the class?)

Enum singleton pattern?

## Chapter 6 - Command Pattern

- *Command Pattern* encapsulates a request as an object, thereby letting you
  parameterize other objects with different requests, queue or log requests, and
  support undoable operations.

- Decouples an object, making a request from the one that knows how to perform it.

```java
public class LightOnCommand implements Command {
  Light light; // RECEIVER

  public LightOnCommand(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    light.on(); // ACTION
  }
}
```

- Thread pools, request queueing

- Logging request: logging all action

```java
public interface Command {
  void execute();
  void undo();
  void store();
  void load();
}
```

- Implement failure recovery by logging the actions on the spreadsheet rather
  than writing a copy of the spreadsheet to disk every time a change occurs.

- Transactional system could use these technique too, logging all actions, then
  applying all or none.(atomicity)

## Chapter 7 - Adapter and Facade Patterns

- The adapter changes the interface of the outlet into one that your laptop
  exptects.

- The adapter acts as a middleman by receiving requests from the client and
  converting them into requests that make sense on the vendor class.

- Allows clients to make use of new libraries and subsets without changing any
  code.

```java
public class TurkeyAdapter implements Duck {
  Turkey turkey;

  public TurkeyAdapter(Turkey turkey) {
    this.turkey = turkey;
  }

  public void quack() {
    turkey.gobble();
  }

  public  void fly() {
    for (int i = 0; i < 5; i++) {
      turkey.fly();
    }
  }
}
```

1. The client makes a request to the adapter by calling a method on it using the
   target interface.
2. The adapter translates the request into one or more calls on the adaptee
   using adaptee interface.
3. The client receives the results of the call and never knows there is an
   adapter doing the translation.

- Two way adapter: implementation of both interfaces at once.

- *Adapter Pattern* converts the interface of a class into another interface the
  clients expect. Adapter lets classes work together that couldnt otherwise
  because of incompatible interfaces.

- There are two versions: Class adapter and Object adapter pattern. But Java
  doesnt support multiple inheritence, therefore Class adapter is not applicable
  because it uses inheritance. Object adapter uses composition.

### Real World Adapters

- Enumaration: Allows you to step through the elements of a collection without
  knowing the specifics of how they are managed in a collection.

- Iterator


* Using an enumaration as an iterator

```java
public class EnumerationIterator implements Iterator {
  Enumeration enumeration;

  public EnumerationIterator(Enumeration enumeration) {
    this.enumeration = enumeration;
  }

  public boolean hasNext() { return enumeration.hasMoreElements(); }
  public Object next() { return enumeration.nextElement(); }
  public void remove() { throw new UnsupportedOperationException(); }
}
```

**Decorator Pattern vs Adapter Pattern**

- Decorator pattern add new responsibilities or behavior.
- Adapter pattern just converts interfaces.(simple pass-through)

- *Usage;* when you need to use an existing class and its interface is not the
  one you need, use an adapter.

### Facade Pattern

- Hides all the complexity of one or more classes behind a clean, well-lit
  facade.

- Can take a complex subsystem and make it easier to use by implementing a
  Facade class that provides one, more reasonable interface.


```java
public class HomeTheaterFacade {
  public void watchMovie(String movie) {
    System.out.println(“Get ready to watch a movie...”);
    popper.on();
    popper.pop();
    lights.dim(10);
    screen.down();
    projector.on();
    projector.wideScreenMode();
    amp.on();
    amp.setDvd(dvd);
    amp.setSurroundSound();
    amp.setVolume(5);
    dvd.on();
    dvd.play(movie);
  }
}
```

- *Facade Pattern* provides a unified interface to a set of interfaces in a
  subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.

- *Usage;* when you need to simplify and unify a large interface or complex set
  of interfaces, use a facade.

# java.lang.reflect.Constructor

- Constructor getContructor(parameterTypes...)
- Constructor getDeclaredConstructor(parameterTypes...)
- Constructor[] getConstructors()
- Constructor[] getDeclaredConstructors()

### Designing for dynamic loading

- for dynamically loaded classes, a good design technique is to implement only
  the default constructor and use instance methods for object initialization.

#### Using constructor to initialize

```java
interface Parrot {}

ParrotImpl1 implements Parrot {
  private String name;

  public ParrotImpl1(String name) {
    this.name = name;
  }
}
```

- the advantage of this implementation is that instances are propertly
  initialized when created.

- Makes dynamic loading complicated

- query contructors, exception handling, implicit agreement on constructor

- subclasses does not inherit constructors, need to call super

- if constructor does not exists, it is not compile time error

```java
Class cls = Class.forName("ParrotImpl1");
Constructor constr = cls.getConstructor(String.class);
Parrot polly = (Parrot) constr.newInstance("Polly");
```

#### Using other method to initialize

- agreement on initialization method, enforced by java language

- no override needed by subclasses

```java
interface Parrot {
  void initialize(String name);
}

ParrotImpl2 implements Parrot {
  private String name;

  public void (String name) {
    this.name = name;
  }
}
```

```java
Class cls = Class.forName("ParrotImpl2");
Parrot polly = (Parrot) cls.newInstance("Polly");
polly.initialize("polly");
```

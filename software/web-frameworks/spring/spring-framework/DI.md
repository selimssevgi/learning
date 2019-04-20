# Dependency Injection

- DI is a core feature of Spring
- Spring determines the dependencies to inject into your classes at runtime.
- This is known as *Inversion of Control*. The framework is in control of whats
  get injected.

#### Problems without DI
- Objects manages their own dependencies
- Leads to more tightly coupled code
- Require code changes in case of dependency changes
- More difficult to unit test

#### Types of DI
1. Constructor based
   - Class cannot be instantiated without its dependencies
2. Setter based
   - More flexible then constructor based

#### Interface based
- Best practise
- Closely aligned with SOLID
- Flexibility to compose classes by using different implementation
- Testing with mock implementations


```java
public interface HelloWorldService {
  sayHello();
}
```

```java
@Component
public class HelloWorldImpl implements HelloWorld {
  @Override
  public void sayHello() {
    System.out.println("Hello World!");
  }
}
```


```java
@Component
public class ConstructorBased {
  private HelloWorldService helloWorldService;

  @AutoWired
  public ConstructorBased(HelloWorldService HelloWorldService) {
    this.helloWorldService = helloWorldService;
  }

  public void sayHello() { helloWorldService.sayHello(); }
}
```


```java
@Component
public class SetterBased {
  private HelloWorldService helloWorldService;

  @AutoWired
  public void setHelloWorldService(HelloWorldService helloWorldService) {
    this.helloWorldService = helloWorldService;
  }

  public void sayHello() { helloWorldService.sayHello(); }
}
```

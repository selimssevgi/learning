# Understanding the join point model

- The join point model is the central concept in AOP.

- It consist of two parts: join points, the points in the execution of an
  application; pointcut, a mechanism for selecting join points.

- Spring supports a subset of AspectJ pointcuts in its proxy-based AOP framework



- Consider a situation where you need to implement transaction management.

1. You 'identify places' where you need to start a transaction before the
   main-line logic and where you commit or roll back the trx after the logic
   finishes based on the outcome.

2. You 'write a pointcut'  that selects the required join points.

3. You 'write an aspect' that encapsulates the trx-management functionality.

## Join points

- A join point is an identifiable execution point in a system.

- A call to a method, a field access, a for loop or an if statement are join points

- AspectJ exposes only a subset of all possible join points. (method call, field access)

- Exposed join points are the only places where you can interject cross-cutting actions

## Pointcuts

- A pointcut is a program construct that selects join points and collects join point context.

- Pointcuts specify a selection criterion.

- A join point has associated runtime information, called join point context

## Categorizing exposed join points

Category               | Exposed join point            | Code it represents
-----------------------|-------------------------------|----------------------
Method                 | Execution                     | Method body
Method                 | Call                          | Method invocation
Constructor            | Execution                     | Execution of an object's creation logic
Constructor            | Call                          | Invocation of an object's creation logic
Field access           | Read/Write access             | 
Exception Processing   | Handler                       | Catch block to handle an exception
Initialization         | Class initialization          | Class loading
Initialization         | Object initialization         | Object initialization in constructor
Initialization         | Object pre-initialization     | 
Advice                 | Execution                     | Advice execution


** Execution vs call

For most purposes, the difference between the execution and call join points
does not matter. The most important effect of choosing one over the other
relates to weaving. If you advice an execution of a method, the weaver weaves
advice into the method body. But if you advise calls to a method, the weaver
weaves all method invocation locations.

If you goall is to issue compile-time errors and warnings, where you may want to
detect calls made from some parts of the code, using a call join point is the
only choice. The call join point also lets you collect the caller object's
context.

## Understanding pointcut basics

- You can declare a pointcut inside an aspect, a class, or an interface. As with
  data and methods, you can use an access specifier to restrict access to it.

### Named and anonymous pointcuts

- In AspectJ, pointcuts can be either anonymous or named.

- Named pointcuts are elements that can be referenced from multiple places,
  making them reusable.

```java
@Pointcut("call(* Account.*(..))")
public void accountOperation() {}  // named

@Before("call(* Account.*(..))")   // anonymous
```

### Pointcut operators

- ! - lets you match all join points 'except' those specified by the pointcut

```shell
!within(JoinPointTraceAspect)
```

- || and && -- Combine multiple pointcuts

## Signature syntax

- * denotes any number of characters except the period

- .. denotes any number of characters including any number of periods. Direct or
  indirect subpackages, or an arbitrary number of method arguments.

- + denotes any subtype of a given type.

## Kinded Pointcut

- Spring support only 'execution'

```shell
@Pointcut("execution(* *.*(..))")
public void allMethods() {}
```

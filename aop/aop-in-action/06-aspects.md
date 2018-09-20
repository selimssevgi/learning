# Aspects

- Aspects represent the unit of modularization in AOP and AspectJ.

- They provide a way to include crosscutting constructs such as pointcuts and advice

- An 'aspect' encapsulates the implementation of a crosscutting functionality.

## Aspect association

- AspectJ offers four different kinds of aspect association:

1. Singleton (default)
2. Per object
3. Per control-flow
4. Per type

## @AspectJ Syntax

- Compilation just with javac, without any other tool

- part of the aspectjrt.jar

** Not supported by @AspectJ syntax

- introducing data and methods
- exception handling
- privileged aspects (accessing private members of a class)

** Java compatibility

- Although you can compile the code for @AspectJ using javac, the javac can't
  understand the semantics associated with the @AspectJ. As a result, you still
  need the AspectJ weaver to perform binary weaving during build-time or
  load-time.


```java
// ProfileAspect.aspectOf() wont work at compile time
Aspects.aspectOf(ProfileAspect.class);
```

- You are required to use fully qualified type names because 'import' statements
  aren't retained in compiled byte code.

## Using a typed join point context

- You can always obtain the join point context using reflective access (JoinPoint),
  but this approach suffers from issues such as lack of compile-tine time
  safety, reduced performance, and difficult programming.

- A better appraoch is to use pointcuts such as this() and args(), which expose
  the join point context with more specific types

## @Around Advice

Any organization that designs a system will produce a design whose structure is
a copy of the organization's communication structure.

- API Gateway

- Authentication
- Security
- Logging
- Transformations
- Load-balancing

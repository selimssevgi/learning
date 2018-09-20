# Alternatives to AOP

- The program AOP addresses isn't new.

- Many competitive technologies deal with the same problem: frameworks, code
  generation, design patters, and dynamic languages.


## Frameworks

- Frameworks such as servlets and EJB offer specific solutions to a focused set
  of problems.

- for example, the servlet specification offers filters to deal with requests
  made using the HTTP protocol. (can be used to implement concerns such as security)

- The EJB framework addresses crosscutting concerns such as transaction
  management and security.
  
- The EJB3 specification even provides limited support for interceptors.

## Code generation

- Code generation takes care of one of the drawbacks of using design patterns
  directly: manual modifications in many places.

- Hibernate and JRuby, use byte-code manipulation techniques as the basis of
  their implementation.

- Many systems, most notably AspectJ, use byte-code manipulation as the
  underlying technique in implementing AOP.

## Design Patterns

- Observer, chain of responsibility, decorator, proxy, and interceptor help with
  crosscutting concerns.

### Observer

- in AOP, you wont see invocations such as 'notify' in the subject class, thus,
  advice decouples the observer pattern logic from the subject.

- The context collected by pointcuts (compared to event object) is much more
  flexible and powerful in AOP.

### Chain of Responsibility

- The filter implementation in the servlet framework implements the COR pattern

### Decorator and Proxy

- Use a wrapper object that can perform some work before, after, or around
  invocation of the wrapped object.

### Interceptor

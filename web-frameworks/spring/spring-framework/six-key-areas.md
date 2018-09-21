# Spring Framework: Six Key Areas

- Core
- Web
- AOP
- Data Access
- Integration
- Testing

## Spring Core

- One of the most important pieces of Spring Framework

- It serves as the foundation of the Spring Framework

- Every other module is built upon

* Provides a number of different features:

- i18n support
- Validation support
- Data binding support
- Type conversion support, so on

- At the center of Spring Core is Dependency Injection
- Spring Core is a dependency injection container

## Spring Web

- Framework for handling web request: Web MVC, WebFlux

### Spring Web MVC

- Built upon Servlet API

- Servlet API is low-level

- Provides a higher level API(easier usage, more productivity)

### Spring Webflux

- Reactive programming: React rather than wait

- A different way of handling web requests

- Asynchronous execution
- Doesn't block (wait)
- Better resource utilization


* Traditional flow: a lot like dialing a support number and having to wait until
  the next agent is available. While you're on hold, you are basically tied up
  from doing anything else.

* Reactive flow: a lot like dialing a support number that allows you to put in
  your number and receive a call back when the next agent is available. Since
  you are not tied up on the phone waiting for that next available agent, you
  are free to do other things until your phone rings

## Spring AOP

- Implementation of AOP within the Spring Framework

- Used to implement features in Spring

- A valuable tool for developers to handle cross-cutting concerns

## Spring Data Access

- Data access module makes it easier to develop applications that interact with data

- Database transactions with Data Access module are really easy

- Data Access module also provides Exception Translation

- Vendor-specific exceptions are mapped into a well-known set of exceptions

## Spring Integration

- Application does not live in isolation

- Isolation is all about making different systems and apps work together

- How does one application 'talk' to another?

* How do you expose operations to other systems?
* How do you invoke or run operations on other systems?

- Many different ways to expose operations

1. RMI
2. Messaging Systems
3. Web Services(RestController, RestTemplate)

## Spring Testing

- Different ways of testing: Unit and Integration Testing

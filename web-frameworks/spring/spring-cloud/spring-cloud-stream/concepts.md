# Spring Cloud Stream Concepts

### Binder

- depends on the messaging system (spring-cloud-start-stream-rabbit or kafka dependency)


### Source

- When a message is needed to be published it is done using *Source*

- Source is an interface having a method annotated with @Output

- @Output is used to identify output channels

- Source takes a POJO object, serializes it and then publishes it to the output channel

```java
public interface EmployeeRegistrationSource {

  @Output("employeeRegistrationChannel")
  MessageChannel employeeRegistration();
}
```

### Sink

- Is used to consume message from queue


```java
@StreamListener(target = Sink.INPUT)
public void processMessage(String msg) {}
```

### Channel

- Represents an input and output pipe between the SC Stream application and the Middleware Platform

- Abstracts the queue that will either publish or consume the message

- Is always associated with a queue

- The name is moved out of code to properties

### Producer

- it consumes messages, process them, and put them in another channel

```java
@StreamListener(Processor.INPUT)
@SendTo(Processor.OUTPUT)
public String uppercase(Person value) {
  return value.toString().toUpperCase();
}
```

# asynchronous session beans

- new in ejb 3.1

- is not a new type of session bean but rather a new functionality that can be
  used with stateless, stateful, and singleton session beans

- prior to this, the only way for parallezation in jee was via mdb.

- when a asynchronous method or method on an asynchronous class is invoked, the
  container spawns a separate thread for execution

- return type of the method is either void(fire&forget) or Future(check back later)

## when to use

- a long running-operation, regardless of what happens with this operation(void)

- a long runnig operation, may want to check the result or cancel the operation(Future)


```java
@Asynchronous
public void sendEmail() {}
```

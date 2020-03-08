# singleton

- added in ejb 3.1

- solves two problems:
  - how to initialize at server startup (*init* method of the servlet)
  - have a single instance of a bean

- container instatiates the singleton and ensures that only one instance is created

- container also helps to properly manage concurrent access to the bean by multiple clients

- can't be passivated, has only two states
  - nonexistant
  - ready for invocation

*NOTE:* singleton beans could be used with REST, but this combination would have
poor performance characteristics becase only one bean would be servicing
requests at a time.

## startup tasks

- perform a couple of operation before the application is accessible to external users

```java
@Singleton
@Startup // instantiates bean on startup, eager instantiation
@DependsOn("SystemInitializer")
public DefaultFeaturedItem {
  
  @Schedule()
  public void loadFeaturedItem() {}

  @Lock(LockType.READ)
  @AccessTimeout(value = 1, unit = TimeUnit.MINUTES)
  public Item getFeaturedItem() {}
}
```

### concurrency control

- @ConcurrenyManagement(ConcurrenyManagementType.BEAN)
- @ConcurrenyManagement(ConcurrenyManagementType.CONTAINER) -- default
  - by default, all bean methods are serialized via write locks

- @Lock(LockType.READ) -- can be access concurrently while noone holds a write lock
- @Lock(LockType.WRITE) -- default, only current thread can get access
  - think as: each method is marked as synchronized

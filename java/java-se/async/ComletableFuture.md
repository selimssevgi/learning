# CompletableFuture

- see Future


```java
public interface UserRepository {

  CompletableFuture<User> findById(Long id);

  CompletableFuture<List<User>> findAll();

  CompletableFuture<Void> save(User user);
  
}
```

```java
CompletableFuture<User> future = repository.findById(id);

future.whenComplete((user, throwable) -> { // Async callback
  // logic
});
```

## Positive Side

- Fundamentally the right idea for use in async APIs

- Allows declarative composition of async logic

- Lambdas keep it readable

## Problem with CompletableFuture

- Not ideal for Collection return values

- Nor for latency sensitive data sets

- Nor large or infinite data sets

# Project Reactor

- Reactive Streams library for the JVM

- Declarative operations on items similar to Java 8 Stream

- Flux and Mono reactive composable API types


## Mono [0..1] sequence

- Similar to CompletableFuture


## Flux [0..N] sequence


## Reactive Repository


```java
public interface UserRepository {
  
  Mono<User> findById(Long id);

  Flux<User> findAll();

  Mono<Void> save(User user);
}
```

```java
repository.findAll()
  .filter(user -> user.getName().matches("J.*"))
  .map(user- > "User: " + user.getName())
  .useCapacity(2) // 2 items at a time, request(2), now has back pressure
                  // request(unbounded), no back pressure
  .log()
  .subscribe(user -> {}) // subscriber triggers flow of data
```



# Introduction to Reactor

- nothing happens until you subscribe -- assembly line

```java
this.myFlux =
  Flux.just("foo")
      .map(String::length);
```

- nothing happens, because you havent subscribe (lazy)

### Execution (subscription) time

```java
this.myFlux
    .subscribe();
```

### Cold vs Hot Publisher

* Cold publisher
  - whenever there is a new subscriber, it will generate new set of data
  - 3 subscriber, 3 http get request

* Hot publisher
  - it can be triggered by first subscriber
  - it generated the data once, and send it to subscriber whenever they come
  - one http get request, 3 subscriber

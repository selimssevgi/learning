# rxJava

## iterator pattern

```java
var list = List.of("One", "Two", "Three", "Four", "Five");
var iterator = list.iterator();

while (iterator.hasNext()) {
  System.out.println(iterator.next()); // blocks, pulls
}
```

## Observables

- rxJava's building blocks are the observables

- Observable class is the mathematical dual of Iterator class, two sides of the same coin

- the consumer doesnt "pull" these values from producer like in the Iterator pattern

- the producer "pushes" the values as notifications to the consumer

```java
var list = List.of("One", "Two", "Three", "Four", "Five");
Observable<String> observable = Observable.from(list); // sends all the values synchronously
observable.subscribe(System.out::println); // want to receive notifications
// everytime subscribe() is called on from(Iterable), iterator() method is called
```

- Observable behave somewhat like asynchronous iterators, which notify that
  there is a next value their subscribers/consumers by themselves

- Observable adds to the classic Observer pattern two things available in the
  Iterable type:

1. ability to signal the consumer that there is no more data
  - hasNext() -> OnCompleted

2. ability to signal the subscriber that an error has occurred
  - try/catch -> attach an error listener

```java
observable.subscribe(
  System.out::println,
  throwable -> System.out.println(throwable.getCause()),
  () -> System.out.println("onCompleted")
);
```

- this is an implementation of the RP paradigm: the data is being propagated to
  all the interested parties -- the subscribers

- using rxJava, we can create data streams from anything
  - file input, sockets, responses, variables, caches, user inputs etc

- consumers can notified that the stream is closed, or that there has been an
  error. So by using these streams, our applications can react to failure


* ConnectableObservable starts emitting events coming from its source only after its connect() is called

### Observable Factory methods

```java
Observable.from(List.of(1, 2, 3)); // Iterable
Observable.from(new Integer[] {1, 2, 3}); // T[]
Observable.just("one value");
Observable.just("multiple", "values");
// period polling, on computation thread
Observable.interval(500L, TimeUnit.MILLISECONDS);
// on computation thread
Observable.timer(0L, 1L, TimeUnit.SECONDS);
// emits 0 after delay, on computation thread, emits completed
Observable.timer(1L, TimeUnit.SECONDS);
// just emits onError, like throw in imperative
Observable.error(new RuntimeException("test error"));
// emits completed immediately
Observable.empty();
// does nothing, not even emits completed
Observable.never();
Observable.range(1, 3);
```

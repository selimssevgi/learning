# Reactive Programming

- reactive APIs of Java 9 - venkat, 2018 oracle code

###  what's reactive programming?

1. elastic (scaleable)
2. message-drive (no database sharing)
3. responsive
4. resilient (fail gracefully and fail-fast)


- dataflow = data -> function -> data -> function ...

- reactive programming == functional programming++

- functional programming
  - functional composition
  - lazy evaluation

- reactive-programming builds on top of those ideas

### java 8 stream & reactive streams

- both have pipeline definition
- both are lazy
- both push
- data only vs data also

```java
numbers.stream()
  .map(e -> e * 2)
  .forEach(System.out::println); // terminal operation


Flowable.interval(1, 1, TimeUnit.SECONDS)
  .map(e -> e * 2)
  .subscribe(System.out::println); // terminal operation

sleep(10000);
```

#### differences

- error
  - java 8 (good luck)
  - reactive streams (deal with it)

- exceptions and functional programming are mutually exclusive

- channel
  - java 8 (1 data channel)
  - reactive streams (3 channels: data, error, complete)

- forking
  - java 8 (no forking)
  - reactive streams (multiple subscribers)

- push
  - java 8 (push at will)
  - reactive streams (backpressure)

- method
  - java 8 (sequential vs parallel)
  - reactive streams (sync vs async)

### reactive streams API

- effort of netflix(rxJava), pivotal(reactor) lightbend(akka) and others

- Publisher - data source of potentially unbounded stream of data
- Subscriber - receiver of data from a publisher
- Subscription - think of this as session between a pub and a sub
- Processor(filter, map etc. both Publisher and Subscriber)

### Java 9 API

- late to the party
- could not turn its back to community or throw aways others work

- defines same 4 interfaces under java.util.concurrent.Flow

- and others decided to use JDKs interfaces instead of theirs custom package


#### SubmissionPublisher

- java.util.concurrent.SubmissionPublisher
- not for production, only for demos

```java
java.util.concurrent.SubmissionPublisher<Integer> feed =
  new SubmissionPublisher<>();

  feed.subscribe(new Flow.Subscriber<Integer>() {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subsription) {
      this.subsription = subsription;

      // without this line, publisher would assume capacity is zero, send nothing
      subsription.request(5); // tells publisher that it has capacity of 5
      // if you send me 1, now i have 4 ...
    }

    @Override
    public void onNext(Integer item) {
      sout(item);
      subscription.request(1);
    }
  });

  for (int i=0; i<10; i++) {
    feed.submit(i);
  }

  sleep(10000);
```

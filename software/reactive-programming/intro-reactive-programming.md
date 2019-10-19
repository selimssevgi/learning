# reactive programming

- is a paradigm that resolves around the propagation of change
- if a program propagates all the changes that modify its data to all the
  interested parties (users, other programs, components), then this program can
  be called *reactive*.

### reactive sum

- in Excel, we have A, B, C cell, C is Sum(A, B). When we update any of A or B,
  C is updated without any interaction from user

- how about in normal imperative approach?

```java
var a = 5;
var b = 10;
var c = a + b;
var a = 6;
// is value of c 15 or 16?
```

## why be reactive?

- today we should be online 7/24
- today slow means usuable or broken
- failures should be handled grafully, fault-tolerance

- event-driven/scalable/resilient/responsive (4 principles)

- changes in the application data can be modeled with notification, which can be
  propagated to the right handlers

- focuses on 3 aspects

1. data streams
2. functional programming (manupilate streams)
3. asyncronous observers (calback)


- *subject:* the stream that emits (produces) events/data

- *observer:* 'subscribes to' or 'consumes' data. There can be multiple observers for a single subject

### what creates the subject data stream?

- these streams are called Observables in RxJava

- Observable.create(), fromIterable(), etc

- retrofitting existing OO design into Observable data streams can be messy

### to subscribe to data

- imperative


```java
var data = new DataSource().getData();

for (Integer value : data) {
  sout(value);
}
```

- reactive


```java
new DataSource().getDataStream()
  .subscribe(val -> sout(val));
```

### to subscribe to data changes

- imperative - involved Scheduling, ExecutorService, Future etc. complicated


- reactive, is same as static data, cus is already a stream, notifies us, when data changes


```java
new DataSource().getDataStream()
  .subscribe(val -> sout(val));
```

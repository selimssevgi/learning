# CompletableFturue: the promises of Java

- by venkat on oracle one 2019

- javascript callback hell

- promise
  - may resolve: complete, cannot change state once in resolve
  - may reject: failure, cannot change state once in reject
  - may be pending: potentially resolve or reject

- promises have two channels:
  - data channel
  - error channel

- promises are easy to compose


- bottom/top track, or left/right track
- x: data, F: function, E:error

```shell
 ---x-F-x-F-------------x-F-x----------------------
P          \           /
 -----------E-F-E-F-E-F----------------------------
```

- CompletableFuture in Java is Promises in Javascript

### stage

- segment of a pipeline

- one stage completes and another stage may run

```java
public static int compute() {
  sout("compute: " + Thread.currentThread());
  return 2;
}

public static CompletableFuture<Integer> create() {
  return CompletableFuture.supplyAsync(() -> compute());
}

public static void main(String[] args) {
  sout("main: " + Thread.currentThread());
  create().thenAccept(data -> sout(data))
}

// main: Thread[main]
// copute: Thread[ForkJoinPool.commonPool]
// 2
```

- where the print run?

```java
public static int compute() {
  sout("compute: " + Thread.currentThread());
  return 2;
}

public static CompletableFuture<Integer> create() {
  return CompletableFuture.supplyAsync(() -> compute());
}

public static void printIn(int value) {
  sout(value);
  sout("printIt: " + Thread.currentThread());
}

public static void main(String[] args) {
  sout("main: " + Thread.currentThread());
  create().thenAccept(data -> printIt(data))
}

// main: Thread[main]
// copute: Thread[ForkJoinPool.commonPool]
// 2
// printIt: Thread[ForkJoinPool.commonPool]
```

- printIt run in the common pool thread as well (non-blocking)

- do not assume that this is the case all the time

- by the time you may do smth with the data, the worker thread would be done

```java
public static void main(String[] args) {
  sout("main: " + Thread.currentThread());
  CompletableFuture<Integer> cf = create();

  sleep(1000);
  cf().thenAccept(data -> printIt(data))
  sleep(1000);
}

// main: Thread[main]
// copute: Thread[ForkJoinPool.commonPool]
// 2
// printIt: Thread[main]
```

- worker thread finished its work, there is no point for thread to waste its
  effeort and wait for you

- by the time we call .thenAccept() the CompletableFuture is resolved and it can
  continue on main thread, is not blocking

*NOTE:* CompletableFuture never completes. We can chain and chain another method
call. Is a pipeline. We do not care where it is going. No ending.

### Stream vs CompletableFuture

Stream                              | CompletableFuture
-----------------------------------------------------------
zero, one, more data                | at most have one data or error
forEach(Consumer#accept)            | .thenAccept (forEach would not make sense)
map(Function#apply)                 | .thenApply
reduce                              | .thenCombine
flatMap                             | .thenCompose

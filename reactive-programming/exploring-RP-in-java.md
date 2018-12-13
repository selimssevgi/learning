# Exploring Reactive Programming in Java

- Reactive is essentially about creating systems that respond to events as they happen

- being responsive: handling varying loads, handling failures

- properties: responsive, elastic, message-driven, and resilient

- reactive programming a particular take on parallelism

- reactive programming ~= async programming

- reactive programming ~= non-blocking

## Java 1 -- level 0

- thread and runnable

- level 0, have threads enables parallesm

```java
new Thread(() -> System.out.println("hello devoxx")).start();
```

## Java 5 -- level 1

- ExecutorService (thread-pools)
- Callable
- Future (result of asynch computation)

- level 1: is this done? Then do this. get() is blocking
- not perfect structure to have async computations together

```java
ExecutorService executor = Executors.newSingleThreadExecutor();
Future<String> future = executor.submit(() -> "hello devoxx"); // return immediately
String result = future.get();
```

- in RP is important to avoid
  - blocking threads (cpu optimizaation)
  - changing treads (context-switch overhead)

## Java 7 -- level 2

- Fork/Join Framework
- ForkJoinPool (an implementation of ExecutorService)
- a better candidate for writing async systems

- FJP understands that some tasks depend on other tasks, it avoid changing
  threads as possible until workload is significant (can help cash corruption)

- key assumption behing the fork/join pool:

newly created tasks are likely to have data in a closer cache so maybe we should
run this recent task on the same CPU and we should offload this older task to
another CPU.

- each thread has its own queue

- works well that it is the base structure for other reactive constructs

- good single-threaded performance and pretty reasonable sharing across CPUs.


```java
ExecutorService executor = ForkJoinPool.commonPool();
Future<String> future = executor.submit(() -> "hello devoxx");
String result = future.get();

```

- Problems: Future composition, blocking while doing so

## Java 8 -- level 3

- CompletableFuture: construct for non-blocking asynch programming

- implement two interfaces: Future, CompletionStage

- makes things to easy to compose in non-blocking way

- they use ForkJoinPool behind the scene

```java
CompletableFuture<String> cf = new CompletableFuture<>();
cf.complete("done");
cf.get(); // returns "done"

CompletableFuture<String> cf = new CompletableFuture<>();
cf.get(); // blocks until some other thread completes the task

cf.completeExceptionally(new ISE());
```

- many methods, mostly comes from CompletionStage interface 38 methods

- the reason that there are many methods(38) because there are 3 categories of
  things that we are trying to expressing the API and creating methods for all combinations

1. what kind of a task is this (runnable, consumer, function)
2. what kind of an operation is it support (chain, compose, combine(and, or))
3. what thread shoudl it run on (current thread, different thread, do what you want to do)

```java
CompletableFuture
  .supplyAsync(() -> "hello")
  .thenApplyAsync(x -> x + " devoxx")
  .thenAcceptAsync(System.out::println);
```

```java
CompletableFuture // combining two tasks into one
  .supplyAsync(() -> "hello")
  .thenCombineAsync(CompletableFuture.supplyAsync() -> " devoxx", (x, y) -> x + y)
  .thenAcceptAsync(System.out::println);
```

- handle failure

```java
CompletableFuture // combining two tasks into one
  .supplyAsync(() -> "hello")
  .thenCombineAsync(CompletableFuture.supplyAsync() -> " devoxx", (x, y) -> x + y)
  // handle the exception that can occur somewhere in the pipeline
  .exceptionally(t -> "we have an error:" + t.getMessage())
  .thenAcceptAsync(System.out::println);
```

## Java 9 -- level 4 (flow api)

- timeout: a CF can be completed on a timeout

```java
CompletableFuture<String> cf = new CompletableFuture<>();

cf.completeOnTimeout("timed out", 5, TimeUnit.SECONDS);

cf.get(); // will be completed after waiting for 5 seconds if some other thread already did not complete it
```

```java
CompletableFuture<String> cf = new CompletableFuture<>();

cf.orTimeout(5, TimeUnit.SECONDS);

cf.get(); // will be completed after waiting for 5 seconds and throw exception
```

- copy method


**PROBLEM:** you can have an issue when your producer is producing the data
faster than your consumers able to comsume it. You need to be able to deal with
that. So what do you do?

- you can drop the data (not ideal)
- you can buffer it (eventually run out of buffers)
- you can block (that is not very reactive)

- you can implement a sort of async mechanism between P and C: back pressure

* Reactive Streams are de facto standard for async stream processing with non-blocking back pressure

- Java support reactive stream through flow api (java 9)

- (watch it again for pub/sub example)

- (dont lose yourself, use a library)

* Now we are able to pass messages between threads in the context of single JVM
  but true reactive system needs to be resilient, systems of many (micro)
  services. Communicates over HTTP.

## Java 11 -- level 5

- Http client (http2)

```java
HttpClient hc = HttpClient.newHttpClient();

HttpRequest request = HttpRequest.newBuilder()
  .uri(URI.create("http://localhost:8000/hello"))
  .GET()
  .build();

HttpResponse<String> hr = hc.send(request, BodyHandlers.ofString())
```

- make asynch

```java
HttpClient hc = HttpClient.newHttpClient();

HttpRequest request = HttpRequest.newBuilder()
  .uri(URI.create("http://localhost:8000/hello"))
  .GET()
  .build();

CompletableFuture<HttpResponse<String>> hr = hc.sendAsync(request, BodyHandlers.ofString())

hr.get().get();
```

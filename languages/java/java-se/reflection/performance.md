# Performance

### Categories

##### Construction overhead

The time it takes to perform modifications to a class object during its
construction. This may manifest itself in extra latency for constructing a proxy
class or instance. It may also take place during dynamic loading and reflective
construction of a delegate. Normally, this is just a one-time cost.

##### Execution overhead

The extra time added to the services supplied by an object/component because of
its reflective features. For example, this is the extra time it takes to call a
method using Method.invoke compared to a compiled call. Another example is the
added latency of forwarding method calls through a proxy. Generally, execution
overhead is incurred more frequently than construction overhead.


##### Granularity overhead

Added latency resulting from reflective code that applies to more of an
object/component than was intended or necessary. Sometimes, when using a proxy
, the changed need not apply to the entire interface. For example, there may not
be needed to have all proxy synchronized when we could just have a few.

## Microbenckmarks

```shell
perform setup
m0 = get first measurement
for (i -> repetationCount) {
  // run the code to be measured
}
m1 = get second measurement
report (m1 - m0) / repetationCount
```

```java
public class HelloWorldBenchmark {
  public static double aDouble = 123456789.0;

  public static void main(String args[]) {
    // 3 - know the clock resultion
    // sufficient iteration to make the resulation an insignificant issue
    int numberOfIterations = 15000;

    // 1 - Account for overhead
    // Loop to measure the overhead
    long time0 = System.currentTimeMillis();
    for ( int j = 0; j < numberOfIterations; j++ ) {
      // 4 - understand the effect of compiler optimization
      // static and public field, can be access from outside
      aDouble /= 1.000001;
    }
    long time1 = System.currentTimeMillis();

    aDouble = 123456789.0;
    // 2 - Warm up the code
    // fix first initialization/loading cost by making a dummy call
    System.out.println("Hello world!");

    long time2 = System.currentTimeMillis();
    for ( int j = 0; j < numberOfIterations; j++ ) {
      aDouble /= 1.000001;
      System.out.println("Hello world!");
    }
    long time3 = System.currentTimeMillis();

    double timeForOverheadLoop = (time1 - time0);
    double timeForHelloWorld = (time3 - time2) - timeForOverheadLoop;

    System.out.println( "HelloWorldBenchmark: " + timeForOverheadLoop
        + " milliseconds for basic loop." );

    System.out.println( "HelloWorldBenchmark: " + timeForHelloWorld
        + " milliseconds for " + numberOfIterations
        + " iterations." );

    System.out.println( "HelloWorldBenchmark: "
        + (timeForHelloWorld/numberOfIterations)
        + " milliseconds per print command" );
  }
}
```

- *Eliminate interference:* other OS/platform operation during benchmarking, for
  java for example there is Garbage Collector (zero garbage collector)

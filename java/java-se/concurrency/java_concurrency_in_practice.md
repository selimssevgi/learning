# Java Concurrency in Practice

- by Brian Goetz and others, Addison Wesley Professional, 2006

- Processes could communicate with one another through a variety of coarse-grained
communication mechanisms: sockets, signal handlers, shared memory, semaphores, and files.

# Several motivating factors of having processes
- Resource utilization - IO waiting
- Fairness - time slicing
- Convenience - easier to write single-task programs

- waiting for the water to boil involves a degree of asynchrony.(Asynchronous Task)
  While water is heating, you have a choice of what to do.

- Threads come into the pictures because of the same reasons of having processes.

- Each thread has its own program counter, stack, and local variables.

- Since threads share the same memory address space of their owning process,
all threads within a process have access to the same variables and allocate objects
from the same heap, which allows finer-grained data sharing than inter-process mechanisms.

# Benefits of threads
- reduce development and maintenance cost
- improve the performance of complex applications
- improve the responsiveness(GUI)
- resource utilization and throughput(server)

- Since the basic unit of scheduling is the thread, a program with only one
thread can run on at most one processor at a time. On a two-processor system,
a single-threaded program is giving up access to half the available CPU resources.

# Thread Safe Class - manages their own thread
- Timer
- Servlet/JSP
- RMI - lets you invoke methods on objects running in another JVM.
- Swing and AWT

# Part 1 - Fundamentals

## Chapter 2 - Thread Safety
- Writing thread-safe code is,at its core, about managing access to 'state',
and in particular to 'shared', 'mutable state'.

- We may talk about thread safety as if it were about 'code', but what we are
really trying to do is protect 'data' from uncontrolled concurrent access.

- Whether an object needs to be thread-safe depends on whether it will be accessed
from multiple threads. This is a property of how the object is 'used' in a program,
not what it 'does'.

- Whenever more than one thread accesses a given state variable,
and one of them might write to it, they all must coordinate their access to it using synchronization.

- The primary mechanism for snychronization in Java is the "synchronized" keyword,
which provides exclusive locking, but the term "synchronization" also includes
the use of 'volatile' variable, explicit locks, and atomic variables.

- It is far easier to design a class to be thread-safe than to retrofit it for thread safety later.

- Thread safety may be a term that is applied to 'code', but it is about the 'state',
and it can only be applied to the entire body of code that encapsulates its state,
which may be an object or an entire program.

### What is thread safety?
- Correctness means that a class conforms its specification

- a class is thread-safe when it continues to behave correctly
  when accessed from multiple threads.

- Stateles : it has no fields and references no fields from other classes.
The transient state for a particular computation exists solely on local variables
that are stored on the thread's stack and are accessible only to the executin thread.

- Since the actions of a thread accessing a stateless object cannot affect
the correctness of operations in other threads, stateless objects are thread-safe.

### Atomicity
- count++ seems to be like a single action because of its compact syntax,
it is not 'atomic', which means that it does not execute as a single, indivisible operation.
This is an example of a read-modify-write operation. This operation is not thread-safe
cus during that three operation, another thread can get in the way, resulting in loss of value.

- The possibility of incorrect results in the presence of unlucky timing is so
  important in concurrent programming that it has a name: *race condition*

### Race conditions
A race condition occurs when the correctness of a computation depends on
relative timing or interleaving of multiple threads by the runtime;
in other words, when getting the right answer relies on the lucky timing.

The most common type of race condition is 'check-then-act', where a potentially
stale observation is used to make a decision on what to do next.

Analogy: Two Starbucks, two friends, meeting, waiting at different starbucks,
then both at the same time checking the other one if the other friend is
there(timing, unlucky timing, observation is invalid at the moment he leaves,
stale observation, check-then-act).

- Lazy initialization has race condition, check if not initialized,(what if
  another thread initialize it at this point), then initialize

- read-modify-write, depends on previous value. data might be changed after
  reading by another thread before writing

### Compound Actions
- Sequences of operations that must be executed atomucally in order to remain thread-safe.

- To ensure thread safety, check-then-act operations(like lazy initialization)
and read-modify-write operations (like increment) must always be atomic.

- To avoid race conditions, there must be a way to prevent other threads from
  using a variable while we are in the middle of modifying it. We need to be
  sure other threads can observe or modify the state before or after not in the
  middle

count.incrementAndGet();
java.util.concurrent.atomic package contains 'atomic' variable classes.

* Compound Actions:
  - read-modify-write
  - check-then-act
  - put-if-abset

### Locking
Adding more than one thread-safe object into stateless object does not guarantee
that our final object is thread safe. Thread-safe field object may be changed
after checking equality.

### Intrinsic locks
- Every Java object can implicitly act as a lock for purposes of synchronization;
these built-in locks are called 'intrinsic locks' or 'monitor locks'.

- They acuqired automatically before entering the block and released when
  control exists the synch block

- Intrinsic locks in Java acts as 'mutexes' (or mutual exclusion locks),
which means that at most one thread may own the lock.

### Reentrancy
- When a thread requests a lock that is already held by another thread,
the requesting thread blocks. But because intrinsic locks are 'reentrant',
if a thread tries to acquire a lock that it already holds, the request succeeds.

- Reentrancy means that locks are acquired on a per-thread rather than per-invocation basis.

- Without reentrant locks, a snychronized method, in which a subclass overrides
a synchronized method and then calls the superclass method, would deadlock.
If intrinsic locks were not reentrant, the call to super.method would never be able
to acquire the lock because it would be considered already held,
and the thread would permanently stall waiting for a lock it can never acquire.

- Reentrancy saves us from deadlock in situations like this.(super methods)

- Reentrancy is implemented by associating with each lock an acquisition count
and owning thread. When the count is zero, the lock is considered unheld.
When a thread acquires a previously unheld lock, the JVM records the owner
and sets the acquisition count to one. If that same thread acquires the lock again,
the count is incremented, and when the owning thread exits the synchronized block,
the count is decremented. When the count reaches zero, the lock is released.

### Guarding state with locks
- Synchronized block should NOT be too long neither too short.
- There should nt be compute-instensive operations, causes performance.
- Block shouldnt be too short or too many, create performance overhead.

## Chapter 3 - Sharing Objects
We have seen how synchronized blocks and methods can ensure that operations
execute atomically, but it is a common misconception that
synchronized  is 'only' about atomicity or demarcating "critical sections".
Synchronization also has another significant, and subtle, aspect: *'memory visibility'.*

We want not only to prevent one thread from modifying the state of an object
when another is using it, but also to ensure that when a thread modifies the state of the object,
other threads can actually 'see' the changes that were made.

### Visibility
- There is no guarantee about ordering of the statements,(reordering)
  or visibility of fields, they can be made visible in different order than writing order.

- To avoid visibility problems: Use proper synchronization whenever data is shared across threads.

### Stale Data
Stale data can cause serious and confusing failures such as unexpected exceptions,
corrupted data structures, inaccurate computations, and infinite loops.

### Nonatomic 64 bit operations
- long and double types. Declare them as volatile or guard them by "this".
- for 64 bit operation JVM fetch and store operations may not be atomic(32bit,
  then other 32 bit), if 64bit vaues are not volatile those two piece might be
  belong to different values.

### Locking and visibility
- When a lock is acquired, all changes before the lock are visible.
Without synchronization, there is no such guarantee.

- A different lock cannot guarantee of visibility of another lock

### Volatile variables
Java also provides an alternative, weaker form of synchronization, volatile variables,
to ensure that updates to a variable are propagated predictably to other threads.

When a field is declared 'volative', the compiler and runtime are put on notice
that this variable is shared and that operations on it should not be reordered with other memory operations.

Volatile variables are not cached in registers or in caches where they are hidden from other processors,
so a read of volatile variable always returns the most recent write by any thread.

From a memory perspective, writing a volatile var is like exiting synch block,
reading a valotile var is like entering synch block.

Flags for critical loops could be volatile.

* Criterias to use volatile variable:

- Writes to variable donot depent on its current value, or can be sure only one
  thread writes

- The variable does not participate in invariants with other state variables,

- Locking is not required for any other reason while the variable is being
  accessed.

### Publication and escape
When a class returns the reference of one its fields, or holds it in a public static field,
this means that references is escaped.

public static Set<Secret> knownSecrets;

They will also have access to secret object, too.

### Thread Confinement
Accessing shared, mutable data requires using synchronization;
one way to avoid this requirement is to 'not share'. If data is only accessed from a single thread,
no synchronization is needed. This technique, 'thread confinement', is one of the simplest ways to achieve thread safety.

### Stack confinement
- An object can only be reached throught local variables.

### ThreadLocal
- A more formal means of maintaining thread confinement

## Immutability
Having all field as final is not enough to have immutability.
Fields reference may be final but the objects it holds are not immutable.
Non-final references shouldnt be escaped!

## Chapter 4 - Composing Objects

- When the next state is derived from the current state, the operation is
  necessarily a compound action.

- You cannot remove an item from an empty queue; a queue must be in 'nonempty'
  state before you can remove an element. Operations with state-based
  preconditions are called 'state-dependent'.

- synchronizedList nad its friends use decorator pattern. The collection object
  is confined into the wrapper class, all operations on the collection should go
  through wrapper class to keep the collection thread-safe.

- Where practical. delegation is one of the most effective strategies for
  creating thread-safe classes: just let existing thread-safe classes manage all
  the state

## Chapter 5 - Building Blocks

### Synchronized Collections

- Vector. Hashtable(legacy), synchronized wrappers classes
  (Collections.synchronizedXxx).

#### Problems with synchronized collections

```java
public static Object getLast(Vector list) { // assume: list.size() -> 5
  int lastIndex = list.size() - 1;   // T1:Step1: lastIndex = 4
  return list.get(lastIndex);        // T1:Step4: IOOBException
}
public static void deleteLast(Vector list) {
  int lastIndex = list.size() - 1;   // T2:Step2: lastIndex = 5
  list.remove(lastIndex);            // T2:Step3: list.size() -> 4
}
```

```java
public static Object getLast(Vector list) {
  synchronized (list) {                       // Client-side locking
    int lastIndex = list.size() - 1;
    return list.get(lastIndex);
  }
}
public static void deleteLast(Vector list) {
  synchronized (list) {
    int lastIndex = list.size() - 1;
    list.remove(lastIndex);
  }
}
```

```java
for (int i = 0; i < vector.size(); i++)
  doSomething(vector.get(i)); // IOOBException if other threads get involved

// Locking? Could work
// But we will block all other threads accessing it while iterating. not desirable

synchronized (vector) {                     // Client-side locking
  for (int i = 0; i < vector.size(); i++)
    doSomething(vector.get(i));
}
```

#### Iterators and ConcurrentModificationException

- While iterating a collection using Iterator, if another thread modifies the
  collection, Unchecked CMException is thrown. Modification count is used to
  detect this, even that check is not synchronized(performance tradeoff)

```java
List<Widget> widgetList = Collections.synchronizedList(new ArrayList<Widget>());
...
// May throw ConcurrentModificationException
for (Widget w : widgetList)
  doSomething(w);

// Locking? Could work
// But we will block all other threads accessing it while iterating. not desirable

// lock
// Clone the collection for iteration
// unlock
// have the copy(local) thread-confined  for iteration
// tradeoff. your decision
```

- Collection methods have hidden iterator usages: toString, removeAll,
  retainAll, containsAll, passing collection to another constructor...

### Concurrent Collection

- Synchronized collections achieve their thread safety by serializing all access
  to the collection's state. Cost: poor concurrency

- ConcurrentHashMap(a replacement for synchronized hash-based Map implementations)
- CopyOnWriteArrayList, a replacement for synchronized List implementations

- ConcurrentSkipListMap(replacement synchronized SortedMap, TreeMap)
- ConcurrentSkipListSet(replacement synchronized SortedSet, TreeSet)

// repos/learning/java/java-se/collections/concurrent_collections

### Blocking and Interruptible Methods

- When a method can throw InterruptedException, it tells, it is a blocking method.

- If it is interrupted, it will make effort to stop blocking early

- When your code call a method that throws IE, then it is a blocking method too

1. Propagate the IE: dont catch it, or catch, some clean up and throw again
2. Restore the interrupt: sometimes IE cannot be thrown in the code, catch it
   and call interrupt on the thread


```java
public class TaskRunnable implements Runnable {
  BlockingQueue<Task> queue;
  // ...
  public void run() {
    try {
      processTask(queue.take());
    } catch (InterruptedException e) {
      // restore interrupted status
      Thread.currentThread().interrupt();
    }
  }
}
```

### Synchronizers

- A synchronizer is any object that coordinates the control flow of threads
  based on its state.

#### Latches

- A latch is a synchronizer that can delay the progress of threads until it
  reaches its terminal state.

- A latch acts as a gate; until the latch reaches the terminal state, the gate
  is closed and no thread can pass. In terminal state the gate opens and
  allowing all threads to pass.

### FutureTask

- FutureTask also acts like a latch.

### Semaphores

- Counting semaphores are used to control the number of activities that can
  access a certain resource or perform a given action at the same time.

### Barrier

- Barriers are similar to latches in that they block a group of threads until some
  event has occurred [CPJ 4.4.3]. The key difference is that with a barrier, all the
  threads must come together at a barrier point at the same time in order to proceed.
  Latches are for waiting for events; barriers are for waiting for other threads.

## Chapter 6 - Task Execution

### Executing tasks in threads

- Tasks are independent activities.

- Most server applications offer a natural choice of task boundary: individual
  client requests.

#### Executing tasks sequentially

```java
class SignleThreadWebServer {
  public static void main(String[] args) throws IOException {
    ServerSocket socket = new ServerSocket(80);
    while (true) {
      Socket conn = socket.accept();
      handleRequest(conn)
    }
  }
}
```

*PROBLEM:* Suffers from poor responsiveness and throughput.

#### Explicitly creating threads for tasks

```java
class ThreadPerTaskWebServer {
  public static void main(String[] args) throws IOException {
    ServerSocket socket = new ServerSocket(80);
    while (true) {
      final Socket conn = socket.accept();
      new Thread(() -> handleRequest(conn)).start();
    }
  }
}
```

*SOLVES:* Responsiveness and throughput.
*PROBLEM:* Suffers from resource managements

#### Disadvantages of unbounded thread creation

- Thread lifecycle overhead: creation and teardown are not free.

- Resource consumption: creating more threads wont help and may even hurt.

- Stability: limit on how many threads can be created -> OutOfMemoryError

### The Executor Framework

- Tasks are logical unit of work.
- Threads are mechanism by which tasks can run asynchronously.

- The primary abstraction for task executin in Java class libraries is not
  Thread, but Executor.


```java
public interface Executor {
  void execute(Runnable command);
}
```

- Executor provides a standard means of decoupling task submission from task
  execution.

- Executor is based on producer-consumer pattern.

- Activities that submit tasks are producers, the threads that execute tasks are
  the consumers.

- Using an Executor is usually the easiest path to implementing a
  producer-consumer design in your application.

#### Web server using Executor

```java
class TaskExecutionWebServer {
  private static final int NTHREADS = 100;
  private static final Executor exec
    = Executors.newFixedThreadPool(NTHREADS);

  public static void main(String[] args) throws IOException {
    ServerSocket socket = new ServerSocket(80);
    while (true) {
      final Socket conn = socket.accept();
      exec.execute(() -> handleRequest(conn));
    }
  }
}
```

```java
// behave like ThreadPerTaskWebServer

public class ThreadPerTaskExecutor implements Executor {
  public void execute(Runnable r) {
    new Thread(r).start();
  }
}
```

```java
// behave like signle-threaded

public class ThreadPerTaskExecutor implements Executor {
  public void execute(Runnable r) {
    r.run();
  }
}
```

#### Execution policies

- An execution policy specifies "what, where, when and how" of task execution:

* In what thread will tasks be executed?
* In what order should tasks be executed(FIFO, LIFO, priority order)?
* How many tasks may execute concurrently?
* How many tasks may be queued pending execution?
* What actions should be taken before or after executing a task?
* If a task has to be rejected because the system is overloaded, which task
  should be selected as the victim, and how should the application be notified?

#### Thread Pools

- A thread pool is tightly bound to a work queue holding tasks waiting to be
  executed.

- CAn create a thread pool by calling static factory methods in Executors:
  - newFixedThreadPool      - creates thread up to maximum size
  - newCachedThreadPool     - flexible, increases and decreases size
  - newSignleThreadExecutor - Sequentially according to order imposed by task que
  - newScheduledThreadPool  - similar to Timer

#### Executor lifecycle

- ExecutorService interface extends Executor, adding a number of methods for
  lifecycle management.

```java
public interface ExecutorService extends Executor {
  void shutdown();
  List<Runnable> shutdoowNow();
  boolean isShutdown();
  boolean isTerminated();
  boolean awaitTermination(long timeout, TimeUnit unit) throws IE;
  //...
}
```

### Finding exploitable parallelism

- The real performance payoff of dividing a program’s workload into tasks
comes when there are a large number of independent, homogeneous tasks
that can be processed concurrently.

## Chapter 7 - Cancellation and Shutdown

- Java doesnot provide any mechanism for safely forcing a thread to stop,
  instead it provides 'interruption', a cooperative mechanism that let one
  thread ask another to stop.

- Dealing well with failure, shutdown, and cancellation is one of the
  characteristics that distinguishes a well-behaved application from one that
  merely works.

### Task Cancellation

Any activity is cancellable if external code can move it to completion before
its normal completion.

- *User requested cancellation:* Cancel button of GUI or web interface

- *Time-limited activities:* 
- *Application events:* one threads finds it, others are cancelled
- *Errors:* Crawler, full disk, threads are being stopped
- *Shutdown:* 

- One such coopeative mechanism: volatile cancellation flag

### Interruption

- A task uses cancellation approach calls a blocking methodu such
  BlockingQueue.put(), the task might never check the cancellation flag and
  therefore might never terminate.

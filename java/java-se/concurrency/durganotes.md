# Multitasking

### Types of Multitasking
* Process based: separate tasks, no dependencies on each other,
                   OS level, not programmatic level
    - writing code in editor
    - listening some music
    - downloading some file

* Thread based: multiple independent parts of a program

### Difference between Process and Thread Based
- Process context switching is more expensive

### Advantage of Multitasking
  - reduces idle time of processor
  - reduces response time of the program/system

## Multithreading in Java
Java has built-in support for multithreading with the rich API.

**Thread** : a flow of execution of a job.

* There are two ways of defining a thread:
  - by extending Thread class
  - by implementing Runnable interface

**Job** : the code block in the run method is the job that thread will execute.

### by extending Thread class

```java
MyThread extends Thread {}
```

#### Case 1 : Thread Scheduler
There is no guarantee of the order of executing threads,
it depends on the implementation of the JVM.

#### Case 2 : t1.run() vs t1.start()
* run method in an extended Thread class, is like any other method.
t1.run() will just execute the code, but there will NOT be any new thread being created.

* start method will create a new thread,
hence a different flow of execution and execute the code that is in run method.

#### Case 3 : importance of Thread class, start method.
Responsible of registering the thread with thread scheduler, and doing all other mandotary activities.
Without calling the start method, there is no other way to create a new thread.

#### Case 4 : Overloading run method
Overloading run method is possible, but the start command will call the one w/o arguments.

```java
public void run()
public void run(int i)
```

#### Case 5 : Not overriding run method
It is a valid program, but there will NOT be any output/effect, Thread run method is empty.

#### Case 6 : Overriding start method
It will use the one in subclass, so it will NOT do what it has to do. There will NOT be a new thread created.

#### Case 7 : Calling super.start
The code after super.start will be executed by main method.

#### Case 8 : Thread life cycle
new -> new Thread
ready/runnable -> t1.start()
running -> tread scheduler allocates processor
dead/terminate -> preemptying or finishes job

#### Case 9 : Restarting a thread
Throws illegalThreadStateException. RuntimeException

### by implementing Runnable interface
```java
MyRunnable implements Runnable {}

MyRunnable r = new MyRunnable();
Thread t1 = new Thread();
Thread t2 = new Thread(r);
```

#### Case 1 : t1.start()
new thread will be created, but there is no run method, default one is empty

#### Case 2 : t1.run()
new thread will NOT be created, run will be executed, but no effect.

#### Case 3 : t2.start()
new thread will be created, and execute run method of MyRunnable class.

#### Case 4 : t2.run()
new thread will not be created, run method will be executed, just like a normal method call.

#### Case 5 : r.start()
compile time error, MyRunnable class does not have start method

#### Case 6 : r.run()
new thread will NOT be created, just like a normal method call

## Runnable Interface over Thread Class
- Extending thread cost of extending another class
- If a class is already extending Thread(C), it loses its chances to extend
  another one. Multiple inheretence is NOT allowed in Java.

## Thread Class Constructor
```java
Thread t = new Thread();
Thread t = new Thread(Runnable target); // a thread can be passed as well, after all Thread class implements Runnable too
Thread t = new Thread(String name);
Thread t = new Thread(Runnable target, String name);
Thread t = new Thread(ThreadGroup g, String name);
Thread t = new Thread(ThreadGroup g, Runnable target);
Thread t = new Thread(ThreadGroup g, Runnable target, String name);
Thread t = new Thread(ThreadGroup g, Runnable target, String name, long stackSize);
```

## Thread Methods
```java
Thread.currentThread(); // native method, returns current thread object
t1.getName(); // returns the name of the thread, if not set, internally created one. (Thread-0)
t2.setName("athreadname");
```

## Thread Priorities
- Priorities are 1 to 10.
- 1 is min, 10 is max priority.

```java
Thread.MIN_PRIORITY = 1;
Thread.NORM_PRIORITY = 5;
Thread.MAX_PRIORITY = 10;
```

* Priority is inhereted.
* Some platforms will not provide proper support for thread priority.

## Prevent thread execution
1. yield
2. join
3. sleep

### yield() method - PhoneBooth analogy
A pause of a thread to give a chance to the same priority threads to use CPU,
if there is no thread, same thread can continue its execution.

* Running thread calls yield, goes into ready/runnable state.
* Some platforms do not provide proper support for yield method.

### join() method - waiting friend analogy
The thread wanting to wait for another thread must call join method on that thread.
If t1 wants to wait until t2 is completed, then t1 has to call t2.join.
It goes into waiting state.
When t2 completes, then t1 can continue its execution.

- venue fixing activity = t1
- wedding card printing = t2
- wedding card distribution = t3

* t2 needs the address, has to wait for t1 to complete. t2 calls t1.join.
* Before distribution we need the card, t3 has to wait for t2 complete, so it calls t2.join

```java
public final void join(); // wait forever
public final void join(long milliseconds); // wait just for that amount of time
public final void join(long milliseconds, int nanosecond); // nanosecond is in range of 0-999. int is enough hold
```

* join method throws InterreptedException, it must be handled
* running thread -> calls join method -> waiting state(blocked for joining)
* after joining for some reasons ends, the thread will goes into ready/runnable state.
Reasons :
  - t2 completes
  - time expires
  - waiting thread interrupted

### Parent Thread
If child thread needs the reference of the parent thread,
it has to have 'static Thread parent',
and that field has to be set from the parent thread by calling Thread.currentThread().

```java
// in thread definition
static Thread parent;
// in parent class
MyThread.parentThread = Thread.currentThread();
```

* If parent and child thread call join on each other, they will wait forever. **DEADLOCK!**
* If thread itself call join on itself, it will wait forever. **Kinda
  DEADLOCK!**

### sleep method
If a thread do not want to do any operation for a certain time, it should go to sleep.

```java
public static native void sleep(long ms) throws InterreptudException
public static void sleep(long ms, int ns) throws InterreptudException
```

* running state -> calls sleep method -> sleeping/waiting state ->
get time expired or get exception -> ready/runnable state

**Examples:** sliderotator, word processor backup, light blinking

## Thread Interruption
Sleeping while waiting for the bus, asking other people to wake u up if bus arrives.

public void interrupt()

Threads can be interreptud in waiting/sleeping state by calling interrupt method on them.

#### Calling interrupt on a thread which is not in waiting/sleeping state?
Interrupt call will wait until that thread goes in waiting/sleeping state.
Then it will be interrupted. It never goes wasted.

If the thread wont go into waiting/sleeping state in its lifetime,
then interrupted calls will be wasted.

# Synchronization
A keyword, modifier can be used for method and block, CANNOT be used for class or variables.

Multiple threads is trying to operate simultaneously on the same object,
there is a chance that it will result in data in-consistency!

Synchronized keywords resolves data in-consistency problem.

If one method or block is synchronized, then only one thread can operate/use that method or block.

**Disadvantages:**
 - Other threads have to wait
 - Increases waiting time
 - Creates performance problems

Hence if there is no requirement, synchronized keywords should NOT be used.

Internally, synchronization concept is implemented by using lock.
Every object in java has a unique lock.
Whenever we are using synchronized keyword, lock will come in to the picture.

If a thread wants to execute a synchronized method on the given object,
firstly it has to get the lock of the object,
once it got the lock, it is allowed to execute any synchronized method on that object,
once method execution finishes, automatically lock is released by JVM.

```java
class X {
  synchronized m1();
  synchronized m2();
  m3();
}
```

- t1.m1(); -> gets the lock of the object
- t2.m1(); -> goes to waiting state
- t3.m2(); -> goes to waiting state(lock is unique to the object, not method)
- t4.m3(); -> executes normally no need for waiting for the lock

```java
class X {
  synchronized area() {
    // add,remove,delete,replace
    // where the state of the object is changing
  }

  non-synchronized area() {
    // where the state of the object will NOT change
    // read operations
  }
}
```

* Different threads operating on different object does not require synchronized keyword usage.

#### Class Level Lock
- Class level lock, static methods belong to class, not to object.
- Every class in java has a unique lock, which is class level lock.

```java
public static synchronized wish() {}
```

## Synchronized Block
For a method having 10k lines of codes, but just 10 lines requiring
synchronized, if we use synchronized keyword for the method,
it will have a huge performance decrease.
the good practise is just to synchronize that 10 lines of block

#### A Bridge Example
A ======---====== B

If we allow just one vehicle from A to B,
because just one vehicle can go through the bridge at a time
it will cost us lots of time, we can let multiple vehicles but just on the bridge will be just one.

#### Advantage over Synch Method
It reduces waiting time on threads. Therefore, the performance increases.

```java
synchronized(this) {
  // it requires the lock of the current object
}

synchronized(anotherobject) {
  // it just requires the lock of the 'anotherobject'
}

synchronized(Display.class) {
  // it requires the lock of the class
}
```

**Important:** We can NOT get the lock of primitive types.

## Questions
1. What is synchronized keyword and where we can apply?
- It is a modifier, it can be used with methods and block but not with class and variables.

2. Explain advantage of synchronized keyword?
- We can resolve data in-consistency problem.

3. Explain disadvantage of synchronized keyword?
- Increases waiting time of the threads, decreases performance.

4. What is race condition?
- If multiple threads oparete simultenaously on an object, causing data in-consistency.
It is race condition. We can overcome this problem by using synchronized keyword.

5. What is Object Lock and when it is required?
- Every object has a unique lock, this lock is required when a thread wants to execute synchronized method.

6. What is class level lock and when it is required?
- Every class has a unique lock, whenever a thread wants to execute a static synchronized method.

7. What is the difference between class level lock and object level lock?

8. While a thread executing synchronized method on the given object,
is it remaining threads execute any other synchronized method simultenaously on the same object?
- NO

9. What is synchronized block?
- It gives advantages and performance increase over method synchronization.

10. How to declare synchronized block to get the lock of current object?
- synchronized(this) {}

11. How to declare synchronized block to get class level lock?
- synchronized(ClassName.class) {}

12. What is the advantage of synchronized block over synchronized method?
- Reduces waiting time for other threads

13. A thread can require multiple lock simultenaously?
- YES, of course from different objects

```java
class X {
  public synchronized void m1(){ // here it requires the lock of x object
    Y y = new Y();
    synchronized(y) { // here it requires the locks of x and y object.
      Z z = new Z();
      synchronized(z) { // here it requires the locks of x,y,z objects.
        // some operations
      }
    }
  }
}
```

14. What is synchronized statement?
- Statements in a synch method or in a sync block.
this terminology is not in JLS. Interview people created.

## Inter-Thread Communication 
- waiting for a letter analogy
- notify
- wait
- notifyAll

#### Case 1 : thread communication methods
- Two threads can communicate with each other by using wait, notify, notifyAll methods.
- The thread which is expecting updation is responsible to call wait method,
then immediately the thread will enter into waiting state.
- The thread which is responsible for updation, after performing updation,
is responsible to call notify method.
- Then waiting thread will get notification and continue its execution, with those updated items.

**IMPORTANT:** wait, notify and notifyall methods present in Object class.

#### Case 2 : If they are just used in multithreading, why are they in Object(C)?
These methods can be called on any other object. Therefore, they are in Object class.


#### Case 3 : These methods can be called on an object owned by the thread
These methods can be called when that thread has the lock of the object(owner of the object),
that means that thread should be in synchronized method/block/static method.

These methods can be called only in the synchronized area.
Otherwise we will get IllegalMonitorStateException. RuntimeEx

#### Case 4: Calling wait() method
If a thread calls wait method on any object,
it **immedeately** releases the lock of that particular object,
and enter into waiting state.

#### Case 5: Calling notify() method
If a thread call notify method on any object,
it releases the lock of that object, but may not immedeately.

**IMPORTANT:** Except wait, notify, notifyAll, there is no other method that threads release the lock.

##### Questions: Which is the following valid?
1. If a thread calls wait method, immedeately it will enter into waiting state, without releasing any lock.
- INVALID, it will release the lock.
2. If a thread calls wait method, it releases the lock of that object but may not immedeately.
- INVALID, it releases the lock immedeately.
3. If a thread calls wait method on any object, it releases all locks required for that thread, and immedetely entering in waiting state. 
- INVALID. Not all locks.
4. If a thread calls wait method on any object, it immedeately releases the lock of that particular object, and enter into waiting state.
- VALID
5. If a thread calls notify method on any object, it immedeately releases the lock of that particular object.
- INVALID. NOT immedeately.
6. If a thread calls notify method on any object, it releases the lock of that object, but may not immedeately.
- VALID.

```java
public final void wait() throws IE; // i want to wait until being notified
public final native void wait(long ms) throws IE; // wait just for that amount
public final void wait(long ms,int ns) throws IE; // wait just for that amount

public final native void notify();
public final native void notifyAll();
```

* obj.wait(); -> goes into waiting state
* Wakes up cus of time expiring, interrupted, notified
* Thread got notification -> goes into another waiting state to get the lock!!!
* If the waiting thread gets the lock -> goes into ready/runnable state

# Producer - Consumer Problem
- Producer thread is responsible to produce items into the queue.
- Consumer thread is responsible to consume items from the queue.
* If the que is emtpy, consumer thread will call wait method, and enter into waiting state.
* After producing the items into the que, producer thread is responsible to call notify method.
* Then waiting consumer will get that notification, and continue its execution with the updated items.

Consumer expects notification, therefore using wait method on common object.
Producer is responsible to notify, therefore using notify method on the common object.

```java
produce() {
  synchronized(queobject) {
    // produce items into the que
    queobject.notify();
  }
}

consume() {
  synchronized(queobject) {
    if( que is empty )
      queobject.wait();
    else
      // consume the items from the que
  }
}
```


## Difference between notify and notifyAll
10 waiting threads waiting notification on object.

- notify    : just one thread will get the notification, but no certainty which one will get the notification.
- notifyAll : obj1.notifyAll(); will notify just the threads waiting for obj1 notification
            then they will wait for the lock of the object, then execution will happen one by one.

```java
Stack s1 = new Stack();
Stack s2 = new Stack();

synchronized(s1) { s2.wait(); } // RE: IllMonStaEx. it is not the owner of s2!
synchronized(s2) { s2.wait(); } // valid, because it is the owner of s2.
```

# Deadlock
If two threads are waiting for each other forever,
such a type of infinite waiting is called deadlock.

### Can we overcome deadlock by using scynhronized keyword?
Synchronized keyword is the only reason for deadlock situation.
Hence using synchronized keyword have to take special care.
*There are no resolution techniques for deadlock, but there are prevention tehcniques.*

## Deadlock vs Starvation
Starvation happens when a thread waiting too long, but after such long time, it will run.
Difference from deadlock, at some point after long time, it will run.

- Deadlock   : long waiting does NOT end.
- Starvation : long waiting does end.

**Example:** Low priority thread waiting too long for the high priority threads,
     but this waiting will end after all high priorty threads are done.

# Daemon Threads
The thread which is executing in the background is a daemon thread.

**Example:** garbage collection, attach listener, signal dispatcher

The purpose of gc is providing memory/support for other nondaemon threads.(main thread)
if main thread runs with low memory, jvm runs gc to destroy useless objects.

**Analogy:** When filming a movie, there are more people involved more than the ones on screen.
         makeup, scenerist, producer, director etc, they are daemon.

Daemon threads run with low priority.
If necessary gc will get highest priority by JVM.

#### how to check if a thread is a daemon?

```java
public boolean isDaemon();
public void setDaemon(boolean b);
```

We change daemon nature of a thread by using setDaemon method.
However, changing daemon nature is only possible before starting of the thread.
After starting a thread, if we are trying to change daemon nature,
we will get runtime excetpion, which is IllegalThreadStateException.

Main thread is always non-daemon.
And for the all remaining threads daemon nature is inhereted from the parent.

**Important:** It is impossible to change the daemon nature of the main thread,
because it is started by JVM already, no change after starting.

* Whenever the last non-daemon terminates,
automatically all daemon threads will be terminated.
Respect of their position, they are just supporter for non-daemon threads.

# Green Thread
Java multithreading concept is implemented by using the following two models:
  - Green thread model
  - Native OS model

**Green thread :** Which is managed completely by JVM without taking underlying OS support.
Very few OSs provide support for green thread model. Sun Solaris.
Green thread model is deprecated, and not recommended using.

**Native OS model :** The thread which is managed by JVM with the help of underlying OS,
is called Native OS model. All Windows based OSs provide support for Native OS model.

# How to stop a thread
We can stop a thread execution by t1.stop() method, if we call stop method,
then immideately the thread will enter into dead state.
stop method is **deprecated**, and not recommended to use.

**Important:** Stop a thread after it opens the db connection, who is gonna close it?!

# How to suspend and resume a thread
We can suspend a thread by using t.suspend() method of Thread class,
then immediately that thread will be enter into suspended state,
we can resume a suspended thread by using t.resume() method of Thread class,
then suspended thread can continue its execution.

```java
public void suspend();
public void resume();
```

Anyway these methods are **deprecated**, not recommended to use.

```java
New/Born State <- Thread t = new MyThread();
Ready/Runnable State <-  t.start(); | t.yield(); | (end of join method) | (end of sleep method) | ( when t gets the lock ) | t.resume();
Waiting State <- t2.join(); | t2.join(2000); | t2.join(2000, 200); | obj.wait(); | obj.wait(2000); | (waiting for the lock)
Sleeping State <- t.sleep(2000); | t.sleep(2000, 100);
Suspended State <- t.suspend();
Running State <- TS allocates processor |
Dead State <- run method the t thread completes | t.stop();
```

# Multithreading Enhancement

## ThreadGroup
Based on functionality we can group threads into a single unit,
which is nothing but threadgroup. That is threadgroup contains a group of threads.

In addition to thread, threadgroup can also contain sub-threadgroups.

The main advantage of maintaining thread in the form of threadgroup is that
we can perform common operations very easily.

```java
Thread.currentThread().getThreadGroup().getName(); // main method, main thread, main group
```

Every thread in java belongs to some group. main thread belongs to main group.

Every threadgroup in java is a child group of system group. Directly or indirectly.
System group access is root group for all java group.

'system group' contains several system level threads. Like :
- Finalizer
- Reference Handler
- Signal Dispatcher
- Attach Listener

system :
  - finalizer
  - reference handler
  - etc
  - main thread group
    - main thread
    - thread-0
    - etc
    - sub-threadgroup

```java
Thread.currentThread().getThreadGroup().getParent().getName();
// (main thread).(main thread group).(system thread group).(system);
```

ThreadGroup is a java class, present in java.lang package, and is directly child of Object.

- ThreadGroup g = new ThreadGroup(String gname);

Creates a new thread group with a specifed gname.
The parent of this new group is thread group of currently executing thread.

- ThreadGroup g = new ThreadGroup(ThreadGroup pgroup, String gname);

Creates a new threadgroup with a specified gname. The parent of the new threadgroup is pgroup.

- g.setMaxPriority(int pri);

Default value for a thread group of max priority is 10. Threads which have lower
than 10 they will be able to go into that group.
If after sometime group priority changes, threads were there earlier wouldnt get effected.
But new coming thread will have that maxpriority of thread group.
Thread default pri is 5. if priority of group is 3, then default for them will be 3.

#### Q: write a program to display all active thread names belongs system group and its child groups.
```java
ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
// Error: time of checking, time of using attack!
Thread[] threads = new Thread[system.activeCount()];
for (Thread t : threads) {
  sout(t.getName() + "--" + t.isDaemon());
}
```

## java.util.concurrent package
The problems with the synchronized keyword:

1. We are not having any flexibility to try for a lock without waiting.
2. There is no way to specifiy maximum waiting time for a thread to get lock.
so the thread will wait until getting the lock,
which may create performance problems, which may cause deadlock.
3. If a thread releases a lock, then which waiting thread will get that lock,
we are not having any control on this.
4. There is no API to list out all waiting threads for a lock.
5. Synchronized keywords compulsery we have to use either method level or block level,
and it is not possible to use across multiple methods.

To overcome these problems, some people introduced java.util.concurrent.locks package in 1.5 version.
It also provides several enhancements to the programmer to provide more control on concurrency.

## Lock Interface
Lock object is similar to implicit lock acquire by a thread to execute snychronized method/block.

Lock implementations more extensive operations than traditional implicit locks.

### Important methods of Lock Interface:
- void lock();

We can use this method to acquire a lock, if the lock is already available,
then immediately the thread will get the lock, if not available, it will wait until getting the lock.
It is exactly same behaviour of traditional synchronized keyword.

- boolean tryLock();

To acquire the lock without waiting.
If the lock is available, then the thread acquire the lock and returns true,
If the lock is not avail, then the method return false, and the thread can continue its execution normally,
in this case, thread will never enter into waiting state.

```java
if(l.tryLock()) {
  // perform safe operations
} else {
  // perform alternate operations
}
```

- boolean tryLock(long time, TimeUnit unit);

If the lock is available, then the thread will get the lock, and continue its execution.
If the lock is not available, then the thread will wait until specified amount of time.
Still if the lock is not available, then thread can continue its executions.

```java
// TimeUnit is an enum, present in java.concurrent package.
l.tryLock(1000, TimeUnit.MILLISECONDS)
```

- void lockInterruptibly();

Acquires the lock if avaiable, and returns immediately, if not available, it will wait.
While waiting if the thread is interrupted, then thread will NOT get the lock.

- void unlock();

To call this method, compulsary current thread should be owner of the lock.
Otherwise we will get runtime exception saying IllegalMonitorStateException

## ReentrantLock(C)
It is an implementation class of Lock interface, and it is direct child class of Object.

Reentrant means that a thread can acquire same lock multiple times without any issue.
Internally, reentrant increments thread's personal count, whenever we call lock method.
and decrements the count, whenever we call unlock method.
And the lock will be released when the count will be zero.

### Constructors of ReentrantLock
- ReentrantLock l = new ReentrantLock();
- ReentrantLock l = new ReentrantLock(boolean fairness);

creates a reentrantlock with the given fairness policy.
* If fairness is true, then longest waiting thread can acquire the lock if it is avaiable,
then it follow first come, first serve policy.
* If fairness is false, then which waiting thread can get the chance we cannot expect.
* Default value of fairness is false.

- int getHoldCount();

returns number of holds on this lock by current thread.

- boolean isHeldByCurrentThread();

returns true if only and if the lock is hold by the current thread.

- int getQueueLength();

return the number of threads waiting for the lock.

- Collection getQueuedThreads();

## Thread Pools (Executor Framework)
Creating a new thread for every job may create performance and memory problems,
to overcome these problem, we should go for thread pool.

Thread Pool is a pool of already created threads, ready to do our jobs.

Java 1.5 introduces thread pool framework to implement thread pools.

Thread Pool Framework is also known as Executor Framework.

```java
// We can create a thread pool as follows :
ExecutorService service = Executors.newFixedThreadPool(3);

// We can submit a runnable job by using sumbit method.
service.submit(job);

// We can shutdown executors service by shutdown method:
service.shutdown();
```

While designing web/application servers we can use thread pool concept.

Without thread pools, we have to create start and hand all threads.

## Callable(I) and Future
In case of Runnable job, thread will NOT return anything after completing the job.
If a thread requires to return some result after execution, then we should go for Callable.

```java
// Callable Interface contains only one method, which is call method.
public Object call throws Exception;
```

If we submit callable object to executors, then after compeleting the job,
thread returns an object of the type Future,
Future object can be used to return the result from the callable job.

# Thread Local
ThreadLocal class provides thread local variables.

ThreadLocal class maintains values per thread bases.

Each ThreadLocal object maintains a separate value like userid, transictionid,
for each thread that accesses that object(tl object).

Thread can access its local value, can manipulate its value, even can remove its value.

In every part of code which is executed by the thread, we can access its local variables.

Consider a servlet which invokes some business methods, we have a requirement to generate a unique transiction id,
for each and every request and we have to pass this transiction id to the business methods.
For this requirement we can use threadlocal to maintain a separate transiction id for every request, that is for every thread.

ThreadLocal class introduces in 1.2 version, and enhancened in 1.5 version.

ThreadLocal can be associated with thread scope.

Total code which is executed by the thread has excess to the correspending threadlocal variables

A thread can access its local variable and cannot access other thread's local variables.

Once a thread enter into dead state, all its variable by default available eligible for garbage collection.

- ThreadLocal tl = new ThreadLocal();

creates a thread local variable,

- Object get();

Returns the value of thread variable associated with current thread.

- Object initialValue();

Returns the initial value of thread local variable associated with the current thread.
Default implementation of this method returns null, to customize our initial value we have to override this method.

- void set(Object newValue);

- void remove();

It is a newly added in 1.5 version.

After removal if we are trying to access, it will reinitialize once again, its initialValue method.

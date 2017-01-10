# Multi-Threading
The operating system supports multitasking in a cooperative or preemptive manner.
In cooperative multitasking each application is responsible for relinquishing 
control to the processor to enable it to execute the other application.
Earlier versions of operating systems followed cooperative multitasking.
Modern operating systems such as W95, W98, WNT, and W2000 support preemptive multitasking.
In the preemptive type multitasking, 
the processor is responsible for executing each application in a certain amount of time called a timeslice.
The processor then switches to the other applications, giving each its timeslice.
The programmer is relieved from the burden of relinquishing control from one application to another.
The operating system takes care of it. 

To understand multithreading, the concepts process and thread must be understood.
A process is a program in execution.
A process may be divided into a number of independent units known as threads.
A thread is a dispatchable unit of work. Threads are light-weight processes within a process.
A process is a collection of one or more threads and associated system resources.
The difference between a process and a thread is shown in Fig.14.1.
A process may have a number of threads in it. A thread may be assumed as a subset of a process.

If two applications are run on a computer (MS Word, MS Access), two processes are created. 
Multitasking of two or more processes is known as process-based multitasking.
Multitasking of two or more threads is known as thread-based multitasking.
The concept of multithreading in a programming language refers to thread-based multitasking.
Process-based multitasking is totally controlled by the operating system.
But thread-based multitasking can be controlled by the programmer to some extent in a program.

## in Java
Java supports thread-based multitasking.
The advantages of thread-based multitasking as compared to process-based multitasking are given below:

* Threads share the same address space.
* Context-switching between threads is normally inexpensive.
* Communication between threads is normally inexpensive

## Ways of Creating Threads in Java
Threads are objects in the Java language.
They can be created by using two different mechanisms.

1. Create a class that extends the standard Thread class.
2. Create a class that implements the standard Runnable interface.


## Thread vs Runnable
It is a little confusing why there are two ways of doing the same thing in the threading API.
It is important to understand the implication of using these two different approaches.
By extending the thread class,
the derived class itself is a thread object and it gains full control over the thread life cycle.
Implementing the Runnable interface does not give developers any control over the thread itself,
as it simply deﬁ nes the unit of work that will be executed in a thread.
Another important point is that when extending the Thread class,
the derived class cannot extend any other base classes because Java only allows single inheritance.
By implementing the Runnable interface, the class can still extend other base classes if necessary.
To summarize, if the program needs a full control over the thread life cycle,
extending the Thread class is a good choice, 
and if the program needs more flexibility of extending other base classes,
implementing the Runnable interface would be preferable.
If none of these is present, either of them is ﬁne to use.


## Thread Life Cycle
* NEW
A thread that is just instantiated is in new state. When a start() method is invoked, the thread 
moves to the ready state from which it is automatically moved to runnable state by the thread scheduler.

* RUNNABLE (readyrunning)
A thread executing in the JVM is in running state. 

* BLOCKED
A thread that is blocked waiting for a monitor lock is in this state.
This can also occur when a thread performs an I/O operation and moves to next (runnable) state.

* WAITING
A thread that is waiting indeﬁ nitely for another thread to perform a particular action is in this state. 

* TIMED_WAITING (sleeping)
A thread that is waiting for another thread to perform an action for up to a speciﬁ ed waiting time is in this state. 

* TERMINATED (dead)
A thread that has exited is in this state.

At any given time, a thread can be in only one state. 
These states are JVM states as they are not linked to operating system thread states.
When the thread completes its execution, it will be moved to TERMINATED state.
A dead thread can never enter any other state, not even if the start() method is invoked on it.

## Thread Methods
The sleep() method causes the current thread to sleep for a speciﬁ ed amount of time in milliseconds:

```java
public static void sleep(long millis) throws InterruptedException
  // for example, the code below puts the thread in sleep state for 3 minutes:
  try {
    Thread.sleep(3 * 60 * 1000); // thread sleeps for 3 minutes
  } catch(InterruptedException ex){}
```


# Execution Control

- Units are smaller than a Thread.
- Creating a new Thread for each work of unit is not efficient.
- Thread startup cost doesnt need to be paid for each unit.
- Threads can be reused for processing units.

- Thread pools, worker and manager patterns, and executors

## Goal

- Tasks(work units) that can be scheduled without spinning a new thread for each
- Tasks have to be modeled as code that can be called(by executors), rather than
  directly as a runnable thread.

* Three different ways of modeling tasks:

1. Callable(I)
2. Future(I)
3. FutureTask(C)

### Callable Interface

- It represent a piece of code that can be called and returns a result.

### Future Interface

- Represent an asynchronous task.
- get() blocks if result is not yet available, get(timeout)
- calcel() before completion
- isDone() 

### FutureTask Class

- Is commonly used implementation of Future interface.
- Also implements Runnable.
- Can be fed to executors(calling run())

### ScheduledThreadPoolExecutor

- is the backbone of thread pool classes
- Extends ThreadPoolExecutor

### Executors

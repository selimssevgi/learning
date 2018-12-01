# Fork/Join Framework

- Came with java 7
- For leight-weight concurreny
- It allows a wide range of concurrent problems to be handled even more
  efficiently than the executors.

- Processor speeds have increased hugely, waiting for IO now a very common situation.
- FJF is all about the automatic scheduling of tasks on a thread pool that is
  invisible to the user.

### Fundamentals

- FJF introduces a new kinf of executor service, ForkJoinPool

- ForkJoinPool service handles a unit of concurrency(ForkJoinTask) that is
  smaller than a Thread.

- ForkJoinTask is an abstraction that can be scheduled in a more light-weight
  manner by ForkJoinPool.

- Fork/join usually makes use of two kinds of tasks:
  - Small tasks, can be performed straightaway without consuming too much CPU
  - Large tasks, need to be split up before can be directly performed

- Framework provides basic methods to support the splitting up of large tasks,
  and it has automatic scheduling and rescheduling.

- Divide and conquer: ForkJoinTask being splitted, bein scheduled in same threadpool

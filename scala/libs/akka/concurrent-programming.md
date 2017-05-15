# Concurrent Programming

## Concurrency

- Concurrency is when more than one task can start and complete in overlapping time periods
- You can write concurrent programs on a single CPU
- Multiple tasks are executed in a time-slice manner
- A concurrent program sometimes becomes a parallel program on multicore env

## Parallel Programming

- you can literally run multiple tasks at the same time
- it is possible with multicore processors

## Distributed Computing

- multiple computing nodes (computer or VM) spanned across network, working together
- A parallel process could be distributed process when it's running on multiple network nodes

## Challenges

- Only a handful of programmers know how to write a correct, concurrent
  application or program. The 'correctness' of the program is important

- Debugging multithreaded programs is difficult

- Threading encourages shared state concurrency: locks, semaphores, dependencies

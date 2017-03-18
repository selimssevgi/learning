# Concurrency Models

- A concurrency model specifies how threads in the system collaborate
  to complete the jobs they are given. Different models splits the jobs
  in different ways, and threads may communicate and collaborate in different ways.

- There are similarities between concurrency models and distributed system.
  In one of them threads are main player, in the other processes on different systems.

- Cus of similarities in their nature, they borrow ideas from each other.
  Models of distributing work among workers is often similar to models of load balancing in dis. sys.

* Parallel Workers Model
* Assembly Line Model
* Functional Parallelism Model

## Parallel Workers Model

           |- Worker
Delegator --- Worker
           |- Worker

If the parallel worker model was implemented in a car factory, each car would be
produced by one worker. The worker would get the specification of the car to build,
and would build everything from start to end.

!! Utilities in java.util.concurrent are designed for use with this model.

### Advantages
- Easir to understand
- Add more workers to increase parallelization of the application
- web crawler, IO instensive add more worker to keep CPU busy

### Disadvantages
- Shared resources is a big problem. Need to be sure data retrieved is fresh.
- If threads wait for accessing shared resources, some of the parallelization would be lost.
- Above problem could be solved with non-blocking algorithms, but they are hard to implement.
- Linked list are not a good way to store data, as they are spread on the computer memory
  a list implemented using array is much better for current CPU, as array is sequential data.
- If a worker is stateless, and doesnt keep state internally but re-reading data every time can make it slow.
- Job ordering is nondeterministic. Even a job given before another one, doesnt mean it is executed first.
  It makes it hard to reason about the state of the system at any given point in time.

## Assembly Line Model

- Other names for this model are 'reactive systems', or 'event driven systems'.

Delegator -> Worker -> Worker -> Worker

Each worker only performs a part of the full job.
When that part is finished, the worker forwards the job to the next worker.

Each worker is running in its own thread, and shared no state with other workers.
This is also sometimes referred to as as a 'shared nothing' concurrency model.

System using this model are usually designed to use non-blocking IO.
Worker does as much as it can before IO operation, then gives up, when the IO
operation is done, the other worker contunies with the job.

In reality a delegator can have multiple assembly line, can workers in different
lines can interact with each other.

The system's workers react to event occuring in the system, either received from outside world,
or emitted by other workers. Example of events, incoming HTTP request, file finished loading into memory.

### Some reactive/event driven platforms

- Vert.x -> Java
- Akka
- Node.JS

### Actor vs Channels

- Actors can send messages directly to each other.
- Messages are sent and processed asynchronously.
- Actors can be used to implement one or more job processing assembly lines.

- In the channel model, workers do not communicate directly.
- Instead they publish messages(events) on different channels.
- Other workers can then listen for messages on these channels w/o sender knowing who is listening.
- Channel model is more flexible.

### Advantages
- No Shared State  - Easir to implement, without so much concern
- Stateful Workers - Faster, can keep its state
- Better Hardware Conformity - Singlethread alike. Better usage of CPU, cache
- Job ordering is possible   - Rebuilding the state of the system from logs in case of fail.
                               The jobs are written to the log in a certain order.

### Disadvantages
- A job is often spread out over multiple workers, and thus over multiple classes
  it becomes harder to see exactly what code is being executed for a given job.
- Creating callback hell

Many jobs are not naturally parallel and independent though, so is better than parallel worker model

## Functional Parallelism Model

- The basic idea of functional parallelism is that you implement your programs using function calls.

- Function calls can be thought as sending messages.

- In function calls, all parameters passed to a function are copied,
  so no entity outside the receiving function can manipulate the data.

- This copying is essential to avoiding race conditions on the shared data.

- This makes the function execution similar to an atomic operation.

- Each function call can be executed independently of any other function call.

- When each function call can be executed independetly, each function call can be executed on separate CPUs.
  That means, that an algorithm implemented functionally can be executed in parallel, on multiple CPUs.

- ForkAndJoinPool, java 8 streams.

- The hard part about fparallelism is knowing which function calls to parallelize.
  Coordinating function calls across CPUs comes with an overhead.
  The unit of work completed by a function need to be a certain size to be worth this overhead.
  If function calls are very small, you get better performance in singlethreaded, single CPU execution.

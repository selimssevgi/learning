# Parallel Stream Notes

* Fork/Join Framework
  - Split a job into mini jobs
  - Thread execute the jobs
  - Aggregate the final result
  - Complex and complicated
  - Java 8 eases the pain

* Java 8 Parallelism
  - Uses Fork/Join Framework
  - The parallel method
  - Data split into chunks
  - Chunks are giving to Threads
  - Aggregated results combined
  - Final result spit out

* Splittable Iterator
  - Input data chunked up by Spliterator
  - Parallel processing splits
  - Default Spliterators for collections
  - Customization hardly needed
  - trySplit method
  - Another Spliterator offshoot

* Sequential to Parallel
  - Invoke parallel method
  - Uses the multi-cores
  - Mixing Sequential and Parallel
  - Free parallelisation out of the box
  - Single core to multi-core

* Parallel Execution
  - Type of Datasource(AL easy to split, LL hard to split)
  - Size of data
  - Stateful vs stateless operations
  - Measure and measure

# Cuncurrent Mark-Sweep(CMS)

- A Concurrent Collector performs garbage collection work concurrently with the
  application's own execution.

- A Parallel Collector uses multiple CPUs to perform garbage collection.

- A Stop-the-World collector performs garbage collection while the application
  completely stopped.

- An Incremental collector performs a garbage collection operation or phase as a
  series of smaller discrete operations with (potentially long) gaps in between.

- A Collector is Conservative if it is unaware of some object references at
  collection time, or is unsure about whether a field is a reference or not.

- A Collector is Precise if it can fully identify and process all object
  references at the time of collection.
  - A collector must be precise in order to move objects

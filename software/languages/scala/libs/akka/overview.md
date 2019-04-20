# Akka Overview

- makes it easier for developers to build correct, concurrent, scalable, and
  fault-torerant application

- provides a higher level of abstractions to deal with concurrency, scalability,
  and faults

- allows you to build next-generation, event-based, fault-tolerant, scalable,
  and distributed application for JVM

- Akka is an event-based platform and relies on actors for message passing and scalability

- Akka provides multiple concurrency abstractions
  - actors
  - STM
  - Agent
  - Dataflow

- 3 core modules provided by Akka: concurrency, scalability, and fault tolerance

```shell
# Akka Core Modules

+----------------------------------------------------------------------------+
| +-----------------+                                                        |
| | Fault-tolerance |                                                        |
| +-----------------+                                                        |
|                                                                            |
| +-------------+                                                            |
| | Supervision |                                                            |
| +-------------+                                                            |
+----------------------------------------------------------------------------+

+----------------------------------------------------------------------------+
| +-------------+                                                            |
| | Scalability |                                                            |
| +-------------+                                                            |
|                                                                            |
| +-------------+    +-------------+    +-------------+                      |
| |  Routing    |    |  Remoting   |    |  Cluster    |                      |
| +-------------+    +-------------+    +-------------+                      |
+----------------------------------------------------------------------------+

+----------------------------------------------------------------------------+
| +-------------+                                                            |
| | Concurrency |                                                            |
| +-------------+                                                            |
|                                                                            |
| +-------------+    +-------------+    +-------------+    +-------------+   |
| |   Actors    |    |     STM     |    |   Agents    |    |  Dataflow   |   |
| +-------------+    +-------------+    +-------------+    +-------------+   |
+----------------------------------------------------------------------------+
```

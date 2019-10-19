# reactive system

- reactive programming does not build a reactive system

- reactive system is an architectural style to build 'responsive distributed system'

- reactive systems could be seen as distributed systems done right

- a reactive system is characterized by four properties:

1. *responsive:* a reactive system needs to handle requests in a reasonable time
2. *resilient/fault-tolerant:* must stay responsive in the face of failures, so it must be
   designed for failures and deal with them appropriately.
3. *elastic/scalable:* must stay responsive under various oad. Consequently, it must
   scale up and down, and be able to handle the load with minimal resources
4. *message/event driven:* componenets from a reactive system interacts using async message passing

- Reactive Manifesto describes a reactive system.

- you can build a message-driven, resilient, scalable, and responsive
  application without using a reactive library or language.

- writing appications using RP is the easiest way to comply with the Manifesto.

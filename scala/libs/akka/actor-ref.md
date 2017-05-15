# ActorRef

- when creating an actor in Akka, you never get the direct reference to the actor
- you get back a handle to the actor called ActorRef

- purpose of ActorRef is to send messages to the actor it represents
- acts as a protection layer so one can't access the actor directly and mutate its state

- is serializable
- in case of crash, serialize the ActorRef, send it to another node, start the actor there


- there are different types of actor references:
  - local actor reference
  - remote actor reference

## Local Actor Reference

- all the actors running locally in a single JVM

## Remote Actor Reference

- actors running on another remote JVM

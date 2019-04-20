# ActorSystem

- An actory system is a hierarchical group of actors that sahre a common config

- It is also the entry point for creating and looking up actors

- actors need to be instantiated by creating an ActorSystem

- ActorSystem is the manager of one or more actors

- ActorSystem provides a method called 'actorOf'

```scala
import akka.actor.Props
import akka.actor.ActorSystem

val system = ActorSystem("greetings")

val a = system.actorOf(Props[GreetingsActor], name = "greetings-actor")

a ! Name("Selim")           // sending a message

// system.shutdown() // http://letitcrash.com/post/30165507578/shutdown-patterns-in-akka-2
```

- An ActorSystem is a heavyweight structure
- create one per logical subsystem

- Actors are very cheap
- can easily create millions of actors

## Guardian Actor

- at the top of the hierarchy
- created automatically with each actor system
- all other actors created by the given actor system become the child of the guardian actor

## Parent Actor

- each actor has one supervisor -- parent actor
- automatically takes care of the fault handling
- if an actor crashes, its parent will automatically restart that actor

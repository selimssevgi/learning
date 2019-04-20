# Actors

- Actors are Scala's alternative take on concurrent programming
- They provide as asynchronous model of concurrency
- They are based on passing messages between executing units of code
- An actor object, extends scala.actors.Actor, implements act() method
- Java's run() method of Thread
- The most important difference is that actors don't communicate using explicit
  shared data under most circumstances
- Sharing data between actors is something programmer should do as its part
- Sharing data between actors is considered bad style
- Actors have communication channel, called mailbox


*!! Deprecated. Use Akka.io*

```scala
// needs to be start()
class MyActor extends Actor {
  def act() {
    //...
  }
}

// Runnable/run()
// doesnot need to be start()
val myactor = actor {
  //...
}
```

## Mailbox

- Sending a msg into an actor from another object is very simple
- Just call ! method on the actor object
- On the other side, actor has to deal with the messages or they will pile up in mailbox
- The body of an actor usually needs to loop to handle all stream of incoming messages

- Make incoming messages immutable
- Consider making message types case classes
- Dont do any blocking operations within an actor

```scala
val myact = actor {
  while (true)  {
    receive {
      case incoming => println("I got mail: " + incoming)  
    }  
  }
}

myact ! "Hello"
```
## Lock-based

- Java's model of explicit locks and synchronization is old
- Balancing act between two unwanted outcomes
- Too little locking leads to unsafe concurrent mode(causes deadlock)
- Too much locking leads to failures of liveness(causes performance problems)
- Lock-based model requires one to think about all concurrent operations that
  could be in flight at a given time.(in big applications is a big problem)
- Java's backward compatibility promise, ties its hands

- Memory management support at runtime(GC), developer kept away from details
- New languages can provide features in runtimes that provide extra support for
  concurrency


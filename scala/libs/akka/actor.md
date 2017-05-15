# Actor

- is an object processes messages asynchronously and encapsulates state

- think of an actor as an object that:
  - processes a message (request)
  - encapsulates state (state is not shared with other actors)
  - performs an action in response to an incoming message

- actors communicate with each other through sending and receiving messages

- there are two main communication abstractions in actor:
  1. send      : send a message to an actor: a ! msg
  2. receive   : defined as a set of patterns matching messages to actions

- each other gets its own mailbox
- messages are stored in a queue and are processed FIFO

- What differentiates an actor from any other object is the ability to perform
  actions in response to an incoming message


```scala
import akka.actor.Actor

case class Name(name: String)

class GreetingsActor extends Actor {
  def receive = {
    case Name(n) => println("Hello" + n)
    case name: String => println("Hello " + name)
  }  
}
```

- You can use Promise to complete a Future by providing the result

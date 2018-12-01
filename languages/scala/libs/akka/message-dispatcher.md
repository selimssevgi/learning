# MessageDispatcher

- Every actor system comes with a default MessageDispatcher component

- its responsibility is to send a message to the actor's mailbox and execute the actor by invoking receive block

- every MessageDispatcher is backed by a thread pool, can be configured


## Sending a Message

- to send a message to an actor mailbox, the ActorRef first send the message to
  the MessageDispatcher associated with the actor

- MessageDispatcher immediately queues the message in the mailbox of the actor

- The control is immediately returned to the sender of the message

## Handling a Message

- When an actor receives a message in its mailbox, MD schedules the actor for execution

- Sending and handling messages happens in two different threads

- if a free thread is available in the thread pool, that thread is selected for execution

- if all threads are busy, the actor will be executed when threads becomes available


- the available thread reads the messages from the mailbox


- the receive method of the actor is invoked by passing one message at a time


**NOTE:** MD always makes sure that a single thread always executes a given
actor. It might not be the same thread all the time but it is always going to
be one. This is a huge guarantee to have in the concurrent work because now you
can safely use mutable state inside an actor as long as it's not shared.

## Types of Message Dispatchers

- Akka comes with four types of message dispatchers:

1. Dispatcher:
   - default one used by the actor system
   - event-based
   - binds actors to a thread pool
   - creates one mailbox per actor

2. PinnedDispatcher:
   - dedicates one thread per actor
   - like creating thread-based actors

3. BalancingDispatcher:
   - event-driven
   - redistributes work from busy actors to idle actors
   - all actors all same type share one mailbox

4. CallingThreadDispatcher:
   - runs the actor on the calling thread
   - doesnt create any new thread
   - great for unit testing purposes

# Spring Messaging Overview

- sometimes it is necessary to talk to someone directly
  - if you injure yourself and need an ambulance, calling is better than emailing to hospital

- often, sending a message is sufficient and offers some advantages over direct communication

- we services(soap, rmi, hessian) enable communication between application
  - all of these mechanisms employ synchronous communication

- synchronous communication has its place, but it is not the only style

- asynchronous messaging is a way to indirectly sending messages from one
  application to another without waiting for the response

- synchronous: client should wait until other other application returns response
- asynchronous: client does not wait, send the message and contineous

### sending messages

- post service

- the key to the postal service is indirection

- we do not delivery the pack directly to other party, that would be a lot of trouble for us
- the postal service will delivery the pack for us while we go about our lives

- similarly, indirection is the key to asynchronous messaging
- when one application sends a message to another, there is no direct link between the two applications
- instead, the sending application places the message in the hands of a service that will ensure delivery to the receiving application

- there are two main actors in asynchronous messaging:
  - message brokers
  - destinations

- when an application sends a message, it hands it off to a message broker
- a message broker is analogous to the post office
- asynchronously sent message are addressed with a destination
- destionations are like mailboxes where messages are placed until someone comes to pick them up

- there are two common types of destinations:

1. point-to-point messaging (for queues)

- each message has exactly one sender and one receiver
- message broker places the message in a queue
- when someone asks for it, it pulls it from the queue and delivered to the receiver
- because it removed from the queue, it is guaranteed to be delivered to only one receiver

- this is analogous to waiting in line at the bank

2. publish-subsribe messaging (for topics)

- all subscribers to a topic receive a copy of the message

### limitation of synchronous communication

* synchronous communication implies waiting
* the client is coupled to the service through the service's interface(changes affect both sides)
* the client is coupled to the service's location
* the client is coupled to the service's availability

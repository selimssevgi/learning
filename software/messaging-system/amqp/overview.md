# Advanced Message Queuing Protocol

- isn't JMS good enough?
- what does AMQP bring to the table that is missing from JMS?

- AMQP offers several advantages over JMS:

1. AMQP defines a wire-level protocol for messaging
  - whereas JMS defines an API specification

- JMS doesnot mandate that message sent by one JMS implementation can be consumed by a different JMS implementation
- AMQP's wire-level protocol specifies the format that messages will take when
  en route between the producer and consumer.

- AMQP is more interoperable than JMS (across implementations, languages and platforms)

2. AMQP has a much more flexible and transparent messaging model

- with JMS, there are only two messaging models to choose from:
  - point-to-point and publish/subsribe

- both of those ways are possible with AMQP, but it also enables other ways
  - AMQP enables you to route messages in a number of ways
  - it does this by decoupling the message producer from the queue(s) in which the messages will be placed

### Messaging Models

##### JMS messaging model

- in JMS, there are three primary participants:
  - the mesasge producer,
  - the message consumer(s),
  - a channel (either a queue or a topic)

- in JMS, the channel helps to decouple the producer from the consumer, but both
  are still coupled to the channel

- the channel has the double duty of relaying messages and determining how those
  messages will be routed (queues, and topics)

##### AMQP messaging model

- AMQP producers don't publish directly to a queue

- AMQP introduces a new level of indirection between producer and any queues
  that will carry the message: *the exchange*

- a message producer publishes a message to an exchange
- the exchange, which is bound to one or more queues, routes the message to the queue(s)

- consumers pull messages from the queue and process them

- the exchange is not a pass-through mechanism to a queue

- AMQP defines four different types of exchanges, each with a different routing
  algorithm that decides whether to place a message in a queue

- the four standard types of AMQP exchanges:

1. Direct: a message will be routed to a queue if its routing key is a direct
   match for routing key of the binding

2. Topic: a message will be routed to a queue if its routing key is a wildcard
   match for the routing key of the binding

3. Headers: if the headers and values in its table of arguments match those in
   the binding's table of arguments, x-match: all or any

4. Fanout: a message will be routed to all queues that are bound to the
   exchange, regardless of the routing key or headers/values in the table of arguments

# Exchanges

- Exchanges are AMQP entities where messages are sent to Mbroker

- RabbitMQ offers 4 types of exchanges:

1. Direct Exchanges
2. Fanout Exchanges
3. Topic Exchanges
4. Header Exchanges

* Exchange attribes

-------------------------------------------------------------
Name         | The name of the exchange
Durability   | Persisting the messages to disk
Auto-Delete  | Delete message when not needed
Arguments    | These are message broker-dependent

## Default Exchange / Nameless Exchange

- Sends messages to their own queue
- In client api, it is empty string("")

## Direct Exchange

- delivers messages to queues that are based on the message routing key

- is ideal if you want to publish a msg onto just one queue

* Works as follows:

1. Queue binds to the exchange with a routing key(payment-requests)

2. when a message arrives at the direct exchange, the exchange routes the
   message onto the queue, if both keys match.


- Direct queues are commonly used to distribute messages between multiple work
  processes in a round robin manner.

## Fanout Exchange

- routes messages to all queues that are bound to it

- unlike Direct exchange, a routing key is ignored

- is ideal for the broadcast routing of messages

- examples: online game scores to all players, sending weather updates, chat
  sessions between groups of people

## Topic Exchange

- routes messages to one or many queues based on matches between the message
  routing key, and a pattern that was used to bind queue to an exchange.

- used to implement pub/sub pattern variations

- a wild carded routing key can be used (all.payroll.\*)

- is powerful, can behave like direct and fanout exchanges

## Header Exchange

- for routing multiple attributes that are expressed in headers

- routing key are ignored for this kind of exchange

- can be seen as superchanged direct exchanges

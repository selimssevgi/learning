# Apache Kafka Topics

- Central Kafka abstraction

- Named feed or category of messages(like a mailbox)
- Producers produce to a topic
- Consumers consume from a topic

- Logical entity 

- Physically represented as a log

- Topics can span an entire cluster of Brokers for benefit of scalability and fault-tolerance.

- When a producer sends a message to a Kafka topic, the messages are appended to
  a time-ordered sequential stream

- The events are immutable, when received by a Broker, cannot be changed

- Event sourcing: capturing all changes as a seq of time-ordered, immutable events


## Message Content

- timestamp: that is set when the message is received by a Kafka Broker

- Referenceable identifier: a message received gets a unique identifier

- Payload(binary)

- The combination of timestamp and id from its placement in the seq of messages
  received within a topic

## Message Offset

- It is how consumers can read messages at their own pace, and process them independently

- It is a placeholder: like a bookmark that maintains the last read position

- The offset is entirely establish and maintained by the consumer

- The offset itself refers to a message identifier

- A consumer can request to start from beginning to read the topic

- When other messages arrive, the connected consumer will receive an event
  indicating there is a new message and it can advance its position once it
  retrieves the new message

## Message Retention Policy

- Kafka is immune to one of the challenges of most messaging systems: slow consumers

- All published messages are retained by a Kafka cluster regardless if a single
  has consumed a message.

- Retention period is configurable(default is 168 hours or 7 days)

- Retention period is defined on a per-topic basis

- Physical storage resources can constrain message retention

## Transaction or Commit Logs

- Append-only
- Ordered sequenece (by time)
- Immutable facts as events

* Kafka is publish-subscribe messaging rethought as a *distributed commit log*

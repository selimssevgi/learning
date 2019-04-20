# What is Apache Kafka?

- A high-throughput distributed messaging system.
- Designed to move data at high volumes

- Addresses shortcomings of traditional data movement tools and approaches

- In computing, a common term for transferring data is 'messaging'

- Kafka describes itself as a messaging system

- Kafka can be used for vast amount of data need to be moved in a scalable, fault tolerant way.

## (Current) Messaging

- Limited scalability: message broker is the bottleneck

- Smaller messages: larger messages can put severe strain on message brokers

- Requires rapid consumption: message broker expects messages to be consumes at a resonable rate

- On Fault tolerance: If a consumer pops smth off the queue,or reads it from a
  topic, it's probably gone. If the consumer loses the message or processes it
  incorrectly, it is extremely difficult to get it back to reprocess.

## Perils of Messaging under high volume

- Publishers(app) -> broker -> consumers (app)

- High volume, message size, no throttle ->
- Single host, local storage, message buildup ->
- No consumption, slow consumption?


## Is there a better way?

* To move data around:

- Cleanly: without a complex web of different integration topologies

- Reliably: as to reduce the impact of any one component's slowness or availability on the system

- Quickly: as data movement and access is only getting faster for real-time use cases

- Autonomously: reducing the coupling between components so can improve or
  change parts of the system without a cascading effect.


## Beginning

- LinkedIn was looking a better way for their data movement in 2010
- It started as a internal project in 2009
- LinkedIn used it in deployment in 2010
- Opensourced in 2011

## Next-generation Messaging Goals

- High throughput
- Horizontally scalable
- Reliable and durable
- Loosely coupled Producers and Consumers
- Flexible publish-subscribe semantics

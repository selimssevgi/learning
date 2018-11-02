# Advanced Message Queue Protocol

- RabbitMQ suports version 0-9-1


- *Publisher* publish to *Message Broker*(Exchange + Routes + Queue)

- *Exchange* receives the published message and *Routes* to *Queue*

- *Consumer* consumes the messages from a queue

* Exchange is like a mailbox
* Exchange sends message to a queue by using different rules called *bindings*

## Network Failure

- AMQP has a mechanism for message acknowlegments

- Message Broker removes the message from the queue when it receives a
  notification for that message.

# Publish and Subscribe

- send same message to many consumer

- In Worker Queue all consumer share the load(different messages to multiple consumers)

- In pub/sub, only interested consumers receive messages.

- Exchange routes messages bounded queues and consumer receive messages from their queue.

- Worker queue uses the default exchange.

- In pub/sub, we need an explicit exchange in type of fanout

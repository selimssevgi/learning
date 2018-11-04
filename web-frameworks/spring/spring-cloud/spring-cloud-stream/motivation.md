# Spring Cloud Stream

- If messaging systems like Kafka or RabbitMQ is used in Spring, it requires a
  lot of configuration code, which is Broker specific.

- Spring Cloud Stream abstract over the messaging systems so that they can be
  used without providing specific configuration for each tool.

- Having required dependencies is easy for Spring to configure the messaging system


```shell
SCStream <-- inputs  --- Binder <-- Messaging System
SCStream --- outputs --> Binder --> Messaging System
```

- Binder is the abstraction of Spring Cloud Stream

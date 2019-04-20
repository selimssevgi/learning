# Spring Cloud Stream

- framework to build highly scalable event-driven and/or streaming microservices

- Provides boot-driven integration with Messaging Brokers using Destination Binders

- leverages native features of brokers while also providing a workarounds for not supported features.
  - Partitioning
  - Consumer groups (kafka supports natively, rabbit does not)
  - Message headers
  - Destination provisioning

- honors application configurations by the underlying frameworks (spring-integration, spring-kafka etc)

- transparent content-type negatiation and argument resolution(default content type is json)

# Integrating Bounded Contexts

## Integration Basics

- When two Bounded Contexts need to integrate, there are a few reasonably
  straigtforward ways this can be done in code.

1. SOAP
2. Messaging Queue
3. REST

- One such approach is for a BContext to expose an API, and another BContext to
  use that API via RPCs.

- The API could made available using SOAP.


- The second approach is through the use of a messaging mechanism.

- Each of the systems that need to interact do so through the use of a message
  queue or a Publish-Subscribe.


- A third way to integrate is by using RESTful HTTP.

## Distributed Systems Are Fundamentally Different

- All developers working within distributed systems will succeed or fail by
  following Principles of Distributed Computing:

1. The network is not reliable.
2. There is always some latency, and maybe a lot.
3. Bandwidth is not infinite.
4. Do not assume that the network is secure.
5. Network topology changes.
6. Knowledge and policies are spread across multiple administrators.
7. Network transport has cost.
8. The network is heterogeneous.

## Integration using RESTful Resource

- When a BContext provides a rich set of RESTful resources through URIs, it is a
  kind of Open Host Service:

"Define a protocol that gives access to your subsystem as a set of services.
Open the protocol so that all who need to integrate with you can use it. Enhance
and expand the protocol to handle new integration requirements." [Evans]

- Since the RESTful service provider must be directly interacted with whenever a
  resource is operated on, this style does not permit clients to be completely
  autonomous.

- A messaging system can be used to have consumers be autonomous.

- Shielding the integrators from the details of understanding the domain model
  would ultimately increase their productivity and make their dependent
  BContexts more maintainable.

## Implementing the REST Client Using an Anticorruption Layer

- When we are focused on the goals of DDD, the representation will not be
  consumed as is in the client Bounded Context.

- Here we may not need to sychronize data with up stream.

## Integration Using Messaging

- A message-based approach to integration can allow any one system to achieve a
  higher degree of autonomy from systems it depends on.

- One of the ways that DDD can be leveraged to make systems autonomous is
  through the use of Domain Events.

(Read again)

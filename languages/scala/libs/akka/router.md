# Routers

- when an actor is processing a message, other messages are waiting in the
  mailbox for processing

- if multiple instances of the actor could be created, messages could be processed in parallel

- messages have to be routed to these actors effectively so some actor dont get overloaded

- how will caller know which actor instance has the fewest messages to process?

- Akka has some special kinds of actors called routers

- routers can effectively route messages between multiple instances of actors

- router actor acts as a gateway to a collection of actors

- you send a message to the router actor, it forwards the msg to one of the
  actors based on some routing policy

```scala
val cheapestDealFinderLoadBalancer = system.actorOf(
  Props[CheapestDealFinder]
    .withRouter(SmallestMailBoxRouter(nrOfInstances = 10)),
  name = "cheapest-deal-finder-balancer")

val internalPriceCalculators: List[ActorRef] =
  createInternalPriceCalculators(10)

val internalLoadBalancer = system.actorOf(
  Props[InternalPriceCalculator]
    .withRouter(RoundRobinRouter(routees = internalPriceCalculators)),
  name = "internal-load-balancer")

```

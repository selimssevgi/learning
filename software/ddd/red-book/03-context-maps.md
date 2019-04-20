# Context Maps

There are several DDD organizational and integration patterns, one of which
commonly exists between two Bounded Contexts.

### Partnership

When teams in two Contexts will succeed or fail together, a cooperative
relationship needs to emerge. The teams institute a process for coordinated
planning of development and joint management of integration. The teams must
cooperate on the evolution of their interfaces to accommodate the development
needs of both systems. Interdependent features should be scheduled so that they
are completed for the same release.


### Shared Kernel

Sharing part of the model and associated code forms a very intimate
interdependecy, which can leverage design work or undermine it. Designate with
an explicit boundary some subset of the domain model that the teams agree to
share. Keep the kernel small. This explicit shared stuff has special status and
shouldn't be changed without consultation with the other team. Define a
continuous integration process that will keep the kernel model tight and align
the ULanguage of the teams.

### Customer-Supplier Development

When two teams are in an upstream-downstream relationship, where the U team may
succeed interdependently of the fate of the D team, the needs of the D team come
to be addressed in a variety of ways with a wide range of consequences. D
priorties factor into U planning. Negotiate and budged tasks for D requirements
so that everyone undersntands the commitment and schedule.

### Conformist

When two development teams have a U/D relationship in which the U team has no
motivation to provide for the D team's needs, the D team is helpless. Altruism
may motivate U developers to make promises, but they are unlikely to be
fulfilled. The D team eliminates the complexity of translation between bounded
contexts by slavishly adhering to the model of the U team.

### Anticorruption Layer (AL)

Translation layers can be simple, even elegant, when bridging well-designed
Bounded Contexts with cooperative teams. But when control or communication is
not adequate to pull off a shared kernel, partner, or customer-supplier
relationship, translation becomes more complex. The translation layer takes on a
more defensive tone. As a downstream client, create an isolating layer to
provide your system with functionality of the upstream system in terms of your
own domain model. This layer talks to the other system through its existing
interface, requiring little or no modification to the other system. Internally,
the layer translates in one or both directions as necessary between the two
models.

### Open Host Service (OHS)

Define a protocol that gives access to your subsystem a set of services. Open
the protocol so that all who need to integrate with you can use it. Enhance and
expand the protocol to handle new integration requirements, except when a single
team has idiosyncratic needs. Then, use a one-off translator to augment the
protocol for that special case so that the shared protocol can stay simple and
coherent.

* This pattern can be implemented as REST-based resources that client Bounded
  Contexts interact with. We generally think of OHS as a RPC API, but it can be
  implemented using message exchange.

### Published Language (PL)

The translation between the models of two Bounded Contexts requires a common
language. Use a well-documented shared language that can express the necessary
domain information as a common medium of communication, translating as necessary
into and out of that language. Published Language is often combined with Open
Host Service.

* This can implemented in a few different ways but is many times done as an XML
  schema. When expressed with REST-based services, the PL is rendered as
  representations of domain concepts. Representations may include both XML and
  JSON, for example. It is also possible to render representations as Google
  Protocol Buffers If you publishing Web UI, it might also include HTML
  representations. One advantage to using REST is taht each client can specify
  its preferred PL, as the resources render representations in the requested
  context type. REST also has the advantage of producing hypermedia
  representations, which facilitates HATEOAS. A PL is also used in a
  Event-Driven Architecture, where Domain Events are delivered as messages to
  subscribing interested parties.























### Separate Ways

We must be ruthless when it comes to defining requirements. If two sets of
functionality have no significant relationship, they can be completely cut loose
from each other. Integration is always expensive, and sometimes the benefit is
small. Declare a bounded context to have no connection to the others at all,
enabling developers to find simple, specialized solutiins within this small
scope.

### Big Ball of Mud:

As we survey existing systems, we find that, in fact, there are parts of
systems, often large ones, where models are mixed and boundaries are
inconsistent. Draw a boundary around the entire mess and designate it a Big Ball
of Mud. Do not try to apply sophisticated modeling with this Context. Be alert
to the tendency for such systems to sprawl into other Contexts.

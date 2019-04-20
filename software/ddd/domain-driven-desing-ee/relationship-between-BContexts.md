# Relationships between Bounded Contexts

1. Shared Kernel

2. Customer/supplier relationship

3. Separate ways

4. Open host services

5. Anticorruption layers

## Shared Kernel

Uncoordinated teams working on closely related applications can go racing
forward for a while, but what they produce may not fit together. They can end up
spending more on translation layers and retrofitting than they would have on CI
in the first place, meanwhile duplicating effort and losing the benefits of a
common UBIQUITOUS LANGUAGE.

Designate some subset of the domain model that the two teams agree to share. Of
course this includes, along with this subset of the model, the subset of code or
of the db design associated with that part of the model. This explicitly shared
stuff has special status, and shouldnt be changed without consulation with the
other team.

The SHARED KERNEL is often the CORE DOMAIN, some set of GENERIC SUBDOMAINS, or
both, but it can be any part of the model that is needed by both teams. The goal
is to reduce duplication.

## Customer/Supplier Development Teams

- Upstream / Downstream

- Two different teams

- Agree on who will do what in session

- write and share test suites to verify agreed interface

- Upstream has no dependencies on the downstream

- Tools/technologies can be different between upstream and downstream

### Conformist

- U/D are directed by different companies/managers

- U does not care about D much.

- Downstream is by its own. Upstream wont provide what they want

* Three options:

1. To abandon use of the upstream alttogether (SEPARATE WAYS)

2. U provides a design is very difficult to work with(lack of encap, awkward
   abstraction), downstream has create its own model and translation layer (ANTICORRUPTION LAYER)

If the provided interface is large, better to follow the lead of the component's
model. when your interface with a component is small, sharing a unified model is
less essential, and translation is viable option. When the interface is large
and integration is more significant, it usually makes sense to follow the leader.

- SHARED KERNEL is a collaboration between two teams that coordinate tightly,
  CONFORMIST deals with integration with a team that is not interested in
  collaboration.

## ANTICORRUPTION LAYER

- The Great Wall

When a new system is being built that must have a large interface with another,
the difficulty of relating the two models can eventually overwhelm the intent of
the new model altogether, causing it to be modified to resemble the other
system's model, in ad hoc fashion. The models of legacy systems are usually
weak, and even the exception that is well developed may not fit the needs of the
current project. Yet there may be a lot of value in the integration, and
sometimes it is an absolute requirement.

- When systems ased on different models are combined, the need for the new
  system to adapt to the semantics of the other system can lead to a corruption
  of the new system's own model.

- Even when the other system is well designed, it is not based on the same model
  as the client.

Create an isolating layer to provide clients with functionality in terms of
their own domain model. The layer talks to the other system through its existing
interface, requiring little or no modification to other system. Internally, the
layer translates in both directions as necessary between the two models.

- ANTICORRUPTION LAYER, which is not a mechanism for sending messages to another
  system. Rather, it is a mechanism that translates conceptual objects and
  actions from one model and protocol to another.

## Separate Ways

- We must ruthlessly scope requirements. Two sets of functionality with no
  indispensable relationship can be cut loose from each other.

Integration is always expensive. Sometimes the benefit is small.

Declare a BOUNDED CONTEXT to have no connection to the others at all, allowing
developers to find simple, specialized solutions within this small scope.

## Open Host Service

When a subsystem has to be integrated with many others, customizing a translator
for each can bog down the team. There is more and more to maintain, and more and
to worry about when changes are made.

Define a protocol that gives access to your subsystem as a set of SERVICES. Open
the protocol so that all who need to integrate with you can use it. Enhance and
expand the protocol to handle new integration requirements, except when a single
team has idiosyncratic needs. Then, use a one-off translator to augment the
protocol for that special case so that the shared protocol can stay simple and
coherent.

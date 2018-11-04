# Event Sourcing

- In the real world you observe events

- In software, you tend to write models

It's about ensuring that all changes made to the application state during the
entire lifetime of the application are stored as a sequence of events.

- Events:
  - are immutable
  - helps you not to miss a thing
  - can be replayed


## Key Points

- Events

- Events as "Data Source"

- Build "Projects" of Event Data

## Key Facts of Event Sourcing

- An event is something that has happened in the past

- Events are expression of the ubiquitous language

- Events are not imperative and are named using past tense verbs

- Have a persistent store for events (append-only, no delete)

- Replay the (related) events to get to the last known state of an entity

- Replay from the beginning or a know point (snapshot)

## An Event is Something that Happened in the Past

- Once stored, events are immutable
  - can be duplicated and replicated (for scalability reasons)

- Any behavior associated with the event has been performed
  - replaying the event doesn't require to repeat the behavior

- You don't miss a thing
  - track everything that happened at the time it happened
  - regardless of the effects it produced


## Power to Events

#### Approach 1

1. Store current state
2. Use events to log relevant facts


#### Approach 2

1. Store events
2. Build relevant snapshots of facts


* Commads submitted by the user form a natural stream of events
* Commands(Event stream), Queries(Orders table)

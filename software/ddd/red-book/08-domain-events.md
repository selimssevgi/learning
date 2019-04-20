# Domain Events

- Use a Domain Event to capture an occurrence of something that happened in the
  domain.

- Consider a few key pharases to listen for when domain expers talk:

* "When ..."
* "If that happens ..."
* "Inform if ..." and "Notify me if ..."
* "An occurrence of ..."

- When Events are delivered to interested parties, in either local or foreign
  systems, they are generally used to facilitate eventual consistency.

- This is purposeful and by design. It can eliminate the need for two phase
  commits (global transactions) and support of the rules of Aggregates.

- One rule of Aggregates state that only a single instance should be modified in
  a single transactions, and all other dependent changes must occur in separate
  transactions. So other Aggregate instances in the local BContext may be
  synchronized using this approach.

```shell
Command operation: BacklogItem#commitTo(Spring aSpring)
Event outcome: BacklogItemCommitted
```

- The Event name states what occurred(past tense) in the Aggregate after the
  requested operation succeeded.

- After the right name is found, we need a timestamp that indicates when the
  Event  occurred.


```java
public interface DomainEvent {
  Date occurredOn();
}
```

- Also we could include the identity of the Aggregate instance

```java
public class BacklogItemCommitted implements DomainEvent {
  private Date occurredOn;
  private BacklogItemId backlogItemId;
  private SprintId committedToSprintId;
  private TenantId tenantId;
}
```

- Event is usually designed as immutable. So, it should get everything it needs
  through constructor and provide accessors.

* It might be easiest to identify Aggregates that have dependencies on the state
  of other Aggregates, where  eventual consistency is necessary.

- In simple scenario of same Bounded Context for Events could be Pub-Sub pattern

- There is an example in the book

## Spreading the News to Remote Bounded Context

- There are several possible ways for remote BContext to become aware of Events
  that occur in your BContext.

- The primary idea is that some form of messaging takes place, and enterprise
  messaging mechanism is needed.

- There are numerous such messaging components available, and they are generally
  classed as middleware. ActiveMQ, RabbitMQ, Akka.

- The use of any such messaging mechanism between BContexts requires that we
  adopt a commitment to eventual consistency.

## Event Store

- Maintaining a store of all Domain Events for a single BContext has several
  potential benefits.

- Consider what you could do if you were to store a discrete Event for every
  model command behavior that is ever executed. You could:

1. Use the EStore as a queue for puslishing all Domain Events through a
   messaging infrastructure. It allows integrations between BContexxts, where
   remote subscribers react to the Events in terms of their own contextual needs

2. You may use the same Event Store to feed REST-based Event notifications to
   polling clients.

3. Examine a historical record of the result of every command that has ever been
   executed on the model.

4. Use the data in trending, forecasting, and for other business analytics.

5. Use the Events to reconstitute each Aggregate instance when it is retrieved
   from its Repository. This is a required part of what is known as Event
   Sourcing.

6. Given an application of the preceding point, undo blocks of changes to an
   Aggregate.




-  when using an Event Store, one of the first things we need to do is create a
   subscriber that will receive every Event that is published out of the model.
   An aspect-oriented hook can be inserted in the execution path of every
   Application Service in the system.

- Publishing events through REST API (Publish-Sub)

- Publishing notification through Messaging Middleware (RabbitMQ) (P/S, Queues)


** Notification is an application concern(Application Service), not a domain
concern, even though the Events being pusblished as notifications as originated
in the model.

### Event De-duplication

- De-duplication is a necessity in environments where a single message published
  through a messaging system could possibly be delivered to subscribers more
  than once. There are various causes of duplicate messages.

1. RabbitMQ delivers the newly sent messages to one or more subscribers.

2. The subscibers process the messages.

3. Before subscribers can acknowledge that the messages were received and
   processed, they fail.

4. RabbitMQ delivers the unacknowledged messages again.

- One way to deal with the possibility of duplicate message delivery is for
  subscriber model operation to be idempotent.

- When domain object idempotence is not a viable option, you can instead design
  the subscriber/receiver itself to be idempotent.

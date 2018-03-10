# Aggregates

- Minimalist design of associations helps simplify traversal and limit the
  explosion of relationships somewhat, but most business domains are so
  interconnected that we still end up tracing long, deep paths through object
  references.

- It is difficult to guarantee the consistency of changes to objects in a model
  with complex associations. Invariants need to be maintained that apply to
  closely related group of objects, not just discrete objects. Yet cautious
  locking schemes cause multiple users to interfere pointlessly with each other
  and make a system unusable.

- We need an abstraction for encapsulating references within the model.

- An AGGREGATE is a cluster of associated objects that we treat as a unit for
  the purpose of data changes.

- Each AGGREGATE has a root and a boundary.

- The boundary defines what is inside the AGGREGATE.

- The root is a single, specific ENTITY contained in the AGGREGATE.

- The root is the only member of the AGGREGATE that outside objects are allowed
  to hold references to, although objects within the boundary may hold
  references to each other.

- ENTITIES other than the root have local identity, but that identity needs to
  be distinguishable only within the AGGREGATE, because no outside object can
  ever see it out of the context of the root ENTITY.

- No one will try to query the system to find a particular tire and then see
  which car it is on. They will query the database to find a car and then ask it
  for a transient reference to the tires.

### Example

```java
@Entity
public class Invoice {
  @OneToMany
  @JoinTable
  private List<InvoiceItem> items;
}
```

- There is no InvoiceItem in the system that does not belong to Invoice so we
  clearly have a life cycle dependency one object into another.

- The aggreate here is Invoice becuase it has a lifecycle of its own.

- The InvoiceItem is mapped to an db table, but it can not survive without an
  invoice, if you you the delete the invoice, you delete all the items too.

- Nobody from outside should be allowed to manipulate items, because only the
  aggregate can manipulate the internal objects of its implementation.

- You only provide repositories to save aggregates.

- Entities in ddd terminology should not have repositories, only aggregates.

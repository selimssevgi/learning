# Aggregates

- Is an aggregate just a way to cluster a graph of closely related object under
  a common parent?

- Is there some practical limit to the number of objects that should be allowed
  to reside in the graph?

- Since one Aggregate instance can reference other Aggregate instances, can the
  associations be navigated deeply, modifying various objects along the way?

- What is the concept of 'invariants' and a 'consistency boundary' all about?

### A very Large Aggregate

```java
public class Product extends ConcurrencySafeEntity {
  private Set<BacklogItem> backlogItems;
  private String description;
  private String name;
  private ProductId productId;
  private Set<Release> releases;
  private Set<Sprint> sprints;
  private TenantId tenantId;

  // CQS commands: they modify Product's state by adding new element to a collection
  // so they have a void return type
  public void planBacklogItem(...) {}

  public void scheduleRelease(...) {}

  public void scheduleSprint(...) {}
}
```

- This model could have concurrency and scalability issues.

- Two different users load Product, an in order modify state, the later one is
  going to be failed to commit, because of @Version number.

## Multiple Aggregates

- Aggregate roots: Product, BacklogItem, Release, Sprint

```java
public class Product extends ConcurrencySafeEntity {
  // ...

  // CQS query contract and act as Factories
  public BacklogItem planBacklogItem(...) {}

  public Release scheduleRelease(...) {}

  public Sprint scheduleSprint(...) {}
}
```

- Application service loads a Product instance, create a BacklogItem and saves
  it by using BacklogItemRepository.

- In this way the transaction failure issue is solved by 'modeling it away'

** Disadvantage:

Even with clear transactional advantages, the four smaller Aggregates are less
convenient from the perspective of client consumption.

We could tune the large Aggregate to eliminate the concurrency issues, by
setting Hibernate mapping 'optimistic-lock' to false. There is no invariant on
the total number of created BacklogItem, Releases, or Sprint instances. The
problem with that approach is that it could grow out of control.

### Rule: Model True Invariants in Consistency Boundaries

- An invariant is a business rule that must always be consistent.

- There are different kinds of consistency.

* transactional consistency: immediate and atomic (invariant)

* eventual consistency: 

#### Transactional Consistency

- When discussing invariants, we are referring to transactional consistency.

```shell
c = a + b
```

- when a is 2 and b is 3, c must be 5. According to that rule and conditions, if
  c is anything but 5, a system invariant is violated. To ensure that c is
  consistent, we design a boundary around these specific attributes of the model:

```shell
AggregateType1 {
  int a;  
  int b;  
  int c;  
}
```

- The consistency of everything outside this boundary is irrelevent to the
  Aggregate. Thus, Aggregate is synonymous with 'transactional consistency boundary'

When employing a typical persistence mechanism, we use a single transaction to
manage consistency. When the transaction commits, everything inside one boundary
must be consistent. A properly designed Aggregate is one that can be modified in
any way required by the business with its invariants completely consistent
within a single transaction. And a properly designed Bounded Context modifies
only one Aggregate instance per transaction in all cases.


### Rule: Design Small Aggregates

- What additional cost would there be for keeping the large-cluster Aggregate?

- Even if we guarantee that every transaction would succeed, a large cluster
  still limits performance and scalability.

- Holding many collections in an aggregate over time even if we have
  lazy-loading capabilities, many user at the same time can cause loading of
  those objects. That would not work very well.

- What should be modeled a contained part as an Entity?

- First ask whether that part must itself change over time, or whether it can be
  completely replaced when change is necessary?

- Cases where instances can be completely replaced point to the use of a Value
  Object rather than an Entity.

- There are important advantages to limiting internal parts to Values.

### Rule: Reference Other Aggregates by Identity

- Evans states that one Aggregate may hold references to the Root of other
  Aggregates. Howevery, we must keep in mind that this does not place the
  referenced Aggregate inside the consistency boundary of the one referencing
  it.

```java
public class BacklogItem {
   private Product product;
}
```

1. Both the referencing Aggregate (BacklogItem) and the referenced Aggregate
   (Product) must not be modified in the same transaction. Only one or the other
   may be modified in a single transaction.

2. If you are modifying multiple instances in a single transaction, it may be a
   strong indication that your consistency boundaries are wrong.

3. If you are attempting to apply point 2, and doing so influences a
   large-cluster Aggregate with all the previously state caveats, in may be an
   indication that you need to use eventual consistency.

** Making Aggregates Work Together through Identity References

Prefer references to external Aggregates only by their globally unique identity,
not by holding a direct object reference.

```java
public class BacklogItem {
   private ProductId productId;
}
```

### Model Navigation

- Having an Application Service resolve dependencies free the Aggregate from
  relying on either a Repository or a Domain Service.

### Rule: Use Eventual Consistency Outside the Boundary

"Any rule that spans AGGREGATES will not be expected to be up-to-date at all
times. Through event processing, batch processing, or other update mechanisms,
other dependencies can be resolved within some specific time."

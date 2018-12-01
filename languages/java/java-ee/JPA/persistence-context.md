# The Persistence Context

- An EntityManager has a persistence context

- You create a persistence context via EntityManagerFactory#createEntityManager()

- The persistence context monitors and manages all entities in persistent state

- The persistence context allows the persistence engine to perform 'automatic
  dirty checking', detecting which entity instances the application modified

- The persistence context acts as a 'first-level cache'; it remembers all entity
  instances you've handled in a particular unit of work

- The persistence context provides a 'guaranteed scope of object identity'; in
  the scope of a single persistence context, only one instance represents a
  particular database row

- entityA == entityB is true only if both references to the same instance

- entityA.getId().equals(entityB.getId()) is true if both have the same db
  identifier value

- Within one persistence context, Hibernate guarantess that both comparisons
  will yield the same result. Solves one of the fundamental O/R mismatch problems

- You can modify the instance after calling persist(), and your changes will be
  propagated to the db with an additional SQL UPDATE statement

- Hibernate detects the changed properties by comparing the instance with a
  snapshot copy it took before, when it was loaded from the db, if the instance
  is different from the snapshot, an UPDATE is necessary. Snapshots consume
  memory, and checking diffs takes time.

- Hibernate propagates the state changes to the db as late as possible, toward
  the end of the trx. DML statements usually create locks in the db that are
  held until trx completes. So Hibernate keeps the lock duration in the db as
  short as possible.

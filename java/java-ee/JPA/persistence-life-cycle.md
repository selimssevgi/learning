# The Persistence Life Cycle

- Classes are unaware of their own persistence capability, because JPA is a
  transparent persistence mechanism.

- Persistence Context is a service that remembers all the modications and state
  changes you made to data in a particular unit of work

## Entity Instance States

- JPA defines four states, hiding the complexity of Hibernate's internal
  implementation from the client code

1. Transient State
2. Persistent State
3. Removed State
4. Detached State

### Transient State

- Instanced created with the 'new' Java operator are 'transient'

- Their state is lost and garbage-collected as soon as they're no longer referenced

- Hibernate doesn't provide any rollback functionality for transient instances

- If you modify the state of a transient entity, you can't automatically undo the change

- From transient to persistent state: EntityManager#persist()

- PersistenceUnitUtil.getIdentifier(e) == null

## Persistent State

- A persistent entity instance has a representation in the database

- A persistent entity instace is with a database identity, the primary key

- EntityManager#contains(e) == true

## Removed State

- You can delete a persistent entity instance from the database in several ways

- EntityManager#remove()

- Also becomes available for delete if remove a ref to it from a mapped
  collection with 'orphan removal' enabled

- The provider will delete the instance at the end of a unit of work

### Detached State

- EntityManager#find to retrieve an entity instance, and close the persistence
  context, at the point application has a handle to the instance

- If it is not in persistent state, and has an identifier assigned

- If a reference leaves the scope of guaranteed identity, we call it a reference
  to a detached entity instance

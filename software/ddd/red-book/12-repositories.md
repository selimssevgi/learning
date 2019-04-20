# Repositories

"For each type of object htat needs global access, create an object that can
provide the illusion of an in-memory collection of all objects of that type. Set
up access through a well-known global interface. Provide methods to add and
remove objects... Provide methods that select objects based on some criteria and
return fully instantiated objects or collections of objects whose attribute
values meet the criteria... Provide repositories only for aggregates..." [Evans]


## Collection-Oriented Repositories

- A Repository interface that does not hint in any way that there is an
  underlying persistence mechanism, avoiding any notion of saving or persisting
  data to a store.

- A standard collection: objects are added to a collection, and they remain in
  the collection until they are removed. There is no need to do anything special
  to get the collection to recognize changes to the objects that it contains,
  other than to ask the collection to hand you a reference to a specific object
  and then ask that object to do something to itself, which modifies its own
  state.

- One special kind of collection, java.util.Set (HashSet) provides the kind of
  collection that a Repository mimics. Every object added to a Set must be
  unique.

** A Repository should mimic a Set collection. Whatever the backing
implementation with a specific persistence mechanism, you must not allow
instances of the same object to be added twice. Also, when retrieving objects
from a Repository and modifying them, you don't need to "re-save" them to the
Repository.

- The persistence mechanism must in some way support the ability to implicitly
  track changes made to each persistent object that it manages. This may be
  accomplish in various ways:

1. Implicit Copy-on-Read [Keith & Stafford]: The persistence mechanism
   implicitly copies each persistent object on read when it is reconstituted
   from the data store and compares its private copy to the client's copy on
   commit. Stepping through this, when you ask the persistence mechanism to read
   an object from the data store, it does so and immediately makes a copy of the
   entire object (minus any lazy-loaded parts). When a transaction created
   through the persistence mechanism is committed, the persistence mechanism
   checks for modifications on the copied objects it has loaded (or reattached
   to) by comparing them. All objects with detected changes are flushed to the
   data store.


2. Implicit Copy-on-Write [Keith & Stafford]: The persistence mechanism manages
   all loaded persistent objects through a proxy. As each object is loaded from
   the data store, a thin proxy is created and handed to the client. Clients
   unknowinly invoke behavior on the proxy object, which reflects the behavior
   onto the real object. When the proxy first receives a method invocation, it
   makes a copy of the managed object. The proxy tracks changes made to the
   state of the managed object and marks it dirty. When a transaction created
   through the persistence mechanism is commited, it checks for dirty objects
   and all such are flushed to the data store.


- Using persistence mechanism like this, such as Hibernate, allows you to
  employ a traditional, collection-oriented Repository.


- TopLink's Unit of Work does not make an implicit copy-on-read. Instead, it
  makes an Explicit Copy-before-Write. Here the term 'explicit' means that the
  client must inform the Unit of Work that changes are about to take place. This
  gives the Unit of Work the opportunity to clone the given domain object in
  preparation for modifications (what it  calls 'edits'). The key point is that
  TopLink consumes memory only when it must.


## Persistence-Oriented Repositories

- For times when a colleciton-oriented style doesn't work, you will need to
  employ a persistence-oriented, save-based Repository.

- This will be the case when you persistence mechanism doesn't implicitly or
  explicitly detect and track object change.

- This happens to be the case when using an in-memory Data Fabric, or by any
  other name a NoSQL key-value data store.

** We must explicitly put() both new and changed objects into the store,
effectively replacing any value previously associated with the given key. Using
these kinds of data stores greatly simplifies the basic writes and reads of
Aggregates. For this reason they are sometimes called Aggregate Stores or
Aggregate-Oriented Databases.

- When using an in-memory Data Fabric, such as GemFire or Oracle Coherence, the
  storage is an in-memory Map implementation mimicking java.util.HashMap, where
  each mapped element is considered an 'entry'.

** When using a collection-oriented style, Aggregate instances are added only
when they are created. When using a persistence-oriented style, Aggregate
instances must be saved both when they are created and when they are modified.

## Managing Transactions

- The domain model and its encompassing Domain Layer in never the correct place
  to manage transactions.

- A common architectural approach to facilitating transactions on behalf of
  persistence aspects of the domain model is to manage them in the Application
  Layer.

## Repository vs Data Access Object

- Sometimes the idea of a Repository is considered synonymous with DAO.

- Both provides an abstraction over a persistence mechanism.

- ORM tool also provides an abstraction over a persistence mechanism, but it is
  neither a Repository nor a DAO.

- A DAO is expressed in terms of database tables, providing CRUD interfaces to them.

- Since you can use DAO and related patterns to perform fine-grained CRUD
  operations on data that would otherwise be considered parts of an Aggregate,
  this would be a pattern to avoid with a domain model.

- You may choose to think of a Repository as a DAO in a general sense. The
  primary thing to keep in mind is that as much as possible you should try to
  design your Repositories with a collection orientation rather than a data
  access orientation. That will help keep you focused on the domain as a model
  rather than on data and any CRUD operations that may be used behind the scenes
  to manage its persistence.

# ch25 - testing persistence

- when we define an abstraction in terms of a third-party API, we have to test
  that our abstraction behaves as we expected when integrated with that API

- ORM hides a lot of sophisticated functionality behind a simple API

- when we build an abstraction upon an ORM, we need to test that our implementation:
  - sends correct queries
  - has correctly configured the mappings between our objects and relational schema
  - uses a dialect of SQL that is compatible with the database
  - performs updates and deletes that are complatible with integrity constraints of the db
  - interacts correctly with the trx manager
  - releases external resources in a timely manner
  - does not trip over any bugs in the db driver

#### isolate tests that affect persistent state

- persistence data stays around we have to take extra care to unsure that
  persistence tests are isolated from one another

- JUnit cannot do much with the persistent state for us

*clean up persistent data at the start of a test, not at the end*

- cleaning up code is ideal candidate to be extracted into a subordinate object
  to be used by any test that uses the database: DatabaseCleaner#clean

```java
@Before
public void cleanDatabase() {
  new DatabaseCleaner(entityManager).clean();
}
```

#### make tests transaction boundaries explicit

- our persistence tests could be run in a transactional resource and rollback after each test
- the idea would be to leave the persistent state the same after the test as before

- the problem with this approach is that it doesn't test what happens on commit
- a test that never commits does not fully exercise how the code under test
  interacts with the database

#### testing an object that performs persistence operations

- repository/dao/persistence implementation tests

- also test if an entity is saved to and load from database, round-trip testing

- there might be test for referential entity behavior

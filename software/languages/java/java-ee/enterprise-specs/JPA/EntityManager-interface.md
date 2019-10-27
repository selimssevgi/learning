# EntityManager Interface

- Creating an EntityManager starts its persistence context.

- hibernate wont access the db ntil necessary; EntityManager doesn't obtain a
  JDBC Connection from the pool until SQL statements have to be executed

- You can create and close EntityManager without hitting the database

- You can (also) force dirty checking synch manually by calling EM#flush() at
  any time during a trx

- You have to close the persistence context at some point, so always place the
  close() call in a finally block

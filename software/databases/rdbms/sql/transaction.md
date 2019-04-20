# Transaction

- A transaction is a set of SQL statements that accomplish a single unit of work

- During a transaction, if ALL steps can't be completed without interference,
  NONE of them should be completed

- There are system(multiple databases) and database transactions

- see java-ee/jta

## ACID

* There are four characteristics that have to be true before we can call a set
  of SQL statements a transaction:

### Atomicity

- all pieces, or none. Can't execute part of a transaction

### Consistency

-  A complete transaction leaves the db in a consistent state at the end of trx

### Isolation

- Isolation means that every transaction has a consistent view of the db
  regardless of other transactions taking place at the same time

- A particular trx should not be visible to other concurrently running
  transactions; they should run in isolation

- Databases (and other transactional systems) attempt to ensure transaction
  isolation, meaning that, from the point of view of each concurrent trx, it
  appears that no other transactions are in progress.

- Traditionaly, db systems have implemented isolation with locking

- Some modern engines implement trx isolation with multiversion concurrency
  control (MVCC), which vendors generally consider more scalable.

### Durability

- Ater the trx, the db needs to save the data correctly and protect it from
  power outrages or other threats. This is generally handled through records of
  transactions saved to a different location than the main db.
  

* No changes will occur to the database until you commit

```sql
-- START TRANSACTION
--   DO SOMEWORK
--   HAPPY WITH IT?
--   YES: COMMIT
--   NO:  ROLLBACK
```

*NOTE:* Some storage engine doesnot support transansaction. In MySQL, it should
be either BDB or InnoDB to have trx support

```sql
SHOW CREATE TABLE table_name;

ALTER TABLE table_name TYPE = InnoDB;
```

## Correctness of a Transaction

- You want correctness of a trx

- ex, the business rules dictate that the application charges the seller once,
  not twice. This is a reasonable assumption, but you may not be able to express
  it with database constraints

- The correctness of a trx is the responsibility of the application

- Consistency is the responsibility of the database

## Transaction Isolation Issues

- No grey area in the real world: isolated or not

- Complete isolation comes at a high price. Can't stop the world to access data

- Several isolation leves are available, which, naturally, weaken full isolation
  but increase performance and scalability of the system

### Lost update

- Occurs if two trxs both update a data item and then the second trx aborts,
  causing both changes to be lost

### Dirty Read

- Occurs if a trx reads changes made by another trx that hasn't yet been committed

- This is dangerous because the changes made by the other trx may later be
  rolled back, and invalid data may be written by the first trx

### Unrepeatable Read

- Occurs if a trx reads a data item twice and reads different state each time

- Another trx may committed changes between two reads

### Last Commit Wins

- Two trx read some data at the same time

- First commits changes, and later the other. First changes are lost

### Phantom Read

- occurs when a trx executes a query twice, and the second result includes data
  that wasn't visible in the first result or less data cus of delation.

- Between two queries data might be changed

## ANSI Isolation Levels

1. Read uncommitted isolation (too dangerous)
   - permits dirty reads

2. Read committed isolation (JPA default)
   - permits unrepeatable reads but not dirty reads

3. Repeatable read isolation
   - permits neither unrepeatable reads not dirty reads. Phantom reads may occur

4. Serializable isolation (scales poorly)
   - the strictest isolation, trxs exexuted one after another, not concurrent

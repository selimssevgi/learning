# Transaction

- A transaction is a set of SQL statements that accomplish a single unit of work

- During a transaction, if ALL steps can't be completed without interference,
  NONE of them should be completed

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

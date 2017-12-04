# Primary Key

- A primary key is a column in your table that makes each record unique

1. A primary key can't be NULL

2. The primary key must be given a value when the record is inserted

3. The primary key must be compact

4. The primary key values can't be changed


```sql
-- remove primary key without changing the data
ALTER TABLE table_name
DROP PRIMARY KEY;
```

* Cannot have more than one field to be AUTO_INCREMENT, has to be integer, not
  null

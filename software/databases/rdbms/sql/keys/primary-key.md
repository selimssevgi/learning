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

## Requirements

To become the primary key, a candidate key must satify the followings:

- The value of any candidate key column is never null. You can't identify
  something with data that is unknown, and there are no nulls in the relational
  model. Some SQL products allow defining (composite) PKs with nullable columns,
  so you must be careful.

- The value of the candidate key column(s) is a unique value for any row.

- The value of the candidate key column(s) never changes; it's immutable.

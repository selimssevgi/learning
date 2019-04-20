# Inner Join

- An INNER JOIN combines the records from two tables using comparison operators
  in a condition. Columns are returned only where the joined rwos match the condition.


```sql
SELECT somecolumns
FROM table1
  INNER JOIN table2
  ON somecondition
```


```sql
contacts(contact_id, ..., profession_id)
professions(profession_id, profession)

SELECT c.last_name, c.first_name, p.profession
FROM contacts AS c
  INNER JOIN profession AS p
  ON c.contact_id = p.profession_id;
```

## Equijoin


```sql
-- one-to-one relationship

SELECT boys.boy, toys.toy
  FROM boys
    INNER JOIN toys
    ON boys.toy_id = toys.toy_id;

SELECT c.first_name, c.last_name, p.profession
  FROM contacts AS c
    INNER JOIN professions p
    ON c.profession_id = p.profession_id;

SELECT c.first_name, c.last_name, s.status
  FROM contacts AS c
   INNER JOIN status AS s
   ON s.status_id = c.status_id;
```

## NON-EQUIJOIN

```sql
-- which toys each boy does not have

SELECT boys.boy, toys.toy
  FROM boys
    INNER JOIN toys
    ON boys.toy_id <> toys.toy_id;
```

## Natural Join

- Natural Joins only work if the column you're joining by has the same name in
  both tables

```sql
SELECT boys.boy, toys.toy
FROM boys
  NATURAL JOIN toys;

SELECT c.first_name, c.last_name, s.status
  FROM contacts AS c
   NATURAL JOIN status AS s
--   ON s.status_id = c.status_id;
```

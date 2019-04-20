# AS

- An alias is temporarily, does not change the original table

## Column Aliases

```sql
-- aliasing first_name column as 'fn'

SELECT first_name AS fn FROM people;
```

## Table Aliases

- While selecting data from more than one table, without aliases there will be
  lots of typing of table names

- Table aliases are also called correlation names

```sql
SELECT profession AS mc_prof
FROM my_contacts AS mc
GROUP BY mc_prof
ORDER BY mc_prof;
```

## Shorthand

- We can just leave out the word AS

- Aliases should directly follow the column/table name

```sql
-- same as above

SELECT profession mc_prof
FROM my_contacts mc
GROUP BY mc_prof
ORDER BY mc_prof;
```

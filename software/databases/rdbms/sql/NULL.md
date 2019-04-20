# NULL

- NULL in sql mean 'undefined'.

- NULL is equal to nothing, even to another null.

- It is not a zero nor a an empty string

## Querying NULL

- use IS NULL operator

```sql
-- does not work as expected
SELECT * FROM drinks WHERE second = NULL;

SELECT * FROM drinks WHERE second IS NULL;
```

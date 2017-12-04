# LIKE Operator

- If where clause has lots of ORs and conditions has some pattern, use like


- % stands for any number of characters

```sql
-- where location value ends with 'CA'
SELECT * FROM contacts WHERE location LIKE '%CA';

SELECT * FROM contacts WHERE location LIKE 'CA%';

SELECT * FROM contacts WHERE location LIKE '%CA%';

-- starts with M and ends with A
WHERE state LIKE 'M%' OR state LIKE 'A%';
```

- _ stands for exactly one character


```sql
SELECT * FROM contact where first_name LIKE '_elim';

SELECT * FROM contact where first_name LIKE 's_rr_';

```

# Outer Join

- Cross join: returns every possible row
- Inner join: returns rows from both tables where there is a match

- Outer join: returns rows that don't have matching counterparts in other table

- With inner join, you're comparing rows from two tables but the order of those two tables does NOT matter

## Left Outer Join

```sql
SELECT g.girl, t.toy
FROM girls g              -- left table
LEFT OUTER JOIN toys t    -- right table
ON g.toy_id = t.toy_id;
```

- The difference with inner join is that:
  - an outer join gives you a row whether there's a match with the other table or not

- A NULL value in the results of left outer join means that the right table has
  no values that correspond to the left table

- Multiple rows when there are multiple matches


```sql
SELECT g.girl, t.toy
FROM toys t
LEFT OUTER JOIN girls g ON t.toy_id = g.toy_id;

/*
  girl   | toy
  <null> | hula hoop
*/
```

## Right Outer Join

- Same thing as Left Outer Join, just tables become right/left

```sql
SELECT g.girl, t.toy
FROM girls g              -- left table
LEFT OUTER JOIN toys t    -- right table
ON g.toy_id = t.toy_id;
```

```sql
SELECT g.girl, t.toy
FROM girls g               -- right table
RIGHT OUTER JOIN toys t    -- left table
ON g.toy_id = t.toy_id;
```

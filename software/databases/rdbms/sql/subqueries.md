# Subqueries

- Joins are great, but sometimes you need to ask your db more than one question

- Take the result of one query and use it as the input to another query (pipe?)

- A subquery is a query that is wrapped within another query.

- It is also called an INNER query

```sql
-- contacts(contact_id, ...)
-- job_current(contact_id, ...)

-- containing query || outer query
-- inner query || subquery

SELECT c.first_name, c.last_name, c.phone, jc.title
FROM job_current AS jc
  NATURAL JOIN contacts AS c
  WHERE jc.title IN (SELECT title FROM job_listing);
```

- Subqueries should return a single (scalar) value, except used with IN

- Sometimes subqueries could be written easier than Joins

## Subquery Rules

- A subquery is always a single SELECT statement

- Subqueries are always inside parentheses

- Subqueries can show up in four places in a query:
  - select clause
  - select column list as one of the columns
  - from clause
  - having clause

- Subqueries can be used with INSERT, DELETE, UPDATE, SELECT

- If a subquery is used as a column expression in a SELECT statement, it can
  only return one value from one column

- If the subquery stands alone and doesnt reference anything from the outer
  query, it is a *noncorrelated subquery*

- Cross joins and correlated subquery are SLOW!

- Joins are more efficient than subqueries

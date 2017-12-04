# View

- If you find yourself writing the same query again and again, you should use views

- Saving query in a file could be a solution, but saving it into DB as view is better

- A view is basically a table that only exists when you use the view in a query

- It is considered a *virtual table* because it acts like a table

- Virtaul table doesnt stay in the db, it gets created when we use the view and
  then deleted. This way we can see the new inserted rows

```sql
SELECT c.first_name, c.last_name, c.phone, c.email
FROM contacts c
NATURAL JOIN job_desired jd
WHERE jd.title = 'Web Designer';
```

- Instead of writing above query again and again, lets create a view

```sql
CREATE VIEW web_designers AS
  SELECT c.first_name, c.last_name, c.phone, c.email
  FROM contacts c
  NATURAL JOIN job_desired jd
  WHERE jd.title = 'Web Designer';

DROP VIEW web_designers;
```

- using views

```sql
SELECT * FROM web_designers;
```

- Underneath it is a subquery

```sql
SELECT * FROM
(SELECT c.first_name, c.last_name, c.phone, c.email
FROM contacts c
NATURAL JOIN job_desired jd
WHERE jd.title = 'Web Designer')
AS web_designers; -- giving subquery an alias so that the query treats it as a table
```

## Views are good for

1. You can keep changes to your db structure from breaking applications that
   depends on your table

By creating views  into your data, you will be able to change your underlying
table structure but create views that mimic what your table structure used to be

2. Views make life easier by simplifying complex query into a simple command

Can use views in application code, easier to write and read than joins or subqueries

3. You can create views that hide information that isn't needed by the user

Hide card information, and just provide a view indicating that it has card

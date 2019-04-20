# Union

- Extracting same information from different table

```sql
-- extracting all job titles

SELECT title FROM job_current;
SELECT title FROM job_desired;
SELECT title FROM job_listing;
```

- just one order by at the end

```sql
-- use union to combine all results

SELECT title FROM job_current
UNION
SELECT title FROM job_desired
UNION
SELECT title FROM job_listing
ORDER BY title;
```

## Union Rules

- The number of columns in each SELECT statement must match

- You must have the same expressions and aggregate functions in each SELECT

- You can put the SELECT statements in any order; it won't change the results

- By default, SQL suppresses duplicate values from the results of a union

- The data types in the columns need to either be the same, or be convertable

- If for some reason you DO want to see duplicates, use UNION ALL. It returns
  every match, not just distinct ones

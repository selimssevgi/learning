# one-to-one

- Only one of the rows in TableA matches to only one of the rows in TableB

- Exactly one row of a parent table is related to one row of a child table

- employee information in one table
- salary information of an employee in another table

- It is not used that often

## When to use

- It generally makes more sense to leave one-to-one data in your main table

1. Writing faster queries, just pulling out the data in smaller table

2. If you have a column containing values you don't yet know. You can isolate it
   and avoid NULL values in your main table

3. Restricting access to salary table

4. If you have a large piece of data, a BLOG type, you may want that large data
   in a separate table

## Examples

```sql
contacts(contact_id, ...)
job_current(contact_id, title, salary, start_date)
job_desired(contact_id, title, salary_low, salary_high, available, years_exp)
```

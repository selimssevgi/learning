# 3NF

1. Be in 2NF
2. Have no transitive dependencies

- If changing any non-key columns might cause any of other columns to change,
  you have a transitive dependency

- Transitive functional dependency:
  When any non-key column is related to any of the other non-key columns


```sql
-- if instructor changes, phone should change too: transitive dependency

courses(course_id, course_name, instructor, instructor_phone)
```

# One-to-many

- A record in TableA can have MANY matching records in TableB, but a record in
  Table B can only match ONE record in Table A

- More than one person can have the same profession
- Each person has only one profession

```sql
-- professions(prof_id, profession)

-- contacts(contact_id, ..., prof_id)
```

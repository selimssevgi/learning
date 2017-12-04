# Many-to-many

- Many women can have many shoes

- Adding either primary key to the other table as foreign key gives us duplicate
  data in our table

- We need a table to step in between these two many-to-many tables and simplify
  the relationships to one-to-many

- We need a *junction table*, which will contain the primary key columns of the
  two tables we want to relate

- A junction table holds a key from each table


```sql
woman_id | shoe_id
   1     |  3
   1     |  4
   3     |  3
   3     |  4
```

- It is usually made up of two one-to-many relationships, with a junction table
  in between

*Example:*

Every person can have more than one interest, and for every interest, there can
be more than one person who shares it

```sql
contacts(contact_id, ...)
interests(interest_id, interest)
contact_interest(contact_id, interest_id)
```

- Junction table lets us separate two connected table. Making changes on one of
  them wont effect the other one. Changing(just in one row, no dups), safe deleting


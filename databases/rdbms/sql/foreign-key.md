# Foreigh Key

- Is a column in a table that references the primary key of another table


## Facts

- A foreign key can have a different name than the primary key it comes from

- The primary key used by a foreign key is also known as a parent key

- The table where the primary key is from is known as a parent table

- The foreign key can be used to make sure that the rows in one table have
  corresponding rows in another table

- * Foreign key values can be null, even though primary key values can't

- * Foreign keys don't have to be unique, in fact they often aren't

## Constaining foreign key

- A column can be just added and used as foreign key, is not the best way

- Foreign key is a foreign key when it is designated to be (constraint)

- Creating a foreign key as a constraint in your table gives you definite advantages

- You will get error if you violate the rules, which will stop you accidentally
  doing anything to break the table

- You can use a foreign key to reference a unique value in the parent table

- * It does not have to be the primary key of the parent table, but it must be unique

## Referential Integrity

You will only be able to insert values into your foreign key that exist in the
table the key came from, the parent table. This is called *referential integrity*

You only put values in the child table's foreign key that already exist in the
parent table.

*NOTE:* With constraint as foreign key, we cannot delete a row in parent table
before deleting the rows that use the primary key of that row from child parent

## Self Referencing Foreign Key

- is the primary key of a table used in that same table for another purpose

- The self-referencing part means that it is a key that is referencing another
  field in the same table


```sql
-- clown has a clown boss

clown_info(id, name, boss_id)

- hierarchical menu

menu(id, text, parent_id)
```

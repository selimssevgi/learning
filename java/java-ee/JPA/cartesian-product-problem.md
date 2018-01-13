# Cartesian Product Problem

- Eagerly loading collections with JOINS can lead to serious performance issues

- If you have more than one EAGER loaded collection mapping in your entity, you
  would run into Cartesian product problem

- The SQL Hibernate will generate can be problematic, result set contains many
  redundant data items

- Instead of 3 rows, you may have 3 * 3 = 9 rows

- Hibernate removes all duplicates when it marshals the result set

- Instead of one SQL query with an extremely large result, three separate
  queries would be faster to retrieve an enetity isntance and two collections at
  the same time.

* Tell hibernate to use multiple selects instead of join not to have this problem

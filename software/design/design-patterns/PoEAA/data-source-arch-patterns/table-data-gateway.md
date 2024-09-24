# Table Data Gateway

- An object that acts as a Gateway to a db table.
- One instance handles all the rows in the table.

- Mixing SQL in application logic can cause several problems.

- A Table Data Gateway holds all the SQL for accessing a single table or view:
  - selects, inserts, updates, and deletes

- The TDG is usualy stateless, as its role is to push data back and forth.

- It often makes sense to have the Data Mappers talk to the db via TDGs.

- Data Access Object(DAO) pattern is a Table Data Gateway.

# Row Data Gateway

- An object that acts as a Gateway to a single record in a data store.
- There is once instance per row.

- It is often hard to tell the difference between a RDG and an Active Record.

- If there is any domain logic present, you have an Active Record.

- A RDG should contain only db access logic and no domain logic.

# Transaction Script

- Organizes business logic by procedures where each procedure handles a single
  request from the representation

## How it works

- If your need is to book a hotel room, the logic to check the room
  availability, calculate rates, and update the db is found inside the Book
  Hotel Room procedure.

## When to use it

- The glory of TS is its simplicity.

- Organizing logic this way is natural for applications with only a small amount of logic

- It involves very little overhead either in performance or in understanding

- The more complicated the business logic gets, the harder to keep it in a well-designed state

- Since the whole point is to handle one trx, any common code tends to be duplicated

- More complex business domains need a Domain Model

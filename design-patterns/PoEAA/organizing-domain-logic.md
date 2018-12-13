# Organizing Domain Logic

- Transaction Script

- Domain Model

- Table Module


## Service Layer

-  A common approach in handling domain logic is to split the domain layer in two

- A service layer is placed over an underlying Domain Model/Table Module

- The presentation logic interacts with the domain purely through the Service
  Layer, which acts as an API for the aplication.

- The Service Layer is also good spot to place such things as trx control and security

- When you see a Service Layer, a key decision is how much behavior to put in it

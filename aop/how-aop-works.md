# How AOP Works

- If you do not use aspects in a large code base:

1. Code Tangling: Multiple concerns in each piece of code: Exceptions, Transaction, Tracing, Business logic,

- Each method will have above concerns, and it will be hard to see what the
  method really is doing

2. Code Scattering: transactions handling everywhere, Aspects are not
   implemented in one place

- Taking transactions code into a Transaction Aspect, there will be clear
  separation between other concerns and business logic.

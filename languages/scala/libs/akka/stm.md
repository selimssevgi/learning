# STM

- software transactional memory

- STM is similar to database transactions

- Because memory isn't durable with STM, you get only 3 properties of ACID
  
  - Atomicity: all changes or nothing, one fails then all are rolled back

  - Consistency: from one consistent state to another.

  - Isolation: no other STM transactions sees partial changes

  - Durability: if completed, recorded to a durable medium(hdd)

- The best part of STM is freedom from locks

- it rolls back from exceptions and is composable

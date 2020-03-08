# message driven beans (MDB)

- reusable workflow logic components
  - rely on JMS
  - support transactions

- similar to stateless session beans
  - MDBs have no client-oriented state
  - no distinction across client or bean

- different from stateless beans
  - no direct client access
  - invoked through message notification
  - asynchronous interactions

### mdb lifecycle

- create
- @PostConstruct
- onMessage
- @PreDestroy

- you should use them only if you require all of:
  - asynch processing (use @Asynchronous if only need this)
  - loose coupling (cdi events)
  - reliability 

- all mdbs use transactions and message ack by default

- mdb uses jta transactions, any db changes will be rollback in case of failure

## multithreading

- when a new message reaches the destination, an mdb instance is retrieved from the pool to handle the message

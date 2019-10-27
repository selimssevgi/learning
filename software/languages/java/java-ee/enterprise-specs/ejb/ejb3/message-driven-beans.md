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

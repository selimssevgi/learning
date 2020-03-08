# transaction

- programmatic transactions, bean-managed transactions, BMTs

- declarative transactions, container-managed transactions, CMTs

- both session and mdb supports

- by default, ejbs will use CMTs

- the bean will either participate in an existing transaction, if already
  started, or start a new transaction

- service bean -> trx manager -> resource manager -> database

- an ejb's interaction with the trx manager is done via JTA

- 

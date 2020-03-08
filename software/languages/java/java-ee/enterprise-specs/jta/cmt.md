# container-managed transactions

```java
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER) // by default
//@TransactionManagement(TransactionManagementType.BEAN) // BMT
public ServiceBean {}
```

## @TransactionAttribute

- container does the heavy lifting

- we need to tell the container how it should manage trxs

- what if you service is called from another service with a trx already in progress?
  - suspend, join it or fail the trx?

* TransactionAttributeType.MANDATORY: method can only join trxs already in
  progress, it can't create a new trx

```java
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public void chargeCreditCard(CreditCard creditCard) {}
```

* TYPE: caller trx exist or not

* REQUIRED: (DEFAULT)
  - no: create a new one
  - yes: join existing one

* REQUIRED_NEW:
  - no: creates a new one
  - yes: suspend existing one, create a new one

* SUPPORTS:
  - no: no trx is used
  - yes: joins caller transaction

* MANDATORY
  - no: EJBTransactionRequiredException is thrown
  - yes: method joins caller's trx

* NOT_SUPPORTED
  - no: no trx is used
  - yes: caller trx is suspended, the method called without a trx

* NEVER
  - no: not used
  - yes: EJBException is thrown

*NOTE:* MDBs support only REQUIRED and NOT_SUPPORTED attribute types

*NOTE:* even in case of error, container will not rollback unless you explicitly say so

```java
@Resource
private SessionContext context;

public void method() {
  try {
  } catch(Exception ex) {
    context.setRollbackOnly();  
  }
}
```

- setRollbackOnly() can only be called in REQUIRED, REQUIRED_NEW, MANDATORY
  - it will throw exception in other cases

- ejb3 provides a way to mark our exception for rollback

```java
@ApplicationException(rollback = true)
public class BusinessException extends Exception{ }

@ApplicationException(rollback = true)
public class UncheckedBusinessException extends RuntimeException{ }
```

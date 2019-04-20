# Why AOP

- AOP is a very important foundation of Spring, and also Java EE

- AOP is used to implement enterprise feautres; transactions, security

- Configurable middleware

- Simplify code

```java
public void doSomething() {
  final String METHOD_NAME = "doSomething"  ;
  log.trace("Entering {}#{}", CLASS_NAME, METHOD_NAME);
  TransactionStatus tx =
    transactionManager.getTransaction(new DefaultTransactionDefinition());

  try {
    // business logic  
  } catch (RuntimeException ex) {
    log.error("exception in {}#{}", CLASS_NAME, METHOD_NAME, ex);
    tx.setRollbackOnly();
    throw ex;
  } finally {
    transactionManager.commit(tx);
    log.trace("exiting {}#{}", CLASS_NAME, METHOD_NAME);
  }
}
```

- Above method handles, exception handling, tracing, and transactions

- Every method will have this aspect

- Transaction Aspect, Tracing Aspect, Exception Aspect

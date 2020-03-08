# bean-managed transactions

- 
```java
@Stateless
@TransactionManagement(TransactionManagementType.BEAN) // BMT
public ServiceBean {
  @Resource
  private UserTransaction usertrx;

  public void businessMethod() {
    try {
      usertrx.begin();
      // do something
      usertrx.commit();
    } catch(Exception ex) {
      usertrx.setRollbackOnly();  
    }
    
  }
}
```

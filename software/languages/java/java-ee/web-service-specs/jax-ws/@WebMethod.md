# @WebMethod

- by default, the following are exposed as web method
  - all public methods on a concrate class
  - all methods on a interface


```java
@WebMethod(
  operationName = "addNewBid" // <operation name = "addNewBid">
  // by default, opeation name is the method name
)
```

# Null Object Pattern

- an example from Working Effectively with Legacy Code


```java
for (EmployeeId eId : idList) {
  Employee e = finder.getEmployeeForID(id); // !!
  e.pay();
}
```

- we could just throw an exception so that we don't have to return anything(client would have deal with that explicitly)

- we could return null, then client would have to check for null explicitly

- Do we really care if there is an employee to pay? NullEmployee

- when we call .pay on NullEmployee it would do nothing

- this would shield client from explicit error checking

```java
int paidCount = 0;
for (EmployeeId eId : idList) {
  Employee e = finder.getEmployeeForID(id); // !!
  e.pay();
  paidCount++; // bug!
}
```

- Null objects are useful specifically when a client doesn't have to care
  whether an operation is successful.

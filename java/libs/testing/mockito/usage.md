
- import static org.mockito.Mockito.\*;

* Creating mock object

```java
// CalculatorService is interface
CalculatorService calcService = mock(CalculatorService.class);
// Now calcService can be used as a normal object,
// but before using we have to define some behavior on the mock object
```

* Mocking behavior - Stubbing methods

- The stubbing process defines the bahvior of a mock method such as the value to
  be returned or the exception to be thrown when the mock is invoked.

- thenAnswer(): dynamic user-defined logic instead of hardcoded value, an interface.
- thenCallRealMethod():

```java
when(calcService.add(10.0, 20.0).thenReturn(30.0);
// when add method is called with these specific parameters, then return 30.0
assertEquals(calcService.add(10.0, 20.0), 30.0, 0);

when(marketWatcher.getQuote(anyString)).thenReturn(aStock);
when(portfolio.getAvgPrice(isA(Stock.class))).thenReturn(new BigDecimal("10.00"));
```

* Verifying behavior

- Void methods dont return any value, hence verify is very handy to test the
  void methods.

```java
// called exact method with exact same arguments
verify(calcService).add(10.0, 20.0); // pass
verify(calcService).add(15.0, 20.0); // fail

verify(calcService, times(3)).add(10.0, 20.0);
verify(calcService, never()).multiply(10.0,20.0);
verify(calcService, atLeastOnce()).subtract(20.0, 10.0);
verify(calcService, atLeast(2)).add(10.0, 20.0);
verify(calcService, atMost(3)).add(10.0,20.0);
verify(calcService, only()).add(10.0,20.0); // fails if any other method is called
```

* Verify method call order

```java
InOrder inOrder = Mockito.inOrder(authenticator);
inOrder.verify(authenticator).foo();
inOrder.verify(authenticator).authenticateUser(username, password);
```

* Verifaction with timeout

```java
Mockito.verify(authenticator, Mockito.timeout(1)).authenticateUser(username, password);
```

* Throwing exceptions

```java
// Compiler doesnt like void methods inside brackets
doThrow(new RuntimeException("Divide is not implemented")).when(calcService).divide(10.0, 2.0);

// following line wont work if called method in when returns void
Mockito.when(authenticator.authenticateUser("", "")).thenThrow(EmptyCredentialsException.class);
```

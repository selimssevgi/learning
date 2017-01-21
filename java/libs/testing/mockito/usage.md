
- import static org.mockito.Mockito.\*;

* Creating mock object

```java
// CalculatorService is interface
CalculatorService calcService = mock(CalculatorService.class);
```

* Mocking behavior

```java
when(calcService.add(10.0, 20.0).thenReturn(30.0);
assertEquals(calcService.add(10.0, 20.0), 30.0, 0);
```

* Verifying behavior

```java
// called exact method with exact same arguments
verify(calcService).add(10.0, 20.0); // pass
verify(calcService).add(15.0, 20.0); // fail

verify(calcService, times(3)).add(10.0, 20.0);
verify(calcService, never()).multiply(10.0,20.0);
verify(calcService, atLeastOnce()).subtract(20.0, 10.0);
verify(calcService, atLeast(2)).add(10.0, 20.0);
verify(calcService, atMost(3)).add(10.0,20.0);
```

* Exception Handling

```java
doThrow(new RuntimeException("Divide is not implemented"))
.when(calcService).divide(10.0, 2.0);
```

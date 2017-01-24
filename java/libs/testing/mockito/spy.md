# Mockito Spy Usage

- Spy is used for partial mocking.
- Spy concept can be used for concrete implementations.
- Method calls will be delegated to real object.
- Also we can define behavior to replace real methods.
- Not recommended, use it occasionally.

```java
public class SpyExampleTest {

  @Test
  public void spyExample() {
    Map<String, String> hashMap = new HashMap<>();
    Map<String, String> hashMapSpy = Mockito.spy(hashMap);

    System.out.println(hashMapSpy.get("key")); // prints null

    hashMapSpy.put("key", "value");
    System.out.println(hashMapSpy.get("key")); // prints value

    Mockito.when(hashMapSpy.get("key")).thenReturn("different value");
    System.out.println(hashMapSpy.get("key")); // prints another value
  }

}
```

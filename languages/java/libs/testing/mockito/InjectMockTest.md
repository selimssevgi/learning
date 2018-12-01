# Mockito Annotations

- MockioJUnitRunner is used to initialize mocks
- Mocks are initialized before each test method

```java
@RunWith(MockitoJUnitRunner.class)
public class AuthenticatorAppInjectTest {

  @Mock
  private AuthenticatorInterface authenticatorMock;

  @InjectMocks
  private AuthenticatorApplication authenticator;

  // Mockito tries in order:
  // By constructor
  // By setter
  // By class field

  @Test(expected = EmptyCredentialsException.class)
  public void shouldThrowException() throws EmptyCredentialsException {
    String username = "";
    String password = "";

    Mockito.when(authenticatorMock.authenticateUser(username, password)).thenThrow(EmptyCredentialsException.class);

    authenticator.authenticate(username, password);
  }
}
```

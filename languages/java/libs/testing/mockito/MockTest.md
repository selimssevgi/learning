
```java
public class AuthenticatorApplicationTest {

  private AuthenticatorInterface authenticator;
  private AuthenticatorApplication app;

  @Before
  public void setUp() {
    authenticator = Mockito.mock(AuthenticatorInterface.class);
    app = new AuthenticatorApplication(authenticator);
  }

  @Test
  public void shouldFail() throws EmptyCredentialsException {
    String username = "Selim";
    String password = "123456";
    Mockito.when(authenticator.authenticateUser(username, password)).thenReturn(false);

    assertFalse(app.authenticate(username, password));

    InOrder inOrder = Mockito.inOrder(authenticator);
    inOrder.verify(authenticator).foo();
    inOrder.verify(authenticator).authenticateUser(username, password);

    Mockito.verify(authenticator, Mockito.timeout(1)).authenticateUser(username, password);
  }

  @Test(expected = EmptyCredentialsException.class)
  public void shouldThrowEmptyCredentailsException() throws EmptyCredentialsException {
    Mockito.when(authenticator.authenticateUser("", "")).thenThrow(EmptyCredentialsException.class);
    authenticator.authenticateUser("", "");
  }

}
```

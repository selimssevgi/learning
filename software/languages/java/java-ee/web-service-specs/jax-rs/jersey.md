# Jersey

- It is Jax-RS reference implementation

- Annotations can be used on the class and methods to define their responsibility

- Provides a servlet implementation to identify RESTful resources

- The base URL for this servlet is:

```shell
http://localhost:8080/context-root/servlet-mapping/@Path
```

- Servlet analyzes the incoming HTTP request
- It selects the correct class and method to respond to this request

### jersey client

- in 1.1 does not exist, in which version?
  - ClientBuilder.newClient() // javax.ws.rs.client.ClientBuilder
- jersey has great client capabilities built-in

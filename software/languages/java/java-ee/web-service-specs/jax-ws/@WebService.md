# @WebService

- can be used on a concrete class as the implementing web service
  - container will generate the interface
- can be used on an interface, in other words Service Endpoint interface

```java
@WebService(
  serviceName = "UserService", // <wsdl:service name="UserService">
  )
public interface UserService {}

@WebService(endpointInterface="com.selimssevgi.service.UserService")
public class UserServiceImpl implements UserService {}
```



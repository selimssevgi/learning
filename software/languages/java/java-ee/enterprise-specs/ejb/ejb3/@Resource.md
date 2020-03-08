# @Resource

- by far the most versatile mechanism for resource injection in ejb3

- is used to inject:
  - jdbc data sources
  - jms resources
  - ejb context
  - anything in the jndi registery

- is used to inject container-managed resources into code that the container also manages

```java
@Stateless
public class AService {
  @Resource(lookup = "java:global/jdbc/MyDB")
  private DataSource dataSource;

  @Resource(lookup = "java:global/jms/MyQueue")
  private Queue queue;

  @Resource
  private SessionContext context;

  @Resource
  private boolean censorship;

  @Resource(lookup = "java:global/mail/MyMail")
  private Session mailSession;

  @Resource
  private TimerService timerService;
}
```

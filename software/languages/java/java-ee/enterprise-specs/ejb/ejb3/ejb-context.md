# javax.ejb.EJBContext

- javax.ejb.SessionContext
- javax.ejb.MessageDrivenContext

```shell
@Stateless
@LocalBean
public class DefaultService {
  @Resource
  SessionContext context; // session bean's own context
}

@MessageDriven
public class Processor {
  @Resource
  MessageDrivenContext context; // its own context
}
```

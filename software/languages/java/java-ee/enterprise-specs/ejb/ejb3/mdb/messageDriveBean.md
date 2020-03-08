# @MessageDrivenBean

- the interface is implemented and used by the container to register the MDB
  with the underlying jms provider

```java
@MessageDriven(activationConfig = {
        // what is this bean listening? Queue or Topic?
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        //@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        // destination name with jndi
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/ShippingRequestQueue")
})
public class ShippingRequestProcessor implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println(message);
    }
}
```

- or use the config to deployment descriptor or simply use default values

```java
@MessageDriven
public class ShippingRequestProcessor implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println(message);
    }
}
```

- if dont want to implement interface

```java
@MessageDriven(messageListenerInterface = "javax.jms.MessageListener")
public class ShippingRequestProcessor {
	```

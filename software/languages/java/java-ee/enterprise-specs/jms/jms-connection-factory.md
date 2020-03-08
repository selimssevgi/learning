# @JMSConnectionFactory

- message server resources are similar to jdbc javax.sql.DataSource
- these resources are created and configured outside the code and stored in the
  server jndi registry

- jms has two primary types of resources:
  - javax.jms.JMSContext (jee 7) = javax.jmx.ConnectionFactory + javax.jmx.Session
  - javax.jms.Destination

## preparing the message


```java
ObjectMessage om = jmsContext.createObjectMessage();
om.setObject(myReqObj)
```

## sending the message


```java
JMSProducer producer = jmsContext.createProducer();
producer.send(destination, objectMessage);
```

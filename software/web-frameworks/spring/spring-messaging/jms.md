# JMS (Java Message Service)

- Spring supports JMS through a template-based abstraction: JmsTemplate

- Spring also supports the notion of message-driven POJOs:
  - simple java objects that react to messages arriving on a queue or topic in an async fashion

### activemq

- you need a JMS conneciton factory to be able to send messages through the message broker

```java
@Bean
public ActiveMQConnectionFactory activeMQConnectionFactory() {
  return new ActiveMQConnectionFactory();
}
```

- we also need to define a bean for topic or queue

### JmsTemplate

- is Spring's answer to verbose and repetitive JMS code

- takes care of creating a connection, obtaining a session, ultimately sending or receiving messages

- Spring uses JMSException(and adds more) but converts them to unchecked ones

```java
@Bean
public JmsTemplate jmsTemplate(connectionFactory ConnectionFactory) { // jms connection factory
  return new JmsTemplate(connectionfactory);
}
```

#### send message

```java
@Autowired
JmsOperations jmsOperations;

public void sendSpittleAlert(Spittle spittle) {
  jmsOperations.send("spittle.alert.queue"), new MessageCreater() {
    public Message createMessage(Session session) {
      return session.createObjectMessage(spittle);
    }
  });
}
```

- we can set a default destionation and ask Spring do the conversion for us

```java
@Bean
public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) { // jms connection factory
  JmsTemplate jmst = new JmsTemplate(connectionfactory);
  jmst.setDefaultDestionation("spittle.alert.queue");
  return jmst;
}
```

```java
@Autowired
JmsOperations jmsOperations;

public void sendSpittleAlert(Spittle spittle) {
  jmsOperations.createAndSend(spittle);
}
```

- Springs offers a handful of MessageConverter implementations
- by default, JmsTemplate uses a SimpleMessageConverter

```java
@Bean
public MessageConverter messageConverter() {
  return new MappingJacksonMessageConverter();
}

@Bean
public JmsTemplate jmsTemplate(ConnectionFactory cf, MessageConverter mc) {
  JmsTemplate jmst = new JmsTemplate(cf);
  jmst.setDefaultDestionation("spittle.alert.queue");
  jmst.setMessageConverter(mc);
  return jmst;
}
```

#### consume messages

- both receive() and receiveAndConvert() are synchronous operations

```java
public Spittle receiveSpittleAlert() {
  try {
    ObjectMessage receivedMessage = (ObjectMessage) jmsOperations.receive();
    return (Spittle) receivedMessage.getObject();
    // spring cannot do much about an exception thrown in deeper level
  } catch (JMSException ex) {
    throw JmsUtils.convertJmsAccessException(ex);
  }
}
```

- when receive() is called, it attempts to retrieve a message from the message broker
  - if no message avaiable, receive() waits until a message becomes available

```java
public Spittle receiveSpittleAlert() {
  return jmsOperations.receiveAndConvert();
}
```

* Does it seem odd to synchronously consume a message that was asynchronously sent?
* that is where message-driven POJOs come in handy

### Message-driven POJOs

- would not be better if application would be notified when something arrives?

- MDBs are EJBs that process message asynchronously
  - had to implement javax.ejb.MessageDrivenBean
  - EJB 2 MDBs were very un-POJO

- with EJB 3 spec, no longer you must implement the MessageDrivenBean
- you implement more generic javax.jms.MessageListener and put @MessageDriven on MDBs

- Spring 2.0 addresses the need for asynchronous consumption of messages by
  providing its own message driven POJOs


- in Spring way, first we need to define a handler method and create a bean of that class
- then wrap it as inside listener-container as message-listener

- A message-listener container is a special bean that watches a JMS destination,
  waiting for a message to arrive. Once a message arrives, the bean retrieves
  the message and passes it on to any message listeners that are interested

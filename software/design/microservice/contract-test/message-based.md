# Message-based CDC

- Provider and consumer are decoupled, become autonomous
- Provider and message-broker can be tested in isolation
- Consumer and message-broker can be tested in isolation

* Message schemas and queues names are still shared
* Real brokers can be slow
* Messages can fanout
* Asynchronous failures are hard to debug

### Spring Cloud Contract Messaging

- Contract DSL supports message-driven interactions

- Supports Apache Camel, Spring Integration, Spring Cloud Stream & Spring AMQP

- Provides stub trigger abstraction for triggering messages

- Auto-generates provider side tests like HTTP

### Comsuming Messages

- Consumer receives messages from the broker

- Consumer needs to listen to the correct queue name

- also needs to know which schema the message payload has in order to be able to deserialize it.

- This is the information that we can catch in the contract

```groovy
Contract.make {
  label "label"   // unique id to trigger the contract in the consumer side tests
  input {         // is used on producer side verification test
    triggeredBy('triggerMessageSendingMethod()')
  }
  outputMessage { // defines a msg that will be produced by the contract
    sentTo "emails" // output channel
    body(
      to: 'fo@foo.com',
      message: 'bar'
    )
  }
  headers {
    header("contentType", applicationJson())
  }
}
```

* Consumer side

```java
@Autowired
private StubTrigger stubTrigger;

@Test
public void someTest() {
  // trigger manually, cus consumer does not do anything to trigger the message
  stubTrigger.trigger("label");

  // Assertions here
}
```

* Producer side

```java
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMessageVerifier
public class BaseContractTestMessaging {
  public void triggerMessageSendingMethod() {
  }
}
```

- Base class configuration for different kinds of contracts

```shell
- http # contains contract based on http
- messaging # contains contract based on messaging
```

```xml
<!-- spring-cloud-contract-maven-plugin -->
<configuration>
  <baseClassMappings>
    <baseClassMapping>
      <contractPackageRegex>.*http.*</contractPackageRegex>
      <baseClassFQN>com.td.BaseContractTest</baseClassFQN>
    </baseClassMapping>
    <baseClassMapping>
      <contractPackageRegex>.*messaging.*</contractPackageRegex>
      <baseClassFQN>com.td.BaseContractTestMessaging</baseClassFQN>
    </baseClassMapping>
  </baseClassMappings>
</configuration>
```

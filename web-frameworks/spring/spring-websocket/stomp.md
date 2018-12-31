# Spring STOMP support

- based on Spring MVC

- handling STOMP messages in a controller isn't much different from handing HTTP requests

```java
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
    config.enableSimpleBroker("/topic", "/queue");
    config.setApplicationDestinationPrefixes("/app");
  }

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry
      .addEndpoint("/gs-guide-websocket")
      .setAllowedOrigins("*") // Origin header value 'http://localhost:3000' not allowed.
      .withSockJS();
  }
}
```

- when a message arrives, the destination prefix will determine how the message is handled

- a message headed for an application destination is routed directly to an
  @MessageMapping-annotated controller method

- Messages destined for the broker, including any messages resulting from values
  returned by @MessageMapping methods, are routed to the broker and are
  ultimately sent out to clients subscribed to those destinations

### Enabling a STOMP broker relay

- the simple broker is great for getting started

- for production, you should back your WebSocket messaging with a real
  STOMP-enabled broker, such as RabbitMQ or ActiveMQ

```java
@Override
public void configureMessageBroker(MessageBrokerRegistry config) {
  config.enableStompBrokerRelay("/topic", "/queue");
  config.setApplicationDestinationPrefixes("/app");
}
```

- any messages whose destination begins with /topic or /queue should go to STOMP broker

- any messages whose destination begins with /app will be routed to an
  @MessageMapping method and not published to a broker queue or topic

### handling STOMP messages

- @MessageMapping annotated method can handle messages as they arrive

```java
@Controller
public class MarcoController {

  @MessageMapping("/marco")
  public void handleShout(Shout incoming) {
    sout("Received " + incoming.getMessage());
  }
}
```

- handles the messages for /app/marco destination

- /app is implied as it is the prefix that was configured as the application destination prefix

- MessageConverter will be used for the payload, as it is for @RequestMapping

### send messages

- WebSocket is often viewed as a way that a server can send data to the browser
  without being in response to an HTTP request

- void return methods only handle the incoming messages

- to send back messages the method has to have a return value

```java
@Controller
public class MarcoController {

  @MessageMapping("/marco")
  @SendTo("/topic/shout")
  public Shout handleShout(Shout incoming) {
    sout("Received " + incoming.getMessage());
    Shout outgoing = new Shout();
    outgoing.setMessage("Polo!");
    return outgoing;
  }
}
```

- any application that's subscribed to that topic (such as client), will receive that message

- @SubscribeMapping is sending the message directly to the client without going through the broker

### sending a message from anywhere

- @MessageMapping and @SubscribeMapping offer a simple way to send messages as a
  consequence of receiving a message or handling a subscription

- SimpleMessagingTemplate makes it possible to send message from anywhere in an
  application, even without having received a message first

- inject SimpleMessagingSendingOperations

- instead of user refreshing their page to see the updates on the feed, client
  can subscribe to a topic/tweetFeed, and server will send the new tweets

```java
@Service
public class SpittleFeedService {
    @Autowired
    private SimpleMessagingSendingOperations messaging;

    public void broadcastSpittle(Spittle spittle) {
      messaging.convertAndSend("/topic/spittleFeed", spittle);
    }
}
```

### working with user targeted messages

- the messages sent and received between a client and the server
- the user of that client hasn't been taken into account

- can use Spring Security authentication mechanism

```java
@MessageMapping("/spittle")
@SendToUser("/queue/notifications")
public Notification handleSpittle(Principal principal, SpittleInput spittleIn) {
  Spittle spittle = spittleRepo.save(spittleIn, principal.getName());
  return new Notification("saved spittle");
}
```

- behind the scene the notification will be rerouted the the authenticated user only
- /user is also a special prefix, and coverted to /queue/notifications-[randomSessionId]


```java
public void broadcastSpittle(Spittle spittle) {
  messaging.convertAndSend("/topic/spittlefeed", spittle);

  Matcher mention@Matcher = pattern.patcher(spittle.getMessage());
  if (mention@Matcher.find()) {
    String username = matcher.group(1);
    messaging.convertAndSendToUser(username, "/queue/notifications",
      new Notification("you just got mentioned!"));
  }
}
```

- will be published to /user/username/queue/notifications

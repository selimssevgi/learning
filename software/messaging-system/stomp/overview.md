# Simple Text Oriented Messaging Protocol

- write a web application using nothing but TCP sockets?

- HTTP addresses the minute of details of how a web browser makes a request and
  how a web server responds to that request

- most developers never write code that deals with low-level TCP socket communication

- working directly with WebSocket (or SockJS) is a lot like developing a web
  application using only TCP sockets

- you dont have to work with raw WebSocket connections
- just as HTTP layers a request-response model on top of TCP sockets,
- STOMP layers a frame-based wire format to define messaging semantics on top of WebSocket

- a STOMP frame that sends data

```shell
SEND
destionation:/app/marco
content-length:20

{\"message\": \"Marco!\"}
```

- STOMP is a messaging protocol (destination header), very much like JMS or AMQP

- message are published to destinations that may, in fact, be backed by real message brokers

- a browser can play the role of producer, and server will be consumer, also
  could be the other way around

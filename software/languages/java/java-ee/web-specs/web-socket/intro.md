# websockets

- JSR-356

- the client side apis can be used by any java applications

- the server-side apis are only available in jee containers

- javax.websocket, javax.websocket.server

- unlike servlets, a websocket endpoint is created for each client that initiates a connection

- an endpoint is stateful and serves only one client

### websocket endpoints

- websockets have two types of endpoints:

1. programmatic (extends javax.websocket.Endpoint)
2. annotated

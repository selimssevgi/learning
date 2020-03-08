# @HandlerChain

- define a set of handlers that are invoked in response to a SOAP message

- logically, handlers are similar to ejb interceptors

- there are 2 types of handlers:

1. logical handlers (@LogicalHandler)
  - operates on the message context props and message payload

2. Protocol handlers (@SOAPHandler)
  - operates on the message context props and protocol specific messages

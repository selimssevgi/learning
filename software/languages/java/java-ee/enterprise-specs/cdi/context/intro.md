# contexts

- the context determines the lifecycle of the bean, whether it lives for only
  one request or it is a port of a conversation or workflow

- contexts and scopes are used interchangeably

- cdi comes with 4 built-in contexts or scopes:

1. application
2. conversation - covers multiple requests, shorter than session
3. request
4. session

* besides these 4 scopes, there are also two pseudo-scopes:
  - singleton
  - dependent (default) - created each time an injection is performed

- every bean is associated with a scope
- the scope determines the lifecycle of the bean

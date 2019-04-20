# Spring MVC with REST Support

- whereas SOAP typically focused on actions and processing, REST's concern is
  with the data being handled (data is king)

- starting with Spring 3.0, Spring introduced first-class support for creating REST APIs

- Spring's REST support builds on Spring MVC

- SOAP cannot be consumed on mobile or JS clients

* Representational: REST resources can be represented in virtually any form:
  XML, JSON, or even HTML. whatever form best suits the consumer of those resources

* State: when working with REST, you are more concerned with the state of a
  resource then with the actions you can take against resources

* Transfer: REST involves transferring resource data, in some representatioanl
  form, from one application to another

- REST is about transferring the state of resources

- Resources in REST are identified and located with URLs
- URL should identify a resource, not bark a command to the server(focus on things, not actions)

### Spring's support

- controllers can handle requests for all HTTP methods, GET, PUT, DELETE, POST,
  with Spring 3.2 also PATCH

- @PathVariable for parameterized URLs (/user/{id})

- resources can be represented in a variety of ways using Spring views and view
  resolvers, including View implementations for rendering model data as XML, JSON, Atom, RSS

- the representation best suited for the client can be chosen using ContentNegotiatingViewResolver

- View-based rendering can be bypassed altogether using @ResponseBody and
  various HttpMethodConverter implementations

- @RequestBody and HttpMethodConverters can convert inbound HTTP data into Java
  objects passed into a controller's handler methods

- Spring applications can consume REST resources using RestTemplate


- Spring offers two options to transform a resource's Java representation into
  the representation that's shipped to the client:

1. Content negotiation: a view is selected that can render the model

2. Message conversion: transforms an object returned froma controller into a
   representation to be server to the client


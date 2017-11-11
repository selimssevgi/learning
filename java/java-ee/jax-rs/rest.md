# Rest - Representational State Transfer

- REST is an architectural style
- Rest is based on web standards and the HTTP protocol
- Initially described by Roy Fielding in 2000

- In a REST based architecture, everything is a RESOURCE
- A resource is accessed via a common interface based on the HTTP standard methods

- Every resource should support the HTTP common operations
- Resources are identified by global IDs (which are typically URIs)

- REST allows that resources have different representations, text, XML, JSON etc
- REST client can ask for a specific representation via the HTTP protocol

## HTTP methods

- PUT, GET, POST and DELETE methods are typically used in REST based architectures

* GET defines a reading access of resource without side-effects(idempotent)

* PUT creates a new resource. It must also be idemponent

* DELETE removes the resources. Idemponent. no different results in repeating

* POST updates an existing resource or creates a new resource

## Principles

- The REST architectural style is based on four principles:

1. Resource identification through ARI

2. Uniform interface (GET, POST, PUT, DELETE)

3. Self-descriptive messages, resources are decoupled from their represention,
   (XML, TEXT, HTML, JSON etc)

4. Stateful interactions through hyperlinks (URI rewriting, cookies, hidden form field)


# Hypermedia Services

- The very essense of hypermedia: by transiting links between resources, we
  change the state of an application.

- On each interaction, the service and consumer exchange representations of
  'resource state', not 'application state'.

- The current state of a resource is combination of:

* The values of information items belonging to that resource

* Links to related resources

* Links that represent a transition to a possible future state of the current resource

* The results of evaluating any business rules that relate the resource to other
  local resources

- The beauty of hypermedia is that it allows us to convey protocol information
  in a declarative and just-in-time fashion as part of an application's resource
  representations.

- Generally, it's better to expose only stable URIs. These stable URIs act as
  entry points to services, after which hypermedia takes over.

- Richardson's model:

* Hypermedia
* Http
* URI

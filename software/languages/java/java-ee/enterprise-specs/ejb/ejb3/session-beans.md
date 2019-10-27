# session beans

1. stateless
2. stateful
3. singleton

* use a Session bean if:
  - only one client has access to bean at any given time
  - state of bean is not persistent
  - bean represents a web service

* use a stateful session bean if:
  - bean state represents client interaction
  - bean needs to hold client data across interactions
  - bean acts as a client mediator to other beans
  - need thread-safe interactions

* session bean cardinality

                         | @Stateless | @Stateful | @Singleton
------------------------------------------------------------------
remote client access     | yes        | yes       | yes
local client access      | yes        | yes       | yes
concurrent client access | no         | no        | yes
unique per client        | no         | yes       | no
client-bean instances    | pooled     | 1:1       | many:1

### creation

- session bean instances are created and managed by container
  - no way for client to directly instantiate a bean
  - physical EJB object creation is "hidden" from client

* session beans are created as a result of some other action
  - stateless -- first client lookup
  - stateful -- on every client lookup
  - singleton -- on application load

### destruction

* session bean instance is destroted by container

* session bean "destruction" is result of some other action
  - stateless -- pool clean up or inactivity
  - stateful -- client inactivity or remove
  - singleton -- application shutdown

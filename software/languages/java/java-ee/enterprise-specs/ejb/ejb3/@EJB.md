# @EJB

- was introduced to allow injection of ejbs into client code without the client code needing to perform jndi lookups

- allow container to do the work of looking up beans and injecting them into
  classes instead of you having to do the jndi lookups yourself

- only works inside another ejb, in code running inside an application-client container

- is a special subset of DI that only handles ejbs

### attributes

- *beanName:* in case of more than one with the same interface

- *beanInterface:* in case of both local and remote interfaces, and using class
  type instead of interface type at the point of injection

- *lookup:* you can tell the container exactly which bean you want

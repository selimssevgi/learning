# ejb (enterprise java beans)

## what

- a simple java class is POJO

- ejb = POJO + some annotations

## jndi names

- java naming directory interface

- jndi name is used to look up a resource

- resources such as ejb, datasource, jms queue on application server is given a jndi name

- jndi name schema: resource-type/resource-name
  - jdbc/test-database
  - jms/test-que

### head first ejb

- ejb suports trxs, security, and concurreny, but it doesnot guarantee
  load-balancing, fail-over, or clustering.

- ejb provides component-based development
  - bean means component
  - instead of sharing just java classes, share more than that
    - reuse a bigger chunk of functionality
    - customize them without touching code

- ejb lets you focus on the business logic for your business, and leave the
  underlying services (trx, networking, security etc) to the ejb server vendor

- jvm - WORA, ejb - WODA (can deploy to any vendor)


* what is the diff between ejb and j2ee?

- both are specifications for a server
- ejb is subset of j2ee
- a j2ee server must include an ejb container
- javabeans run in an ejb container
- every j2ee server must include an ejb container(along with a web container
  that run servlets and JPPs)

* can i use ejb components without an ejb-compliant app server?

- no, ejb component cannot live outside of ejb container
- it needs the services provided by ejb container

* java bean vs enterprise bean

- java bean is just a pojo with some naming convention
- enterprise java bean kicks in at runtime, must be under the control of an ejb container

### how it works?

- server steps into the middle of every method call from a client to a bean and
  insert the service like security, trx, persistence etc


- client -> ejbobject -> container(services) -> java bean(from the bean pool)

## types of enterprise beans

1. session beans (does something)
2. message driven beans
3. entity beans (is something)


#### session beans

- encapsulates business logic that can be invoked by a client

- invocation can be done by in same jvm or remotely

- the bean performs the task for the client, abstracting its complexity similar to a web service

- lifecycle of a session bean is managed by ejb container
  - stateless (shared, must be thread-safe)
  - stateful (unique to each client, conversational state)
  - singleton (shared state across all clients)

*NOTE:* stateless beans can have state (just not client-specific state)

- a stateless bean can have instance variables like any other object; it just
  can't use them to maintain values specific to a particular client

#### message driven beans (MDB)

- allows you to process messages asynchronously
- acts as a jms listener

- in many ways similar to stateless session beans
  - but not invoked by client
  - they are event-driven

- j2ee application = (servlet and jsp) + ejb components

- beneath ejb, there is java's distributed technologiy for RMI

- local beans share the same heap/jvm

- EJB uses java rmi so that your beans can be accessed by remote clients

- local client doesnot use RMI to invoke business methods

- plain rmi : client -> stub || -> remote object -> db
- rmi in ejb: client -> stub || -> remote object(EJBObject) -> services -> enterprise bean

- in ejb, the EJBObject is the bean's bodyguard

- the container implements your component interface(EJBObject)


### the bean home

- every session and entity bean has a Home

- MDBs dont have homes because MDBs dont have a client view
  - clients cant get a reference to a MDB

- its job is to hand out references to a bean's component interface

- the home is like a bean factory for that type

- the AdviceBean is deployed, and the server instantiates the AdviceBean Home
  object and registers it with JNDI


- stateless beans instatiation can be postponed to later time
- clients dont share EJBObjects, but the same bean can service multiple EJBObjects

#### MDBs

- dont have a client view
- dont have interfaces(remote or local)
- dont have a Home or EJBObject
- dont have a Home interface or a Component interface

#### ch3

- home object(bean factory) -> EJbObject(proxy) -> bean (business class)

- bean name

```java
Context ic = new InitialContext();
Object o = ic.loopup("Advisor"); // this name was given in deployment descriptor
AdviceHome home = (AdviceHome) o;
Advice advisor = home.create();
sout(advisor.getAdvice());
```

- we can remove beans, when we are done, we need a key for that
  - cus home might create many beans so far, should know which one should remove
- we dont have to remove home, container should keep that around

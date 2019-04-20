# API Gateway

When a service client invokes a service directly, there's no way you can easily
implement cross-cutting concerns such as security or logging without having each
service implement this logic directly in the service.

- The service gateway sits between the service client and the corresponding
  service instances. All service calls (both internal-facing and external)
  should flow through the service gateway.

- It also acts as a central Policy Enforcement Point (PEP) for service calls.

- The use of a centralized PEP means that cross-cutting service concerns can be
  implemented in a single place without the 'individual' development teams
  having to implement these concerns.

- Example of cross-cutting concerns that can be implemented in a service gateway:

* Static routing: A service gateway places all service calls behind a single URL
  and API route. This simplifies development as developers only have to know
  about one service endpoint for all of their services.

* Dynamic routing: A service gateway can inspect incoming service requests and,
  based on data from the incoming request, perform intelligent routing based on
  who the service caller is. For instance, customers participating in a beta
  program might have all calls to a service routed to a specific cluster of
  services that are running a different version of code from what everyone else
  is running.

* Authentication and authorization: Because all service calls route through a
  service gateway, the service gateway is a natural place to check whether the
  caller of a service has authenticated themselves and is authorized to make the
  service call.

* Metric collection and logging: A service gateway can be used to collect
  metrics and log information as a service call passes through the service
  gateway. You can also use the service gateway to ensure that key pieces of
  information are in place on the user request to ensure logging is uniform.


**Single Point of Failure**

- A load balancer sitting in front of multiple gateway instances is an
  appropriate design and ensures your service gateway implementation scale.

- Keep any code for service gateway stateless.

- Keep the code you write for service gateway light.


## @EnableZuulServer vs @EnableZuulProxy

- @XServer will create a Zuul Server that doesn't load any of the Zuul reverse
  proxy filters or use Netflix Eureka for service discovery.

- @XServer is used when you want to build your own routing service and not use
  any Zuul pre-built capabilities. An example of this would be if you wanted to
  use Zuul to integrate with a service discovery engine other than Eureka (for
  example Consul)

## Routes in Zuul

- Zuul at its heart is a reverse proxy

- A reverse proxy is an intermediate server that sits between the client trying
  to react a resource and the resource itself.

- Zuul has to know how to map the incoming call to a downstream route
- Zuul has several mechanisms to do this:

1. Automated mapping of routes via service discovery
2. Manual mapping of routes using service discovery
3. Manual mapping of routes using static URLs

### Automated mapping routes via service discovery

- Zuul automatically route requests based on their service IDs with zero configuration

- If you don't specify any routes, Zuul will automatically use the Eureka
  service ID of the service being called and map it to a downstream service instance

```shell
localhost:5555/organizationservice/v1/org/random-uuid
```

- localhost:5555 is the Zuul server.
- organizationservice is the service you want to invoke.


* The beauty of using Zuul with Eureka is that not only do you now have a single
  endpoint that you can make calls through, but with Eureka, you can also add
  and remove instances of a service without ever having to modify Zuul.

### Mapping routes manually using service discovery

- Zuul allows you define routes.

```shell
zuul.routes.organizationservice: /organization/**

# can be accessed
localhost:5555/organization/v1/org/random-uuid
```

### Manual mapping of routes using static URLs

- Zuu can be used to route services that aren't managed by Eureka.

```shell
zuul.routes.licencestatic.url=http://licenceservice-static:8081
```

## Filters

- The real power of Zuul comes into play when you want write custom logic that
  will be applied against all the service calls flowing through the gateway.

- Most often the custom logic is used to enforce a consistent set of application
  policies like security, logging, and tracking against all the services.

- Zuul filters can be used in a similar way as a J2EE servlet filter or a Spring
  Aspect that can intercept a wide body of behaviors and decorate or change the
  behavior of the call without the original coder being aware of the change.

- Zuul supports three types of filters:

1. Pre filters -- A pre-filter usually carries out the task of making sure that
   the service has a consistent message format (key HTTP headers are in place),
   or acts as gatekeeper to ensure that the user calling the service is
   authenticated and authorized

2. Post filters -- Usually a post filter will be implemented to log the response
   back from the target service, handle errors, or audit the response for
   sensitive information.

3. Route filters -- Usually a route filter is used to determine if some level of
   dynamic routing needs to take place. For instance, use a route-level filter
   that will route between two different version of the same service so that a
   small percentage of calls to a service are routed to a new version.


** A pre-filter cannot redirect the user to a different endpoint or service.

** Route filters can change the destination of where the service is heading. A
Zuul route filter doesn't do an HTTP redirect, but will instead  terminate the
incoming HTTP request and then call the route on behalf of the original caller


** Zuul does not allow you to directly add or modify the HTTP request headers on
an incoming request. If  ;


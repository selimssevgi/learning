# Spring 3.1

- to address the common issue of selecting distinct configurations for various
  environments (such as dev,tst,liv). Spring 3.1 introduced environment profiles

- building on Spring 3.0's Java-based configuration, Spring 3.1 added several
  'enable' annotations to switch on certain features of Spring with a single annotation

- declarative caching support made its way into Spring, similar to how you could
  already declare transaction boundaries

- a new *c* namespace brought constructor injection the same succint
  attribute-oriented style as Spring 2.0's *p* namespace brought property injection

- Spring began to support Servlet 3.0, including the ability to declare servlets
  and filters in Java-based configuration instead of web.xml

- Improvements to Spring's JPA support made it possible to completely configure
  JPA in Spring without needing a persistence.xml file

### Spring MVC

- automatic binding of path variables to model attributes

- @RequestMapping *produces* and *consumes* attributes

- @RequestPart that enables binding parts of a multipart request to handler method parameters

- support for flash attributes (attributes that survive a redirect) and a
  RedirectAttributes type to carry the flash attributes between requests

## Deprecation

- JpaTemplate and JpaDaoSupport were deprecated in favor of native EntityManager usage

- they were removed in Spring 4.


# Spring Security Filter

- Spring Security employs several servlet filters to provide various aspects of security

- thanks to a little Spring magic we only need to configure one filter instead
  of several filter in web.xml or WebApplicationInitializer

- DelegatingFilterProxy is a special servlet filter that, by itself, doesnot do much
- it delegates to an implementation of javax.servlet.Filter that is registered as a ben


```xml
<filter>
  <filter-name>springSecurityFilterChain</filter-name>
  <filter-class>
    org.springframework.web.filter.DelegatingFilterProxy
  </filter-class>
</filter>
```

- java config that implements WebApplicationInializer

```java
public class SecurityWebInitializer
  extends AbstractSecurityWebApplicationInitializer {}
```

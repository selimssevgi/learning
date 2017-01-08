# Deployment Descriptor (DD)
It provides a "declarative" mechanism for customizing your web applications
without touching source code.

- Mapping URLs to actual servlets
- Security roles
- Error pages
- Tag libraries
- Initial configuration information


## Init Parameters

### ServletConfig
We can put these in java code too, but in case of change we have to recompile
the source. However, in case of XML restarting web container is enough. 

Restarting Web Container for a parameter is not a good idea. Thats why there is
such thing as hot redeploy, redeploys entire web apps without restarting Tomcat.

If the value changes frequently, better to read that value from a database.


```xml
<!-- web.xml -->
<servlet>
  <servlet-name>ParamTest</servlet-name>
  <servlet-class>com.selimssevgi.ParamServlet</servlet-class>

  <init-param>
    <param-name>adminEmail</param-name>
    <param-value>admin@email.com</param-value>
  </init-param>
</servlet>
```

```java
// ParamServlet.java
out.println(getServletConfig().getInitParameter("adminEmail"));
```

### ServletContext
Parameters are availabe in all servlets and JSP etc.

```xml
<!-- web.xml -->
<servlet>
  <servlet-name>ParamTest</servlet-name>
  <servlet-class>com.selimssevgi.ParamServlet</servlet-class>
</servlet>

<!-- child of web-app -->
<context-param>
  <param-name>adminEmail</param-name>
  <param-value>admin@email.com</param-value>
</context-param>
```

```java
// ParamServlet.java
out.println(getServletContext().getInitParameter("adminEmail"));
```

### ServletContextListener
It is listening servletContext, therefore it is application wide. It should be
in <web-app> tag, not in <servlet> tag.

```xml
<web-app>
    <context-param>
        <param-name>breed</param-name>
        <param-value>Great Dane</param-value>
    </context-param>

    <listener>
        <listener-class>
          com.servletcontextlistenerexample.MyServletContextListener
        </listener-class>
    </listener>
</web-app>
```

## Session
To define how long sessions will be valid. (in minutes)

```xml
<web-app>
  <session-config>
    <session-timeout>15</session-timeout>
  </session-config>
</web-app>
```

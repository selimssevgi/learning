# Understand web.xml

- the deployment descriptor file: web.xml

- is the entry point to understand all configuration for a Spring MVC project

- in many cases; there are 2 types of xml configuration files:

1. web.xml: describe how to deploy the web application to any Java Servlet container

2. content configuration xml: configuration file to create Spring Application Context

### what is web.xml

- /WEB-INF/web.xml is used to define how to deploy the web module to a Servlet
  container like JBoss, Tomcat, Glassfish etc.

- it is part of java servlet specification

- the file name and location can not be changed

- basically web.xml tell container all servlets in the web application with *servlet* tag element

- then tell container when to use which servlet by the url mapping with *servlet-mapping* tag

* In spring mvc project, for most cases, there is only one servlet: DispatcherServlet

- let this DispatcherServlet handle all requests

- after container hands over the request to DispatcherServlet, the incoming http
  request formally enters the Spring world.


### what is context configuration xml

- there will be at least one xml to configure Spring MVC WebApplicationContext

- there are 2 types of WebApplicationContext:

1. Root WebApplicationContext
2. Servlet WebApplicationContext

- All servlets, although in most cases only one DispatcherServlet, share root context

- Each servlet has its private context

- Spring tries to locate a bean first in Servlet context, if not found, then search root context.

* The default configuration file for root WebApplicationContext: /WEB-INF/applicationContext.xml

* the default configuration file for servelt WebApplicationContext: /WEB-INF/[servletName]-servlet.xml

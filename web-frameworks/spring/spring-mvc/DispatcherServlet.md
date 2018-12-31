# DispatcherServlet

- is the centerpiece of Spring MVC

- is where the request first hits the framework

- is responsible for routing the request through all the other components

- historically, servlets like DispatcherServlet have been configured in a web.xml

- thanks to recent advances in the Servlet 3 spec and in Spring 3.1, web.xml is not the only option


```java
public class SpittrWebAppInitializer
  extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
      return new String[] { "/" }; // map DispatcherServlet to /
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
      return new Class<?>[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
      return new Class<?>[] { WebConfig.class };
    }
  }
```

- in a Servlet 3.0 environment, the container looks for any classes in the
  classpath that implement the javax.servlet.ServletContainerInitializer
  interface; if any are found, they are used to configure the servlet container

- spring supplies an implementation of that interface called SpringServletContainerInitializer

- that implementation seeks out any classes that implement
  WebApplicationInitializer and delegates to them for configuration

- Spring 3.2 introduced a convenient base implementation of
  WebApplicationInitializer called AbstractAnnConfDisSerInitializer

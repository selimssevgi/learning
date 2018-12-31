# a tale of two application context

- When DispatcherServlet starts up, it creates a Spring application context and
  starts loading it with beans declared in the configuration files or classes that's given

- in spring web applications, there's often another application context

- this other application context is created by ContextLoaderListener

- whereas DispatcherServlet is expected to load beans containing web components
  such as controllers, view resolvers, and handler mappings.

- ContextLoaderListener is expected to load the other beans, typically
  middle-tier and data-tier components that drive the back end of the application


```java
public class SpittrWebAppInitializer
  extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
      return new String[] { "/" }; // map DispatcherServlet to /
    }

    // will be used to configure appContext created by ContextLoaderListener
    @Override
    protected Class<?>[] getRootConfigClasses() {
      return new Class<?>[] { RootConfig.class }; // @Configuration classes
    }

// will be used to configure appContext created by DispatcherServlet
    @Override
    protected Class<?>[] getServletConfigClasses() {
      return new Class<?>[] { WebConfig.class }; // @Configuration classes
    }
  }
```

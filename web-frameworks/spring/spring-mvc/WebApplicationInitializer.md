# WebApplicationInitializer

- one of the nice things working with a java-based initializer is that (unlike
  web.xml) you can define as many initializer as you want.

- if you need to register any additional components into the web container, you
  need only create a new initializer class.


```java
public class MyServletInitializer implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) {
    Dynamic myServlet = servetContext.addServlet("myServlet", MyServlet.class);

    myServlet.addMapping("/custom/**");
  }
}
```

- you can register filters as well

```java
@Override
public void onStartup(ServletContext servletContext) {
  Dynamic myFilter = servetContext.addFilter("myFilter", MyFilter.class);

  myFilter.addMappingForUrlPatterns(null, false, "/custom/**");
}
```

- WebApplicationInitializer is a fine general-purpose way of registering
  servlets, filters, and listeners in Java when deploying to a Servlet 3.0 container

- to register one or more filters and map them to DispatcherServlet

```java
// AbstractAnnotationConfigDispatcherServletInitializer
@Override
protected Filter[] getServletFilters() {
  return new Filter[] { new MyFilter() };
}
```

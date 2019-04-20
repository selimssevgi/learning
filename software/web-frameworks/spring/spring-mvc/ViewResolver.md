# ViewResolver

- spring mvc defines an interface named ViewResolver that looks like this:


```java
public interface ViewResolver {
  View resolveViewName(String viewName, Locale locale) throws Exception;
}

public interface View {
  String getContentType();

  void render(Map<String, ?> model, HttpServletRequest req, HttpServletResponse req) throws Exception;
}
```

- typically, you would not need to implement those interface, Spring provides
  several out-of-the-box implementations

View resolver                                 | Description
------------------------------------------------------------------------------
BeanNameViewResolver
ContentNegotiatingViewResolver
FreeMarkerViewResolver
InternalResourceViewResolver                  | typically jsp
JasperReportsViewResolver
ResourceBundleViewResolver
TilesViewResolver
UrlBasedViewResolver
VelocityViewResolver
XmlViewResolver                               | similar to BeanNameResolver
XsltViewResolver


### InternalResourceViewResolver

- /WEB-INF/views/home.jsp
- "/WEB-INF/view/" is prefix
- ".jsp" is suffix
- "home" is logical view name

```java
@Bean
public ViewResolver viewResolver() {
  InternalResourceViewResolver resolver = new InternalResourceViewResolver();
  resolver.setPrefix("/WEB-INF/views/");
  resolver.setSuffix(".jsp")
  return resolver;
}

// home -> /WEB-INF/views/home.jsp
// productList -> /WEB-INF/views/productList.jsp
// books/detail -> /WEB-INF/views/books/details.jsp
```

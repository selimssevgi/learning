# thymeleaf

- jsp is a spec that is thightly coupled to the servlet specification

- jsp can only be used for web views in a servlet-based web application

- jsp templates aren't an option for general-purpose templating(formatted emails)

- thymeleaf templates are natural and don't rely on tag libraries

- they can be edited and rendered and anywhere that raw HTML is welcome

- a SpringTemplateEngine processes the templates and render results
- a TemplateResolver loads Thymeleaf templates

```java
@Bean
public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
  ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
  viewResolver.setTemplateEngine(templateEngine);
  return viewResolver;
}

@Bean
public TemplateEngine templateEngine(TemplateResolver templateresolver) {
  SpringTemplateEngine templateEngine = new SpringTemplateEngine();
  templateEngine.setTemplateResolver(templateResolver);
  return templateEngine;
}

@Bean
public TemplateResolver templateResolver() {
  TemplateResolver templateResolver = new ServletContextTemplateResolver();
  femplateResolver.setPrefix("/WEB-INF/templates/")
  templateResolver.setSuffix(".html");
  templateResolver.setTemplateMode("HTML5");
  return templateResolver;
}
```


```html
<a th:href="@{/register}">Register</a>
```

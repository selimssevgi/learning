# Spring 3.2

- it was primarily a Spring MVC focused release

- Controllers can take advantage of Servlet 3's async requests to spin off
  request processing in separate threads, freeing up the servlet thread to process more request

- Although Spring MVC controllers have been easily testable as POJOs since
  Spring 2.5, Spring 3.2 included a Spring MVC test framework for writing richer
  tests against controllers, asserting their behavior as controllers, but without a servlet container

- included support for testing RestTemplate-based clients without sending
  requests to the real REST endpoint

- an @ControllerAdvice annotation enables common @ExceptionHandler, @InitBinder,
  and @ModelAttributes methods to be collected in a single class and applied to all controllers.

- Prior to Sptring 3.2, full content negatiation support was only available via
  ContentNegatiatingViewResolver. But in 3.2, it became available throughout
  Spring MVC, even on controller methods relying on message converters for
  content consumption and production

- the abstract base class AbstractDispatcherServletInitializer can be used for
  conveniently configuring DispatcherServlet without web.xml

- ResponseEntityExceptionHander was added to be used as an alternative to
  DefaultHandlerExceptionResolver. the new one's methods return
  ResponseEntity<Object> instead of ModelAndView

- RestTemplate and @RequestBody arguments support generic types

- RestTemplate and @RequestMapping methods support the HTTP patch method

- Mapped interceptors support URL patterns to be excluded from interceptor processing

### other improvements

- @Autowired, @Value, and @Bean can be used as meta-annotations to create custom
  injection and bean-declaration annotations.

- integration tests can configure and load a WebApplicationContext

- integration tests can test against request- and session-scoped beans

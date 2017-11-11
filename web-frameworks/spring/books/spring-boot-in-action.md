# Spring Boot in Action

- When Spring 1.0 hit the scene, it completely changed how we develop enterprise
  Java applications. Spring DI and declarative transactions meant no more tight
  coupling of components and no more heavyweight EJBs. It couldnt get any better

- With Spring 2.0 we could use custom XML namespaces for configuration, making
  Spring itself even easier to use with smaller and easier to understand
  configuration files. It couldnt get any better

- Spring 2.5 gave us a much more elegant annotation-oriented DI model with the
  @Component and @Autowired annotations, as well as an annotation-oriented
  Spring MVC model. No more explicit declaration of application components, and
  no more subclassing one of several base controller classes. It couldnt get any
  better

- Then with Spring 3.0 we were given a new Java-based configuration alternative
  to XML that was improved further in Spring 3.1 with a variety of
  @Enable-prefixed annotations. For the first time, it become realistic to write
  a complete Spring application with no XML configuration. It couldnt get any
  better

- Spring 4.0 unleashed support for conditional configuration, where where
  runtime decisions would determine which configuration would be used and which
  would be ignored based on the application's classpath, environment, and other
  factors. We no longer needed to write scripts to make those decisions at build
  time and pick which configuration should be included in the deployment. How
  could it possibly get any better?

## Chapter 1

### Examining Spring Boot Essentials

- Automatic configuration -- Spring Boot can automatically provide configuration
  for application functionality common to many Spring applications

- Starter dependencies -- You tell Spring Boot what kind of functionality you
  need, and it will ensure that the libraries needed are added to the build

- The command-line interface -- This optinal feature of Spring Boot lets you
  write complete applications with just application code, but no need for a
  traditional project build

- The Actuator -- Gives you insight into what's going on inside of a running
  Spring Boot application

* The Actuator, lets you inspect the inner workings of your application

- What beens have been configured in the Spring application context
- What decisions were made by Spring Boot's auto-configuration
- What environment variables, system properties, configuration properties, and
  command-line arguments are available to your application
- The current state of the threads in and supporting your application
- A trace of recent HTTP requests handled by your application
- Various metrics pertaining to memory usage, GC, web requests, and data source
  usage


- XXXApplication.java is a both a bootstrap class and a configuration class

### @SpringBootApplication

- @SpringBootApplication -- Enable component-scanning and auto-configuration

- @SpringBootApplication combines three other useful annotations

1. Spring's @Configuration -- Designates a class as a configuration class using
   Spring's Java-based configuration.

2. Spring's @ComponentScan -- Enables component-scanning so that the web
   controller classes and other components you write will be automatically
   discovered and registered as beans in the Spring application context.

3. Spring Boot's @EnableAutoConfiguration -- this humble little annotation might
   as well be named @Abracadabra because it's the one line of configuration that
   enables the magic of Spring Boot auto-configuration.


- IF your application requires any additional Spring configuration beyond what
  Spring Boot auto-configuration provides, it's usually best to write it into
  separate @Configuration-configured classes

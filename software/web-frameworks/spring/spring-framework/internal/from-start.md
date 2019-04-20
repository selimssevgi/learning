# Spring Boot Application

```java
@SpringBootApplication
public class SpringDataApplication {

  public static void main(String[] args) {
    // SpringApplication.run(SpringDataApplication.class, args);
    SpringApplication springApplication =
      new SpringApplication(SpringDataApplication.class);
    springApplication.run(args);
  }

}
```

### SpringApplication

- takes primary sources
- deduces the web application type (none, servlet, reactive)
  - environment changes based on type: ServletEnv, ReactiveEnv, StandardEnv
  - deduceEnvironmentClass-switch
  - switch on to pick context class
- finds, initiates, sorts the ApplicationContextInitializers
- finds, initiates, sorts the ApplicationListeners
  - starting
  - environmentPrepared
- deduces the main application class

### run(args)

- start stop watch
- SpringApplicationRunListeners
- listeners.starting()
- handling args
- prepare environment - publish event
- print banner
- create application context
- apply initializers
  - DelegatingApplicationContextInitializer (property: context.initializer.classes)
  - SharedMetadataReaderFactoryContextInitializer (internal)
  - ContextIdApplicationContextInitializer ((spring.application.name || 'application') + ++AtomicLong)
  - ConfigurationWarningsApplicationContextInitializer
  - ServerPortInfoApplicationContextInitializer - WebServerInitializedEvent
  - ConditionEvaluationReportLoggingListener
- listeners.contextPrepared
- log start up info
- prepare context
- listener.contextLoaded

### ApplicationContextInitializer

### SpringFactoriesLoader

### SimpleApplicationEventMulticaster

### AnnotationConfigApplicationContext

- default content when application is WebApplicationType.NONE

### BeanDefinitionLoader

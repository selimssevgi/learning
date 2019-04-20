# BeanPostProcessor

- An important extension point in Spring
  - can modify bean instances in any way
  - powerful enabling feature

- Spring provides many implementations
  - not common to write your own (but you can)


```java
public interface BeanPostProcessor {

  Object postProcessorAfterInitialization(Object bean, String beanName);
  Object postProcessorBeforeInitialization(Object bean, String beanName);

}
```

## By Framework

- CommonAnnotationBeanPostProcessor - handles JSR-250 (@PostContruct)

- RequiredAnnotationBeanPostProcessor - enforces @Required semantics

- AutowiredAnnotationBeanPostProcessor - enables recognition of @Autowired

- ConfigurationClassPostProcessor  enables java configuration support

- PersistenceAnnotationBeanPostProcessor - enables use of @PersistenceContext

- PersistenceExceptionTranslationPostProcessor - performs exception translation
  for classes annotatied with @Repository

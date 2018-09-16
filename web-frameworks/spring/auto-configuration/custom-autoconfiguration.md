# Writing Your First Custom Auto-Configuration

- Custom auto-configuration is going to be its own library,

- projectname-autoconfigure

```java
@Configuration
@ConditionalOnClass({SomeUsedLibrary.class, AnotherUsedLibrary.class})
public class ProjectAutoConfiguration {

  @Bean
  // providing default and possibility to override it
  @ConditionalOnMissingBean(AaService.class)
  public AaService aaService() {
    return new AaService();  
  }

  @Bean
  @ConditionalOnProperty(prefix = "com.project", name="customize")
  public Boolean doSomeMutation() {
    // side-effect method  
    return true;
  }

  @Configuration
  @ConditionalOnWebApplication
  public static class SomeOtherConfiguration {
      // some other bean definitions
  }
}
```

## spring.factories

- under auto-configure project, src/main/resources/META-INF/spring.factories

```shell
# spring.factories
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
  full.package.name.ProjectAutoConfiguration
```

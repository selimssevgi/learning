# Spring Boot Annotations

- @SpringBootApplication
- @Component
- @Service
- @Repository
- @Configuration
- @Bean
- @RestController
- @PathVariable

## @SpringBootApplication

- Is a shortcut, marks the class as a configuration class

- begins auto-scanning all the classes on the Java class path for other Beans

- Can be used for instead of all the following:
  - @EnableAutoConfiguration
  - @Configuration
  - @ComponentScan

## @EnableAutoConfiguration
  - Framework will make smart configurations for us
  - Goes to class with main method
  - Run Configuration / Enable Debug Output

## @Value()

## @RestController

- is a class level annotation

- tell Spring Boot this is a REST-based services

- Spring will automatically serialize/deserialize service request/response to JSON

- doesn't require the developer to return a ResponseBody class

- It includes a @ResponseBody annotation

## @PathVariable

- is used to map the parameter values passed in the incoming URL to the parameters

```java
@RestController
@RequestMapping("/v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

  @GetMapping("/{licenseId}")
  public License getLicense(@PathVariable("organizationId") String organizationId,
                            @PathVariable("licenseId") String licenseId) {
    return new License()
    .withId(licenseId)
    .withOrganizationId(organizationId)
    .withProductName("Teleco")
    .withLicenseType("Seat");
  }
}
```

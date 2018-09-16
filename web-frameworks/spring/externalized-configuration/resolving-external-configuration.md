# Resolving External Configuration

- Spring Boot provides a standard cascading resolution of configuration

- The order by default:

1. Command line arguments: --server.port=9000, --debug

2. Embedded JSON in SPRING_APPLICATION_JSON

3. StandardServletEnvironment, System.getProperties(), OS env variables

3. RandomValuePropertySource, ${random.\*} replacements

4. application.properties/yml, profile specifies is 1st

5. @PropertySource

6. Default Properties: SpringApplication.setDefaultPropertie

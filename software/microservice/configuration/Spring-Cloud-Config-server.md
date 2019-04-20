# Spring Cloud Configuration Server

- is a REST-based application that's built on top of Spring Boot

- It doesn't come as a standalone server.

- You can choose to either embed in an existing SBoot application or start a new
  SBoot project with the server embedded it

- Spring Cloud Config server can use file system, Git, Eurake, Consul as backend services

```shell
/ resources
  / config
    / licensingservice
      / licesingservice.yml
      / licesingservice-dev.yml
      / licesingservice-prod.yml
  / application.yml             // normal SBoot config
  / bootstrap.yml               // bootstapping config
```

* Your config service will be another microservice running in your environment.
  Once it is set up, the contents of the service can be access via REST endpoint

- The environment names translate directly into the URLs that will e accessed to
  browse the configuration information

- The environment you want to run the service against is specified by the SBoot
  profile that you pass in on the command-line service startup

- If a profile isn't passed in on the command-line, Spring Boot will always
  default to the configuration data contained in the application.yml file
  packaged with the application

## Using with the filesystem


```shell
// Config-server's application.yml
server:
   port: 8888
spring:
   profiles:
      active: native
   cloud:
      config:
         server:
            native:
               # comma-separated list
               searchLocations: file:///<full-path>/config-server/src/main/resources/config/licensingservice

# locahost:8888/licensingservice/default -> licensingservice.yml
# locahost:8888/licensingservice/dev     -> licensingservice-dev.yml
```

- When you ask for the dev/prod properties, response will also have the default one

- Spring always look for the property in the default properties first and then
  override the deafault with an environment-specific value if one is present

## Configuring a service to use Spring Cloud Config

- spring-cloud-config-client dependency should be added in to pom.xml

- bootstrap.yml file reads the application properties before any other
  configuration information is used

- bootstrap.yml contains application name for the service, the application
  profile, and the URI to connect to a Spring Cloud Config server.

- Any other information that you want to keep local to the service (and not
  stored in Spring Cloud Config) can be set locally in the services in the
  application.yml

- Usually, the information you store in the application.yml file is
  configuration data that you might want to have available to a service even if
  the Spring Cloud Config service is unavailable

```yaml
# bootstrap.yml
spring:
  application:
    name: licensingservice # must map directly to the name of the directory within SCConfig server

profiles:
  active: default

cloud:
  config:
    uri: http://localhost:8888
```

## Using Git for backend

- using a filesystem as the backend repository for SCConfiguration server can be
  impractical for a cloud-based application because the dev tem has to set ip
  and manage a shared filesystem

```yml
server:
  port: 8888
spring:
  cloud:
    config:
      server:
        git:   # tells the spring cloud config to use Git as a backend repository
          uri:
          search-paths: licensingservice # comma-separated list
          username:
          password:
```

## Refreshing properties

- How can we dynamically refresh our applications when a property changes

- Spring Cloud Config server will always serve the latest version of a property

- Spring Boot applications will only read their properties at startup time

- Property changes made in the Spring Cloud config server won't be automatically
  picked up by the Spring Boot application

- Spring Boot Actuator does offer a @RefreshScope annotation that will allow a
  dev team to access a /refresh endpoint that will force the SBoot application
  to reread its application configuration

```java
@SpringBootApplication
@RefreshScope
public class LicensingServiceApplication {}
```

* @RefreshScope will only reload the custom Spring properties you have in your applications configuration

* Items such as db configuration that are used by Spring Data won't be reloaded by the @RefreshScope

* Spring Cloud Config server can push changes to instances, requires Bus and RabbitMQ

* An script can handle via /refresh endpoint using resfresh events

* Another way could be restarting all instances so they will pick up changes

### Protecting sensitive configuration information

- Do not keep credentials in plain text in config files

- Spring Cloud Config gives you the ability to encrypt your sensitive properties easily

- Spring Cloud Config supports using both symmetric (shared secret) and
  asymmetric (public/private key) encryption

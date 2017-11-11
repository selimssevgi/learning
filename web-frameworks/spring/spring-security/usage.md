# Spring Security Usage

- add following three dependencies:

- spring-security-core
  - contains core authentication and access-control classes and interfaces
- spring-security-web
  - contains filters and related web-security infrastructure code, also URL based security
- spring-security-config
  - is used for configuring the authentication providers, whether to use JDBC, DAO etc
  - contains the security namespace parsing code, required if XML file used for configuration
- spring-security-taglibs
  - provides basic support for accessing security info and applying security constraints in JSP



















```xml
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-web</artifactId>
    <version>${springsecurity.version}</version>
</dependency>

<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-config</artifactId>
    <version>${springsecurity.version}</version>
</dependency>

<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-taglibs</artifactId>
    <version>${springsecurity.version}</version>
</dependency>
```

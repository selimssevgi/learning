# Spring Security

- is a framework that focuses on providing both authentication and authorization to Java EE-based enterprise software applications

- a security framework implemented with Spring AOP and servlet filters

- tackes security from two angles:

1. to secured web requests and restrict access at the URL level: it uses servlet filters
2. can also secure method invocations using Spring AOP (@Secured)

## Benefits

- Prevents some of the common attacks such as CSRF, session fixation attacks
- Easy to integrate in any web application, no need to modify app config
- Spring automatically injects security filters to the web application
- Provides support for auth by different ways - in-memory, DAO, JDBC, LDAP and many more
- Provides option to ignore specific URL patterns, good for serving static HTML, image files
- Support for groups and roles

### spring security modules

module         | description
----------------------------------------------------------
ACL            | domain object security through Access Control Lists
Aspects        | provides support for AspectJ-based aspect instead of Spring AOP
CAS client     | for single sign-on authentication using Central Authentication Service
configuration  | configuring spring security with XML and Java(support with 3.2)
core           | essential library
cryptography   | for encyription and password encoding
ldap           | support for ldap-based authentication
openID         | support for centralized authentication with OpenID
tag library    | JSP tag library
web            | filter-based web security support

# Security Configuration

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {}
```

- @EnableWebSecurity is generally useful for enabling security in any web
  application. but if you happen to be developing a spring mvc application, you
  should consider using @EnableWebMvcSecurity instead.

```java
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {}
```

- among other thinds, @EnableWebMvcSecurity configures a Spring Mvc argument
  resolver so that handler methods can receive @AuthenticatedPrincipal parameters

- it also configures a bean that automatically adds a hidden CSRF token field on
  forms using Spring's form-binding tag library

### customization

- we can override the configure() methods in WebSecurityConfigurerAdapter

method                                  | description
----------------------------------------------------------------------
configure(WebSecrity)                   | configure Spring Security's filter chain
configure(HttpSecurity)                 | configure how requests are secured by interceptors
configure(AuthenticationManagerBuilder) | configure user-details services

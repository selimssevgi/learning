# Securing Methods

- Spring Security provides three different kinds of security annotations:

1. Spring Security's own @Secured
2. JSR-250's @RolesAllowed
3. Expression-driven annotations: @PreAuthorize, @PostAuthorize, @PreFilter, @PostFilter

### @Secured

```java
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {}
```

- when 'securedEnabled' is true, a pointcut is created such that the Spring
  Security aspects will wrap bean methods that are annotated with @Secured


```java
@Secured("ROLE_SPITTER")
public void addSpittle(Spittle spittle) {}
```

- if more than one value is passed into @Secured, then the authenticated user
  must be granted at least one of those authorities to gain access to the method

```java
@Seucred({"ROLE_SPITTER", "ROLE_ADMIN"}) // or
public void addSpittle(Spittle spittle) {}
```

- one drawback of the @Secured is that it is a Spring-specific annotation

### @RolesAllowed

- almost same as @Secured
- the only difference is that it is java's standard annotation

```java
@Configuration
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {}
```

- it is not either that or this, we can enable both jsr250 and secured

### using expressions for method-level security

- sometimes security constraints depend on more than just whether a user has privileges or not

- Spring Security 3.0 introduced a handful of new annotations that use SpEL to
  enable even more interesting security constraints on methods

annotation      | description
----------------------------------
@PreAuthorize   | restricts access to a method before invocation based on the result of SpEL
@PostAuthorize  | allows a method to be invoked, but throws a security exception if SpEL is false
@PostFilter     | allows a method to be invoked, filters the results of based on expression
@PreFilter      | allows a method to be invoked, filters input prior to entering the method

```java
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {}
```

```java
@PreAuthorize("hasRole('ROLE_SPITTER'") // @Secured("ROLE_SPITTER")
public void addSpittle(Spittle spittle) {}
```

- text is less than 140 or use is premium

```java
@PreAuthorize(
  "(hasRole('ROLE_SPITTER') and #spittle.text.length() <= 140)"
  + "or hasRole('ROLE_PREMIUM')")
public void addSpittle(Spittle spittle) {}
```

- do not let users to see other users content

```java
@PostAuthorize("returnObject.spitter.username == principal.username")
public Spittle getSpittleById(long id) {}
```

- @PostAuthorize make the decision after the method is invoked, make sure the
  method doesnot have any side effects that would be undesirable if authorization fails

### filtering method inputs and outputs

- sometimes we dont want to restrict the access to the method, but the content

- lets say we want to return offensive content from a method:
  - if it is admin, can see it all
  - if it is user, can see just theirs

```java
@PreAuthorize("hasAnyRole({'ROLE_SPITTER', 'ROLE_ADMIN'})")
@PostFilter("hasRole('ROLE_ADMIN') || "
  + "filterObject.spitter.username == principal.name")
public List<Spittle> getOffensiveSpittles() {}

```

### permission evaluator

- the expression can get complex and hard to debug/test

```shell
@PreFilter("hasPermission(targetObject, 'delete')")
public void deleteSpittles(List<Spittle> spittles) {}
```

- hasPermission() is a Spring Security provided extension to SpEL

```java
public class SpittlePermissionEvaluator implements PermissionEvalutor {
  private static final GrantedAuthority ADMIN_AUTHORITY =
    new GrantedAuthorityImpl("ROLE_ADMIN");

  public boolean hasPermission(Authentication authentication, Object target, Object permission) {
    if (target instanceof Spittle) {
      Spittle spittle = (Spittle) target;
      String username = spittle.getSpitter().getUsername();
      if ("delete".equals(permission)) {
        return isAdmin(authentication)  ||
          username.equals(authentication.getName());
      }
    }

    throw new UnsupportedOperationException();
  }
}
```

- see how to override GlobalMethodSecurityConfiguration#createExpressionHandler

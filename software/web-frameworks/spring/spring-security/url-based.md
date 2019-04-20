# Url Based Security

- not all requests should be secured equally;
  - some may require authentication
  - some may not
  - some may only be available to users with certain authorities

- the key to fine-tuning security for each request is to override the configure(HttpSecurity)


```java
@Override
protected void configure(HttpSecurity http) throws Exception {
  http
    .authorizeRequests()
      .antMatchers("/profile/me").authenticated()
      .antMatchers(HttpMethod.POST, "/todo").authenticated()
      .anyRequest().permitAll();
}
```

method                                   | what it does
-------------------------------------------------------------------------
access(String)                           | SpEL evaluates to true
anonymous()                              |
authenticated()                          |
denyAll()                                |
fullyAuthenticated()                     | not remembered
hasAnyRole(String...)                    |
hasAnyAuthority(String...)               |
hasAuthority(String)                     |
hasRole(String)                          |
hasIpAddress(String)                     |
not()                                    | negates the effect of any other access methods
rememberMe()                             | users who are authenticated via remember-me

- the rules will be applied in the order given, for that reason, it is
  important to configure the most specific request path patterns first and the
  least specific ones (such as anyRequest()) last.

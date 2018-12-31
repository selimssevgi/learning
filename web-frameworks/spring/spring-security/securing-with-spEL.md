# Securing with Spring Expressions

- most of the methods for configuring url based security are one-dimensional

- you can use hasRole() but you can't also use hasIpAddress() on the same path

- there is no way to work in any conditions that aren't defined by the methods

- what if we wanted to restrict access to certain roles only on Tuesday?

```shell
.antMatchers("/profile/me").access("hasRole('ROLE_PROFILE')")
```

security expression                         | what it evaluates to
----------------------------------------------------------------------
authentication                              | the user's authentication object
denyAll                                     | always to false
hasAnyRole(list of roles)
hasRole(role)
hasIpAddress(IP address)
isAnonymous()
isAuthenticated()
isFullyAuthenticated()
isRememberMe()
permitAll
principal


```shell
.antMatchers("/profile/me")
  .access("hasRole('ROLE_PROFILE') and hasIpAddress('192.168.1.2')")
```

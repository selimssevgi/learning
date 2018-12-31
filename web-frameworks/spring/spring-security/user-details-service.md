# User Details Service

- a user store is a plce where usernames, passwords, and other data can be kept
  and retrieved from when making authentication decisions

- Spring Security is extremely flexible and is capable of authenticating users
  against virtually any data store

### in-memory user store

```java
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
      .inMemoryAuthtication()
        .withUser("admin").password("password").roles("USER")
        .and()
        .withUser("admin").password("password").roles("USER", "ADMIN");
  }
}
```

method                            | description
---------------------------------------------
accountExpired(boolean)
accountLocked(boolean)
authorities(GrantedAuthority...)
authorities(String...)
credentialsExpired(boolean)
disabled(boolean)

- note that roles() is a shortcut for authorities()
- any roles given to roles() are prefixed with ROLE\_

- in-memory user store is very useful for debugging and developer testing
  purposes, not the most ideal for production

### database user store

- auth.jdbcAuthentication().dataSource(dataSource) will expect certain tables to be in certain format

- queries can be overriden by chaining .usersByUsernameQuery() and others

### password encoding

- BCryptPasswordEncoder
- NoOpPasswordEncoder (for testing)


```java
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  auth
    .passwordEncode(anyBeanImplementingPasswordEncodeInterface)
}
```

### custom user service

- need to implement a custom UserDetailsService

```java
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(Email.from(email))
        .orElseThrow(() -> new UsernameNotFoundException("Not found: " + email));

    return new SecurityUser(user);
  }
}

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  auth
    .userDetailsService(aBeanImplementingUserDetailsService);
}
```

- instead of using Spring's provided user stores, it takes a custom implementation

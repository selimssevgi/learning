# preventing CSRF

- what if POST request comes from another website?

- CSRF happens when one site tricks a user into submitting a request to another
  server possible having a negative outcome

- starting with Spring Security 3.2, CSRF protection is enabled by default

- Spring Security implements CSRF protection with a synchronizer token

- state changing requests(any request that is not GET, HEAD, OPTIONS, TRACE)
  will be intercepted and checked for a CSRF token

```shell
@Override
protected void configure(HttpSecurity http) throws Exception {
  http
    .csrf()
      .disable();
}
```

- generally is not a good idea to disable CSRF protection

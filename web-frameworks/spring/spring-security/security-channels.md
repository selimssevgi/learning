# Security Channels

- some form endpoints should be requested over https
- not all of them has to be over https


```shell
@Override
protected void configure(HttpSecurity http) throws Exception {
  http.
    // bla bla
    .and()
    .requiresChannel()
      .antMatchers("/shopWithCreditCard").requiresSecure(); // requires HTTPS
    // automatically redirect the request to go over HTTPS
}
```

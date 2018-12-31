# Authentication

- until you override configure(HttpSecurity) you have a simple fully-functional login page

- if you want to get it back

```shell
@Override
protected void configure(HttpSecurity http) throws Exception {
  http
    .formLogin(); // enable default login page
}
```

### Http Basic

- when the user of the application is another application, prompting for login
  with a form just won't do.

- HTTP Basic authentication is one way to authenticate a user to an application
  directly in the HTTP request itself

- 401 response to browser, and browser should username and password form

```shell
@Override
protected void configure(HttpSecurity http) throws Exception {
  http
    .httpBasic()
      .realmName("springSecurity");
}
```

### logout

- logout capability is already enabled

- logout is implemented as a servlet filter that (by default) intercepts requests to /logout

- remember-me tokens are cleared, and redirect to /loging?logout

```shell
@Override
protected void configure(HttpSecurity http) throws Exception {
  http
    .logout()
      .logoutSuccessUrl("/")
      .logoutUrl("/signout")
}
```

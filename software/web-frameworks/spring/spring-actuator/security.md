# Actuator Endpoints Security

- If spring-security is on the classpath, the endpoints will not return sensitive information.

- in browser: localhost:8080/health will just say is up


```shell
# defualt username is user
# spring-security generates a password if default not given, sout to console
curl -u user:generated-password http://localhost:8080/health
```

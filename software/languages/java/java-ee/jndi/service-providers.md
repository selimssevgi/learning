# service providers

- just like jdbc drivers for each database vendor

- we also need a service providers to talk to the underlying naming service
  - a different library to interact with ldap, dns etc

- jee container already has the necessary libraries

## outside of jee env


```java
Properties props = new Properties();
props.put(Context.INITIAL_CONTEXT_FACTORY, "oracle.j2ee.rmi.RmiInitialCF");
props.put(Context.PROVIDER_URL, "url");
props.put(Context.SECURITY_PRINCIPAL, "url");
props.put(Context.SECURITY_CREDENTIALS, "pass");
Context context = new InitialContext(props);
```

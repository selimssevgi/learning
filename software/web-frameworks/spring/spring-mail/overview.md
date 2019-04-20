# Spring Mail Abstraction

- at the heart of Spring's email abstraction is the MailSender interface

- Spring comes with one implementation of the MailSender: JavaMailSenderImpl

```java
// this one will configure its own MailSession
@Bean
public MailSender mailSender(Environment env) {
  JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
  mailSender.setHost(env.getProperty("mailserver.host"));
  mailSender.setPort(env.getProperty("mailserver.port"));
  mailSender.setUsername(env.getProperty("mailserver.username"));
  mailSender.setPassword(env.getProperty("mailserver.password"));
  return mailSender;
}
```

- you may already have a javax.mail.MailSession configured in JNDI

```java
@Bean
public JndiObjectFactoryBean mailSession() {
  JndiObjectFactoryBean jndi = new JndiObjectFactoryBean();
  jndi.setJndiName("mail/Session");
  jndi.setProxyInterface(MailSession.class);
  jndi.setResourceRef(true);
  return jndi;
}

@Bean
public MailSender mailSender(MailSession mailSession) {
  JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
  mailSender.setSession(mailSession);
  return mailSender;
}
```

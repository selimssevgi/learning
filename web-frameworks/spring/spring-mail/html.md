# Rich Email Content

- is not so much different than sending plaintext email messages

- the key is to set the message's text as HTML


```shell
public void sendSimpleHtmlMessage() throws MessagingException {
  MimeMessage mimeMessage = mailSender.createMimeMessage();
  MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
  helper.setFrom(mailProperties.getUsername());
  helper.setTo("selimssevgi@gmail.com");
  helper.setSubject("Supposedly multipart message");
  // cid: !!
  helper.setText("<html><body><img src='cid:todarchLogo'></body></html>");
  ClassPathResource logo = new ClassPathResource("logo.png");
  helper.addInline("todarchLogo", logo);
  mailSender.send(mimeMessage);
}
```

- adding an embeeded image to the message using 'cid'

### generating email with templates

- thymeleaf does not contain any special tag libraries or unusual markup

- can be used to work out the template in a browser

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<body>
  <img src="spitterLogo.png" th:src='cid:spitterLogo'>
  <h4><span th:text="${spitterName}">Craig Walls</span> says...</h4>
  <i><span th:text="${spittleText}">Hello there!</span></i>
</body>
</html>
```

```java
@Autowired
private SpringTemplateEngine thymeleaf;

Context ctx = new Context();
cxt.setVariable("spitterName", spitterName);
cxt.setVariable("spittleText", spittle.getText());
String emailText = thymeleaf.process("emailTemplate.html", ctx);
//...
helper.setText(emailText, true);
mailSender.send(message);
```

- the email templates will need to be resolved from the classpath

```java
@Bean
public ClassLoaderTemplateResolver emailTemplateResolver() {
   ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
   resolver.setPrefix("mail/");
   resolver.setTemplateMode("HTML5");
   resolver.setCharacterEncoding("UTF-8");
   setOrder(1);
   return resolver;
}

// using multiple resolvers if we also have one for servlet pages
@Bean
public SpringTemplateEngine templateEngine(Set<ITemplateResolver> resolvers) {
  SpringTemplateEngine engine = new SpringTemplateEngine();
  engine.setTemplateResolvers(resolvers);
  return engine;
}
```

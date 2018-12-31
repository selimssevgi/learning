# Mail Attachments

- multipart messages: the body and the attachments

- SimpleMailMessage class is too simple for sending attachments
- to send multipart email messages, you need to create Multipurpose Internet Mail Extensions (MIME) message

```java
MimeMessage mimeMessage = mailSender.createMimeMessage
```

- the javax.mail.internet.MimeMessage has an API that is too cumbersome to use on its own
- Spring provides MimeMessageHelper to lend a hand

```java
public void sendMessageWithAttachment() throws MessagingException {
  MimeMessage mimeMessage = mailSender.createMimeMessage();
  MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
  helper.setFrom(mailProperties.getUsername());
  helper.setTo("selimssevgi@gmail.com");
  helper.setSubject("Supposedly multipart message");
  helper.setText("Some text");
  FileSystemResource couponImage = new FileSystemResource("collateral/coupon.png");
  helper.addAttachment("Coupon.png", couponImage);
  mailSender.send(mimeMessage);
}
```

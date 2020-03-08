# @OneWay

- define a ws that doesnot return a value
- optimizes the message to reflect that no value is returned

```java
@WebMethod
@OneWay
public void pingServer() {}
```

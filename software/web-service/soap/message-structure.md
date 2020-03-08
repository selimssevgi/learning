# soap message structure

- SOAP-ENV: envelope
  - SOAP-ENV: header
  - SOAP-ENV: body


```xml
<S:Envelop xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
  <S:Body>
    <bid xmlns=”http://com.app/endpoint”>
      <bidPrice></bidPrice>
      <itemId></itemId>
      <bidderId></bidderId>
    </bid>
  </S:Body>
</S:Envelop>
```

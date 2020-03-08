# resource lookup

- Context interface
- Object Context#lookup(String name)

```java
Context ctx = new InitialContext();
BidService bs = (BidService) ctx.lookup("/ejb/bid/BidService");
```

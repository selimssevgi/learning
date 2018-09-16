# Zuul Filters

## Filter Types

- pre: before the request
- route: direct the request
- post: after the request
- error: handle request errors

## RequestContext

- Sharing data between filters

```java

RequestContext ctx = RequestContext.getCurrentContext();

// get the servlet request
HttpServletRequest req = ctx.getRequest();

// get the servlet response
HttpServletResponse req = ctx.getResponse();

// set a variable
ctx.set("foobar", "PRE_FILTER_EXECUTED");

// get a variable
String foobar = (String) ctx.get("foobar");
```

# HttpClient API

- Replacement for java.net.HttpURLConnection, which is too low level
- Had to use Apache Http client etc

- Supports HTTP/2, WebSocket

- Reactive Streams integration

** Goal: easy to use in common cases, powerful enough for complex ones

## Types

- HttpClient#send
- HttpClient#sendAsync
- HttpClient#newBuilder

- HttpRequest#uri
- HttpRequest#headers
- HttpRequest#methods
- HttpRequest#newBuilder

- HttpResponse (immutable)
- HttpResponse#uri
- HttpResponse#headers
- HttpResponse#statusCode
- HttpResponse#body

```java
HttpClient httpClient = HttpClient.newHttpClient();

HttpRequest request =
    HttpRequest.newBuilder(URI.create("https://pluralsight.com"))
        .GET()
        .build();

HttpResponse<String> httpResponse =
System.out.println(httpResponse.headers().map());
```

- sendAsync example

```java
HttpClient httpClient = HttpClient.newBuilder()
    .version(HttpClient.Version.HTTP_2)
    .build();

HttpRequest request =
    HttpRequest.newBuilder(URI.create("https://google.com"))
        .GET()
        .build();

CompletableFuture<HttpResponse<String>> future =
    httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

future.thenAccept(res -> System.out.println(res.version()));
future.join();
```

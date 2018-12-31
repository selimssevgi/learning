# multipart form data

- file uploads need to be handled differently than other form data

- file uploads are binary-based while other form data is text-based

### configuration

- DispatcherServlet doesn't implement any logic for parsing the data in a multipart request

- it delegates to an implementation of Spring's MultipartResolver strategy interface

- sing Spring 3.1, Spring comes with two out-of-box implementation of MultipartResolver

1. CommonsMultipartResolver: using Jakarta Commons FileUpload

2. StandardServletMultipartResolver: relies on Servlet 3.0 support (recommended)

```java
@Bean
public MultipartResolver multipartResolver() throws IOException {
  return new StandardServletMultipartResolver();
}
```

- StandardServletMultipartResolver has no-args constructor and does not have accept any properties

- you must specify multipart configuration in the servlet configuration

```java
DispatcherServlet ds = new DispatcherServlet();
Dynamic registration = context.addServlet("appServlet", ds);
registration.addMapping("/");
registration.setMultipartConfig(new MultipartConfigElement("/tmp/uploads"));
```

```java
@Override
protected void customizeRegistration(Dynamic registration) {
  //registration.setMultipartConfig(new MultipartConfigElement("/tmp/uploads"));
  int fileLimit = 2097152; // 2MB
  int multipartRequestLimit = 41943404; // 4MB
  int writeAllFilesToDisk = 0;

  registration.setMultipartConfig(
      new MultipartConfigElement("/tmp/uploads", fileLimit,
      multipartRequestLimit, writeAllFilesToDisk));
}
```

```java
@PostMapping("/register")
public String processRegistration(
  @RequestPart("profilePicture" byte[] profilePicture, InputModel input)
) {}
```

- working with the uploaded file's raw bytes is simple but limiting

- Spring also offers MultipartFile as a way to get a richer object for processing multipart data

- in Servlet 3.0 container, you have an alternative to MultipartFile

- Spring MVC also accepts javax.servlet.http.Part as a controller method parameter

```java
@PostMapping("/register")
public String processRegistration(
  @RequestPart("profilePicture" Part profilePicture, InputModel input)
) {}
```

- Part interface looks a like MultipartFile

- if you write controller handler methods to accept file uploads via a Part
  parameter, then you don't need to configure the
  StandardServletMultipartResolver, which is required only when you're working
  with MutlipartFile.

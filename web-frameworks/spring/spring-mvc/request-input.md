# request input

- spring-mvc provides several ways that a client can pass data into a
  controller's handler method. these include:

1. query parameters (?key=value)
2. form parameters
3. path variables

### query parameters

- ?max=5&count=4

```java
public void handle
  (@RequestParam(value = "max" defaultValue = "20") long max,
  (@RequestParam(value = "count" defaultValue= "5") int count) {}
```

### path variable

- /item/123, /item/{id}


```java
@GetMapping("/item/{id}")
public void handle(@PathVariable("id") long id) {}

@GetMapping("/item/{id}")
public void handle(@PathVariable long id) {}
```

- request parameters and path variables are fine for passing small amount of data on a request

- often you need to pass a lot of data (perhaps data coming from a form
  submission), and query parameters are too awkward and limited for that

### form parameters

- spring will map form data to method parameter object

```java
@PostMapping("/register")
public void handle(RegistrationInput input) {}
```

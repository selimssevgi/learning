# Handling Exception in Spring MVC

### mapping exception to HTTP status codes

- out of the box, spring automatically maps a dozen of its own exceptions to appropriate status code

- for any exception that isn't mapped, the response will always have 500 status code

```java
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "splitle not found")
public class SplittleNotFoundException extends RuntimeException {}
```

### writing exception handling methods

- what if we want the response to carry more than just a status that represents the error that occurred?

- rather than threat the exception generically as some HTTP error, maybe you
  would like to handle the exception the same way you might handle the request itself

```java
@ExceptionHandler(DuplicateItemException.class)
public String handleDuplicateItem() {
  return "error/duplicate";
}
```

- we could catch the exception in controller, and return a different view, but
  that would complicate controller with two different paths

- interesting about @ExceptionHandler methods is that they handle their
  exceptions from any handler method in the same controller.

- if @ExceptionHandler methods can handle exception thrown from any handler
  method in the same controller, can we handle the same exception thrown from any controller?

### advising controller

- since Spring 3.2

- we dont want to duplicate logic or use inheratence to handle exception

- @ControllerAdvice annotated class has one or more of the following methods:

1. @ExceptionHandler-annotated
2. @InitBinder-annotated
3. @ModelAttribute-annotated

- those methods in an @ControllerAdvice-annotated class are applied globally
  across all @RequestMapping methods

- @ControllerAdvice is itself annotated with @Component

- one of the most practical uses for @ControllerAdvice is to gather all
  @ExceptionHandler methods in a single class so that exceptions from all
  controllers are handled consistently in one place

```java
@ControllerAdvice
public class AppWideExceptionHandler {

  @ExceptionHandler(DuplicatedItemException.class)
  public String duplicateItemHandler() {
    return "error/duplicate";
  }
}
```

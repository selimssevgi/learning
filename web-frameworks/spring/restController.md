# Rest Controller Example


```java
@RestController
public class TodoController {
  @AutoWired
  private TodoService service;

  @RequestMapping(value = "/todos", method = RequestMethod.GET)
  public List<Todo> index() {
    return service.getAll();
  }
}
```

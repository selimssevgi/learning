# Eta Expansion

- Converts methods to functions

- take an existing method and append _ to create the function


```scala
class UseResource {
  def use(r: Resource): Boolean = {}
}

val use_func: Resource => Boolean = (new UseResource).use _
```

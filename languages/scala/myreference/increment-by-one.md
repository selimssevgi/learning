# i++ or ++i

- in scala i++ and ++i stuff dont work.

```scala
// instead
// i++ has side-effect, mutating the variable.
i += 1 
i = i + 1
```

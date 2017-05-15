# Access Modifiers in Scala

- Default access level is public.(in Java is 'default')
- By default, when you dont specify any modifier, everything is public
- private
- protected, only allowed in subclasses.(in Java also same package)

- override, abstract, sealed

## Qualifier

- you can qualify a modifier with a class or a package name or this

```scala
class Outer {
  class Inner {
    private[Outer]  def f() = "this is f"
    private[this] def g() = "class-private"
  }  
}
```

## Protected

- applicable to class member definitions
- accessible to defining class and its subclasses
- accessible to companion object of defining class and subclasses

## override

- override modifier is mandatory while overriding a concrete member

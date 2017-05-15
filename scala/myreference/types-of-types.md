# Types of Types in Scala

- One of Scala's unique features is its rich type system

## Structural Types

- is the way to describe types by their structure, not by their names

- is a good technique to get rid of unnecessary class heirarchies

- is comparatively slow cus it uses reflection under the hood

- ex: close any resource after use as long as it's closable

- one way to do that would be to define a trait that declares a close method

- using structural type, can easily define a new type by specifying its structure

```scala
def close(closable: { def close: Unit }) = {
  closable.close
}
```

- the flexibility of this approach is that now you can pass instances of any
  type to this function as long as it implements the def close: Unit method

- using the 'type' keyword, can easily provide a name (type alias)
- not limited to a single method

```scala
type Closable = { def close: Unit }

type Profile = {
  def name: String
  def address: String
}
```

## Higher-kinded types

- are types that know how to create a new type from the type argument
- also knows as type constructors

- higherKinds is an advanced feature of the language. see scala.language

- Most of the collections classes are good examples of why kinds are such are
  powerful abstraction tool

```scala
def fmap[A, B](xs: Vector[A], f: A => B): Vector[B] = xs map f

def fmap[A, B](r: Option[A], f: A => B): Option[B] = r map f

trait Mapper[F[_]] { // parameterized by F[_]: higher-kinded type
  def fmap[A, B](xs: F[A], f: A => B): F[B]
}

def VectorMapper = new Mapper[Vector] {
  def fmap[A, B](xs: Vector[A], f: A => B): Vector[B] = xs map f
}

def OptionMapper = new Mapper[Option] {
  def fmap[A, B](r: Option[A], f: A => B): Option[B] = r map f
}
```

# Class Linearization

- trait           ReadOnly -> AnyRef -> Any
- updatable    -> readonly -> anyref -> any
- DBCollection -> ReadOnly -> AnyRef -> Any

- UpdatableCollection -> Updatable -> DBCollection -> ReadOnly -> AnyRef -> Any

- UpdatableCollection -> Memoizer -> Updatable -> DBCollection -> ReadOnly -> AnyRef -> Any


```scala
class DBCollection(override val underlying: MongoDBCollection) extends ReadOnly

trait ReadOnly {
  val underlying: MongoDBCollection

  def name = underlying.getName
  def fullName = underlying getFullName
  def find(doc: DBObject) = underlying find doc
  def findOne = underlying findOne
  def getCount(doc: DBObject) = underlying getCount doc
}

trait Administrable extends ReadOnly {
  def drop: Unit = underlying drop
  def dropIndexes: Unit = underlying dropIndexes
}

trait Updatable extends ReadOnly {
  def -=(doc: DBObject): Unit = underlying remove doc
  def +=(doc: DBObject): Unit = underlying save doc
}

trait Memoizer extends ReadOnly {
  val history = scala.collection.mutable.Map[Int, DBObject]()

  override def findOne = {
    history.getOrElseUpdate(-1, { super.findOne })
  }

  override def findOne(doc: DBOject) = {
    history.getOrElseUpdate(doc.hashCode, { super.findOne(doc) })
  }
}

```

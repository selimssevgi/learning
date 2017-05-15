# Scala Imports

- Uses same keywords: import, package
- Scala can import and use Java packages and classes without an issue
- Unlike in Java, imports in Scala can appear anywhere in the code
- scala.\_ is always imported into every .scala file


```scala
import scala.xml._                                     // all content
import scala.collection.mutable.HashMap                // a single class
import scala.collection.immutable.{TreeMap, TreeSet}   // more than one class
import java.util.{Date => UDate}

import java.sql.{Date => _}      // hide Date class from sql package
```


```scala
import com.mongodb._                 // imports all classes under the package

val randomValue = {
  import scala.util.Random          // import statement can be anywhere
  new Random().nextInt
}

val anotherRandom = {
  import util.Random                // scala package is already imported
  new Random().nextInt
}

import java.lang.System._           // scala doesnt have static keywords
nanoTime

import java.lang._                  // makes all classes and subclasses available

import System._
```

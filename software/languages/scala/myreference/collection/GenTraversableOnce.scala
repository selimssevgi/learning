trait GenTraversableOnce[+A] extends Any {
  // Abstract Value Members
  def /:[B](z: B)(op: (B, A) => B): B

  def :\[B](z: B)(op: (A, B) => B): B

  def aggregate[B](z: =>B)(seqop: (B, A) => B, combop: (B, B) => B): B

  def count(p: A => Boolean): Int

  def exists(p: A => Boolean): Boolean

  def find(p: A => Boolean): Option[A]

  def fold[A1 >: A](z: A1)(op: (A1, A1) => A1): A1

  def foldLeft[B](z: B)(op: (B, A) => B): B

  def foldRight[B](z: B)(op: (A, B) => B): B

  def forall(p: A => Boolean): Boolean

  def hasDefiniteSize: Boolean

  def isEmpty: Boolean

  def isTraversableAgain: Boolean

  def mkString: String

  def mkString(sep: String): String

  def mkString(start: String, sep: String, end: String): String

  def nonEmpty: Boolean

  def reduce[A1 >: A](op: (A1, A1) => A1): A1

  def reduceLeftOption[B >: A](op: (B, A) => B): Option[B]

  def reduceOption[A1 >: A](op: (A1, A1) => A1): Option[A1]

  def reduceRight[B >: A](op: (A, B) => B): B

  def reduceRightOption[B >: A](op: (A, B) => B): Option[B]

  def seq: TraversableOnce[A]

  def size: Int

  def toBuffer[A1 >: A]: Buffer[A1]

  def toIndexedSeq: immutable.IndexedSeq[A]

  def toIterable: GenIterable[A]

  def toIterator: Iterator[A]

  def toList: List[A]

  def toSeq: GenSeq[A]

  def toSet[A1 >: A]: GenSet[A1]

  def toStream: Stream[A]

  def toTraversable: GenTraversable[A]

  def toVector: Vector[A]

  // Concrete Value Members [these one doesnt have implementation either?]
  def copytoArray[B >: A](xs: Array[B]): Unit

  def copyToArray[B >: A](xs: Array[B], start: Int): Unit

  def copyToArray[B >: A](xs: Array[B], start: Int, len: Int): Unit

  def foreach[U](f: A => U): Unit

  def max[A1 >: A](implicit ord: Ordering[A1]): A

  def maxBy[B](f: A => B)(implicit cmp: Ordering[B]): A

  def min[A1 >: A](implicit ord: Ordering[A1]): A

  def minBy[B](implicit cmp: Ordering[B]): A

  def product[A1 >: A](implicit num: Numeric[A1]): A1

  def sum[A1 >: A1](implicit num: Numeric[A1]): A1

  def toArray[A1 >: A: ClassTag]: Array[A1]

  def toMap[K, V](implicit ev: A <:< (K, V)): GenMap[K, V]
}

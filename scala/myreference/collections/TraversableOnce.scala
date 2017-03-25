/**
 * This trait exists primarily to eliminate code duplication between Iterator and Traversable.
 * It includes a number of abstract methods.
 * Implements some of the common methods that can be implemented by solely in
   terms of foreach without access to a 'Builder.'
 */
trait TraversableOnce[+A] extends GenTraversableOnce[A] {

  // Abstract Value Members(from GenTraversableOnce)
  def exists(p: A => Boolean): Boolean
  def find(p: A => Boolean): Option[A]
  def forall(p: A => Boolean): Boolean
  def foreach[U](f: A => U): Unit
  def hasDefiniteSize: Boolean
  def isEmpty: Boolean
  def isTraversableAgain: Boolean
  def seq: TraversableOnce[A]
  def toIterator: Iterator[A]
  def toStream: Stream[A]
  def toTraversable: Traversable[A]

  // Concrete Value Members

  def /:[B](z: B)(op: (B, A) => B): B = foldLeft(z)(op)

  def :\[B](z: B)(op: (A, B) => B): B = foldRight(z)(op)

  def aggregate[B](z: =>B)(seqop: (B, A) => B, combop: (B, B) => B): B = foldLeft(seqop)

  def count(p: A => Boolean): Int = { var cnt = 0; for (x <- this) if (p(x)) cnt += 1; cnt; }

  def copyToArray[B >: A](xs: Array[B], start: Int, len: Int): Unit
  def copyToArray[B >: A](xs: Array[B], start: Int): Unit = copyToArray(xs, start, xs.length - start)
  def copyToArray[B >: A](xs: Array[B]): Unit = copyToArray(xs, 0, xs.length)

  def fold[A1 >: A](z: A1)(op: (A1, A1) => A1): A1 = foldLeft(z)(op)

  def  foldLeft[B](z: B)(op: (B, A) => B): B = { }
  def foldRight[B](z: B)(op: (A, B) => B): B = reversed.foldLeft(z)((x, y) => op(y, x))

  def mkString(start: String, sep: Start, end: String): String = addString(new StringBuilder, start, sep, end).toString
  def mkString(sep: String): String = mkString("", sep, "")
  def mkString: String = mkString("")

  def nonEmpty: Boolean = !isEmpty

  def  reduceLeft[B >: A](op: (B, A) => B): B = { }
  def reduceRight[B >: A](op: (A, B) => B): B = reversed.reduceLeft((x, y) => op(y, x))

  def  reduceLeftOption[B >: A](op: (B, A) => B): Option[B] = if (isEmpty) None else Some(reduceLeft(op))
  def reduceRightOption[B >: A](op: (B, A) => B): Option[B] = if (isEmpty) None else Some(reduceRight(op))

  def       reduce[A1 >: A](op: (A1, A1) => A1): A1 = reduceLeft(op)
  def reduceOption[A1 >: A](op: (A1, A1) => A1): Option[A1] = reduceLeftOption(op)

  def size: Int = { var result = 0; for (x <- this) result += 1; result }

  def     sum[B >: A](implicit num: Numeric[B]): B = foldLeft(num.zero)(num.plus)
  def product[B >: A](implicit num: Numeric[B]): B = foldLeft(num.zero)(num.times)

  def min[B >: A](implicit cmp: Ordering[B]): A = reduceLeft((x, y) => if (cmp.lteq(x, y)) x else y)
  def max[B >: A](implicit cmp: Ordering[B]): A = reduceLeft((x, y) => if (cmp.gteq(x, y)) x else y)

  def maxBy[B](f: A => B)(implicit cmp: Ordering[B]): A = { }
  def minBy[B](f: A => B)(implicit cmp: Ordering[B]): A = { }

  // Method Specific to this Trait

  def addString(b: StringBuilder, start: String, sep: String, end: String): StringBuilder = { }
  def addString(b: StringBuilder, sep: String): StringBuilder = addString(b, "", sep, "")
  def addString(b: StringBuilder): StringBuilder = addString(b, "")

  def copyToBuffer[B >: A](dest: Buffer[B]): Unit = dest ++= seq
  def collectFirst[B](pf: PartialFunction[A, B]): Option[B] = { }

}

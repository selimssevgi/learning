object Functions {

  // parameterized types
  def toList[A](value: A): List[A] = List(value)

  // type pattern matching
  def printType(obj: AnyRef) = obj match {
    case s: String => println("This is a string")
    case l: List[_] => println("This is a List")
    case a: Array[_] => println("This is an array")
    case d: java.util.Date => println("This is a date")
  }

  // guarded pattern matching
  def rangeMatcher(num: Int) = num match {
   case within10  if within10  <= 10 => println("with in 0 to 10")
   case within100 if within100 <= 100 => println("with in 11 to 100")
   case beyond100 if beyond100 <= Integer.MAX_VALUE => println("beyond 100")
  }

  // scala doesnt have break or continue keywords
  // scala.util.control.Breaks
  val breakException = new RuntimeException("break exception")
  def break = throw breakException;

  def breakable(op: => Unit) {
    try {
      op
    } catch { case _ => }
  }

  def install = {
    val env = System.getenv("SCALA_HOME")
    if (env == null) break
    println("found scala home")
  }

  // pass it as a closure
  breakable {
    val env = System.getenv("SCALA_HOME")
    if (env == null) break
    println("found scala home")
  }

}

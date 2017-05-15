import org.scalacheck.Gen._
import org.scalacheck.Properties
import org.scalacheck.Arbitrary.arbitrary
import org.scalacheck.Prop.forAll

object EitherSpecification extends Properties("Either") {

  val leftValueGenerator  = arbitrary[Int].map(Left(_))
  val rightValueGenerator = arbitrary[Int].map(Right(_))

  implicit val eitherGenerator = oneOf(leftValueGenerator, rightValueGenerator)
  
  property("isLeft or isRight not both") =
    forAll { (e: Either[Int, Int]) => e.isLeft != e.isRight }

  property("left value") =
    forAll { (n: Int) =>
      Left(n).fold(x => x, b => throw new AssertionError("fail")) == n }

  property("right value") =
    forAll { (n: Int) =>
      Right(n).fold(a => throw new AssertionError("fail"), x => x) == n }

  property("swap values") = forAll { (e: Either[Int, Int]) => e match {
      case Left(a) => e.swap.right.get == a
      case Right(b) => e.swap.left.get == b
    }
  }

  property("getOrElse") = forAll { (e: Either[Int, Int], or: Int) => 
    e.left.getOrElse(or) == (e match {
      case Left(a) => a
      case Right(_) => or })
  }

  property("forall") = forAll { (e: Either[Int, Int]) =>
    e.right.forall(_ % 2 == 0) == (e.isLeft || e.right.get % 2 == 0)
  }


}

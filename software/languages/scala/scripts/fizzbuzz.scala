val isDividedBy: (Int, Int) => Boolean = (number, divide) => number % divide == 0
val isDividedBy3 = isDividedBy(_: Int, 3)
val isDividedBy5 = isDividedBy(_: Int, 5)

val fizzBuzz: Int => String = {
  case i if isDividedBy3(i) && isDividedBy5(i) => "FizzBuzz"
  case i if isDividedBy3(i)                    => "Fizz"
  case i if isDividedBy5(i)                    => "Buzz"
  case i                                       => i.toString
}

Stream(1 to 10: _*).map(fizzBuzz).foreach(println)

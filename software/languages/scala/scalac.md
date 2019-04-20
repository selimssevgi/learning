// "aaabcc" => "a3bc2"
def transform(s: String): String = {
   
  val letterCount: Map[Char, Int] = Map()
  s.foldLeft(letterCount)((letter, map) => map + (letter, map.getOrElse(letter, 0) + 1)
  
  s.takeWhile
  
  for(letter <- s) {
    val count = letterCount.getOrElse(letter,0)
    letterCount += (
    letterCount.put(letter, count)
  }
  
  letterCount.map((k,v) => k + v).mkString   
}

      
      def getA(): Future[String] = { ... } 
      
      val a = getA().map(str => asdasd)

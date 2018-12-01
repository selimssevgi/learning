
implicit class IntOps(val n: Int) extends AnyVal {
   def stars = "*" * n
}

// 5.stars
//

implicit class StrOps(val s: String) extends AnyVal {
   def isBlank = s.trim.isEmpty
}

// "\t \n ".isBlank

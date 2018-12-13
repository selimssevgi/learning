
def myClosure = { println "closure is just a block of code" }
myClosure()

(1..3).each({
  myClosure()
})

(1..3).each({
  println "can inline the closure itself"
})

(1..3).each({
  println "it is a special variable: $it"
})

(1..3).each({ i -> // pass argument to the closure
  println "it is a special variable: $i"
})

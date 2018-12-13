
def beatles = ["John", "Paul", "George", "Ringo"]

for (int i = 0; i < beatles.size(); i++) {
  println "Hello, " + beatles[i]
}

println "Remove optional parenthesis"

for (int i = 0; i < beatles.size; i++) {
  println "Hello, " + beatles[i]
}

println "use def instead of type"

for (def i = 0; i < beatles.size; i++) {
  println "Hello, " + beatles[i]
}

println "use for-each"

for (beatle in beatles) {
  println "Hello, " + beatle
}

println "use g-string"

for (beatle in beatles) {
  println "Hello, $beatle"
}

def cat = "meow"
def one = 1

// Integer one = 1
// Integer one = "one" // ERROR

println cat
println cat.getClass() // java.lang.String
println cat.toUpperCase()

println one
println one.getClass() // java.lang.Integer
// println one.toUpperCase() // compiles but throws errro at runtime

one = "one"
println one
println one.getClass() // java.lang.String
println one.toUpperCase()

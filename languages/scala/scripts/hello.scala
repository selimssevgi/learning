// Although scala is designed to help programmers build very large-scale systems
// it also scales down nicely to scripting.

println("Hello, world, from a scipt!")


// Commentline arguments to a Scala script avaliable via array named args.
if (args.length > 0) {
  println("First arguments: " + args(0))
} else {
  println("No arguments given.")  
}

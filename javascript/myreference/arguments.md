# Arguments

- An object named 'arguments' is available in every function when that function is called

- It is not in the parameters list, but is always available

- The 'arguments' object contains every argument passed to the function

- It can be accessed in an array-like manner

- 'arguments' can be used to create 
  - a function that accepts a variable number of arguments
  - a function that does different things depending on the number of arguments passed to it 


```javascript
function printArgs() {
  for (var i=0; i < arguments.length; i++) {
    console.log(arguments[i]);
  }
}

printArgs('one', 2, 1 + 2, 'four');
```

- arguments looks just like an array, it ist not actually an array; it is an object

- It has a length property, and items can be access using bracket notation.
  That's all the similarity with arrays

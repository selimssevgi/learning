# Modules in Node.js


```javascript
// mymath.js
let add = function(a, b) {
  return a + b;
}

let multiply = function(a, b) {
  return a * b;
}

const PI = 3.143;

// module.exports => is an object
module.exports.add = add;
module.exports.multiply = multiply;
module.exports.PI = PI;

// another way
module.exports = {
  add: add,
  multiply: multiply,
  pi: pi,
};
```


```javascript
// app.js
let mymath = require("./mymath"); // storing module.exports object

console.log(mymath.add(1, 2));
console.log(mymath.PI);
```

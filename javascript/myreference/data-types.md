# Data Types in JS

- Dynamically typed
- 7 basic types: number, string, boolean, null, undefined, object, symbol

- no char type, is basically string like in Python
- no float type, is a number

- 'typeof' operator: "typeof x" or "typeof(x)"
- 'typeof alert'; // function: is an object, in practise is useful
- 'typeof null';  // object: offically recognized mistake, is null


```javascript
// NUMBERS //

// 'number' type: for integer and floats
let n = 123

// special numeric values: Infinity, -Infinity, NaN
alert(1 / 0 );     // Infinity
alert("abc" / 2 ); // NaN

// STRING //

let str = "Hello"
let str = 'Single quote'
let str = `Back ticks: ${str}`

// Boolean //
let found = false;
let stop = true;
```

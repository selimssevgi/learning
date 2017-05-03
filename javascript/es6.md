# ECMAScript

## ECMAScript

- A standard for scripting languages such as JavaScript

## ECMAScript 6

- Latest standardized version of ES
- Includes many new features
- https://kangax.github.io/compat-table/es6/

* Constants
* let Keyword
* Default Parameters
* Spread Operator
* Template Strings
* Object Literal Enhancements
* New String Methods
* Arrow Functions - Fat Functions
* Sets
* Generators

### Constants

```javascript
const pi = 3.14;
```

### let Keyword

```javascript
var x = 10;

if (x > 5) {
  let x = 5; // creates a local scoped variable
  console.log("inner x: " + x); // 5
}

console.log("outside x: " + x); // 10
```

```javascript
var items = document.getElementsByTagName('li');

for (var x = 0; x < items.length; x++) {
  items[x].onclick = function() {
    console.log(x); // always prints 4
  }
}

console.log(x); // 4, final global x variable has value of 4
```

```javascript
var items = document.getElementsByTagName('li');

for (let x = 0; x < items.length; x++) {
  items[x].onclick = function() {
    console.log(x); // prints what x is
  }
}

console.log(x); // undefined
```

### Default Parameters

```javascript
function log(num = 10) {
  console.log(num);
}

log();   // 10
log(20); // 20
```

### Spread Operator

```javascript
let meats = ["ham", "salami", "bacon"];

console.log(meats);    // ["ham", "salami", "bacon"]
console.log(...meats); // ham salami bacon

let num1 = [1, 2, 3];
let num2 = [4, 5, 6];

let num3 = [num1, 4, 5, 6]; // [ [1, 2, 3], 4, 5, 6 ]
let num4 = [...num1, 4, 5, 6]; // [1, 2, 3, 4, 5, 6]

function add(a, b, c) {
  console.log(a + b + c);
}

let nums = [3, 5, 7];
add(...nums);
```

### Template Strings

```javascript

let temp = `hello`; // doesnt ignore new line or white space

let name = "JavaScript";

console.log("hello " + name);
console.log(`hello ${name}`);

console.log(`5 + 10 is ${5 + 10}`);
```

### Object Literal Enhancements

```javascript
let name = "John";
let age  = 25;

// es5
let person = {
  name: name,
  age: age,
  walk: function(x) { console.log("walked " + x + "km"); }
};

console.log(person.name); // John

// new way:es6
let person2 = {
  name,
  age,
  walk(x){ console.log("walked " + x + "km"); },
};

console.log(person2.name); // John
```

### New String Methods

```javascript
"a".repeat(5); // "aaaaa"

"goodbye".startsWith("good"[,startposition=0]);

"bye".endsWith("e"[, startposition=length-1]);

"somestring".includes("str");
```


### Arrow Functions - Fat Functions

```javascript
// es5
let ninjaGreeting = function(name) {
  console.log(name + " says hiiiyaa");
}

// es6
let ninjaGreeting = (name) => console.log(name + " says hiiyaa");
```

### Sets

```javascript
let names=  new Set();

names.add("john").add("jilly");

console.log(names.size); // 2

names.delete("jilly"); // boolean
names.clear();
names.has("john"); // true

let uniqueArrayElement = new Set(anArr);
```

### Generators

```javascript
function gen() {
  console.log("pear");
  console.log("banana");
  console.log("apple");
}

gen();

// generator: adding asteriks

function* gen() {
  console.log("pear");
  console.log("banana");
  console.log("apple");
}

let myGen = gen(); // returns an iterator
gen.next(); // prints three lines

// yield keyword
function* gen() {
  yield console.log("pear");
  console.log("banana");
  console.log("apple");
}

let myGen = gen(); // returns an iterator
gen.next(); // prints just pear
gen.next(); // prints other 2 lines

// returning value
function* gen() {
  yield "pear";
  yield "banana";
  yield "apple";
  return "all done";
}

let myGen = gen(); // returns an iterator
console.log(gen.next()); // {value: "pear", done: false}
console.log(gen.next()); // {value: "banana", done: false}
console.log(gen.next()); // {value: "apple", done: false}
console.log(gen.next()); // all done

// local variables
function* gen() {
  let x = yield "pear"; // x = 5
  let y = yield "banana";
  let z = yield "apple";
  return x + y + z;
}

let myGen = gen(); // returns an iterator
console.log(gen.next());   // {value: "pear", done: false}
console.log(gen.next(5));  // {value: "banana", done: false}
console.log(gen.next(10)); // {value: "apple", done: false}
console.log(gen.next(15)); // 30

```

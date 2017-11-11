# Functions in JS

- A function can access an outer variable (global scope)

* Anonymous function

```javascript
function sayHello() {
  alert("Hello!");
}

function say(text) {
  alert(text);
}

function say(text = "hello") {
  alert(text);
}

function add(a, b) {
  return a + b;
}
```

## Function Expressions

- Functions are values.

```javascript
// Function declaration
function sayHi() {
  console.log("Hi!");
}

// Function expression
let sayHi = function() {
  console.log("hi!");
};

let aFunc = sayHi;

console.log(sayHi); // print string rep
sayHi();
aFunc();
```

## Callback Functions

```javascript
function ask(question, yes, no) {
  if (confirm(question)) {
    yes();
  } else {
    no();
  }
}

function showOk() {
  alert("You agreed!");
}

function showCancel() {
  alert("You canceled the execution!");
}

ask("Do you agree?", showOk, showCancel);

// shorter way: anonymous function
ask(
  "Do you agree?",
  function() { alert("You agreed"); },
  function() { alert("You canceled the exec"); }
);
```

## Function Declaration vs Function Expression

- Declaration are initialized when the script is loaded, can be called anywhere.
- Expression are initialized when the code block is reached, and can be used
  afterwards.

```javascript
// declaration
function sum(a, b) { return a + b; }

// expression
let sum = function(a, b) { return a + b };
```

## Local Functions

```javascript
let age = 15;

if (age < 18) {
  function welcome() { alert("Hello"); }
} else {
  function welcome() { alert("Greetings"); }
}

welcome(); // ERROR: cannot reach
```

```javascript
let welcome = (age < 18) ?
  function() { alert("Hello"); } :
  function() { alert("Greetings"); };
```

## Arrow Functions

```javascript
function sum(a, b) {
  return a + b;
}

let sum = (a, b) => a + b;

let double = n => n * 2; // one argument, parents can be omitted

let welcome = () => alert("Hello");

let multiLine = () => {
  let result = 3 + 5;
  alert(result);
};
```

## Function Details

- Values are passed-by-value

* What happens when we don't pass enough arguments?

```javascript
function f(a, b) {
  console.log(a, b);
}

f(5); // 5 undefined
```

* What happens when we pass too many arguments? // just ignores the extra

* A function without a return statement returns 'undefined'

* JS does not care if functions are declared before or after you use them

* JS makes two passes over the page: in the first pass it reads all the function
  definitions, in the second it begins executing your code

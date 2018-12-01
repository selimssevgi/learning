# Closure

- A closure is a function together with a referencing environment


```javascript
function whereAreYou() { // all local variables are stored in an 'environment'
  var justAVar = "Just an every day LOCAL";

  function inner() {
    return justAVar;
  }

  return inner; // not just returns the function, returns the function with the
                // environment attached to it
}
```

- Every function has an attached environment, which contains the local variables
  within its enclosing scope

- Function reference is linked to an environment

-  Lexical scope means that JS's rules for scoping are based on purely on the
   structure of the code (not on some dynamic runtime properties)

- When it comes to finding a variable in the environment, start at the closest
  one, and the follow the chain until finding the variable, lastly in the global environment

- You can consider parameters be local variables in functions, so they are
  included in environment as well

- If a function is returned from within a function, it carries its environment
  around with it

## Closing a function

- A function typically has 'local variables' in its code body (including any parameters it has)

- A function also might have variables that aren't defined locally, which can be called 'free variables'

- The name 'free' comes from the fact that within the function body, free
  variables aren't bound to any values(they are not declared locally in the function)

- When there is an environment that has a value for each of the free variables,
  we say that we have 'closed' the function

- When we take the function and environment together, we say we have a 'closure'

* A closure results when we combine a function that has free variables with an
  environment that provides variable bindings for all those free variables

* The closure contains the actual environment, not a copy

- the environment references the live variables being used by your code, if a
  value is changed by code outside your closure function, that new value is seen
  by your closure function when it is evaluated


```javascript
function setTimer(doneMessage, n) {
  setTimeout(function() {
    console.log(doneMessage);
  }, n);

  doneMessage = "Changed!!";
}

setTimer("Cookies are done!", 1000);
```

## Examples

```javascript
var count = 0;

function counter() {
  count = count + 1;
  return count;
}

console.log(counter());
console.log(counter());
console.log(counter());
```

- Problems with this approach is that using a global raise some issues, it is
  public, can be overwritten by anyone


```javascript
function getCounter() {
   var count = 0; // local and protected variable

   var counter = function() {
     return count++; 
   }
  
   return counter; // the closure, holds the count in its environment
}
```

```javascript
function makePassword(password) { // enclosing parameter, which is a local var
  return function(passwordGuess) {
    return (passwordGuess === password);
  }
}

var passwordChecker = makePassword("selim");
console.log(passwordChecker("afdadf"));
console.log(passwordChecker("selim"));

function multN(n) {
  return function(number) {
    return n * number;
  }
}

var mult5 = multN(5);
console.log(mult5(5));
console.log(mult5(50));

function makeCounter2() {
  var count = 0;
  return function() {
     return {increment: function() { return count++; } };
  }
}

var counter2 = makeCounter2();
console.log(counter2().increment());
console.log(counter2().increment());
```

* Closure by passing a function expression as an argument

```javascript
function makeTimer(doneMessage, n) {
  setTimeout(function() {      // a function plus an environment
     console.log(doneMessage); // doneMessage: is a free variable
  }, n);
}

makeTimer("Cookies are done!", 1000);
```

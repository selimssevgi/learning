# Function Expression

* Function definition

```javascript
function plus(x) {
  return x +1;
}
```

* Function expression

```javascript
var plus = function (x) {
  return x +1;
}
```

- The first thing the browser does is scan the code for 'function declarations'

- When it finds one, it creates a function and assigns the resulting referecence
  to a variable with the same name as the function

## Notes

- Function declarations are evaluated before the rest of the code is evaluated

- Function expressions get evaluated later, with the rest of the code

- A function declaration doesnt return a reference to a function; rather it
  creates a variable with the name of the function and assigns the new function to it

- A function expression returns a reference to the new function created by the expression

- Function declarations are statements; function expressions are used in statements

- The process of invoking a function created by a declaration is exactly the
  same for one created with an expression

- You can hold function references in variables

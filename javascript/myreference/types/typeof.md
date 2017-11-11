# typeof operator

- can be used as an operator or a function

```javascript
typeof("abfasdf");           // string
typeof(124);                 // number
typeof(true);                // boolean
typeof({});                  // object
typeof([]);                  // object
typeof({"abc": 123});        // object
typeof(["abc", 123]);        // object
typeof(function() {});       // function
typeof(null);                // object
var a;
typeof(a);                   // undefined
```

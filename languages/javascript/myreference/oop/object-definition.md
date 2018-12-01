# Common Pattern for Object Definition

- define properties inside the constructor
- define methods on the prototype

```javascript
function Test(a, b, c, d) {
  // property definitions
}

// first method definition
Test.prototype.x = function () {}

// second method definiton
Test.prototype.y = function() {}
```

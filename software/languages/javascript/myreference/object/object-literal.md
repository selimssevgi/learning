# Object Literal

- You tyoe out each part of the object within curly braces
- Gives you a convienient way to create objects anywhere in your code
- It is not the best way when you need to create lots of objects
  - tired fingers
  - can ensure each object has the same properties? A typo?
  - lots of code, lots of time to download the code
  - functionality would have to be duplicated
  - A change? In lots of places

- See 'Object Constructor'


* An object being created using object literal

```javascript
var taxi = {
  model: 'Taxi',
  year: 1995,
  started: false,

  start: function() { this.started = true; },
  stop: function() { this.started = false; }
}
```

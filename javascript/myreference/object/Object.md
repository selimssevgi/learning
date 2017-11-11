# Object

- Every prototype chain you ever create will end in Object

## Members

## Override

- toString

- toLocaleString

- valueOf

```javascript
Robot.prototype.toString = function() {
  return this.name + ' Robot belonging to ' + this.owner;
}
```

## Do Not Override

- constructor

- hasOwnProperty

- isPrototypeOf

- propertyIsEnumarable

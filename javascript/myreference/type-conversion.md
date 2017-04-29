# Type Conversion in JS

- Most of time, operators of functions automatically convert a value to the
  right type, this is called 'type coersion'.


```java
let value = String(true); // "true"
console.log("6" / "2"); // 3

let num = Number("123");

Number("123z"); // NaN
Number(true);   // 1
Number(null);   // 0

console.log(1 + '2'); // "12"
console.log('1' + 2); // "12"

console.log("2" - 1); // 1
```

- Values that are intuitively "empty", like 0, an empty string, null, undefined,
  NaN becomes false.

```javascript
Boolean(1);   // true
Boolean("hello"); // true

Boolean(0); // false
Boolean("0"); // true, non-empty string
```

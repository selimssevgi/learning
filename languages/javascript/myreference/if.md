# IF

## Comparison in JS

- == and != can be used. However, they do conversion on types, and not obvious
  sometimes what is going on.

- Use their strict version to be sure what is going on: ===, !==
- Strict operators wont cause type conversions, if they are diff type, return f
- === compares types and values of operands

*NOTE:* Any value that is not 'false', 'undefined', 'null', 0, 'NaN', or an
empty string ('') actually returns true when tested as an conditional statement

```javascript
let num = 10;
let otherNum = 4;

if (num === 10 && otherNum === 5) {
  // do something
} else if (num > 10 || otherNumber > 5) {
  // do something
} else {
  // do something
}
```

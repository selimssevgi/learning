# null in JS

- null is not another type, it is object type
- typeof(null); // object
- In recent specs, it is type null

- means no object
- not to confuse with undefined, which mean no value

- getElementById returns null if cannot find an object matches that
- null can be useful meaning that something does not exist
- null is intended to represent an object isn't there


```javascript
var weather = document.getElementById('weatherDiv');

if (weather !== null) {
  // create content for the weather div
}
```

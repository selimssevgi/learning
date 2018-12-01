# RegExp

- a built-in JS object for regular expression


```javascript
var areaCode = new RegExp(/[0-9]{3}/);

var phoneNumber = new RegExp(/^\d{3}-?\d{4}$/);

var amyHome = '544-1345';

var result = amyHome.match(phoneNumber);
```

- The result is an array containing any parts of the string that matched

- If the result is null, then nothing matched

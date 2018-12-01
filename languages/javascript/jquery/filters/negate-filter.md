# Negate Filter

- to negate a selector
- :not()


```javascript
$('input:not(:checkbox)'); // any input element that's NOT a checkbox

$(':not(img[src*="dog"])'); // not only img elements but other elements too

$('img:not([src*="dog"])'); // all img that does NOT contain dog
```

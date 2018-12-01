# jQuery

- is a JS library
- is specialized for changing the web page documents on the fly
- is aimed at reducing and simplifying much of the JS code and syntax that is need to work with DOM

- It also solves many browser compatibility issues for you


```javascript
window.onload = function() {
  console.log('the page is loaded!');
}

// jQuery
$(document).ready(function() {
  console.log('the page is loaded!');
});

// or
$(function() {
  console.log('the page is loaded!');
});
```

# Exception Handling in JS

```javascript
window.onload = function() {
  try {
    var message = document.getElementById('messge');
    message.innerHTML = 'Here is a message'; // null
  } catch (error) {
    console.log('Error! ' + error.message);
  }
}
```

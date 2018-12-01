# Where to Put DOM Manipulating JS Code

- If JS code is manipulating DOM, it is more important where the code is placed

## In Head Element

- Because the rest of the page is not loaded, code might not have an effect
- For example it might not find the p element with id that you are looking for

## At the Bottom of Body

- At the this other elements will be loaded in to DOM, can be manupilated

## window.onload

- a way to make sure that js code will run after the page is fully loaded
- adding it as callback, or event handler


```javascript
function init() {
  // do smth with the DOM
}

window.onload = init;
```

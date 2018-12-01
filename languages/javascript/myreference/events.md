# Events

```javascript
let title = document.getElementById('page-title');

title.onclick = () => { console.log("clicked on title"); };
```

- Put js scripts at the bottom, cus if trying to reach 'page-title', the page
  wont be loaded completely and wont find the id
- or listen window.onload event to overcome such problems

```javascript
window.onload = function () {
  console.load('page is loaded');
};
```


```javascript
let myform = document.forms.myform;
let message = document.getElementById('message');

myform.onsubmit() = function () {
  
  if (myform.username === "") {
    message.innerHTML = "please enter a name";
    return false;
  } else {
    message.innerHTML = "";
    return true;
  }

};
```

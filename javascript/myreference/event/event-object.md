# Event Objects

- sometimes inside the event handler function there is a parameter specified
  with a name such as event, evt, or simple e. This is called the 'event object'

- It is automatically passed to event handlers to provide extra features and information

- JS lets you ignore parameters if you want, a handler function can be without any parameters

- The even object is mostly used with DOM-related events handlers

```javascript
btn.onclick = function(e) {
  e.target.style.backgroundColor = 'yellow';
}


form.onsubmit = function(event) {
  e.preventDefault();
  console.log('preventing default action');
}
```

### event.target

- holds a reference to the object that generated the event
- event.target === document.querySelectory('#clickedElement'); (most of the time)

### event.keyCode

- tell which key the user just pressed

### event.touches

- tells how many fingers are touching the screen

### event.type

- "click", "load"

### event.timeStamp

- tells when the event happened

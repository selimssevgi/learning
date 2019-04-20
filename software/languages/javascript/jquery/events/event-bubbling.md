# Event Bubbling

- When an event is triggered on an element, the event-handling mechanism of the
  browser checks if a handler has been established for that particular event on
  that element, and if so, invokes it


- After the target element has had its chance to handle the event, the event
  model checks with the parent of that element to see it it has a handler for
  the event type, and if so, it is also invoked, then its parent, so on and on


```javascript
// prevent an event from propagating any higher
event.stopPropagation();

// or stop default action
event.preventDefault();

// both jobs are done different in older IE browsers
```

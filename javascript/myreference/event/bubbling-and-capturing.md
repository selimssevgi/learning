# Bubbling and Capturing

- When an event is fired on an element that has parent elements, modern browsers
  run two different phases -- the capturing phase and the bubbling phase


## Capturing Phase

- the browser checks to see if the element's outer-most ancestor(html) has an
  'onclick' event handler registered on it, and runs it if so.

- Then it moves on to the next element in html and does the same thing, then the
  next one, and so on until it reaches the element that was actually clicked on.

## Bubbling Phase

- The browser checks to see if the element that was actually clicked on has an
  onclick event handler registered on it, and runs it if so.

- Then it moves on to the next immediate ancestor element and does the same
  thing, then the next one, so on until it reaches the html element.


- In modern browsers, by default, all event handlers are registered in the
  bubbling phase.

## Stop Propagation

- The standard event object has a function available on it called
  stopPropagation()

- When stopPropagation() invoked on a handler's event object, handlers is run
  but the event doesnot bubble any further up the chain, so no more handlers
  will be run.


```javascript
video.onclick = function(event) {
  e.stopPropagation();
  video.play();
}
```

- addEventListener has third optional parameters to use capturing phase as defult

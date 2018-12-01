# Event Types

- Network-based events
- Timer events
- DOM events

- mousemove event: clientX, clientY, screenX, screenY, pageX, pageY

- window.onload
- window.unload (closing or moving another tab)
- obj.onclick
- obj.onmouseover
- mousemove, keypress, resize, mouseover, mouseout, dragstart, touchstart


* Not all events work same, with time-based events, rather than assingning a
  handler to a property, setTimeout is used to call a function


```javascript
// is a method on window object, cus it is a global object, it is omitted
setTimeout(timerHandler, 5000); // run after 5 seconds

setTimeout(reblur, 2000, image); // uses third argument while calling callback

var timer = setInterval(handler, 1000);     // repeat every 1 seconds
clearInterval(timer); // stop setInterval
```

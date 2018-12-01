# Events

- Are actions or occurrences that happen in the system you are programming

- Each avaliable event has an 'event handler' 

- When user-defined function is passed as event handler, it called 'registering
  an event handler'

- Event handlers are sometimes called event listeners

*NOTE:* Web events are not part of the core JS language. They are defined as
part of the JS APIs built into the browser


```javascript
btn.onclick = function() {
  console.log('button is clicked!');
}
```

- Some events are:
  - onclick
  - onchange
  - onblur
  - onfocus
  - ondblclick - ondoubleclick

- Some events are very general and available nearly anywhere (for example an
  onclick handler can be registered on nearly any element), whereas some are
  more specific and only useful in certain situations (for example it makes
  sense to use onplay only in specific elements, such as video)

## addEventListener() and removeEventListener()

- using onclick property doesnot have a counterpart
- using onclick property doesnt let you register more than one event handler


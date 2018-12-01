# Event Instance

- When an event handler is fired, an instance of an object named Event is passed
  to the handler as its first parameter in all standards-compliant browsers

- IE8 and below do things differently: window.event


```javascript
// non-jquery event handler

if (!event) {
   event = window.event;
}

// or
event = event || window.event;
```

- The properties of the Event instance provide a great deal of information
  regarding the event that has been fired and is currently being handled

## Inspection the Event Instance

- jQuery defines an object of type jQuery.Event that it passes to the handlers

- jQuery copies most of the original Event properties to this object

- The important aspect of jQuery.Event is that it holds a set of normalized
  values and methods that can be used independently of the containing browser

- see jQuery.Event for full property and method list

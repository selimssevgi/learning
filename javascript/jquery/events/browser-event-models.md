# The Browser Event Models

- Netscape Navigator browser
  - Netscape Event Model, the Basic Event Model, Browser Event Model
  - DOM Level 0 Event Model

- W3C didnt create a standardized model for event handling until DOM Level 2,
  introduced in Nov 2000.

- IE9+ and modern browsers support the model in DOM Level 2 


## The DOM Level 0 Event Model

- Browser-independent and fairly easy to use

- Assigning a function to the 'onclick' property

```javascript
// an anonymous function is automatically created
// using the value of click attribute as the body
<img id="example" src="example.jpg" onclick="console.log('Helloo!')" />

document.getElementById('example').onmouseover = function(event) {
  console.log('Helloooo');
}
```

- This kind of usage violates the precepts of unobtrusive JS

*NOTE:* Under the DOM Level 0 Event Model, almost every step you take in an
event handler involves using browser-specific detection in order to figure out
what action to take.

## The DOM Level 2 Event Model

- One of the shortcomings of Level 0 Event Model is that only one event handler
  per element can be registered for any specific event type at a time

```javascript
someElement.onClick = function () { // do smth };
someElement.onClick = function () { // do smth else }; // overrides the first one

// both functions could be wrapped up in one function

// another library might override the handler, or yours override theirs
```

## Establishing event handlers

- Rather than assigning a function reference to an element property, DOM Level 2
  event handlers are established via an element 'method'

- Each DOM element defines a method named addEventListener()

- addEventListener(eventType, listener, useCapture);

- useCapture is defualting to false

```javascript
element.addEventListener('click', handleClick);
element.addEventListener('click', anotherHandleClick);
element.addEventListener('click', yetAnotherHandleClick);
```

### Event Propagation

- 'root to target' is called 'capture phase'

- 'target to root' is called 'bubble phase'

- capture handlers are hardly ever used in web pages, old IEs dont support it

## Internet Explorer Model

-  IEs prior to 9 dont provide support for the DOM Level 2 Event Model

- It defines attachEvent() for each DOM element

- Closely resembles the bubble phase of the standard model

- attachEvent(eventName, handler);

- eventName is string same as event types: onclick etc

- Event instance must be fetched from the window.event property

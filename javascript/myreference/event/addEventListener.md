# addEventListener

1. Event handlers can be assinged to event using object properties

2. A more general way of assigning event handlers is using addEventListener

- addEventListener lets use to assign multiple handler foor one event type
- Multiple handlers cannot be done using object properties


```javascript
window.addEventListener('load', init, false);

function init() {}
```

- 'load' is name of the event
- 'init' is the referenceo of the function as an event handler
- the last one is a flag indicating if we want to bubble the event up

- Another event handler can be add just in the same way

*NOTE:* There is no guarantee of which one will be called first

- Event handler can be removed too

```javascript
function handleClick(e) {
   var target = e.target;
   target.removeEventListener('click', handleClick);
}
```

- This method does not work before IE9

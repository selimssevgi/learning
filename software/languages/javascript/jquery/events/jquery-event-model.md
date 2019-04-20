##  The jQuery Event Model

- read 'browser-event-models'

- Provides a unified method for establishing event handlers

- Allows multiple handlers for each event type on each element

- Uses standard event-type names like click or mouseover

- Passes the Event instance as the first argument of the handlers

- Normalizes the Event isntance for the most-often-used properties

- Provides unified methods for event canceling and default action blocking

## Attaching event handlers with jQuery

- eventType string can be space-separated

```javascript
$('img').on('click', function(event) { // every img on the page
  console.log('Helloo');
});

$('#my-button').on('click', {
   name: 'John'
}, function (event) {
   console.log('the name is: ' + event.data.name);
});
```

### Event

```shell
blur        | focusin    | mousedown  | mouseup    | unload
change      | focusout   | mouseenter | ready      | 
click       | keydown    | mouseleave | resize     |
dblclick    | keypress   | mousemove  | scroll     |
error       | keyup      | mouseout   | select     |
focus       | load       | mouseover  | submit     |
```

### one()

- establishes an event handler as a one-shot deal

- Once the event handler executes, it's automatically removed

- Identical syntax to on()

## Removing event handlers

- remove an event handler to save memory

- off(), identical syntax to on()

- handler is optional

- eventType is enough 

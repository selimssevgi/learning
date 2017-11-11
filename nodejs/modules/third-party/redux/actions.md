# Actions

- An important Redux rule: application state should be stored in a single
  immutable object

- Eventually update the state object by replacing it entirely

- In order to replace it entirely, we will need instructions about what changes

- Actions provide: instructions about what should change in application state
  along with the necessary data to make those changes

- Actions are the only way to update the state of a Redux application

- We can also look at actions like receipts about the history of what has
  changed over time


```javascript
// color organizers

const constants = {
  SORT_COLORS: "SORT_COLORS",
  ADD_COLOR: "ADD_COLOR",
  RATE_COLOR: "RATE_COLOR",
  REMOVE_COLOR: "REMOVE_COLOR"
}

export default constants
```

- An action is a JS object that has at minimum a field for type:

```javascript
{ type: "ADD_COLOR" } // possible typo bugs

import C from './constants'

{ type: C.ADD_COLOR }
```

- 'Action type' is a string that defines what should happen

## Action type naming conventions

- Action types are just strings, so technically could be anything

- Typically action types are capitalized and underscores instead of spaces

- Aim to clearly state the action's intended purpose

## Action Payload Data

- Most state changes also require some data
  - Which record should I remove?
  - What new information should I provide in a new record?

- We refer to this data as the action's payload

```javascript
{
  type: "RATE_COLOR",
  id: "<some_id>",
  rating: 4
}

{
  type: "ADD_COLOR",
  color: "#FFFFFF",
  title: "Bright White",
  rating: 0,
  id: "some_id",
  timestamp: "some_time_stamp"
}
```

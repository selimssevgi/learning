# Action Creators

- Action objects are simply JS literals

- Action 'creators' are functions that create and return these literals


```javascript
import C from './constants';

export const removeColor = id =>
  ({
    type: C.REMOVE_COLOR,
    id
  });

export const rateColor = (id, rating) =>
  ({
    type: C.RATE_COLOR,
    id,
    rating
  });


store.dispatch(rateColor("some_id", 5))
store.dispatch(removeColor("some_id"))
```

- Action creators simplify the task of dispatching action

- We only need to call a function and send it the necessary data

- Action creators can abstract away details of how an action is created

- Action creators can have logic. They also can help abstract away unnecessary
  details when creating an action

```javascript
export const addColor = (title, color) =>
  ({
    type: C.ADD_COLOR,
    id: v4(),
    title,
    color,
    timestamp: new Date().toString()
  })
```

- Action creators are where we should put any logic for communicating with
  backend APIs

- With an action creator, we can perform asynchronous logic like requesting data
  or making an API call

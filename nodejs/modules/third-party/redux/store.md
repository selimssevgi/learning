# The Store

- in Redux, the store is what holds the application's state data and handles all
  the state updates

- While the Flux desing pattern allows for many stores that each focus on a
  specific set of data, Redux only has one store

- The store handles state updates by passing the current state and action
  through a single reducer


```javascript
import { createStore } from 'redux';
import { color } from './reducers';

const store = createStore(color);
console.log(store.getState()); // {}
```

```javascript
import { createStore, combineReducers } from 'redux';
import { colors, sort } from './reducers';

const store = createStore(
  combineReducers(colors, sort), initialState
)

console.log(store.getState().colors.length)
```

- The only way to change state of your application is by dispatching action
  through the store

- The store has a dispatch method that is ready to take actions as an argument

- When you dispatch an action through the store, the action is sent through the
  reducers and the state is updated


```javascript
store.dispatch({
  type: "ADD_COLOR",
  id: "2222e1p5-3abl-0p523-30e4-8001l8yf2222",
  title: "Party Pink",
  color: "#F142FF",
  timestamp: "Thu Mar 10 2016 01:11:12 GMT-0800 (PST)"
});
```

## Subscribing to Stores

- The store's subscribe method returns a function that you can use later to
  unsubscribe the listener

```javascript
const logState = () => console.log('next state:', store.getState())

const unsubscribeLogger = store.subscribe(logState)

// invoke when ready to unsubscribe
unsubscribeLogger();
```

## Saving to localStorage

- Using the store's subscribe function, we will listen for state changes and
  save those changes to localStorage under the key 'redux-store'

- When we create the store we can check to see if any data has been saved under
  this key and, if so, load that data as our initial state


```javascript
const store = createStore(
  combineReducers({ colors, sort }),
  (localStorage['redux-store']) ?
    JSON.parse(localStorage['redux-store']) :
    {}
);

store.subscribe(() =>
  localStorage['redux-store'] = JSON.stringify(store.getState())
);

```

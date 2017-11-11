# Reducers

- Our entire state tree is stored in a single object

- A potential complaint might be that it's not modular enough(not many objects)

- Redux achieves modularity via functions

- Functions are used to update parts of the state tree, they are called 'reducers'

- Reducers are functions that take the current state along with an action as
  arguments and use them to create and return a new state

- We can compose reducers into one reducer that handle updating the entire state
  of our app given any action


```javascript
// color organizer data
{
  colors: [],
  sort: "SORTED_BY_DATA"
}
```

- Stub reducers for such data

```javascript
export const color = (state={}, action) => {
  return {}
}

export const colors = (state=[], action) => {
  return []
}

export const sort = (state="SORTED_BY_DATE", action) => {
  return ""
}
```


```javascript
export const color = (state = {}, action) => {
  switch(action.type) {
    case C.ADD_COLOR:
      return {
        id: action.id,
        title: action.title,
        color: action.color,
        timestamp: action.timestamp,
        rating: 0
      }
    case C.RATE_COLOR:
      return (state.id !== action.id) ?
        state :
        {
          ...state,
          rating: action.rating
        }
    default:
      return state
  }
}

const action = {
  type: "ADD_COLOR",
  id: "id",
  color: "#FFF",
  title: "Big Blue",
  timestamp: "timestamp"
}

console.log(color({}, action))
```

- Reducers should always return something

```javascript
export const colors = (state = [], action) => {
  switch(action.type) {
    case C.ADD_COLOR:
      return [
        ...state,
        color({}, action)
      ]
    case C.RATE_COLOR:
      return state.map(
        c => color(c, action)
      )
    case C.REMOVE_COLOR:
      return state.filter(
        c => c.id !== action.id
      )
    defult:
      return state
  }
}
```


#### Treat state as an immutable object

- In all of these reducers, we need to treat state as an immutable object

- Although it may be tempting to use state.push({}) or state[index].rating, we
  should resist the urge to do so.

#### No side effects in reducers

- Reducers should be predictable

- They are used to simply manage the state data

- Generating random data, calling APIs, and other asynchronous processes should
  be handled outside of reducers

- Avoiding state mutations and side effects is always recommended


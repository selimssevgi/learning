# setState

- setState function is a asynchronous
- it just schedules an update
- multiple setState calls might potentially  be batched for performance

```javascript
handleClick = () => {
  // reading and writing to the state object
  // we might have race condition
  this.setState({
    count: this.state.counter + 1;
  })
}
```

- The general rule of thumb is wheneven you need to update the state using a
  value from the current state, use the the other contract of the setState
  method, which is a function instead of an object.

```javascript
handleClick = () => {
  // pass a function that takes previos state
  // and return an object to set the state
  this.setState((prevState) => {
    return {
      count: prevState.counter + 1;
    };
  })

  // arrow function version
  this.setState((prevState) => ({counter: prevState.counter + 1}));
}
```

* What can you do when you need to run logic after some state update?

```javascript
acceptAnswer = () => {
  this.setState(prevState => ({
    // change properties for accepting answer
  }), this.updateDoneStatus);

  // cannot depend on this that it will run right after setState
  // becuase that function is asynchronous
  // instead we can use another version of setState with extra argument
  // to say what to do after being done with updating state
  // this.updateDoneStatus(); // also updates state
}
```

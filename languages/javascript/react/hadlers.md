# Handler Functions


```javascript
render () {
  return (
      <button onClick={this.props.incrementerCounter}>
      +1
      </button>
  );
}
```

- using inline function
- creating a new function for every renderen button!

```javascript
render () {
  return (
      <button onClick={() =>
      this.props.incrementerCounter(this.props.incrementValue)}>
      {this.props.incrementValue}
      </button>
  );
}
```

```javascript
handleClick = () => {
  this.props.incrementerCounter(this.props.incrementValue);
}

render () {
  return (
      <button onClick={this.handleClick}>
      {this.props.incrementValue}
      </button>
  );
}
```

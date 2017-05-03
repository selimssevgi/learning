# Components


```javascript
var React = require('react');
var ReactDOM = require('react-dom');


// create component
var TodoComponent = React.createClass({
  render: function () {
    return(
      <h1>Ninja!!</h1>
    );
  }
});

// put component into html page
ReactDOM.render(<TodoComponent />, document.getElementById('todo-wrapper'));
```

- There are two main ways to work with data in react: props and state

## Props

```javascript
// create component
var TodoComponent = React.createClass({
  render: function () {
    return(
      <div>
      <h1>Helloo!!</h1>
      <p>{this.props.mssg}</p>
      <p><strong>Cheese name: </strong> {this.props.cheese.name} </p>
      <p><strong>Cheese smell: </strong> {this.props.cheese.smellFactor} </p>
      <p><strong>Cheese price: </strong> {this.props.cheese.price} </p>
      </div>
    );
  }
});

var myCheese = {name: 'Camembert', smellFactor: 'Extreme pong', price: '3.50'};

// put component into html page
ReactDOM.render(<TodoComponent mssg="I like cheese!" cheese={myCheese}/>, document.getElementById('todo-wrapper'));
```

## State

```javascript
// create component
var TodoComponent = React.createClass({
  getInitialState: function () {
    return {
      todos: ['wash up', 'eat some cheese', 'take a nap'],
    };
  },

  render: function () {
    return(
      <div id="todo-list">
        <p>The busiest people have the most leisure...</p>
        <ul>
          <li>{this.state.todos[0]}</li>
          <li>{this.state.todos[1]}</li>
          <li>{this.state.todos[2]}</li>
        </ul>
      </div>
    );
  }
});


// put component into html page
ReactDOM.render(<TodoComponent />, document.getElementById('todo-wrapper'));
```

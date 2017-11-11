# React State Management

- Properties are immutable, once rendered, a component's properties do not change

- React state is a built-in option for managing data that will change within a
  component

- State represents data that we may wish to change within a component

- State can only be change by calling 'this.setState', which updates specific
  parts of the state object.

- After every 'setState' call, the 'render' function is called, updating the
  state with the new UI

## Initializing State from Properties

- State values can be initialized using incoming properties

- componentWillMount

- Or in constructor of ES6 class

**NOTE:** For the most part, you will want to avoid setting state variables from
properties. Only use these pattern when they are absolutely required. You should
find this goal easy to accomplish because when working with React component, you
want to limit the number of components that have state

## State Within the Component Tree

- In many react applications, it is possible to group all state data in the root
  component

- State data can be passed down the component tree via properties, and data can
  be passed back up the tree to the root via two-way function binding

- All of the state for the entire application exists in one place, often
  referred to as having a 'single source of truth'

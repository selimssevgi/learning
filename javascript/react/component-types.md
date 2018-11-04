# Component Types

- Function component
- Class component

## Function Component

- Just takes props
- No private state

```js
const MyComponent = (props) => {
  return (
    <OtherComponent ... />
  );
}
```

## Class Component

- Takes props
- But it has its own internal state as well

```js
class MyComponent extends React.Component {
  render() {
    return (
      <SomeOtherComponent ... />
    );
  }
}
```

** Defining components as class component does not mean that component should
have private state. Having a function handler that uses a prop on the component
could also be a reason to define it as a class component.

# Costum Property Validation

- There are instances that require more robust validation

- make sure that 
  - a number is within a specific range
  - a value contains a specific string

- Custom validation in React is implemented with a function
- This function should either return an error or null when the property is valid


```javascript
Summary.propTypes = {
  ingredients: PropTypes.number.isRequired,
  steps: PropTypes.number.isRequired,
  title: (props, propName) =>
    (typeof props[propName] !== 'string') ?
      new Error("A title must be a string") :
      (props[propName].length > 20) ?
        new Error("Title is over 20 characters") :
        null
};

```

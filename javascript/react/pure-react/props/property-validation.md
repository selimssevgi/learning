# Property Validation

- npm install --save prop-types

- React components provide a way to specify and validate property types

- Using property validation will greatly reduce the amont of time spent
  debugging applications

Type       | Validator
-----------|----------
Arrays     | React.PropTypes.array
Boolean    | React.PropTypes.bool
Functions  | React.PropTypes.func
Numbers    | React.PropTypes.number
Objects    | React.PropTypes.object
Strings    | React.PropTypes.string

- Stateless functional components and ES6 classes have different ways of
  implementing property validation

## Validating Props with ES6 class

```shell
export default Summary extends React.Component {}

Summary.propTypes = {
  ingredients: PropTypes.array.isRequired,  
  title: PropTypes.string
}
```

- Show useful warnings in console

## Validating Props with Stateless functional component

- The propTypes and defaultProps object literals can be added

```javascript
const Summary = ({ ingredients, steps, title }) => {
  return (
    <div>
      <h1>{title}</title>
      <p>{ingredients} Ingredients | {steps} Steps</p>
    </div>
  )
}

Summary.propTypes = {}

Summary.defaultProps = {}
```

- We can set default values when we destructure the properties object in the
  function arguments

```javascript
const Summary = ({ ingredients=0, steps=0, title='[recipe]' }) => {}
```

**NOTE:** Property validation, custom property validation, and the ability to
set default property values should be implemented in every component. This makes
the component easier to reuse because any problems with component properties
will show up as console warnings.

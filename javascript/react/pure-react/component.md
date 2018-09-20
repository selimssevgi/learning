# React Components

- Components allow us to reuse the same DOM structure for different recipes or
  different sets of data

- Three different ways to create components:
  1. createClass
  2. ES6 classes
  3. stateless functional components

## React.createClass

- When React was first introduced in 2013, there was only one way to create a
  component: the 'createClass' function

- The React team has indicated that 'createClass' may be deprecated in the future

```javascript
const IngredientsList = React.createClass({
  displayName: "IngredientsList",
  render() {
    return React.createElement("ul", {"className": "ingredients"},
      React.createElement("li", null, "1 lb Salmon"),
      React.createElement("li", null, "1 cup Pine Nuts"),
      React.createElement("li", null, "2 cups Butter Lettuce")
    )
  }
})

const list = React.createElement(IngredientsList, null, null)

ReactDOM.render(
  list,
  document.getElementById('react-container')
)

```

- Data can be passed to React components as properties

```javascript
const IngredientsList = React.createClass({
  displayName: "IngredientsList",
  render() {
    return React.createElement("ul", {"className": "ingredients"},
      this.props.items.map((ingredients, i) =>
        React.createElement("li", {key: i}, ingredient)
      )
    )
  }
})

const items = [
 "1 lb Salmon",
 "1 cup Pine Nuts",
 "2 cups Butter Lettuce"
]

ReactDOM.render(
  React.createElement(IngredientList, {items}, null),
  document.getElementById('react-container')
)
```

- Components are object, can be used to encapsulate code just like classes

```javascript
const IngredientsList = React.createClass({
  displayName: "IngredientsList",
  renderListItem(ingredient, i) {
     return React.createElement("li", { key: i }, ingredient)
  },
  render() {
    return React.createElement("ul", {"className": "ingredients"},
      this.props.items.map(this.renderListItem)
    )
  }
})
```

## React.Component

- ES6 spec has classes

```javascript
class IngredientsList extends React.Component {
  
  renderListItem(ingredient, i) {
    return React.createElement("li", { key: i }, ingredient)
  }

  render() {
    return React.createElement("ul", {className: "ingredients"}),
      this.props.items.map(this.renderListItem)
    )
  }
}
```

## Stateless Functional Components

- Stateless functional components are functions, not objects

- They do not have a 'this' scope

- They are simple, pure functions, recommended to use them as much as possible

- Use 'class' or 'createClass' where the stateless functional component is not robust enough

- Stateless functional components are functions that take in properties and
  return a DOM element


```javascript
const IngredientsList = props =>
  React.createElement("ul", {className: "ingredients"}),
    props.items.map((ingredient, i) => 
      React.createElement("li", { key: i }, ingredient)
    )
  )

// using ES6 destructuring syntax
const IngredientsList = ({items}) =>
  React.createElement("ul", {className: "ingredients"}),
    items.map((ingredient, i) => 
      React.createElement("li", { key: i }, ingredient)
    )
  )
```

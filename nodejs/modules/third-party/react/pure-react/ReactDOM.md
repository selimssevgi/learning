# ReactDOM

- ReactDOM contains the tools necessary to render React elements in the browser

- 'render', 'renderToString', 'renderToStaticMarkup' methods

- All the tools necessary to generate HTML from the virtual DOM are found in
  this library


```javascript
var dish = React.createElement("h1", null, "Baked Salmon")

ReactDOM.render(dish, document.getElementById('react-container'))

// 1st: the element that we wish to render
// 2nd: the target node, where we should render the element
```

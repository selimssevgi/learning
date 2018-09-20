# React Elements

- The browser DOM is made up of DOM elements

- Similary, the React DOM is made up of React elements

- React elements are the instructions for how the browser DOM should be created


```javascript
// React Element
React.createElement("h1", null, "Baked Salmon")

// 1st: the type of element that we wish to create
// 2nd: the element's properties
// 3rd: the element's children, any node that are inserted between o/c tag

// DOM Element
<h1>Baked Salmon</h1>
```


```javascript
React.createElement("h1",
  {id: "recipe-0", 'data-type': "title"},
  "Baked Salmon")

<h1 data-reactroot id="recipe-0" data-type="title">Baked Salmon</h1>
```

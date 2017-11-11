# Children

- ReactDOM allows to render a single element to the DOM

- React tags that element as 'data-reactroot'

- All other React elements are composed into a single element using nesting

- React renders child elements using 'props.children'


```html
<ul>
  <li>1 lb Salmon</li>
  <li>1 cup Pine Nuts</li>
  <li>2 cups Butter Lettuce</li>
</ul>
```


```javascript
React.createElement(
  "ul",
  null,
  React.createElement("li", null, "1 lb Salmon"),
  React.createElement("li", null, "1 cup Pine Nuts"),
  React.createElement("li", null, "2 cups Butter Lettuce")
)
```

```javascript
var items = [
 "1 lb Salmon",
 "1 cup Pine Nuts",
 "2 cups Butter Lettuce"
]

React.createElement(
  "ul",
  { className: "ingredients" },
  items.map( (item, i) =>
    React.createElement("li", { key: i }, item))
)
```

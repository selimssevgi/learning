# JSX

- An alternative to typing out verbose React.createElement calls is JSX

- A JS extension that allows us to define React elements using syntax that looks
  similar to HTML

- In JSX, an element's type is specified with a tag

- The tag's attributes represent the properties

- The element's children can be added between the opening and closing tags

```javascript
React.createElement(IngredientsList, {list:[...]});

<IngredientsList list={[...]}/>
```

- Component properties will take two types:
  - a string        ""
  - a JS expression {}

## Nested Components

```javascript
<IngredientsList>
  <Ingredient />
  <Ingredient />
  <Ingredient />
</IngredientsList>
```

- JSX looks clean and readable, but it can't be interpreted with a browser
- All JSX must be converted into createElement calls or factories
- Babel is an excellent tool for this task


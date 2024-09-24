# CSS Selectors

- h1 {color: blue;}
- h1 is a selector
- color is property
- blue is value
- "color: blue" is declaration

1. The element selector: p {}
2. The id selector: #id {}
3. The class selector: .class {}
4. Grouping selectors: h1, p {}
5. Selector Specificty
6. Descendant Selectors: #main-content p {}
7. Direct child selector: #main-content > p {}
8. Adjacent selector: #all-articles h + p {} // just p coming right after h
9. Attribute selector: span[class] {}, a[title="homepage"] {} // span elements with class attribute

## The element Selector

- Selects elements based on the element name
- To select on p elements:

```css
p {
  text-align: center;
}
```

## The id Selector


```css
#para1 {
  color: red;
}
```

## The class Selector

- Elements can have more than one class
- class="center large" -> class="center" and class="large"

```css
.center {
  text-align: center;
}

p.center {
  color: blue;
}
```

## Grouping Selectors

- Group elements with the same style

```css
p, h1, h2 {
  color: red;
}
```

## Selector Specificty

- id selector has 100points
- class selector has 10points
- element selector has 1 point

```css
#main-content p { color: red; }

p { color: blue; }

.text { color: green; } /* even this is in main-content, p tag will have red color */
```

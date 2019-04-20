# Content Filters

- Are designed to select elements based on their content

- Select elements if they contain a given word or if the content is empty

- 'content' does not mean only raw text but also child elements


```javascript
$('div span'); // span elements that are descendants of div elements

$('div:has(span)'); // div elements as ancestor of span elements
```

Selector        | Description | In CSS?
----------------|-------------|--------
:contains(text) | elements and descendants | NO
:empty          | elements that have no children | YES
:has(selector)  | contains at least 1 element that matches the selector | NO
:parent         | elements that have at least on child node | NO

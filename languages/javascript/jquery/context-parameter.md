# Context Parameter

- $ function takes two arguments, second one is 'context', can be omitted

- Used to restrict the selection to one or more subtrees of the DOM

- This argument is helpful when there is a large number of elements in a page

- jQuery methods assume reasonable defults for optional arguments

- For 'context' parameters, the default is 'document'

- When a selector or jQuery collection is provided as 'context', the identified
  elements serve as the context for the application of the selector


```javascript
var selector = 'some selector';

$(selector); // applies to the entire DOM tree

$(selector, '#sample-dom'); // narrow the search in element with id #sample-dom


// Descendant selector
$('div p');

// can be turned into
$('p', 'div');
```

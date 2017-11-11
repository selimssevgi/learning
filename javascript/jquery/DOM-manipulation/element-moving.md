# Moving Elements

- append()
- after()

```javascript
$('p').append('<b>some text</b>');

$('p.append-to').append($('a.append')); // move a to p
                                        // it will copy and move if multiple target
```

- prepend()
- before()


- appendTo(target)
- prependTo(target)
- insertBefore(target)
- insertAfter(target)

- remove([selector]) - removes all elements, their content, event listeners, any data stored

- detach([selector]) - retaining any bound event and jQuery data
  - faster to modify detached elements and then put them back

- empty() - removes the content of all DOM elements in matched set

```javascript
$('#content')
  .empty()
  .html(newContent);
```

- clone() - deep copy

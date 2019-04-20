# Generate HTML


```javascript
$('<div>Hello</div>');

// same, but use the well formated one above
$('<div>')
$('<div />')
```

* Dynamically creating a full-featured img element

```javascript
$('<img>', 
  {
    src: 'images/little.bear.png',
    alt: 'Little Bear',
    title: 'I wood in your general direction',
    click: function() {
      alert($(this.attr('title')));
    }
  }
)
.appendTo('body');
```

# Working with Attributes

- in jQuery, the same method can be used either to read or to write a value
- The same method work as a getter or a setter

- attr() can be used with custom attributes set through JS or HTML markup

## Getting Attribute Values

```html
<img id="my-image" src="image.gif" alt="An image" alt="A beautiful image"
  data-custom="some value" />
```

```javascript
$('#my-image').attr('data-custom'); // "some value"
```

## Setting Attribute Values

- attr(name, value)

- 'value' can be any JS expression results in value
- 'value' is converted into a string

- if 'value' is a function, is invoked for each element, return value is used

- attr(attributes) takes an object whose properties are copied as attributes to
  all elements in the set

```javascript
$('input').attr({
  value: '',
  title: 'Please enter a value'
});
```

## Removing Attributes

- removeAttr(name:String)

- uses JS removeAttribute() function

```javascript
$('img').removeAttr('title alt');
```


## Examples

* Make all links open in a new window

```javascript
$('a[href^="http://"]')
  .not('[target="_blank"]')
  .attr('target', '_blank');
```

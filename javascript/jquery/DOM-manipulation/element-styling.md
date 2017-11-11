# Element Styling

- className property is an example of a case where markup attr names differ from prop names

- Class names are a bit special in other respects as well

- There are often used two main options to change change the styling:

1. Adding or remove a class

2. Applying styles directy manipulating DOM element

## Adding and Removing Class Names

- In HTML, the 'class' attribute is used to supply these names a space-separated string

- There can be as many spaces as one wants

```html
<div class="some-class my-class   another-class"></div>
```

- Unfortunately, rather than manifesting themselves as an array of names in the
  DOM element's corresponding className property, the class names appear as that
  same space-dlimited string

- HTML5 has introduced a better way to manipulate class names through an API
  called 'classList'

  - This addition works on one element at the time (unlike jQuery)
  - It is a new addition, not all browsers support it

```javascript
// pure JS, works IE10+
var elements = document.getElementsByClassName('some-class');

for (var i = 0; i < elements.length; i++) {
  elements[i].classList.add('hidden');
}

// jQuery, works IE6+
$('.some-class').addClass('hidden');

// remove
$('#text').removeClass('hidden');
```

## Getting and Setting Styles

- css(name, value)
- css(properties)

```javascript
$('div').width(500);

$('div').css('width', 500);
```

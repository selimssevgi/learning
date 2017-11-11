# Properties, Attributes, Data

- jQuery in Action - Chapter 4

## Properties vs Attributes

- Both properties and attributes can be manipulated in DOM elements

- Parsing HTML markup -> JS object instances of DOM elements

- Properties are intrinsic to JS objects

- Attributes are specified on the markup of DOM elements

```html
<img id="my-image"
     src="image.gif"
     alt="An image"
     class="some-class"
     title="this is an image" />
```

- In the above element's markup:
  - tag name is 'img'
  - id, src, alt, class and title represents the element's attributes

- Browser reads and interprets the elements markup to create the JS object
  instance of type HTMLElement that represents this element in the DOM

* The first difference between these two concepts is that the properties's
  values may be different from their related attributes' values

  - Attributes' values are always strings
  - Properties's values may be strings, Booleans, numbers, or even objects


```html
<input id="surname" tabindex="1" style="color:red; margin:2px;" />

var element = document.getElementByID('surname');
console.log(typeof element.getAttribute('tabindex'));  // "string"
console.log(typeof element.tabIndex);                  // "number"

console.log(element.getAttribute('style')); // "color:red; margin:2px;"
console.log(element.style); // CSSStyleDeclaration object containing all the style
```

- the attribute values are stored not only in the 'attributes' property but also
  in a handful of other properties

- An active connection remains between the attribute values stored in the
  'attributes' object and the corresponding properties

- Changing an attribute value usually results in a change in the corresponding
  property value and vice versa


```html
<input type="checkbox" id="book" name="book" title="Check this!"
       book="jQuery in Action" />
```

* The following are true:

1. if the attribute exists as a built-in (native) property of the corresponding
    DOM object, the value is synchronized. for example: title

2. If the attribute exists as a built-in property but it's a Boolean, the value isn't sychronized. for example: 
   - checked retrieved as an attribute gives you the initial state of the check box element (null if not defined)

   - if retrieved as a property, regardless of whether it was defined or not,
     you obtain a Boolean of the current state of the element

3. If the attribute does not exist as a built-in property, it won't be created
   and the value wont be synchronized. the 'book' attribute won't be created as
   a property of the DOM element


```javascript
var checkbox = document.getElementById('book');

// built-in attribute
console.log(checkbox.getAttribute('title') === checkbox.title); // true
checkbox.title = 'New Title';
console.log(checkbox.getAttribute('title') === checkbox.title); // true
checkbox.setAttribute('title', 'Another Title');
console.log(checkbox.getAttribute('title') === checkbox.title); // true
```

*NOTE:* Values are not always identical. For example src attribute will set to
the full absolute URL of the image

* For the most part, the name of a JS property matches that of any corresponding
  attribute, but there are some cases where they differ. For example the 'class'
  attribute is represented by the 'className' property.

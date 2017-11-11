# jQuery Fundamentals

- jQuery focuses on retrieving elements from HTML pages and performing operations on them

- jQuery places a high priority on ensuring that code will consistently across all major browser

## Properties, utilities and methods

- the jQuery library is exposed through a property called 'jQuery'

- utility functions: handful of commonly used, general-purpose functions

- jQuery acts as a 'namespace' for utility functions


```javascript
var trimmed = jQuery.trim(someString);
var trimmed = $.trim(someString);

$.isArray(arr); // tests if a given argument is an array
```

## The jQuery Object

- It accepts up to two arguments

- Depending on the the number and type of the given argument, it performs different tasks

- It allows for 'chaining', like many other (almost all) methods in the library

- The most common use of jQuery() is to select elements from the DOM

- jQuery makes use of the same selectors as CSS

- It supports not only widely implemented ones of CSS2.1 but also in CSS3

- jQuery also has its own selectors and allows you to create your own custom selectors

```javascript
var paras = jQuery('p');

// if there are so many p elements, the process can be slow
// speed up the search using the 'context' parameter

var paras = jQuery('p', 'div');

// jQuery first collects elements based on this selector called 'context'
// then retrieves the descendants that match the first parameter
```

## The document ready handler

- When embracing unobstructive JS, behavior is separated from structure

- Perform operations on the page elements outside the doucment markup that creates them

- 'onload' handler is executed 'after' the document has "fully" loaded

- Fully loaded means that DOM tree creation, all external resources loading

- There might be serious delay between the time seeing the page and 'onload' script execution

- An image or any resources taking so much time to load can get in the way of
  creating the unobtrusive JS

- A much better approach would be to wait only until the document structure is
  fully parsed, and HTML is converted into DOM tree

```javascript
jQuery(document).ready(function() {
  // do smth
});

// shorter
$(function() {
  // do smth
});
```

- The code passed will be executed when DOM (but only the DOM) is fully loaded

- This technique can be used multiple times, and they will be executed in given order

- onload allows for only a single function (what if a 3rd party lib uses onload?)

- Using document-ready handler is a good way to embrace the unobtrusive JS
  tehcnique, but its use isnot mandatory and can be avoided

- If script is placed in the head element, ready() can be used (not best practise)

- Place your script at the bottom of the page, at that point all the elements will be ready to use

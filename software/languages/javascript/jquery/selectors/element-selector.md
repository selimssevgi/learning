# Element Selector 

- Also known as tag selector

- It selects all of elements in the document with given tag

- Uses the getElementsByTagName(), even IE6 supports it

- jQuery also enables you to use different types in a single selection,
  providing performance gain because the DOM is traversed only once

```javascript
$('h1').hide();     // hides all the h1 elements on the page

var $divs = $('div');

var $clearfixDivs = $('div.clearfix');

$('div, span'); // space is ignored, removes all duplicates
```

# Attribute Selector

- Allows to select elements based on their attributes

- Easily recognizable because they are wrapped with square brackets

- Watch out the quotes, either escape them with double \ or mixture of ' "" '

```javascript
var $externalLinks = $("a[href^='http://']"); // ^ match at the beginning of the string

$('a[href!="http://jquery.com"]');   // select the ones are NOT, slow execution

$('[href^="http://"]'); // assumes * selector, slow execution

var $formsWithMethodAtt = $('form[method]'); // regardless of its value

var $inputText = $('input[type="text"]');

$('div[title^="my"]'); // attribute starts with

var $allPdfLinks = $('a[href$=".pdf"]'); // attribute ends with

var $jQueryLinks = %('a[href*="jquery.com"]');  // *= contains, attribute contains

$('div[class|="main"]'); // contain prefix, main, main-xxx, main-footer
```

## Chaining of Selectors

```javascript
$('input[type="text"][required]')
```

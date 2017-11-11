# jQuery Collection

- jQuery set acts a lot like an array

## Methods

- As a rule of thumb, you use methods over filters becuse they usually lead a better performance

```javascript
$('p').length;

var imgElement = $('img[alt]')[0];
var imgElement = $('img[alt]').get(0); // (): all as js array,
                                       // -1 last one as DOM element
                                       // undefined if out of bounds

var $secondDiv = $('div').eq(1);  // using eq() method
var $secondDiv = $('div:eq(1)');  // using :eq() filter

var $firstPar = $('p').first();
var $firstPar = $('p:first');

var allLabeledButtons = $('label + button').toArray(); // js array of DOM elements

var index = $('#main-menu > li').index($('#blog-link'));
```

## Slicing and dicing a set

```javascript
$('img[alt], img[title]'); // img with either alt or title

$('img[alt]').add('img[title]');

$('img[alt]')
  .addClass('red-border')
  .add('img[title]')
  .addClass('opaque');


// remove
$('img[title]').not('[title*="puppy"]');

// filter
$('td').filter(function() {
  return this.innerHTML.match(/^\d+$/);
});


// map
var $allIDs = $('div').map(function() {
  return this.id;
});
//or
.toArray();

// each
$('img').each(function(i) {
  this.alt = 'This is image[' + i '] with an id of ' + this.id;
})

// end
$('img')
  .filter('[title]')
  .hide()
  .end()  // go back to previous set
  .addClass('my-class');

// without end
var $imgs = $('img');
$imgs.filter('[title]').hide();
$imgs.addClass('my-class');
```

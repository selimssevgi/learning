# JQuery

- Makes working with the DOM easier
- Making animations easier
- Makes event handling easier
- Makes AJAX really simple


```html
<body>
  <script src="scripts/jquery-min.js"></script>
  <script src="scripts/script.js"></script>
</body>
```

```html
<div id="content">
  <p>blablabla</p>
  <p>blablabla</p>
  <p>blablabla</p>
  <p>blablabla</p>
  <p>grab me</p>
</div>
```

```javascript
// vanilla JS
let para = document.getElementById('content').getElementsByTagName('p')[4];

// jQuery: $('css selectors') return jQuery Objects
let para = $('#content p:last-child'); // wraps the element and provides many methods
```

## jQuery Selectors

```javascript
// element selector
$('h3').css({border: "3px solid blue;"});

// class selector
$('.wrapper')

// id selector
$('#lead-banner')
$('#lead-banner p')
```

## jQuery Filters

- Similar to CSS pseudo selectors
- https://api.jquery.com/category/selectors/

```javascript
$('header nav li:first')
$('header nav li:last')

$('header nav li:even')
$('header nav li:odd')

$("section:not('#contact')")

$('#social-nav li:lt(3)')
$('#social-nav li:gt(2)')

// attribute filter: all the div with class attribute
$('div[class]')
$('img[alt]')

// attribute with specific value
$('img[alt=quote]')

// att
```

## Traversing DOM


```javascript
$('#contact-methods').next()
$('#social-nav').prev()
$('.banner-title').parent()
$('.banner-title').parents()
$('#social-nav').children()
$('#social-nav').find('.facebook')
```

## Adding Content


```html
<section id="tweets">
  <h2>Latest Tweets</h2>
  <div>
    <p> check out twitter </p>
  </div>
</section>
```

```javascript
// tweet is variable holding some text mixed in html
$('#tweets div').append(tweet);
$('#tweets div').prepend(tweet);
$('#tweets div p').before(tweet)
$('#tweets div p').after(tweet);
$('#tweets div').html(tweet);
$('#tweets div p').text(tweet);
```

## Remove Content


```javascript
$('.button').empty(); // empties inner html >Save<

$('.button').remove(); // remove the button all together

$('input[type=text]').val('');
```

## Changing Attributes

```javascript
$('#contact img').removeAttr('alt');

$('#contact img').attr(); // read
$('#contact img').attr("alt", "location"); // set
```

## Changing Class

```javascript
$('header .wrapper').removeClass('wrapper');
$('header > div').addClass('wrapper');
```

## Event Binding

```javascript
let lis = $('#points-of-sale li');

lis.on('click', function () {
  $(this).css({"background" : red;});
  $(this).off('click');
};

// event helper
$('#banner').click(callback); // similar to on('click')
```

## Document Ready vs Window Load

- When the scripts are linked in head part
- document is ready even the images are not loaded
- window load waits even for all sources and images to load

```javascript
// in order to make it a jquery object wrap: $(object)

$(document).on('ready', callback);
// or
$(document).ready(callback);
// or event shorter
$(callback)


$(window).on('load', callback);
$(window).load(callback);
```

## Show, Hide, Toggle

```javascript
$(document).ready(function () {

  $('section > h2').click(function () {

    $(this).hide(1000).show(1000);
    $(this).toggle();

  });
});
```

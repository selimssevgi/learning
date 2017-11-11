# Storing Custom Data on Elements

- Global variables suck

- The page behaviors are so element-focused, it makes sense to use the elements
  themselves as storage scopes

- DOM elements are represented by JS object instances, can be extended with
  custom propertoes

- Not being careful while extending object may cause serious problems

- jQuery provides a data() method to add data onto any DOM element in a
  controller fashion, without relying on potentially problematic expandos

- data(name: String, value: Any)

```javascript
$('.class').data('lastValue');

// equivalent of
$('.class').data('last-value');
```

* Unlike the attr() method that stores values always as string, data() is able
  to keep the value's type

```javascript
$('class').attr('last-value', 10);
console.log(typeof $('.class').attr('last-value')); // "string"

$('.class').data('last-value', 10);
console.log(typeof $('.class').data('last-value')); // "number"
```

- data(object), adds the key-value pairs

*NOTE:* Should not be confused with $.data(), which operates on DOM elements

```javascript
$.data(document.getElementById('book'), 'price', 10);

$('#book').data('price', 10);
```

## Retrieving Stored Data

```javascript
$('#level1').data('level');
```

- Is level data stored using data()? YES return stored value

- Does the element have a data-level attribute? YES store the value, return the value

- Return undefined

*NOTE:* Later changes to data-level attribute without using data() will not
affect data stored in jQuery's own storage

```javascript
<input id="level1" type="text" value="I'm a text!" data-custom="foo" />

$('#level1').data('custom'); // "foo"
$('#level1').attr('data-custom'); // "foo"

$('#level1').data('custom', 'new value');

$('#level1').data('custom'); // "new value"
$('#level1').attr('data-custom'); // "foo"
```

```javascript
<input id="level1" type="text" value="I'm a text!" data-custom="foo" />

$('#level1').data('custom'); // "foo"      // couldnt find, stored "foo" and returned
$('#level1').attr('data-custom'); // "foo"

$('#level1').attr('data-custom', 'new value');

$('#level1').data('custom'); // "foo"
$('#level1').attr('data-custom'); // "new-value"
```

## Remove Data

- removeData([name:(String|Array)])
- If no parameters, all data is removed

- Does not remove data-\*, have to use removeAttr() for that

```javascript
$('#legal-age').removeData(); // removes all data stored on the element

$('#legal-age').removeData(['foo', 'bar']);
// or
$('#legal-age').removeData('foo bar');
```

# Element Content

- Properties like textContent or innerText can be used depending on the browser

- jQuery solves those problems

## HTML or Text Content

- html()        - retrieve the HTML content of an element
- html(content) - sets the passed HTML fragment for all matched elements

```javascript
<div id="message"></div>

$('#message').html('<p>Current balance is <b>1000$</b></p>');

<div id="message"><p>Current balance is <b>1000$</b></p></div>
```

- text() - string that's the concat of all the texts in the matched set
- text(content) - html characters are replaced with their HTML entities


```javascript
<ul id="the-list">
  <li>One</li><li>Two</li><li>Three</li><li>Four</li>
</ul>

$('#the-list').text(); // OneTwoThreeFour
```

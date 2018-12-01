# Accessing Elements in DOM

- after browser loads the page, it gives a object called 'document'
- DOM methods return null if cannot find what is asked from
- Any changes made to DOM, are observable on the page

## Basic DOM Manipulation

* Accessing elements

```javascript
var link = document.querySelector('a');           // returns the first a element
var link = document.querySelector('#error');      // return element with id="error"
var link = document.querySelector('.error');      // return elements with class="error"
var links = document.querySelectorAll('a');       // return all in an array

link.textContent = 'Mozilla Developer Network';
link.href = 'https://developer.mozilla.org';
```

* Manipulating elements

```javascript
var section = document.querySelector('section');
var para = document.createElement('p');
para.textContent = 'A paragraph';
section.appendChild(para);

section.removeChild(para);

// tell a node to remove itself
para.parentNode.removeChild(para);
```

- manipulating css

```javascript
para.style.color = 'white';
para.style.backgroundColor = 'black'; // inline css

para.setAttribute('class', 'highlight'); // assuming we defined highlight class
para.getAttribute('class'); // highlight


img.getAttribute('alt');  // alt="alternative text"
```

* Create and add elements

* Remove elements

* Traverse the elements

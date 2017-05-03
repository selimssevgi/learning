# DOM - Document Object Model

- The DOM is an API
- Using the DOM when interact with web pages

- Add content to a HTML document
- Delete content from a HTML document
- Change content on a HTML document

- Document is just the web page

## Objects are Elements

- Every HTML element in the document is an object

- head-/head is an object
- body-/body is an object
- p-/p is an object

## The Model

- Elements are nodes of a tree, html is the root node
- Everything we can change in the document is a node:
  - Elements
  - Text within elements
  - HTML attributes

## Traversing the DOM

- Can reach in at any node
- Once we have that node, we can traverse the DOM to access other nodes

```javascript
let contentDivs = document.getElementsByClassName("content"); // []

let myH2 = contentDivs[1].getElementsByTagName("h2"); // []

myH2[0].innerHTML = "<p>Hello, there!</p>";
container.insertAdjacentHTML('beforeend', "<p>HELLO</p>");

let title = document.getElementById('page-title'); // single

title.textContent = "Just the text in the tag";

// changing element attributes
let link = document.getElementById('test');

link.getAttribute('href');
link.setAttribute('class', "pie");   // update
link.setAttribute('title', "hello"); // add
link.className;
link.className = "somethingelse";
link.href;

link.setAttribute('style', "position: relative;");
link.setAttribute('style', "left: 10px;"); // override all others

link.style.left = "20px"; // updating just the style necessary
link.style.top = "10px";

link.style.background-color = "blue"; // error cus of hyphen
link.style.backgroundColor = "blue";

// adding elements
let newLi = document.CreateElement("li");
let newA  = document.CreateElement("a");

let menu = document.getElementById("main-nav").getElementsByTagName("ul")[0];
menu.appendChild(newLi);
newLi.appendChild(newA);
newA.innerHTML = "Blog";

menu.insertBefore(newLi, menu.getElementsByTagName('li')[0]);

// removing element from DOM
var parent = document.getElementById('main-nav').getElementsByTagName('ul')[0];
var child = parent.getElementsByTagName('li')[0];
let removed = parent.removeChild(child);

// form <form name="myform">
let myform = document.forms.myform;

myform.username.value;

```

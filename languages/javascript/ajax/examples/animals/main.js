// https://learnwebcode.github.io/json-example/animals-1.json
//
let links = [
  "https://learnwebcode.github.io/json-example/animals-1.json",
  "https://learnwebcode.github.io/json-example/animals-2.json",
  "https://learnwebcode.github.io/json-example/animals-3.json",
];

let nextLink = 0;

let button = document.getElementById('btn');

// button.onclick(() => { });

button.addEventListener('click', () => {

  var ourRequest = new XMLHttpRequest();

  ourRequest.open('GET', links[nextLink++]);
  ourRequest.onload = function () {
    var jsonData = JSON.parse(ourRequest.responseText);
    //console.log(jsonData[0]);
    injectJsonData(jsonData);
  };

  ourRequest.onerror = function () {};

  ourRequest.send();

  if (nextLink === links.length) {
    button.remove();
  }

});

function injectJsonData(data) {
  let div = document.getElementById('animal-info');
  let details = (animal) => "<p>" + animal.name + " is a " + animal.species + "</p>";
  div.insertAdjacentHTML('beforeend', data.map((animal) => details(animal)).join(""));
}





function randInt(start, end) {
  return Math.floor(Math.random() * (end - start)) + start;
}

function randInt(upperLimit) {
  return Math.floor(Math.random() * upperLimit);
}

function makePhrases() {
  var words1 = ["24/7", "multi-tier", "30,000 foot", "B-to-B", "win-win"];
  var words2 = ["empowered", "value-added", "oriented", "focused", "aligned"];
  var words3 = ["process", "solution", "tipping-point", "strategy", "vision"];

  var rand1 = randInt(words1.length);
  var rand2 = randInt(words2.length);
  var rand3 = randInt(words3.length);

  console.log(words1[rand1] + ' ' + words2[rand2] + ' ' + words3[rand3]);
}

makePhrases();

// a closure
function makeCounter() {
  var count = 0;
  return function() {
    return count++;
  }
}

var counter = makeCounter();
var anotherCounter = makeCounter();
console.log("counter: ", counter());
console.log("another counter:", anotherCounter());

function makePassword(password) { // enclosing parameter, which is a local var
  return function(passwordGuess) {
    return (passwordGuess === password);
  }
}

var passwordChecker = makePassword("selim");
console.log(passwordChecker("afdadf"));
console.log(passwordChecker("selim"));

function multN(n) {
  return function(number) {
    return n * number;
  }
}

var mult5 = multN(5);
console.log(mult5(5));
console.log(mult5(50));

function makeCounter2() {
  var count = 0;
  return function() {
     return {increment: function() { return count++; } };
  }
}

var counter2 = makeCounter2();
console.log(counter2().increment());
console.log(counter2().increment());

function handler() {
  console.log(doneMessage);
}

function makeTimer(doneMessage, n) {
  setTimeout(handler, n);
}

makeTimer("Cookies are done!", 1000);

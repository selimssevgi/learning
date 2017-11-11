// using constructor function
//
function createNewPerson(name) {
  var obj = {};

  obj.name = name;
  obj.greeting = function() {
    console.log('Hi! I\'m' + this.name + '.');
  }

  return obj;
}

var salva = createNewPerson('Salva');
console.log(salva.name);
salva.greeting();

function Person(name) {
  this.name = name;
  this.greeting = function() {
      console.log('Hi! I\'m ' + this.name + '.');
  }
}

var p1 = new Person('Selim');
var p2 = new Person('Joe');

p1.greeting();
p2.greeting();

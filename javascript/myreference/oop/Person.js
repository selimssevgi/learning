// function constructor
//

function Person(first, last, age, gender, interests) {
  this.name = {
    first: first,
    last: last
  };
  this.age = age;
  this.gender = gender;
  this.interests = interests;
  this.bio = function() {
    var pronoun = this.gender === 'male' ? 'He' : 'She';
    console.log(
        this.name.first + ' ' +
        this.name.last + ' is ' + this.age +
        ' years old. ' + pronoun + ' likes ' + getPrintableInterests() + '.');
  };
  this.greeting = function() {
    console.log('Hi! I\'m ' + this.name.first + '.');
  }

  function getPrintableInterests() {
    var lastIndex = interests.length - 1;
    var interestsStr = interests.slice(0, lastIndex).join(',');
    return interestsStr + ' and ' + interests[lastIndex];
  }
}

Person.prototype.farewell = function() {
  console.log(this.name.first + ' has left the building. Bye for now!');
}

Person.prototype.fullName = this.name.first + ' ' + this.name.last;

var p1 = new Person('Bob', 'Smith', 32, 'male', ['music', 'skiing']);
p1.bio();

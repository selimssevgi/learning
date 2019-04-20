// without a closure
var count = 0;

window.onload = function() {
  var button = document.getElementById("clickme");
  button.onclik = handleClick;
};

function handleClick() {
  var message = "You clicked me ";
  var div = document.getElementById("message");
  count++;
  div.innerHTML = message + count + " times!";
}


// with a closure

window.onload = function() {
  var count = 0;
  var message = "You clicked me ";
  var div = document.getElementById("message");
  var button = document.getElementById("clickme");
  button.onclik = function() {
    count++;
    div.innerHTML = message + count + " times!";
  } // all three variables are free
}

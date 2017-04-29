let http = require('http'); // http is a core module, importing it
let myModule = require('./my-module');

function onRequest(request, response) {
  response.writeHead(200, {'Content-Type': 'text/plain'});
  response.write('Hello World!' + myModule.myString);
  myModule.myFunction();
  response.end();
}

http.createServer(onRequest).listen(8000);

// node server.js
// go to localhost:8000

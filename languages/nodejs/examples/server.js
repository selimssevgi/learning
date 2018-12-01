let http = require('http');

http.createServer(function (req, res) {
  res.writeHead(200, {'Content-Type': 'text/plain'});
  res.end("Hello World\n");
}).listen(3000);

console.log("Server running at locahost:3000");

// node server.js
// go to localhost:3000

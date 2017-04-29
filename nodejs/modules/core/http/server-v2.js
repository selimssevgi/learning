let http = require('http')
  , fs   = require('fs')
  , url  = require('url');

function onRequest(req, res) {
  let pathname = url.parse(req.url).pathname;
  console.log("Requested: " + pathname);

  fs.readFile(pathname.substr(1), (err, data) => {
    if (err) {
      console.log(err);
      res.writeHead(404, {'Content-Type': 'text/plain'});
    } else {
      res.writeHead(200, {'Content-Type': 'text/html'});
      res.write(data.toString());
      res.end();
    }
  });
}

http.createServer(onRequest).listen(3000);

console.log("Running at localhost:3000");

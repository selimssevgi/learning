let http = require("http");

let options = {
  host: 'localhost',
  port: '3000',
  path: 'index.html',
};

let req = http.request(options, (res) => {
  let body = '';

  res.on('data', (data) => body += data);
  res.on('end', () => console.log(body));
});

req.end();

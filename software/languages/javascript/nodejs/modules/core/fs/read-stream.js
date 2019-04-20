let fs = require("fs");

let data = '';

// create a readable stream
let readerStream = fs.createReadStream('readme.txt');

readerStream.setEncoding('utf-8');

// handle stream events: data, end, error

readerStream.on('data', (chunk) => data += chunk);

readerStream.on('end', (chunk) => console.log(data));

readerStream.on('error', (err) => console.log(err.stack));

console.log("program ended.");

let fs = require('fs');

let readerStream = fs.createReadStream('input.txt');

let writerStream = fs.createWriteStream('output.txt');

readerStream.pipe(writerStream);

console.log("program ended");

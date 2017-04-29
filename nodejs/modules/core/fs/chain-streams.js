let fs = require('fs');
let zlib = require('zlib');

fs.createReadStream('input.txt')
  .pipe(zlib.createGzip())
  .pipe(fs.createWriterStream('output.txt.gz'));

console.log('file compressed');

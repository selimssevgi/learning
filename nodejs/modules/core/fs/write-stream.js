let fs = require('fs');

let data = "some dummy text";

let writerStream = fs.createWriteStream('dummy.txt');

writerStream.write(data, "utf-8");

// mark the end of file
writerStream.end();

// handle stream errors: finish, error

writerStream.on('finish', () => console.log('write completed'));
writerStream.on('error', (err) => console.log(err.stack));

console.log('program ended');

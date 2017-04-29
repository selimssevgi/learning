let fs = require('fs');

let path = 'readme.txt';
let content = fs.readFileSync(path, 'utf8'); // blocking


let writePath = 'write.txt';
fs.writeFileSync(writePath, content);

console.log(content);

// Asynchronous: non-blocking - using callback
fs.readFile(path, 'utf8', function(err, data) {
  console.log(data);
});

console.log('This sentence logs first, and then file content')

fs.writeFile(writeFile, content);

fs.unlink('to-be-deleted.txt'); // deleting files

fs.mkdirSync('stuff');
fs.rmdirSync('stuff');
fs.mkdir('stuff');
fs.rmdir('stuff');

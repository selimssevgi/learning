let path = require('path');

// normalization: take care of .. or .
console.log(path.normalize("/test/tes1/.."))

console.log(path.join("test", "test1", "tab", ".."));

console.log(path.resolve("basic.js"));

console.log("Extension: " + path.extname("basic.js"));

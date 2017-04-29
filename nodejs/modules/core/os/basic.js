let os = require('os');

// in node repl
// os.[TAB]

console.log("OS type: " + os.type());

console.log("Platform: " + os.platform());

// console.log("tmp dir: " + os.tmpDir()); :DEPRECATED
console.log("tmp dir: " + os.tmpdir());

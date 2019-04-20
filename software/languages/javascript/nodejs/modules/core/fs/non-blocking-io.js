let fs = require("fs");

let inputPath = "readme.txt";
let content;
fs.readFile(inputPath, "UTF-8", function (err, data) {
  if (err) return console.log(err);
  content = data;
});

console.log("Reading file...");

let outputPath = "output.txt"
fs.writeFile(outputPath, content, function (err, data) {
  if (err) return console.log(err);
});

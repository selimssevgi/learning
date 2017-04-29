let fs = require("fs");

const path = "readme.txt";
let content = fs.readFileSync(path, 'UTF-8');

const outputPath = "output.txt";
fs.writeFileSync(outputPath, content);

console.log("Reading file...")

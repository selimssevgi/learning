# The Global Objects

- In Nodejs global objects are 'global' in nature
- They are available in all modules
- Global object in JS in browser is 'window'



```javascipt
__filename // resolved abs path of executed code
__dirname  // name of directory of script is being executed

let t = setTimeout(() => console.log("Hello after 5sn"), 5000);
let t = setIntervel(() => console.log("Say Hi every 2sn"), 2000);

clearTimeout(t);
clearInterval(t);
```

## console Object

- Used to print information on stdout and stderr

```javascript
let counter = 1;
console.log("Counter: %d", counter);
console.info("arg1", "arg2", "argn");
console.error("arg1", "arg2", "argn");
console.warn("arg1", "arg2", "argn");

console.time("timing");
// some process
consome.timeEnd("timing");
```

## process Object

- Used to get info on current process
- Provides multiple events related to process activities

```javascript
process.env
process.version
process.pid

// in node repl
process.[TAB]
```

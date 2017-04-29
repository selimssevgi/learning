# Buffers

- Buffer class is a global class
- Can be accessed in an application without importing the buffer module

```javascript
let buf = new Buffer(10); // 10 octets

let buf = new Buffer( [10, 20, 30, 40, 50] );

let buf = new Buffer("Hello Javascipt!", "utf-8");

//buf.write(string[, offset=0][, length][, encoding=utf8]);
buf.write("Hello World!");

buf.toString([encoding=utf8][, start=0][, end]);

let json = buf.toJSON(buf)
```

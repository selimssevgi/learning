# Testing in JS

- Mocha – the core framework: it provides common testing functions including
  describe and it and the main function that runs tests.

- Chai – the library with many assertions.

- Sinon – a library to spy over functions, emulate built-in functions and more,


```javascript
describe("pow", function() {

  it("raises to n-th power", function() {
    assert.equal(pow(2, 3), 8);
  });

});
```

- https://javascript.info/testing-mocha

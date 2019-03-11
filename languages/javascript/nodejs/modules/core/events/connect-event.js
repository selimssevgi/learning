let events = require('events');


let eventEmitter = new events.EventEmitter();

// an event handler
let connectHandler = function connected() {
  console.log("connection successful");

  eventEmitter.emit("data_received");
};

// bind the connection event with the handler
eventEmitter.on('connection', connectHandler);

// bind data_received event with anon function
eventEmitter.on('data_received', function () {
  console.log("data received successfully...");
});

// fire the connection event
eventEmitter.emit('connection');

console.log("program ended.");

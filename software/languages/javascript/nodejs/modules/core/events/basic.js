let events = require('events');

let eventEmitter = new events.EventEmitter();

// bind event and event handler
eventEmitter.on('eventName', eventHandler);

// fire an event programmatically
eventEmitter.emit('eventName');

# Streams

- Streams are objects:
  - let you read data from a source
  - or write data to a destination in continuous fashion

- There are 4 types:
  1. Writable  - allow node js to write data to a stream
  2. Readable  - allow node js to read data from a stream
  3. Duplex    - can read and write to a stream
  4. Transform - A type of duplex stream where output is computed based on input

- Each type of stream is an EventEmitter instance
- Some common events:
  - data   - when there is data available to read
  - end    - no more data to read
  - error  - an error
  - finish - all data flushed

- examples at core/fs

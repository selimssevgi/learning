# jms overview

- phone call:
  - ring and answer: synchronous communication
  - ring and voicemail: asynchronous communication

- mom: message-oriented middleware

- mom acts as a middleman between the send and receiver so that both don't have to be present simultaneously

- mom's used primarily to integrate different systems, often legacy systems
  - from front-end to mainframe

- moms evolved as a way to simplify system integration and reduce the amount of custom integration code

- messaging improves reliability by decoupling the two different actions
- the reliability stems from the fact that both systems dont have to be up and running at the same time
- also servers are not expected to function at the same processing rate

- this way also enables the possibility of another party/service/vendor to process the messages

## use case

- ecommorce uses external systems for shipment
- placed an order and waiting for shipment processing
- other systems/business can be slow, this will affect our business as well

- a mom is put between our system and external system

# Layering

- The higher layer uses various servies defined by the lower layer, but the
  lawer layer is unaware of the higher layer.

- Each layer usually hides its lower layers from the layers above.

## Benefits

- You can understand a single layer as a coherent whole without knowing much
  about the other layers.

- You can understand how to build an FTP service on top of TCP without knowing
  the details of how ethernet works.

- You can substitute layers with alternative implementations of the same basic services.

- You minimize dependencies between layers.

- Layers make good places for standardization.

- Once you have a layer built, you can use it for many higher-level services.
  Otherwise, all of these higher-levels would have to write their own lower-levels.

## Downsides

- Layers encapsulate some, but not all things well.

- You sometimes get cascading changes.

- A field for UI, must be in the db, thus must be added to every layer in between.

- Extra layers can harm performance.

- At every layer things typically need to be transformed from one representation to another

- The encapsulation of underlying function often gives you efficiency gains that
  more than compensate. A layer that controls transactions can be optimized and
  will then make everything faster.

## Three-layer System

- A presentation layer for UI

- A domain layer for domain logic

- A data source


- If all your business logic was buried in a rich client, then all your business
  logic needed to be redone to have a Web interface.

- A well designed three-layer system could just add a new presentation layer.

## Tier vs Layer

- Often the two are used as synonyms, most people see tier as implying a physical separation.

- Client-server systems are often described as two-tier systems:
  - client is a desktop
  - server is a server

- Layer can be used to stressed that you don't have to run the layers on different machines.

- A distinct layer of domain logic often runs on either a desktop or db server.
  In this situation you have two nodes but three distinct layers.

- With a local db I can run all three layers on a single laptop, but there will
  still be three distinct layers.

## Three Principal Layers

Layer        | Responsibilities
-------------|---------------------
Presentation | Provision of services, display of information, HTTP requests
Domain       | Logic that is the real point of the system
Data Source  | Communication with db, messaging systems, trx managers

- The domain and data source should never be dependent on the presentation.

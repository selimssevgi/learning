# Agents

- Agents provide async changes to any individual storage location bound to it

- An agent only lets you mutate the location by applying an action

- Actions are functions that asyncly applied to the state of Agent

- Agents also participant in STM transactions when used in atomic block

- you dont have to do a side-effect action with STM, logging to a file

- Agent is associated with data, behavior is sent to Agent in the form of func

- the behavior is defined inside the actor, data is sent to Actor in form of msg

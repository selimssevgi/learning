# Distillation

- Distillation is the process of separating the components of a mixture to
  extract the essence in a from that makes it more valuable and useful.

- A model is a distillation of knowledge.

## Core Domain

- A system that is hard to understand is hard to change.

Boil the model down. Find the CORE DOMAIN and provide a means of easily
distinguishing it from the mass of supporting model and code. Bring the most
valuable and specialized concepts into sharp relief. Make the CORE small.

- One application's CORE DOMAIN is another application's generic supporting component.

## Generic Subdomains

Identify cohesive subdomains that are not the motivation for your project.
Factor out generic models of these subdomains and place them in separate
MODULES. Leave no trace of your specialties in them.

Once they have been separated, give their continuing development lower priority
than the CORE DOMAIN, and avoid assigning your core developers to the tasks
(because they gain little domain knowledge from them). Also consider
off-the-shelf solutions or published models for these GENERIC SUBDOMAINS.

1. An off-the-shelf solution

### Advantages

- Less code to develop

- Maintenance burden externalized

- Code is probably more mature, used in multiple places, and therefore more
  bulletproof and complete than homegrown code.

### Disadvantages

- You still have to spend the time to evaluate it and understand it before using it.

- Quality control being what it is in our industry, you can't count on it being
  correct and stable.

- It may be overengineered for your purposes, integration could be more work
  than a minimalist homegrown implementation.

- Foreign elements don't usually integrate smoothly. There may be a distinct
  BOUNDED CONTEXT. Even if not, it may e diffucult to smoothly reference
  ENTITIES from your other packages.

- It may introduce platform dependencies, compiler version dependencies, and so on

# Contract Test Introduction

- Consumer: the side who uses the service
- Provider: the side who gives the service

- "Your service isn't working the way that the spec said it would" (consumer)
- "The service is working according to spec, RTFM" (provider)

- Before any testing can take place, consumer or producer, a contract must be
  available to all parties. (API documentation, Swagger)

## Benefits

- Enable services to be deployed independently
- Enables teams to work independently from each other
- Enables verification of external endpoints - am I building what is wanted?

## Not to test

- The focus of a constract test is to make sure that things work as advertised
  in terms of the agreement(API documentation).

- Do not plan to test 'service availability', 'load tolerance' or 'deployment integrity'

### Provider Perspective

- I test directly against an active endpoint, usually in Development or QA environments

- When in DEV, I might mock an internal collaborator component or service within
  the service, but the entry point of my testing will always be against an
  active METHOD/URL using HTTP.

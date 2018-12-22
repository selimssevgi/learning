# ch15 - my application is all api calls

1. Skin and Wrap the API

- we make interfaces that mirror the API as close as possible and then create
  wrappers around library classes.

- to minimize our changes of making mistakes, we can Preserve Signatures as we work

- one advantage is that we can end up having no dependencies on the underlying API code

- our wrapper can delegate to the real API in production code and we can use fakes during test

* it is good when:

- the API is relatively small
- want to completely separate deps on a third-party library
- you dont have tests, and you cant write them because you can't test through the API

2. Responsibility-based Extraction

- the API is more complicated

- you have a tool that provides a safe extract method support, you feel
  confident that you can do the extraction safely by hand.



* many teams use both techniques: a thin wrapper for testing and a higher-level
  wrapper to present a better interface to their application

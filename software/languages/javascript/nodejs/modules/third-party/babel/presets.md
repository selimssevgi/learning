# Babel Presets

- Babel 6 breaks possible transformations up into modules called 'presets'

- The goal was to make everything more modular to allow developers to decide
  which syntax should be converted

* Some presets:

- babel-preset-es2015
  - compiles ES2015, or ES6, to ES5

- babel-preset-es2016
  - compiles what is in ES2016 to ES2015

- babel-preset-es2017
  - compiles what is in ES2017 to ES2017

- babel-preset-env
  - compiles everything from ES2015, ES2016, ES2017

- babel-preset-react
  - compiles JSX to React.createElement calls


## Stages

- When a new feature is proposed for inclusion in the ECMAScript spec, it goes
  through stages of acceptance from stage 0 to stage 4.

- Babel provides presets for each of these stages, so you can choose which stage
  you want to allow in your application

- babel-preset-stage-0: Strawman
- babel-preset-stage-1: Proposal
- babel-preset-stage-2: Draft
- babel-preset-stage-3: Candidate

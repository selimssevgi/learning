# Webpack Intro

- A module bundler takes all of our different files (JS, LESS, CSS, JSX, ES6 and
  so on) and turns them into a single file

- The two main benefits of modular bundlings are 'modularity' and 'network performance'

- Modularity will allow you to break down your source code into parts, or
  modules that are easier to work with

- Network performance is gained by only needing to load one dependency in the browser, the bundle
- Each 'script' tag makes an HTTP request, and there is a latency penalty for
  each HTTP request

- Aside from transpiling, webpack also can handle:

- Code splitting

- Minification

- Feature flagging - sends code to one or more, but not all, env when testing out features

- Hot Module Replacement (HMR) - watches source code, updates modules

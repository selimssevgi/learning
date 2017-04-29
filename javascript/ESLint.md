# Coding Style

- Google JS Style Guide
- Airbnb JS Style Guide

## Style Checkers

- JSLint – one of the oldest open-source solutions.
- JSHint – the more “featured” variant of JSLint.
- ESLint – the newest breed.

## ESLint

1. Install eslint: npm i -g eslint
2. Create a config file .eslintrc in your JavaScript project


- an example .eslintrc

```shell
{
  "extends": "eslint:recommended",
  "env": {
    "browser": true,
    "es6": true
  },
  "rules": {
    "no-console": 0,
    "no-constant-condition": ["error", { "checkLoops": false }]
  },
  "indent": 2
}
```

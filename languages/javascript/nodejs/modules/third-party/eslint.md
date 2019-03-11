# ESLint

* Style Checkers
- JSLint – one of the oldest open-source solutions.
- JSHint – the more “featured” variant of JSLint.
- ESLint – the newest breed.

## ESLint

1. Install eslint

```shell
// may need sudo
npm install eslint -g
```

## Integrating with Vim

- Use Syntastic if you havent already

```shell
// in .vimrc
let g:syntastic_javascript_checkers=['eslint']
```

- Create .eslintrc in your JS project or globally ~/.eslintrc

- an example .eslintrc

```shell
{
  "extends": "eslint:recommended",
  "env": {
    "browser": true,
    "node": true,
    "es6": true
  },
  "rules": {
    "no-console": 0,
    "no-constant-condition": ["error", { "checkLoops": false }]
  },
  "indent": 2
}
```

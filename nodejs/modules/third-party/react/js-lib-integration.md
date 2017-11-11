# JS Library Integration

- Frameworks such as Angular and jQuery come with their own tools for
  - accessing data
  - rendering UI
  - modeling state
  - handling routing and more

- React is simply a library for creating views, we may need other JS libs


**NOTE:** React With JQuery
Applications perform much better if we incorporate smaller libs with React, as
opposed to large frameworks. Additionally, using jQuery to manipulate the DOM
directly by passes the virtual DOM, which can lead to strange errors

## Making Request with Fetch

- Fetch is a polyfill that allows to easily make API calls using promises

- 'isomorphic-fetch', a version of Fetch that works nicely with React

```javascript
npm install isomorphic-fetch --save
```

- Components that make API calls have to handle 'latency'
- We can address these issues in our state by including variables that tell the
  component whether a request is pending or not

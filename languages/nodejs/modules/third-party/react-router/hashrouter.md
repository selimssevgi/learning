# HashRouter

- The router will allow use to set up routes for each section of the website

- Each route is an endpoint that can be entered into the browser's location bar

- When a route is requested, we can render the appropriate content

**NOTE:** When the # is used in the location bar, the browser does not make a
server request, When using the HashRouter, the # is always required before all
routes.

- The 'HashRouter' is a nice tool to use for new projects or for small client
  sites that do not require a backend.

- The BrowserRouter is a preferred solution for most production-ready applications


```javascript
npm install react-router-dom --save
```

- Instead of App component, we render HashRouter
- HashRouter can have only one child element (div)

```javascript
ReactDOM.render(
  <HashRouter>
    <div>
      <Route exact path="/" component={Home} />
      <Route path="/about" component={About} />
      <Route path="/events" component={Events} />
      <Route path="/products" component={Products} />
      <Route path="/contact" component={Contact} />
    </div>
  </HashRouter>
  , document.getElementById('root'));

```

- localhost:3000/#/
- localhost:3000/#/about

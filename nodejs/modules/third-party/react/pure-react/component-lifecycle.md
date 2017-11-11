# Component Lifecycle

- A series of methods that can be invoked every time we mount or update a component

- These methods are invoked either before or after the component renders the UI

- The 'render' method itself is a part of the component lifecycle

- There are 2 primary lifecycles;

1. The mounting lifecycle
2. The updating lifecycle

## Mounting Lifecycle

- Consists of methods that are invoked when a component is mounted or unmounted

- set up state, make API calls, start and stop timers, manipulate the rendered
  DOM, initialize third-party libraries

- These methods allow you to incorporate JS to assist in the initalization and
  destruction of a component

- When we use 'createClass'
  - 'getDefaultProps' is invoked first to obtain the component's properties
  - 'getInitialState' is invoked next to initialize the state

- ES6 classes do not have these methods
  - default props are obtained and sent to the contructor as an argument
  - The constructor is where the state is initialized

ES6 class                 | React.createClass()
--------------------------|---------------------------
                          | getDefaultProps()
constructor(props)        | getInitialState()
componentWillMount()      | componentWillMount()
render()                  | render()
componentDidMount()       | componentDidMount()
componentWillUnmount()    | componentWillUnmount()

**NOTE:**
Technically, the constructor is not a lifecycle method. We include it because it
is used for component initialization(where the state initialized). Also, the
constructor is always the first function invoked when a component is mounted

### componentWillMount

- This method is invoked before the DOM is rendered

- Can be used to initialize third-party libraries, start animations, request
  data, or perform any additional setup that may be required before a component
  is rendered

- It is possible to invoke setState from this method to change the component
  state just before the component is initially rendered

* Using setState in componentWillMount

Calling setState before the component has rendered will not kick off the
updating lifecycle. Calling setState after the component has been rendered will
kick off the updating lifecycle. If you call setState inside an asynchronous
callback defined within componentWillMount method, it will invoked after the
component has rendered and will trigger the updating lifecycle

### componentDidMount

- is invoked just after the component has rendered

- any setState calls from this method will kick off the updating lifecycle

- is another good place to make API requests

- is also a good place to initialize any third-party JS that requires a DOM

- Another good use for this is to start background processes like intervals or timers

### componentWillUnmount

- is invoked just before the component is unmounted

- Any processes started in componentDidMount or componentWillMount can be
  cleaned up in here

- Components are unmounted when their parents remove them

- They may be unmounted with 'unmountComponentAtNode' function found in react-dom


## Updating Lifecycle

- a serios of methods that are invoked when a component's state changes or when
  new properties are received from the parent

- The updating lifecycle kicks off every time 'setState' is called
- Calling setState within the updating lifecycle will cause an infinite recursive loop

- setState can only be called in 'componentWillReceiveProps', which allows the
  component to update state when its properties are updated

* The updating lifecycle methods include:

- componentWillReceiveProps(nextProps)
  - only invoked if new properties have been passed to the component
  - the only method where setState can be called

- shouldComponentUpdate(nextProps, nextState)
  - the update lifecycle's gatekeeper
  - a predicate that can call off the update
  - can be used to improve performance by only allowing necessary updates

- componentWillUpdate(nextProps, nextState)
  - invoked just before the component updates
  - similar to componentWillMount, only it is invoked before each update occurs

- componentDidUpdate(prevProps, prevState)
  - invoked just after the update takes place, after the call to render
  - similar to componentDidMount, but is invoked after each update

*NOTE:* The updating lifecycle methods componentWillUpdate and
componentDidUpdate are great places to interact with DOM elements before or
after updates

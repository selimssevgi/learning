# Benefits of Webpack

## Modularity

Using the CommonJS module pattern in order to export modules that will later be
imported or required by another part of the application makes our src more
approachable. It allow dev teams to easily work together by allowing them to
create and work with separate files that will be statically combines into a
single file before sending to prod

## Composing

With modules, we can build small, simple, reusable React components that we can
compose efficiently into applications. Smaller components are easier to
comprehend, test, and reuse. They are also easier to replace down the line when
enhancing your applications

## Speed

Packaging all of the application's modules and deps into a single cluent bundle
will reduce the load time of your app cus there is latency associated with each
HTTP request. Packaging everything together in a single file means that the
client will only need to make a single request. Minifying the code in the bundle
will improve load time as well

## Consistency

Since webpack will transpile JSX into React and ES6 or even ES7 into universal
JS, we can start using tomorrow's JS syntax today. It allows devs to
consistently use cutting-edge JS syntax

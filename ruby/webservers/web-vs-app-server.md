http://www.justinweiss.com/articles/a-web-server-vs-an-app-server/
# Web Server
A web server is a program that takes a request to your website from a user
and does some processing on it. Then, it might give the request to your Rails app.

Nginx and Apache are the two big web servers.

If the request is for smth that doesnt change often, like CSS, JS or images,
Rails app probably doesnt need to see it. The web server can handle the request itself,
without even talking to the app. It will usually be faster that way.

Web servers can handle SSL requests, server static files and assets, compress requests,
and do lots of other tings that almost every website needs.
And if Rails app does need to handle a request, the web server will pass it on to your app server.

# App Server
An app server is the thing that actually runs the Rails app.

App server loads your code and keeps your app in memory.
When the app server gets a request from the web server, it tells Rails app about it.
After the app is done handling the request, app server sends the response bacj to the web server.

Most app servers can be run by themselves, without a web server in front of it.
Thats probably what it is done in development mode!
In production, though, there is usually a web server in front.
It will handle multiple apps at once, render assets faster, deal with a lot of processing on every request.

There are a ton of app servers for Rails apps, Unicorn, Thin, Rainbows, Puma.
Each has different advantages and different philosophies. But in the end, 
they all accomplish the same thing -- keeping the Rails app running and handling requests.

# Fitting all together
A web request will hit the web server first.
If the request is smth Rails can handle, 
the web server will do some processing on the request,
and hand it off to the app server.
The app server uses Rack to talk to Rails app.
When the app is done with the request, 
Rails app sends the response back through the app server
and the web server to the persing using the app.

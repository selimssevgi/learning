# cUrl Notes
- cURL is a tool for working with URLs.
- cURL lets us query a URL from the command line.
- It lets us post form data, FTP to a server, and much, much more.
- One of the places that cURL comes in handy most often is working with APIs.
- With cURL we can try out new APIs simply, with just the command line,
  with no need for installing, or writing complex wrappers around the API.

### Example Usage of Flags

```shell
# http request and prints its response
curl www.google.com

# print with header info
curl -i www.google.com

# print just the header info
curl -I www.google.com

# write the output to a file
curl -o example.html www.example.com

# download a file with the same name
curl -O www.example.com/example.html

# follow redirects. If a page is moved(302) follow the link
curl -L www.google.com
```

curl -X POST <url> # default is get request method. to use a different one like PATCH,PUT,DELETE

curl -X POST <url/echo?fname=Mark&lname=Bates> # sending parameters

curl -X POST -d "fname=Mark&lname=Bates" <url> # passing data in a request body

curl -X POST -d "{\"name\":\"Mark\"}" <url> # passing JSON data

curl -X POST -d @form_data.json <url> # sending larger amounts of JSON

curl -F ... # sending form parameters

curl ... -H "Accept: application/json" # sending header file asking for json

curl -X POST -u "user1:password1" <url> # basic http auth 

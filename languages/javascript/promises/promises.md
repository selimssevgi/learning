# Promises

- Promises give us a way to make sense out of async behavior

- When making an async request, one of two things can happen: success or error

```java
const getFakeMembers = count => new Promise((resolves, rejects) => {
  const api = 'randomuser.com?results=' + count
  const request = new XMLHttpRequest()
  request.open('GET', api)
  request.onlaod = () =>
    (request.status == 200) ?
      resolves(JSON.parse(request.response).results) :
      reject(Error(request.statusText))
  request.onerror = (err) => rejects(err)
  request.send()
}


// usage
getFakeMembers(5)
  .then(members => console.log(members), err => console.error(new Error("err")))
```

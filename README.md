# Java Test

### Requirement
Build a REST API that accepts a GET users request and returns a list of users that are sourced from a remote service.
Your application should retrieve **all** users from ``https://reqres.in/api/users`` and then sort the records in alphabetical order based on the value in ``first_name`` field before returning it back to the client.
Note that https://reqres.in/api/users returns a pageable result. You'll need to handle the pagination logic and to dump all users from that API, not just first page.

### Instructions and Restrictions
Complete the implementation of ``nz.co.cocca.test.javatest.Controller.listAllUsers()`` method. You can introduce any new Java library to this project as long as the requirement is met, however you need to make sure that your application can be executed by other Java developers who have Maven and JDK installed.

No unit test is required for this test.


### Sample Flow
A web client sends a GET request to localhost:8080/users
This application should handle this request (already implemented in Controller class) and make one or a few calls to ``https://reqres.in/api/users``
This application should merge all responses from ``https://reqres.in/api/users``
This application should sort the user list based on user's ``first_name``
This application should return a **JSON** list back to the client, for example (Please note that this is only a hand-crafted sample. you need to return full user list from reqres.in):
```
[
   {
      "id":3,
      "first_name":"Emma",
      "last_name":"Wong",
      "avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg"
   },
   {
      "id":4,
      "first_name":"Eve",
      "last_name":"Holt",
      "avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg"
   },
   {
      "id":1,
      "first_name":"George",
      "last_name":"Bluth",
      "avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"
   },
   {
      "id":2,
      "first_name":"Janet",
      "last_name":"Weaver",
      "avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"
   }
]
```



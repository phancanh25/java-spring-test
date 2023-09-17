# Running the application
## Prerequisites
* Java 17
* Maven
## Run and Test
* Build and run app
* Call API http://localhost:8080/item, method post to create new todo list.
* With req body : {
  "name":"Todo List 1",
  "description": "Todo list 1",
  "userId": 1
  }
* Call API http://localhost:8080/item/get-item/1 to read todo list from a specific user
## Note
* Because not using DB and just a basic project then some fields and methods on the project not best practice
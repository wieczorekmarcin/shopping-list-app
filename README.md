# Shopping List App

## Specification
### Functional requirements
* Create/Read/Update/Delete unit
* Create/Read/Update/Delete product
* Create/Read/Update/Delete category
* Create/Read/Update/Delete shoppig list
* Create/Read/Update/Delete shoppig list item
* Create Shopping List Item from Product
* Add Shopping List Items to Shopping List
* Add Shopping List to favourites
* Mark Shopping List Items as purchased
* Check status of Shopping List
* Mark Shopping List as completed
### Non-functional requirements
* The application must have separate modules: My Shopping Lists, Promotions, Recipes, Trash, Settings
* The application displays correctly on Android and iOS
* The application will comply with the User Interface Design pattern.
* The maximum response time of an application to a user's query cannot be longer than 1.5 seconds.
* In the application, mandatory fields are marked differently than optional fields.
* Application colors: white, blue, red
### Description, recipients, benefits
Shopping List App allows you to add shopping list and monitor their status. Many product categories allow you to find almost every products. By using the UI Design Pattern, the user will be able to use all the modules and functionalities ones without any problems.## Documentation
### Technology stack
- Java 8
- Spring Boot 2
- Ionic
- Maven
- H2 Database Engine + H2 console
- Swagger UI
### Database diagram
![database_diagram](/../master/src/main/resources/images/database_diagram.png?raw=true "database_diagram")
### Endpoints
![endpoints](/../master/src/main/resources/images/endpoints.png?raw=true "endpoints")

## How to run
* run `sudo mvn spring-boot:run` in root folder
* http://localhost:8080 - Shopping List App
* http://localhost:8080/api/swagger - Swagger UI
* http://localhost:8080/api/docs - Doc JSON
* http://localhost:8080/h2-console - H2 console

## App flow
![app](/../master/src/main/resources/images/app.gif?raw=true "app")

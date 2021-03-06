# Shopping List App

## Specification
### Functional requirements
* Create/Read/Update/Delete unit
* Create/Read/Update/Delete product
* Create/Read/Update/Delete category
* Create/Read/Update/Delete shopping list
* Create/Read/Update/Delete shopping list item
* Create Shopping List Item from Product
* Add Shopping List Items to Shopping List
* Add Shopping List to favourites
* Check status of Shopping List
* Mark Shopping List Items as purchased
* Mark Shopping List as completed
### Non-functional requirements
* The Application should have pages: My Shopping Lists, Promotions, Recipes, Trash, Settings,
* The Application displays Android and iOS content correctly,
* Implementation of the Application should be compliant with SOLID principles,
* Mandatory fields should be validated and marked in a different way than optional fields.
* Application colors: white, blue, red
### Description, end users, benefits of use
The application is aimed at people who have problem with remembering their purchases, and traditional methods (such as writing down on a piece of paper) are insufficient for them.
With the app, we can create new lists, manage them, monitor their status, and add products.
## Documentation
### Technology stack
- Java 8
- Spring Boot 2
- Ionic
- Maven
- JUnit 5
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

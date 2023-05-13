# RestaurantAPI
This project is a simple implementation of a Restaurant API using Spring Boot and Jakarta Persistence. The API provides basic CRUD operations for managing restaurants and their menus.

## Endpoints
The following endpoints are available:
### Restaurants
- **GET /get-all -** Retrieves all restaurants
- **GET /get-by-id/{id} -** Retrieves a restaurant by ID
- **POST /create-rest -** Creates a new restaurant
- **PUT /update-rest/{id} -** Updates an existing restaurant
- **DELETE /delete-rest/{id} -** Deletes a restaurant by ID

### Foods
- **GET /get-all-food -** Retrieves all foods
- **GET /get-food-id/{id} -** Retrieves a food by ID
- **POST /create-food -** Creates a new food
- **PUT /update-food/{id} -** Updates an existing food
- **DELETE /delete-food/{id} -** Deletes a food by ID

## Model
The project has two main entities:
### Restaurant
- id: Long
- name: String
- address: String
- menu: List<Food>

### Food
- id: Long
- name: String
- price: Double
- restaurant: Restaurant

## Technologies
The following technologies were used in this project:
- Spring Boot
- Lombok
- Maven
- java
- Mysql  


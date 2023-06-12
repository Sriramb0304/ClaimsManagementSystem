# ClaimsManagementSystem
The Claims Management System is a Spring Boot application that offers REST endpoints for performing HTTP CRUD operations (GET, PUT, POST, DELETE) on claims and associated member data.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- MySQL

## Getting Started

To get started with the Claims Management System, follow these steps:

### 1. Clone the repository:

```shell
git clone https://github.com/Sriramb0304/ClaimsManagementSystem.git
```
### 2. Set up the database:

 - Install and configure MySQL or any database on your system.
 - Create a new database for the application.
 - Update the database connection details in the application.properties file.
 
### 3. Building and Running the Application
 - Ensure that Java (JDK) and Maven are installed on your system.
 - Open the project in your preferred Java IDE.
 - Build the application using Maven.
 - Run the application.
 - The application only provides REST API endpoints to perform CRUD operations, so use an API testing application like Postman.
 - The application runs on port 8080. Visit ```http://localhost:8080/api/v1``` to access the below api endpoints. 


## Endpoints

### 1. GET /members

- Retrieves a list of all members and their claims.

### 2. GET /members/{memberid}

- Retrieves details of a specific member and their claims.

### 3. GET /members/{memberid}/claims

- Retrieves all claims associated with a specific member.

### 4. GET /members/{memberid}/claims/{claimId}

- Retrieves details of a specific claim associated with a member.

### 5. GET /claims

- Retrieves a list of all claims in the database.

### 6. POST /members

- Creates multiple members along with their claims.

### 7. POST /member

- Creates a single member along with their claims.

### 8. PUT /members/{memberId}

- Updates the details of a specific member along with their claims.

### 9. PUT /members/{memberId}/claim

- Updates the details of a specific claim associated with a member.

### 10. DELETE /members/{memberId}

- Deletes a specific member along with their claims.

### 11. DELETE /members

- Deletes all members along with their claims.

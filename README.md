<h1>Overview</h1>
The accommodation reservation system is a web application that allows users to search for and book accommodations at various locations. The system is built using the Spring Boot framework and uses an H2 database to store information about accommodations, users, and reservations. The system also includes JWT (JSON Web Token) authentication to secure user accounts and Junit for testing.
<br>
<h2>Features</h2>
<ul>
   <li>User registration and login</li>
   <li>Search for accommodations by location and availability</li>
   <li>View details and images of accommodations</li>
   <li>Book accommodations and manage reservations</li>
   <li>Secure user accounts with JWT authentication</li>
   <li>Unit and integration tests with Junit</li>
 </ul>
<h2>Requirements</h2> 
 <ul>
   <li>Java 8 or higher</li>
   <li>Maven 3.6 or higher</li>
   <li>An internet connection for dependencies and authentication</li>
 </ul>
   
<h2>Technologies</h2>
<ul>
   <li>Spring Boot</li>
   <li>H2 database</li>
   <li>JWT authentication</li>
   <li>Junit</li>
</ul>

<h2>Getting Started</h2>
<ul>
   <li>Install the required technologies (Java, Maven)</li>
   <li>Clone the repository and navigate to the project directory</li>
   <li>Run mvn clean install to build the project and install dependencies</li>
   <li>Run mvn spring-boot:run to start the application</li>
   <li>Access the application at http://localhost:8080</li>
   <li>Access the API documentation at http://localhost:8080/api/swagger-ui/</li>
</ul>

<h2>Testing</h2>
The project includes both unit and integration tests written with Junit. To run the tests, use the following command:

```
mvn test
```
<br>
This will run all of the tests in the project and generate a report of the test results.

<h2>Conclusion</h2>
The accommodation reservation system is a simple, but powerful application that allows users to easily search for and book accommodations at various locations. The use of Spring Boot, H2, JWT, and Junit allows for a robust and well-tested application that is easy to set up and use.

Spring Boot Tasks
----------
1. master
    1. Complete all the endpoints for CRUD operations on Muzix
2. h2-console
   1. Use h2-console to view in-memory data
3. @Query
     1.  Add an endpoint to search trackByName. Understand @Query and parameter passing to @Query
4. Swagger-2
    1. Generate API documentation using Swagger 2
5. exception
   1. Create custom exceptions TrackNotFoundException, TrackAlreadyExistsException in a
com.stack....exceptions package. Perform appropriate exception handling and propagation
Back.
6. start-up
      1. Running Logic on Startup in Spring. Create seed data to pre-fill the database with track
information whenever the application starts. Use both approaches:
Approach 1: ApplicationListener<ContextRefreshedEvent>
Approach 2: CommandLineRunner (Find out how it differs from ApplicationRunner)
7. Global-exception
     1. Global exception using Controller advice
8. @Value,@propertySource
     1. Remove all hard coded data from the application code to application.properties
a)by using @Value.
b)by using @PropertySource
c)by using Environment
9. @Lombok
      1.  Add @Lombok
10. muzixapp-with-mockito-testcases
     1. Mockito test cases for all the operations of controller,service and repository.
11. muzixapp-mongodb
      1. Refactor the code using MongoDB

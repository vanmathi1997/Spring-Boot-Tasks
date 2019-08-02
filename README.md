#Spring Boot Tasks
----------
Branch:1(master)
  Complete all the endpoints for CRUD operations on Muzix
Branch:2(h2-console) 
  Use h2-console to view in-memory data
Branch:3(@Query)
  Add an endpoint to search trackByName. Understand @Query and parameter passing to @Query
Branch:4(Swagger-2)
  Generate API documentation using Swagger 2
Branch:5(exception)
  Create custom exceptions TrackNotFoundException, TrackAlreadyExistsException in a
com.stack....exceptions package. Perform appropriate exception handling and propagation
Back.
Branch:6(start-up)
  Running Logic on Startup in Spring. Create seed data to pre-fill the database with track
information whenever the application starts. Use both approaches:
Approach 1: ApplicationListener<ContextRefreshedEvent>
Approach 2: CommandLineRunner (Find out how it differs from ApplicationRunner)
Branch:7(Global-exception)
    Global exception using Controller advice
Branch:8(@Value,@propertySource)
 
  Remove all hard coded data from the application code to application.properties
a)by using @Value.
b)by using @PropertySource
c)by using Environment
Branch:9(@Lombok)
  Add @Lombok
Branch:10(muzixapp-with-mockito-testcases)
  Mockito test cases for all the operations of controller,service and repository.
Branch:11(muzixapp-mongodb)
  Refactor the code using MongoDB

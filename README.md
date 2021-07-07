# Agreement Overview API
The assignment is to build a REST API with a GET endpoint to provide
  - Aggregated product details of an user (/agreement-overview/{user})

There are some input API serving via mocks **To build and run mock:** use `mvn compile exec:java`
  - Agreements of a customer (/agreements/{user})
  - Account details for a specific IBAN (/accounts/{accountId})
  - Debit card details (/debit-card/{cardId})
  - Credit card details (/credit-card/{cardId})
  - There are some errors, please check the JsonStub file

# Requirements
## Functional
  - Don't return inactive products
  - Handle error case gracefully

## Non-functional but very important
  - Please write clean and readable code
  - We suggest using Java 8 or higher, Spring-Boot & Maven ( or Gradle )
  - Your code should have tests!
  - Think about performance optimization
  - Please instruct us how to run your application
  - Would be very helpful if we get a swagger file :)

## Extra for the daring
  - (Optional) Expose the API over HTTPS
  - (Optional) Dockerize your application


## Steps to test.

- 1. Start Wiremock(8080 port)
- verify by accessing mock endpoint url e.g
- http://localhost:8080/agreements/1
- ![image](https://user-images.githubusercontent.com/73360754/124835737-13735480-df82-11eb-8f02-502c6a7e3543.png)

2. Start Spring boot application(8081)
 ![image](https://user-images.githubusercontent.com/73360754/124835847-44538980-df82-11eb-88ce-db0ebb7d0f2d.png)
 
 3. Access the agreement-overview endpoint by passing path variable ....1 represent User1, 2 represent User2...
 http://localhost:8081/agreement-overview/1
 http://localhost:8081/agreement-overview/2
 
 eg. ![image](https://user-images.githubusercontent.com/73360754/124836315-1458b600-df83-11eb-9054-110c95a73b90.png)

![image](https://user-images.githubusercontent.com/73360754/124836358-25a1c280-df83-11eb-883a-da011b621e65.png)

4. Invalid senerios. (Wrong value ) Bad request
http://localhost:8081/agreement-overview/fdfd

![image](https://user-images.githubusercontent.com/73360754/124836544-6b5e8b00-df83-11eb-90d3-154859911d26.png)

Internal Server error.
![image](https://user-images.githubusercontent.com/73360754/124836582-7dd8c480-df83-11eb-9dbc-0aba225196b2.png)

Design Pattern used - Facade

Test cases --Partialy completed
Dockerization -- Not completed.


      









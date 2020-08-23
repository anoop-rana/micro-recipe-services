## Microservices for Recipe
It contains micro-services related to recipe app
1. Eureka Service Registry
2. API Gateway Microservice
3. Ingredient Microservice
4. User Microservice
5. Recipe Microservice

#### Eureka Service Registry
    spring.application.name=recipe-eureka 
    server.port=8082 
    eureka.client.register-with-eureka=false 
    eureka.client.fetch-registry=false 

#### API Gateway Microservice
    zuul:
        prefix: /recipe
        routes:
          ingredient-service:
            path: /ingredient/**
            url: http://localhost:8084/ingredient
          recipe-service:
            path: /recipe/**
            url: http://localhost:8081/recipe
          user-service:
            path: /user/**
            url: http://localhost:8083/user
        
#### Ingredient Microservice
It manage and provide ingredient

    * href	"http://localhost:8084/ingredient"
    * href	"http://localhost:8084/ingredient/{id}"
    * href	"http://localhost:8084/ingredient/name/{name}"
    * href	"http://localhost:8084/actuator/delete/{id}"

#### User Microservice

#### Recipe Microservice

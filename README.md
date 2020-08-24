## Microservices for Recipe
It contains micro-services related to recipe app
1. Eureka Service Registry
2. API Gateway Microservice
3. Ingredient Microservice
4. Recipe Microservice
5. User Microservice 

#### Eureka Service Registry
    spring.application.name=recipe-eureka 
    server.port=9091 
    eureka.client.register-with-eureka=false 
    eureka.client.fetch-registry=false 

#### API Gateway Microservice
    zuul:
        prefix: /recipe
        routes:
          ingredient-service:
            path: /ingredient/**
            url: http://localhost:9092/ingredient
          recipe-service:
            path: /recipe/**
            url: http://localhost:9093/recipe
          user-service:
            path: /user/**
            url: http://localhost:9094/user
        
#### Ingredient Microservice
It manage and provide ingredient

    * href	"http://localhost:9092/ingredient"
    * href	"http://localhost:9092/ingredient/{id}"
    * href	"http://localhost:9092/ingredient/name/{name}"

#### Recipe Microservice
It manage and provide Item informations

    * href	"http://localhost:9093/item"
    * href	"http://localhost:9093/item/{id}"
    * href	"http://localhost:9093/item/name/{name}"
    
#### User Microservice
It manage and provide User Credential

    * href	"http://localhost:9094/user"
    * href	"http://localhost:9094/user/{id}"
    * href	"http://localhost:9094/user/name/{name}"



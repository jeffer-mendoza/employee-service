# Employee Service

## Installation
```
git clone https://github.com/jeffer-mendoza/employee-service.git employee-service
cd employee-service
mvn clean install
```

## Configuration
you must go to ***src/main/resources/application.properties***, identify the parameters and modify them according to the database to use.

Note: A cloud database has been used to facilitate the installation of the database.
```
spring.datasource.url=jdbc:mysql://remotemysql.com:3306/yPjnFbS4lu
spring.datasource.username=yPjnFbS4lu
spring.datasource.password=oSgwEdcyNh
```

## Deploy
```
mvn spring-boot:run
```
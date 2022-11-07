# Spring Boot, Spring Security, MySQL
Demo with Spring Boot, Spring Security and MySQL.
## Prepare
- Import data from [./sql/demo.sql](./sql/demo.sql) into database.
- Change default database name **demo**  in [./src/main/resources/application.properties](./src/main/resources/application.properties)
```
spring.datasource.url=jdbc:mysql://localhost:3306/demo?useUnicode=yes&characterEncoding=UTF-8
```
- Change default username / password for the database in [./src/main/resources/application.properties](./src/main/resources/application.properties)
```
spring.datasource.username=demo
spring.datasource.password=demo
```
## Compile
```
mvn clean package
```
## Run
```
java -jar ./target/demo-0.0.1-SNAPSHOT.jar
```
Open browser and navigate to: http://localhost:8080/
## Available users for Spring Security
Login with username / password : 
- **user** / **user** to have **USER** role.
- **admin** / **admin** to have **USER** and **ADMIN** role.

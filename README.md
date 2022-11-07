# Spring Boot, Spring Security, MySQL
Demo with Spring Boot, Spring Security and MySQL.
## Prepare
- Import data from [./sql/demo.sql](./sql/demo.sql) into database.
- Change default database name **demo**  in [./src/main/resources/application.properties](./src/main/resources/application.properties)
```
spring.datasource.url=jdbc:mysql://localhost:3306/demo?useUnicode=yes&characterEncoding=UTF-8
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

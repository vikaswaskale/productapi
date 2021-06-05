APP REST API
===

This API exposes for

    - Get Products
    - Get Transactions
    

Installation
---
    * you need docker to be installed
    * java and maven also needed

Scripts
---
	Start MYSQL DB in docker
		* docker-compose up
	Maven Build JAR
		* mvn clean install -DskipTests
	Maven Start Spring Boot Server
		* java -jar target/product-api-0.0.1-SNAPSHOT.jar
	

Technologies Used
---
    * Java, Spring, Hibernate, JPA, MYSQL
    * Spring Boot, REST API

Test
---
    * Unit test, 100% coverages
    * Int Test , all flows of end points
    * Reports
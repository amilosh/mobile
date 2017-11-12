# Mobile
The purpose of the project is to provide mobile communication services to users.

## Stack of technologies
1. Project: **three-layer** architecture.
2. Build automation tool: **Gradle**.
3. Frameworks: **Hibernate, Spring Boot, Spring Data JPA.**
4. Database: **MySQL**.
8. View: **Bootstrap, Thymeleaf**.
9. Misc.: **POJO, SQL**.

## Description
1. **Admin** can add and change *tariffs* and *services*; add *numbers*; and browse *users*.
2. **User** can connect to one of some tariffs. Automatically he receives a *phone number* and becomes **abonent**.
3. **Abonent** can changes tariffs and services, and top up balance. 

## Project structure
Mobile is a single-module **Gradle** project structured in the following way:
```
+---Mobile
|   +---java
|   |   +---config
|   |   +---controllers
|   |   +---model
|   |   +---repository
|   |   +---REST
|   |   +---service
|   |   +---ApplicationConfig.java
|   +---resources
|   |   +---application.properties
|   +---webapp
|   |   +---resources
|   |   +---WEB-INF
```
* **Mobile** - the parent project
* **config** - configuration files for viewResolver settings, security, i18n, l10n, error handling and other
* **controllers** - controllers of Spring MVC
* **model** - domain objects used by the other modules
* **repository** - code for database access using Spring Data JPA
* **REST** - controllers and models for ajax validation forms
* **service** - business-logic of the project
* **ApplicationConfig.java** - class for starting Spring Boot application
* **application.properties** - setting for database connecting and other
* **resources** - contains static resources (js, images)
* **WEB-INF** - contains views using Bootstrap and Thymeleaf

## Required environment
1. JDK 1.8
2. MySQL 5.7
3. (optional) Maven 3.3
4. (optional) Tomcat 8
5. (optional) Git
6. (optional) IDE (Eclipse or IntelliJ IDEA)

## Deploying project
## First way (using gradle wrapper and embedded tomcat)
### Download project
```
git clone https://github.com/amilosh/mobile.git
```
or 
```
Download ZIP
```
### Prepare MySql Database
Open **application.properties** in project:
```
{project classpath}\src\main\resources\application.properties
```
Change the **username/password** corresponding to your **root** user, configured at installation time:
```
#Hibernate
spring.datasource.url=jdbc:mysql://localhost:3306/mobile?useSSL=false&createDatabaseIfNotExist=true
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.username=root    <!-- use your installation admin user-->
spring.datasource.password=12345    <!-- use your installation admin user's password-->
```
### Run application
```
{project classpath}> gradlew bootrun
```
### Setup
For creating **roles**, **phone numbers** and setup **username/password of admin** follow this link in **browser**:
```
http://localhost:8080/mobile/setup
```
and insert username and password.
## Second way (using gradle wrapper and remote tomcat)
### Download project
```
git clone https://github.com/amilosh/mobile.git
```
or 
```
Download ZIP
```
### Prepare MySql Database
Open **application.properties** in project:
```
{project classpath}\src\main\resources\application.properties
```
Change the **username/password** corresponding to your **root** user, configured at installation time:
```
#Hibernate
spring.datasource.url=jdbc:mysql://localhost:3306/mobile?useSSL=false&createDatabaseIfNotExist=true
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.username=root    <!-- use your installation admin user-->
spring.datasource.password=12345    <!-- use your installation admin user's password-->
```
### Build project
```
{project classpath}> gradle build -x test
```
### Run Tomcat
```
{tomcat classpath}\bin> startup
```
### Deploy application
Copy **mobile.war** from
```
{project classpath}\build\libs\mobile.war
```
to
```
{tomcat classpath}\webapps
```
### Setup
For creating **roles**, **phone numbers** and setup **username/password of admin** follow this link in **browser**:
```
http://localhost:8080/mobile/setup
```
and insert username and password.
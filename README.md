# Mobile

*App for managing Tariffs and joining to mobile operator network for customers.*

## Run application
1. Download zip archive with project to your computer.
2. Unzip archive to folder "mobile-master".
3. Open file src/main/resources/application.properties.
4. Change this code according to your settings:
`spring.datasource.username=root`
`spring.datasource.password=12345`
5 Open command line.
6. Go to the folder with project: cd %path%\mobile-master\mobile-master (in command line)
#### First way
7.1. Run the command: gradlew build.
7.2. Open folder build\libs (in File Explorer Windows).
7.3. Copy file "mobile.war" and put it into folder %tomcat_home%\webapps.
#### Second way
8.1. Run the command: gradlew bootRun.
9. In browser address bar type "localhost:8080/mobile/setup".
10. Enter 'username' and 'password' to add administrator data to the database.

## Technologies
1. Project: three-layer architecture.
2. Build automation tool: Gradle.
3. Frameworks: Hibernate, Spring Boot, Spring Data JPA.
4. Database: MySQL, driver - dbcp.
5. View: Thymeleaf.
6. Misc.: POJO, HQL.

## Description
1. Admin can add and change tariffs, add numbers and browse users.
2. User can connect to one of some tariffs. Automatically he receives a phone number.
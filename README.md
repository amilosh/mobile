# Mobile

*App for managing Tariffs and joining to mobile operator network for customers.*

## Run application
#### First way
1. Download zip archive with project to your computer.
2. Unzip archive to folder "mobile-master".
3. Open command line.
4. Go to the folder with project: cd %path%\mobile-master\mobile-master (in command line)
5. Run the command: gradlew build.
6. Open folder build\libs (in File Explorer Windows).
7. Copy file "mobile.war" and put it into folder %tomcat_home%\webapps.
8. In browser address bar type "localhost:8080/mobile".
#### Second way
1. Download zip archive with project to your computer.
2. Unzip archive to folder "mobile-master".
3. Open command line.
4. Go to the folder with project: cd %path%\mobile-master\mobile-master (in command line)
5. Run the command: gradlew bootRun.
6. In browser address bar type "localhost:8080/mobile".

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
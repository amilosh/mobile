App for managing Tariffs and joining to mobile operator network for customers.

Run application:
1. Download zip archive with project to your computer.
2. Unzip archive to folder "mobile-master".
3. Open command line.
4. Go to the folder with project: cd %path%\mobile-master\mobile-master (in command line)
5. Run the command: gradlew build.
6. Open folder build\libs (in File Explorer Windows).
7. Copy file "mobile.war" and put it into folder %tomcat_home%\webapps.
8. In browser address bar type "localhost:8080/mobile".
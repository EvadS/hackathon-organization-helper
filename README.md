# hackathon-organization-helper
Development and integration of a web application client for participants and organizers of hackathons


## Run depend on environment profile

gradle wrapper

* Run with maven plugin
```bash
    ./gradlew bootRun -Plocal
```


 ./gradlew bootRun --args='--spring.profiles.active=local'


* Run as a java application
```bash
    java -jar -Dspring.profiles.active=dev ..?../admin-backend-api-1.0-SNAPSHOT.jar
```
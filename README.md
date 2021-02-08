# hackathon-organization-helper
Development and integration of a web application client for participants and organizers of hackathons

a kind of prototype of a service for publishing announcements of hackathons (the main
way on the topic of software development) and submitting applications for participation in them.

## Run depend on environment profile

 gradle wrapper
* Run with custom gradle task
```bash
    ./gradlew bootRun -Plocal
```

Gradle command line interface, how to set profile and open debug port 
```bash
 ./gradlew bootRun -Pargs=--customArgument=custom,--spring.profiles.active=local -Pdebug
```


## Gradle Command-Line Arguments

* Run as a java application
```bash
    java -jar -Dspring.profiles.active=dev ..?../admin-backend-api-1.0-SNAPSHOT.jar
```
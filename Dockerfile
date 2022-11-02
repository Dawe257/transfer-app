FROM openjdk:11
EXPOSE 5500

ADD build/libs/transferApp-0.0.1-SNAPSHOT.jar springbootapp.jar

ENTRYPOINT ["java", "-jar", "springbootapp.jar"]
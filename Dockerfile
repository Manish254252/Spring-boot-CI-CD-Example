FROM openjdk:17
EXPOSE 8080
ADD target/spring-cicd.jar spring-cicd.jar
ENTRYPOINT [ "java","-jar","spring-cicd.jar" ]

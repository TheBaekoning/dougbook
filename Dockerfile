FROM openjdk:11
EXPOSE 8080
ADD target/spring-boot-dougbook.jar spring-boot-dougbook.jar
ENTRYPOINT ["java","-jar","spring-boot-dougbook.jar"]
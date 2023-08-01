FROM amazoncorretto:17-alpine-jdk
EXPOSE 8080
ADD target/role-base-login.jar role-base-login.jar
ENTRYPOINT ["java","-jar","/role-base-login.jar"]
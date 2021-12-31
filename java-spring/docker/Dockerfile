FROM openjdk:11.0.13-jdk-oracle
ARG JAR_FILE=./*.jar
COPY ${JAR_FILE} wordTest.jar
ENTRYPOINT ["java","-jar","/wordTest.jar"]
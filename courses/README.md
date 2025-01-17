## Create project

    mvn io.quarkus.platform:quarkus-maven-plugin:3.17.7:create \
        -DprojectGroupId=de.thws \
        -DprojectArtifactId=courses

## Start with different port

    mvn quarkus:dev -Dquarkus.http.port=9090

Example service

    http://localhost:9090/courses?studentId=1

## Communiction

- HttpClient
- MicroProfile RestClient

## JPA with Panache

Create database

    create database course;
    create user course with encrypted password 'course@123';
    grant all privileges on database course to course;

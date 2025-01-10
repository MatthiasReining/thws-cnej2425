## Business Logic

Students CRUD service

## Run & Build

see README-Quarkus.md

Start:

    mvn quarkus:dev

### Build jar

    mvn package
    java -jar target\quarkus-app\quarkus-run.jar

### Build Docker.jvm

see README-Quarkus.md AND Dockerfile.jvm

    ./mvnw package
    docker build -f src/main/docker/Dockerfile.jvm -t quarkus/students-jvm .
    docker run -i --rm -p 8080:8080 quarkus/students-jvm

### Build Docker.Native

see README-Quarkus.md AND Dockerfile.native

    ./mvnw package -Dnative
    docker build -f src/main/docker/Dockerfile.native -t quarkus/students-native .
    docker run -i --rm -p 8080:8080 quarkus/students-native

### Deployment at Hetzner

- https://www.hetzner.com/de/cloud/
- CentOS
- Create Subdomin Hetzner DNS
- Install on host
  - nginx
  - let's encrypt
  - docker host
- docker pull AWS ECR (before install aws cli)
- docker compose start

### Details Public AWS ECR

Create public AWS ECR `thws/students`

    aws ecr get-login-password --region eu-central-1 | docker login --username AWS --password-stdin 908027413209.dkr.ecr.eu-central-1.amazonaws.com

    ./mvnw package
    docker build -f src/main/docker/Dockerfile.jvm -t thws/students:jvm-latest .
    docker tag thws/students:jvm-latest 908027413209.dkr.ecr.eu-central-1.amazonaws.com/thws/students:jvm-latest
    docker push 908027413209.dkr.ecr.eu-central-1.amazonaws.com/thws/students:jvm-latest

    ./mvnw package -Dnative
    docker build -f src/main/docker/Dockerfile.native -t thws/students:native-latest .
    docker tag thws/students:native-latest 908027413209.dkr.ecr.eu-central-1.amazonaws.com/thws/students:native-latest
    docker push 908027413209.dkr.ecr.eu-central-1.amazonaws.com/thws/students:native-latest

--> see src/main/docker/hetzner

Memory / CPU:

via ctop

docker run --rm -ti --name=ctop --volume /var/run/docker.sock:/var/run/docker.sock:ro quay.io/vektorlab/ctop:latest

### Deploy as AWS Lambda

https://quarkus.io/guides/aws-lambda-http

see also ../aws-lambda

## JPA

settings in `application.propertes`

- Lazy Loading and Eager Loading
- Settings via ENV variables
- DTOs / Entity Beans
- NamedQuery
- OneToMany (Cascade ,...)

- new Service with Panache

Testing: curl -H "Content-Type: application/json" -d '{"firstname": "Mini 234",
"lastname": "Mouse", "immatriculationNumber": "123456", "birthdate": "2000-11-18"}' http://localhost:8080/students

## Patterns

- BCE package structure

## Frontend

- lit
- Bootstrap
- Vanilla JS (fetch)

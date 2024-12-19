## Project Setup

### Git clone

    git clone git@github.com:MatthiasReining/thws-cnej2425.git

### Preconditions

    mvn: 3.9.6
    java: Java HotSpot(TM) 64-Bit Server VM Oracle GraalVM 21.0.2+13.1 (build 21.0.2+13-LTS-jvmci-23.1-b30, mixed mode, sharing)

**Project init**

Initial setup via mvn archetype

    mvn org.apache.maven.plugins:maven-archetype-plugin:3.1.2:generate -DarchetypeArtifactId="jakartaee10-minimal" -DarchetypeGroupId="org.eclipse.starter" -DarchetypeVersion="1.1.0" -DgroupId="de.thws.appserver" -DartifactId="demo"

## Deploy

### via CLI

mvn clean package -DskipTests && copy target\demo.war ..\srv\wildfly-34.0.1.Final\standalone\deployments\.

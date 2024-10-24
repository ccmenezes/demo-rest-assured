# A docker image from docker hub with java sdk and maven, responsible to handle the project dependencies
FROM maven:3.9.9-eclipse-temurin-21-alpine

# Set the work directory where the source code is available, also the project management, in this case maven
WORKDIR /sample-rest-assured

# Copy the source code from the main root to the containter main root
COPY . .

# Mvn command to run the tests
ENTRYPOINT mvn clean test

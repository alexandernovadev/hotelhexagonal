# Use an official maven image as a parent image
FROM maven:3.8.1-openjdk-17-slim AS build

# Set the working directory in the image to /app
WORKDIR /app

# Copy the pom.xml file to our app directory
COPY pom.xml .

# Download all required dependencies into one layer
RUN mvn dependency:go-offline -B

# Copy the rest of the code
COPY src ./src

# Package the application
RUN mvn package -DskipTests

# Use an official openjdk runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the image to /app
WORKDIR /app

# Copy the jar file from the build image
COPY --from=build /app/target/*.jar ./app.jar

# Set the startup command to run your binary
CMD ["java", "-jar", "/app/app.jar"]
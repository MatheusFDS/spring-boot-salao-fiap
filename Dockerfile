# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged JAR file into the container at /app
COPY target/your-project-name.jar /app/your-project-name.jar

# Specify the command to run your application
CMD ["java", "-jar", "your-project-name.jar"]

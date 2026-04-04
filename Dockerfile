# Stage 1: Build the application using Maven
FROM maven:3.9.9-eclipse-temurin-17-focal AS build

# Set working directory inside the container
WORKDIR /app

# Copy all files from your project into the container
COPY . .

# Build the JAR file (skip tests to make it faster)
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:17-jdk-alpine3.12

# Allow Render to assign a port
ARG PORT=8080
ENV PORT=${PORT}

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar /app/app.jar

# Tell the container which port to use
EXPOSE 8080

# Run the application
CMD ["sh", "-c", "java -jar /app/app.jar --server.port=${PORT}"]
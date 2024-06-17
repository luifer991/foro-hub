# Use the official Maven/Java 17 image as the base image
FROM maven:3.8.6-amazoncorretto-17

# Set the working directory
WORKDIR /foro-hub

# Copy the pom.xml file
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src ./src

# Build the application
RUN mvn package

# Use the official OpenJDK 17 image as the base image for the final stage
FROM amazoncorretto:17

# Set the working directory
WORKDIR /app

# Copy the built artifact from the previous stage
COPY --from=0 /foro-hub/target/*.jar app.jar

# Expose the port your application listens on
EXPOSE 8080

# Set environment variables
ENV DB_USERNAME=$DB_USERNAME
ENV DB_PASSWORD=$DB_PASSWORD
ENV DB_NAME=$DB_NAME
ENV JWT_SECRET=$JWT_SECRET

# Run the application
CMD ["java", "-jar", "app.jar"]

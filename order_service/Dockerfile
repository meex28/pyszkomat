FROM gradle:8.8-jdk21 AS builder

WORKDIR /app

COPY ../order_service ./order_service

COPY  ../settings.gradle.kts ./
COPY  ../build.gradle.kts ./

COPY ../gradle ./gradle

RUN gradle order_service:bootJar

FROM eclipse-temurin:21-jre-alpine

# Add a non-root user
RUN addgroup -S spring && adduser -S spring -G spring

# Set working directory
WORKDIR /app

# Copy the jar file from the builder stage
COPY --from=builder /app/order_service/build/libs/*.jar app.jar

# Change ownership to non-root user
RUN chown -R spring:spring /app

# Switch to non-root user
USER spring

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

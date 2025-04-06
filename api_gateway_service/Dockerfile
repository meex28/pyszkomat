FROM gradle:8.8-jdk21 AS builder

WORKDIR /app

COPY ../api_gateway_service ./api_gateway_service

COPY  ../settings.gradle.kts ./
COPY  ../build.gradle.kts ./

COPY ../gradle ./gradle

RUN gradle api_gateway_service:bootJar

FROM eclipse-temurin:21-jre-alpine

RUN addgroup -S spring && adduser -S spring -G spring

WORKDIR /app

COPY --from=builder /app/api_gateway_service/build/libs/*.jar app.jar

RUN chown -R spring:spring /app

USER spring

ENTRYPOINT ["java", "-jar", "app.jar"]

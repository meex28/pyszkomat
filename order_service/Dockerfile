FROM gradle:8.8-jdk21 AS builder

WORKDIR /app

COPY ../order_service ./order_service

COPY  ../settings.gradle.kts ./
COPY  ../build.gradle.kts ./

COPY ../gradle ./gradle

RUN gradle order_service:bootJar

FROM eclipse-temurin:21-jre-alpine

RUN addgroup -S spring && adduser -S spring -G spring

WORKDIR /app

COPY --from=builder /app/order_service/build/libs/*.jar app.jar

RUN chown -R spring:spring /app

USER spring

ENTRYPOINT ["java", "-jar", "app.jar"]

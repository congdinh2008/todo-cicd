# Sử dụng Maven image để build ứng dụng
FROM maven:3.9.5-eclipse-temurin-17 AS build

# Thiết lập thư mục làm việc
WORKDIR /app

# Copy pom.xml và download dependencies trước (tận dụng Docker layer caching)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code và build ứng dụng
COPY src ./src
RUN mvn clean package -DskipTests

# Sử dụng JRE image nhẹ hơn để chạy ứng dụng
FROM eclipse-temurin:17-jre-alpine

# Thiết lập thư mục làm việc
WORKDIR /app

# Copy file jar từ build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port mà ứng dụng sẽ chạy
EXPOSE 8080

# Environment variables mặc định (có thể override khi chạy container)
ENV DB_HOST=postgres
ENV DB_PORT=5432
ENV DB_NAME=tododb
ENV DB_USERNAME=postgres
ENV DB_PASSWORD=postgres

# Command để chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]

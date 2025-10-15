---
name: "Bước 1: Thiết lập Backend Spring Boot"
about: Hướng dẫn thiết lập dự án Spring Boot với Maven
title: "[Backend] Thiết lập Spring Boot"
labels: backend, setup, step-1
assignees: ''
---

## 🎯 Mục tiêu
Tạo dự án Spring Boot cơ bản với Maven và cấu hình kết nối PostgreSQL.

## 📋 Các công việc cần làm

### 1. Tạo cấu trúc project
- [ ] Tạo thư mục `backend/`
- [ ] Tạo cấu trúc package: `com.todoapp`
- [ ] Tạo các package con: controller, service, repository, model, config, exception

### 2. Tạo file pom.xml
- [ ] Thêm Spring Boot parent
- [ ] Thêm dependencies:
  - spring-boot-starter-web (REST API)
  - spring-boot-starter-data-jpa (Database)
  - postgresql (PostgreSQL driver)
  - spring-boot-starter-validation (Validation)
  - lombok (Giảm boilerplate)
  - spring-boot-starter-test (Testing)

### 3. Tạo class TodoBackendApplication
- [ ] Tạo main class với `@SpringBootApplication`
- [ ] Thêm method `main()` để chạy ứng dụng

### 4. Tạo file application.properties
- [ ] Cấu hình server port: 8080
- [ ] Cấu hình database connection:
  - URL: jdbc:postgresql://localhost:5432/tododb
  - Username: postgres
  - Password: postgres
- [ ] Cấu hình JPA/Hibernate:
  - ddl-auto: update
  - show-sql: true
  - dialect: PostgreSQL

### 5. Thêm comments tiếng Việt
- [ ] Comment giải thích từng annotation
- [ ] Comment giải thích từng configuration

## 📚 Kiến thức cần có
- Java cơ bản
- Maven
- Spring Boot basics
- PostgreSQL

## 🔗 Tài liệu tham khảo
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Maven Documentation](https://maven.apache.org/guides/)
- [PostgreSQL JDBC Driver](https://jdbc.postgresql.org/documentation/)

## ✅ Tiêu chí hoàn thành
- [ ] Project có thể build thành công với `mvn clean package`
- [ ] Application có thể start thành công
- [ ] Có thể kết nối đến PostgreSQL database
- [ ] Tất cả code có comments tiếng Việt đầy đủ

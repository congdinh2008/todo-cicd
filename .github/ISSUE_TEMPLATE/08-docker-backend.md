---
name: "Bước 8: Dockerize Backend"
about: Hướng dẫn tạo Docker image cho Spring Boot backend
title: "[Docker] Dockerize Backend"
labels: docker, backend, step-8
assignees: ''
---

## 🎯 Mục tiêu
Tạo Dockerfile để containerize Spring Boot backend application.

## 📋 Các công việc cần làm

### 1. Tạo Dockerfile (backend/Dockerfile)
- [ ] Stage 1: Build stage
  - Base image: maven:3.9.5-eclipse-temurin-17
  - Set WORKDIR: /app
  - Copy pom.xml và download dependencies
  - Copy source code
  - Build application: mvn clean package -DskipTests
- [ ] Stage 2: Runtime stage
  - Base image: eclipse-temurin:17-jre-alpine (nhẹ hơn)
  - Set WORKDIR: /app
  - Copy JAR file từ build stage
  - Expose port 8080
  - Set environment variables:
    - DB_HOST=postgres
    - DB_PORT=5432
    - DB_NAME=tododb
    - DB_USERNAME=postgres
    - DB_PASSWORD=postgres
  - ENTRYPOINT: java -jar app.jar

### 2. Tạo .dockerignore (backend/.dockerignore)
- [ ] Ignore các files không cần thiết:
  - target/
  - .git/
  - .idea/
  - *.iml
  - .DS_Store

### 3. Thêm comments trong Dockerfile
- [ ] Comment giải thích multi-stage build
- [ ] Comment giải thích từng stage
- [ ] Comment giải thích tại sao dùng alpine
- [ ] Comment giải thích environment variables

## 📚 Kiến thức cần có
- Docker basics
- Dockerfile syntax
- Multi-stage builds
- Docker layer caching
- Environment variables

## 🔗 Tài liệu tham khảo
- [Docker Documentation](https://docs.docker.com/)
- [Dockerfile Best Practices](https://docs.docker.com/develop/develop-images/dockerfile_best-practices/)
- [Multi-stage Builds](https://docs.docker.com/build/building/multi-stage/)

## 🧪 Testing

### Build image
```bash
cd backend
docker build -t todo-backend:latest .
```

### Run container (standalone)
```bash
docker run -d \
  --name todo-backend \
  -p 8080:8080 \
  -e DB_HOST=host.docker.internal \
  -e DB_PORT=5432 \
  -e DB_NAME=tododb \
  -e DB_USERNAME=postgres \
  -e DB_PASSWORD=postgres \
  todo-backend:latest
```

### Check logs
```bash
docker logs -f todo-backend
```

### Test API
```bash
curl http://localhost:8080/api/todos
```

## ✅ Tiêu chí hoàn thành
- [ ] Dockerfile build thành công
- [ ] Image size được optimize (sử dụng alpine)
- [ ] Container có thể chạy và kết nối database
- [ ] API endpoints hoạt động đúng
- [ ] Environment variables có thể override được
- [ ] Dockerfile có comments tiếng Việt đầy đủ

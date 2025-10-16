---
name: "Bước 10: Docker Compose"
about: Hướng dẫn tạo docker-compose.yml để chạy toàn bộ stack
title: "[Docker] Setup Docker Compose"
labels: docker, docker-compose, step-10
assignees: ''
---

## 🎯 Mục tiêu
Tạo docker-compose.yml để orchestrate tất cả services: PostgreSQL, Backend, Frontend.

## 📋 Các công việc cần làm

### 1. Tạo docker-compose.yml (root directory)
- [ ] Version: 3.8
- [ ] Define 3 services:

#### Service 1: PostgreSQL
- [ ] Image: postgres:16-alpine
- [ ] Container name: todo-postgres
- [ ] Restart policy: unless-stopped
- [ ] Environment variables:
  - POSTGRES_DB: tododb
  - POSTGRES_USER: postgres
  - POSTGRES_PASSWORD: postgres
- [ ] Ports: 5432:5432
- [ ] Volume: postgres_data:/var/lib/postgresql/data
- [ ] Healthcheck: pg_isready

#### Service 2: Backend
- [ ] Build context: ./backend
- [ ] Container name: todo-backend
- [ ] Restart policy: unless-stopped
- [ ] Environment variables:
  - DB_HOST: postgres
  - DB_PORT: 5432
  - DB_NAME: tododb
  - DB_USERNAME: postgres
  - DB_PASSWORD: postgres
- [ ] Ports: 8080:8080
- [ ] Depends on: postgres (với condition: service_healthy)
- [ ] Healthcheck: wget http://localhost:8080/api/todos

#### Service 3: Frontend
- [ ] Build context: ./frontend
- [ ] Container name: todo-frontend
- [ ] Restart policy: unless-stopped
- [ ] Ports: 3000:80
- [ ] Depends on: backend

### 2. Define volumes
- [ ] postgres_data: driver local

### 3. Define network
- [ ] todo-network: driver bridge

### 4. Thêm comments chi tiết
- [ ] Comment giải thích từng service
- [ ] Comment giải thích healthchecks
- [ ] Comment giải thích depends_on
- [ ] Comment giải thích volumes và networks
- [ ] Comment giải thích environment variables

## 📚 Kiến thức cần có
- Docker Compose basics
- Service orchestration
- Container networking
- Volume management
- Health checks
- Service dependencies

## 🔗 Tài liệu tham khảo
- [Docker Compose Documentation](https://docs.docker.com/compose/)
- [Compose File Reference](https://docs.docker.com/compose/compose-file/)
- [Compose Healthcheck](https://docs.docker.com/compose/compose-file/compose-file-v3/#healthcheck)

## 🧪 Testing

### Start all services
```bash
docker-compose up -d
```

### Check services status
```bash
docker-compose ps
```

### View logs
```bash
docker-compose logs -f

# Hoặc logs của service cụ thể
docker-compose logs -f backend
```

### Stop services
```bash
docker-compose down
```

### Stop và xóa volumes
```bash
docker-compose down -v
```

### Rebuild và restart
```bash
docker-compose up -d --build
```

## 🧪 Integration Testing
- [ ] Tất cả services start thành công
- [ ] PostgreSQL healthy
- [ ] Backend connect được database
- [ ] Backend API hoạt động
- [ ] Frontend accessible
- [ ] Frontend gọi được Backend API
- [ ] Tạo, sửa, xóa todos hoạt động end-to-end

## ✅ Tiêu chí hoàn thành
- [ ] docker-compose.yml syntax đúng
- [ ] Tất cả services start thành công
- [ ] Services có thể communicate với nhau
- [ ] Healthchecks hoạt động
- [ ] Data persist khi restart (PostgreSQL volume)
- [ ] End-to-end flow hoạt động
- [ ] File có comments tiếng Việt đầy đủ

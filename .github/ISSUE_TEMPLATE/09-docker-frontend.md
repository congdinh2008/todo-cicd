---
name: "Bước 9: Dockerize Frontend"
about: Hướng dẫn tạo Docker image cho React frontend
title: "[Docker] Dockerize Frontend"
labels: docker, frontend, step-9
assignees: ''
---

## 🎯 Mục tiêu
Tạo Dockerfile để containerize React frontend application và serve với Nginx.

## 📋 Các công việc cần làm

### 1. Tạo Dockerfile (frontend/Dockerfile)
- [ ] Stage 1: Build stage
  - Base image: node:20-alpine
  - Set WORKDIR: /app
  - Copy package.json và package-lock.json
  - Install dependencies: npm ci
  - Copy source code
  - Build application: npm run build
- [ ] Stage 2: Production stage
  - Base image: nginx:alpine
  - Copy built files từ build stage vào /usr/share/nginx/html
  - Expose port 80
  - CMD: nginx -g "daemon off;"

### 2. Tạo Nginx config (optional: frontend/nginx.conf)
- [ ] Cấu hình server block:
  - Listen port 80
  - Root: /usr/share/nginx/html
  - Index: index.html
  - Try_files với fallback cho SPA routing

### 3. Tạo .dockerignore (frontend/.dockerignore)
- [ ] Ignore files không cần thiết:
  - node_modules/
  - dist/
  - .git/
  - .DS_Store
  - *.log

### 4. Thêm comments trong Dockerfile
- [ ] Comment giải thích multi-stage build
- [ ] Comment giải thích build stage với Node
- [ ] Comment giải thích production stage với Nginx
- [ ] Comment giải thích tại sao dùng alpine

## 📚 Kiến thức cần có
- Docker basics
- Dockerfile multi-stage builds
- Nginx basics
- Static file serving
- SPA (Single Page Application) routing

## 🔗 Tài liệu tham khảo
- [Nginx Docker Image](https://hub.docker.com/_/nginx)
- [Dockerizing React App](https://mherman.org/blog/dockerizing-a-react-app/)
- [Nginx Configuration](https://nginx.org/en/docs/beginners_guide.html)

## 🧪 Testing

### Build image
```bash
cd frontend
docker build -t todo-frontend:latest .
```

### Run container
```bash
docker run -d \
  --name todo-frontend \
  -p 3000:80 \
  todo-frontend:latest
```

### Check logs
```bash
docker logs -f todo-frontend
```

### Test trong browser
- Truy cập http://localhost:3000
- Kiểm tra UI render đúng
- Kiểm tra routing hoạt động

## ✅ Tiêu chí hoàn thành
- [ ] Dockerfile build thành công
- [ ] Image size được optimize
- [ ] Container chạy thành công
- [ ] Frontend accessible qua browser
- [ ] Static files được serve đúng
- [ ] SPA routing hoạt động (nếu có nginx config)
- [ ] Dockerfile có comments tiếng Việt đầy đủ

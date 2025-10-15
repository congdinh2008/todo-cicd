# Quick Start Guide - Todo App

Hướng dẫn nhanh để chạy ứng dụng Todo App với Docker Compose.

## 🚀 Chạy ứng dụng (Khuyến nghị)

### Yêu cầu
- Docker Desktop đã cài đặt và đang chạy
- Git

### Các bước thực hiện

1. **Clone repository**
```bash
git clone https://github.com/congdinh2008/todo-cicd.git
cd todo-cicd
```

2. **Chạy với Docker Compose**
```bash
docker-compose up -d
```

Lệnh này sẽ:
- Tải và khởi động PostgreSQL container
- Build và chạy Backend Spring Boot container
- Build và chạy Frontend React container

3. **Kiểm tra trạng thái**
```bash
docker-compose ps
```

Bạn sẽ thấy 3 containers đang chạy:
- `todo-postgres` - PostgreSQL database
- `todo-backend` - Spring Boot API
- `todo-frontend` - React UI

4. **Truy cập ứng dụng**
- **Frontend**: http://localhost:3000
- **Backend API**: http://localhost:8080/api/todos
- **PostgreSQL**: localhost:5432

5. **Xem logs**
```bash
# Xem logs của tất cả services
docker-compose logs -f

# Xem logs của một service cụ thể
docker-compose logs -f backend
docker-compose logs -f frontend
docker-compose logs -f postgres
```

6. **Dừng ứng dụng**
```bash
# Dừng containers
docker-compose down

# Dừng và xóa volumes (xóa data)
docker-compose down -v
```

## 🛠️ Development Mode

Nếu bạn muốn chạy từng service riêng lẻ để development:

### 1. Chạy PostgreSQL
```bash
docker run -d \
  --name postgres \
  -e POSTGRES_DB=tododb \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -p 5432:5432 \
  postgres:16-alpine
```

### 2. Chạy Backend
```bash
cd backend
mvn spring-boot:run
```

Backend sẽ chạy tại: http://localhost:8080

### 3. Chạy Frontend
```bash
cd frontend
npm install
npm run dev
```

Frontend sẽ chạy tại: http://localhost:3000

## 🧪 Test API với curl

### Lấy tất cả todos
```bash
curl http://localhost:8080/api/todos
```

### Tạo todo mới
```bash
curl -X POST http://localhost:8080/api/todos \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Học Docker",
    "description": "Tìm hiểu về Docker và containerization"
  }'
```

### Cập nhật todo
```bash
curl -X PUT http://localhost:8080/api/todos/1 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Học Docker - Updated",
    "description": "Đã hoàn thành",
    "completed": true
  }'
```

### Xóa todo
```bash
curl -X DELETE http://localhost:8080/api/todos/1
```

### Lấy thống kê
```bash
curl http://localhost:8080/api/todos/stats
```

## 🐛 Troubleshooting

### Port đã được sử dụng
Nếu bạn gặp lỗi "port already in use", có thể thay đổi port trong `docker-compose.yml`:

```yaml
services:
  frontend:
    ports:
      - "3001:80"  # Thay vì 3000:80
  
  backend:
    ports:
      - "8081:8080"  # Thay vì 8080:8080
```

### Container không start
```bash
# Kiểm tra logs
docker-compose logs

# Rebuild images
docker-compose up -d --build

# Xóa tất cả và start lại
docker-compose down -v
docker-compose up -d --build
```

### Backend không kết nối được database
Đợi vài giây để PostgreSQL khởi động hoàn toàn. Backend có healthcheck và sẽ tự động retry.

### Frontend không gọi được API
Kiểm tra backend đã chạy chưa:
```bash
curl http://localhost:8080/api/todos
```

## 📖 Tài liệu đầy đủ

Xem [README.md](README.md) để có hướng dẫn chi tiết về:
- Kiến trúc ứng dụng
- API endpoints
- Development guide
- CI/CD setup

Xem [TEACHING_GUIDE.md](TEACHING_GUIDE.md) để có:
- Lộ trình học chi tiết
- Kế hoạch bài giảng
- Issue templates cho từng bước

## 🎯 Next Steps

1. Thử thêm, sửa, xóa todos trên UI
2. Xem code trong các thư mục `backend/` và `frontend/`
3. Follow các issue templates để học từng phần
4. Customize và mở rộng ứng dụng

## 💡 Tips

- Sử dụng `docker-compose logs -f` để debug
- Sử dụng Postman hoặc Insomnia để test API
- Mở Browser DevTools để xem network requests
- Check PostgreSQL data với pgAdmin hoặc psql

---

**Chúc bạn code vui vẻ! 🎉**

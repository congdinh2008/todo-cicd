# Todo App với CI/CD

Ứng dụng quản lý công việc (Todo App) được xây dựng với kiến trúc Full Stack hiện đại, tích hợp Docker và GitHub Actions CI/CD.

## 🏗️ Kiến trúc

- **Frontend**: ReactJS với Vite
- **Backend**: Spring Boot 3.2.0 với Java 17
- **Database**: PostgreSQL 16
- **Container**: Docker & Docker Compose
- **CI/CD**: GitHub Actions

## 📋 Tính năng

### Backend (Spring Boot)
- ✅ RESTful API với đầy đủ CRUD operations
- ✅ Tích hợp Spring Data JPA với PostgreSQL
- ✅ Validation dữ liệu đầu vào
- ✅ Exception handling tập trung
- ✅ CORS configuration cho Frontend
- ✅ Tìm kiếm và filter todos
- ✅ Thống kê todos
- ✅ Comments tiếng Việt chi tiết

### Frontend (React)
- ✅ Giao diện hiện đại, responsive
- ✅ Quản lý state với React Hooks
- ✅ Tích hợp Axios để gọi API
- ✅ Thêm, sửa, xóa todos
- ✅ Đánh dấu hoàn thành/chưa hoàn thành
- ✅ Tìm kiếm và filter theo trạng thái
- ✅ Hiển thị thống kê
- ✅ Comments tiếng Việt chi tiết

## 🚀 Cách chạy dự án

### Yêu cầu
- Docker & Docker Compose
- (Hoặc) Java 17 + Maven + Node.js 20 + PostgreSQL

### Chạy với Docker Compose (Khuyến nghị)

```bash
# Clone repository
git clone https://github.com/congdinh2008/todo-cicd.git
cd todo-cicd

# Chạy tất cả services với Docker Compose
docker-compose up -d

# Kiểm tra logs
docker-compose logs -f
```

Sau khi chạy thành công:
- Frontend: http://localhost:3000
- Backend API: http://localhost:8080/api/todos
- PostgreSQL: localhost:5432

### Chạy từng service riêng lẻ

#### 1. Database (PostgreSQL)

```bash
docker run -d \
  --name postgres \
  -e POSTGRES_DB=tododb \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -p 5432:5432 \
  postgres:16-alpine
```

#### 2. Backend (Spring Boot)

```bash
cd backend

# Build với Maven
mvn clean package

# Chạy ứng dụng
java -jar target/todo-backend-1.0.0.jar

# Hoặc với Maven
mvn spring-boot:run
```

Hoặc với Docker:

```bash
cd backend
docker build -t todo-backend .
docker run -d \
  --name todo-backend \
  -p 8080:8080 \
  -e DB_HOST=host.docker.internal \
  -e DB_PORT=5432 \
  -e DB_NAME=tododb \
  -e DB_USERNAME=postgres \
  -e DB_PASSWORD=postgres \
  todo-backend
```

#### 3. Frontend (React)

```bash
cd frontend

# Install dependencies
npm install

# Development mode
npm run dev

# Build cho production
npm run build
```

Hoặc với Docker:

```bash
cd frontend
docker build -t todo-frontend .
docker run -d \
  --name todo-frontend \
  -p 3000:80 \
  todo-frontend
```

## 📡 API Endpoints

### Todos

| Method | Endpoint | Mô tả |
|--------|----------|-------|
| GET | `/api/todos` | Lấy tất cả todos |
| GET | `/api/todos?completed=true` | Lấy todos đã hoàn thành |
| GET | `/api/todos?search=keyword` | Tìm kiếm todos |
| GET | `/api/todos/{id}` | Lấy todo theo ID |
| POST | `/api/todos` | Tạo todo mới |
| PUT | `/api/todos/{id}` | Cập nhật todo |
| DELETE | `/api/todos/{id}` | Xóa todo |
| PATCH | `/api/todos/{id}/complete` | Đánh dấu hoàn thành |
| PATCH | `/api/todos/{id}/incomplete` | Đánh dấu chưa hoàn thành |
| GET | `/api/todos/stats` | Lấy thống kê |

### Ví dụ Request

#### Tạo todo mới

```bash
curl -X POST http://localhost:8080/api/todos \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Học Docker",
    "description": "Tìm hiểu về Docker và Docker Compose"
  }'
```

#### Cập nhật todo

```bash
curl -X PUT http://localhost:8080/api/todos/1 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Học Docker (Updated)",
    "description": "Đã hoàn thành khóa học Docker",
    "completed": true
  }'
```

## 🔄 CI/CD với GitHub Actions

### CI Workflow (`.github/workflows/ci.yml`)

Tự động chạy khi có push hoặc pull request:
1. Test Backend với Maven
2. Build Frontend với npm
3. Build Docker images
4. Validate docker-compose configuration

### CD Workflow (`.github/workflows/cd.yml`)

Tự động deploy khi:
- Push tag (ví dụ: `v1.0.0`)
- Manual trigger từ GitHub Actions UI

## 📁 Cấu trúc thư mục

```
todo-cicd/
├── backend/                    # Spring Boot Backend
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/todoapp/
│   │   │   │   ├── controller/     # REST Controllers
│   │   │   │   ├── service/        # Business Logic
│   │   │   │   ├── repository/     # Data Access Layer
│   │   │   │   ├── model/          # Entity Models
│   │   │   │   ├── exception/      # Exception Handling
│   │   │   │   └── config/         # Configurations
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/                   # Tests
│   ├── pom.xml                     # Maven dependencies
│   ├── Dockerfile                  # Backend Docker image
│   └── .gitignore
│
├── frontend/                   # React Frontend
│   ├── src/
│   │   ├── components/         # React Components
│   │   │   ├── TodoForm.jsx
│   │   │   ├── TodoList.jsx
│   │   │   ├── TodoItem.jsx
│   │   │   └── TodoStats.jsx
│   │   ├── services/           # API Services
│   │   │   └── todoService.js
│   │   ├── App.jsx             # Main App Component
│   │   ├── App.css             # App styles
│   │   ├── main.jsx            # Entry point
│   │   └── index.css           # Global styles
│   ├── public/                 # Static assets
│   ├── index.html              # HTML template
│   ├── package.json            # npm dependencies
│   ├── vite.config.js          # Vite configuration
│   ├── Dockerfile              # Frontend Docker image
│   └── .gitignore
│
├── .github/
│   └── workflows/
│       ├── ci.yml              # CI Workflow
│       └── cd.yml              # CD Workflow
│
├── docker-compose.yml          # Docker Compose configuration
└── README.md                   # Documentation
```

## 🧪 Testing

### Backend Tests

```bash
cd backend
mvn test
```

### Frontend Tests (nếu có)

```bash
cd frontend
npm test
```

## 🛠️ Development

### Backend Development

1. Chạy PostgreSQL với Docker
2. Chạy backend trong development mode với Maven
3. API sẽ chạy tại http://localhost:8080

### Frontend Development

1. Đảm bảo backend đang chạy
2. Chạy frontend dev server với `npm run dev`
3. Frontend sẽ chạy tại http://localhost:3000
4. Hot reload tự động khi có thay đổi

## 📝 Environment Variables

### Backend

| Variable | Default | Mô tả |
|----------|---------|-------|
| DB_HOST | localhost | PostgreSQL host |
| DB_PORT | 5432 | PostgreSQL port |
| DB_NAME | tododb | Database name |
| DB_USERNAME | postgres | Database username |
| DB_PASSWORD | postgres | Database password |

### Frontend

| Variable | Default | Mô tả |
|----------|---------|-------|
| VITE_API_URL | http://localhost:8080/api | Backend API URL |

## 🎯 Roadmap

- [ ] Thêm authentication (JWT)
- [ ] Thêm phân quyền user
- [ ] Thêm categories/tags cho todos
- [ ] Thêm due date và reminders
- [ ] Thêm file attachments
- [ ] Tích hợp notification
- [ ] Thêm unit tests và integration tests
- [ ] Deploy lên cloud (AWS/Azure/GCP)

## 👥 Đóng góp

Mọi đóng góp đều được chào đón! Hãy tạo issue hoặc pull request.

## 📄 License

MIT License

## 📧 Liên hệ

- GitHub: [@congdinh2008](https://github.com/congdinh2008)

---

**Made with ❤️ for teaching purposes**
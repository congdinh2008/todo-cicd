---
name: "Bước 4: Tạo REST API Controller"
about: Hướng dẫn tạo REST API endpoints
title: "[Backend] Tạo REST API Controller"
labels: backend, api, step-4
assignees: ''
---

## 🎯 Mục tiêu
Tạo REST API controller để expose endpoints cho frontend.

## 📋 Các công việc cần làm

### 1. Tạo TodoController (controller/TodoController.java)
- [ ] Thêm annotations:
  - `@RestController`
  - `@RequestMapping("/api/todos")`
  - `@CrossOrigin`
  - `@RequiredArgsConstructor`
- [ ] Inject TodoService
- [ ] Implement các endpoints:

#### GET Endpoints
- [ ] `GET /api/todos` - Lấy tất cả todos
  - Support query params: `completed`, `search`
  - Return List<Todo>
- [ ] `GET /api/todos/{id}` - Lấy todo theo ID
  - Path variable: id
  - Return Todo
- [ ] `GET /api/todos/stats` - Lấy thống kê
  - Return Map với: total, completed, incomplete, completionRate

#### POST Endpoint
- [ ] `POST /api/todos` - Tạo todo mới
  - Request body: Todo (với @Valid)
  - Return Todo với status 201 Created

#### PUT Endpoint
- [ ] `PUT /api/todos/{id}` - Cập nhật todo
  - Path variable: id
  - Request body: Todo (với @Valid)
  - Return updated Todo

#### PATCH Endpoints
- [ ] `PATCH /api/todos/{id}/complete` - Đánh dấu hoàn thành
  - Path variable: id
  - Return updated Todo
- [ ] `PATCH /api/todos/{id}/incomplete` - Đánh dấu chưa hoàn thành
  - Path variable: id
  - Return updated Todo

#### DELETE Endpoint
- [ ] `DELETE /api/todos/{id}` - Xóa todo
  - Path variable: id
  - Return 204 No Content

### 2. Tạo CORS Configuration (config/CorsConfig.java)
- [ ] Tạo @Configuration class
- [ ] Tạo @Bean CorsFilter
- [ ] Cấu hình:
  - Allowed origins: localhost:3000, localhost:5173
  - Allowed methods: GET, POST, PUT, PATCH, DELETE, OPTIONS
  - Allow credentials: true
  - Allow all headers

### 3. Thêm comments chi tiết
- [ ] Comment giải thích các REST annotations
- [ ] Comment giải thích từng endpoint và HTTP method
- [ ] Comment giải thích request/response types
- [ ] Comment giải thích CORS configuration

## 📚 Kiến thức cần có
- REST API principles
- HTTP methods và status codes
- Spring MVC annotations
- CORS (Cross-Origin Resource Sharing)

## 🔗 Tài liệu tham khảo
- [Spring REST Controllers](https://spring.io/guides/gs/rest-service/)
- [HTTP Status Codes](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status)
- [Spring CORS](https://spring.io/guides/gs/rest-service-cors/)

## 🧪 Testing
- [ ] Test với Postman hoặc curl
- [ ] Test GET /api/todos
- [ ] Test POST /api/todos
- [ ] Test PUT /api/todos/{id}
- [ ] Test DELETE /api/todos/{id}
- [ ] Test PATCH endpoints
- [ ] Test với query parameters

## ✅ Tiêu chí hoàn thành
- [ ] Tất cả endpoints hoạt động đúng
- [ ] Validation errors trả về 400 Bad Request
- [ ] Not found errors trả về 404 Not Found
- [ ] CORS được cấu hình đúng
- [ ] API có thể test được với Postman/curl
- [ ] Code có comments tiếng Việt đầy đủ

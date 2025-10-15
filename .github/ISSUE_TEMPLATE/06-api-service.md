---
name: "Bước 6: Tạo API Service Frontend"
about: Hướng dẫn tạo service để gọi Backend API
title: "[Frontend] Tạo API Service"
labels: frontend, api, step-6
assignees: ''
---

## 🎯 Mục tiêu
Tạo API service sử dụng Axios để gọi Backend REST API.

## 📋 Các công việc cần làm

### 1. Tạo todoService.js (src/services/todoService.js)
- [ ] Import axios
- [ ] Tạo axios instance với:
  - baseURL: API_BASE_URL (từ env hoặc default)
  - headers: Content-Type: application/json
  - timeout: 10000ms
- [ ] Thêm request interceptor:
  - Log request method và URL
  - Handle request errors
- [ ] Thêm response interceptor:
  - Log response status
  - Handle response errors

### 2. Implement API methods
- [ ] `getAllTodos(params)` - GET /api/todos
  - Params: completed, search (optional)
  - Return promise với list todos
- [ ] `getTodoById(id)` - GET /api/todos/:id
  - Return promise với todo object
- [ ] `createTodo(todoData)` - POST /api/todos
  - Body: { title, description }
  - Return promise với created todo
- [ ] `updateTodo(id, todoData)` - PUT /api/todos/:id
  - Body: { title, description, completed }
  - Return promise với updated todo
- [ ] `deleteTodo(id)` - DELETE /api/todos/:id
  - Return promise void
- [ ] `completeTodo(id)` - PATCH /api/todos/:id/complete
  - Return promise với updated todo
- [ ] `incompleteTodo(id)` - PATCH /api/todos/:id/incomplete
  - Return promise với updated todo
- [ ] `getStats()` - GET /api/todos/stats
  - Return promise với stats object

### 3. Thêm comments chi tiết
- [ ] Comment giải thích axios configuration
- [ ] Comment giải thích interceptors
- [ ] Comment giải thích từng API method
- [ ] Comment parameters và return types
- [ ] Comment error handling

### 4. Tạo .env.example (optional)
- [ ] VITE_API_URL=http://localhost:8080/api

## 📚 Kiến thức cần có
- Axios library
- HTTP methods
- Promises và async/await
- API request/response handling
- Environment variables trong Vite

## 🔗 Tài liệu tham khảo
- [Axios Documentation](https://axios-http.com/docs/intro)
- [Axios Interceptors](https://axios-http.com/docs/interceptors)
- [Vite Environment Variables](https://vitejs.dev/guide/env-and-mode.html)

## 🧪 Testing
- [ ] Test trong browser console
- [ ] Test getAllTodos()
- [ ] Test createTodo()
- [ ] Test updateTodo()
- [ ] Test deleteTodo()
- [ ] Kiểm tra interceptors log ra console

## ✅ Tiêu chí hoàn thành
- [ ] todoService có đầy đủ methods
- [ ] Axios instance được cấu hình đúng
- [ ] Interceptors hoạt động (log ra console)
- [ ] API calls thành công khi test
- [ ] Code có comments tiếng Việt đầy đủ

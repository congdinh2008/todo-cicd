---
name: "Bước 3: Tạo Service Layer"
about: Hướng dẫn tạo service layer với business logic
title: "[Backend] Tạo Service Layer"
labels: backend, service, step-3
assignees: ''
---

## 🎯 Mục tiêu
Tạo service layer để xử lý business logic và tách biệt controller với repository.

## 📋 Các công việc cần làm

### 1. Tạo Exception Handler
- [ ] Tạo `ResourceNotFoundException` extends RuntimeException
  - Constructor với message
  - Constructor với message và cause
- [ ] Tạo `GlobalExceptionHandler` với `@RestControllerAdvice`
  - Handler cho ResourceNotFoundException (404)
  - Handler cho MethodArgumentNotValidException (400)
  - Handler cho Exception chung (500)
  - Return error response với format chuẩn

### 2. Tạo TodoService (service/TodoService.java)
- [ ] Thêm annotations:
  - `@Service`
  - `@RequiredArgsConstructor` (Lombok)
  - `@Transactional`
- [ ] Inject TodoRepository
- [ ] Implement các methods:
  - `getAllTodos()` - Lấy tất cả todos
  - `getTodoById(Long id)` - Lấy theo ID, throw exception nếu không tồn tại
  - `createTodo(Todo todo)` - Tạo mới todo
  - `updateTodo(Long id, Todo todoDetails)` - Cập nhật todo
  - `deleteTodo(Long id)` - Xóa todo
  - `getTodosByStatus(Boolean completed)` - Lấy theo trạng thái
  - `searchTodos(String title)` - Tìm kiếm
  - `completeTodo(Long id)` - Đánh dấu hoàn thành
  - `incompleteTodo(Long id)` - Đánh dấu chưa hoàn thành
  - `countTodosByStatus(Boolean completed)` - Đếm theo trạng thái

### 3. Thêm comments chi tiết
- [ ] Comment giải thích business logic
- [ ] Comment giải thích @Transactional
- [ ] Comment giải thích exception handling
- [ ] Comment giải thích từng method

## 📚 Kiến thức cần có
- Spring Service layer pattern
- Transaction management
- Exception handling
- Optional in Java

## 🔗 Tài liệu tham khảo
- [Spring @Transactional](https://docs.spring.io/spring-framework/docs/current/reference/html/data-access.html#transaction)
- [Exception Handling in Spring](https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc)
- [Optional in Java](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html)

## ✅ Tiêu chí hoàn thành
- [ ] TodoService có đầy đủ methods cho business logic
- [ ] Exception handling hoạt động đúng
- [ ] Transaction được quản lý đúng
- [ ] Methods throw exception khi cần thiết
- [ ] Code có comments tiếng Việt đầy đủ

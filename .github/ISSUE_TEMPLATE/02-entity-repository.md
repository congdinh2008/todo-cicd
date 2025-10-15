---
name: "Bước 2: Tạo Entity và Repository"
about: Hướng dẫn tạo Todo entity và repository layer
title: "[Backend] Tạo Entity và Repository"
labels: backend, database, step-2
assignees: ''
---

## 🎯 Mục tiêu
Tạo Todo entity để ánh xạ với database table và repository để thao tác với database.

## 📋 Các công việc cần làm

### 1. Tạo Todo Entity (model/Todo.java)
- [ ] Tạo class Todo với các thuộc tính:
  - `id` (Long) - Primary key, auto increment
  - `title` (String) - Tiêu đề, not null, max 255 chars
  - `description` (String) - Mô tả, có thể null, text
  - `completed` (Boolean) - Trạng thái, default false
  - `createdAt` (LocalDateTime) - Thời gian tạo
  - `updatedAt` (LocalDateTime) - Thời gian cập nhật
- [ ] Thêm annotations:
  - `@Entity` và `@Table(name = "todos")`
  - `@Id` và `@GeneratedValue`
  - `@Column` với các constraints
  - `@NotBlank` cho validation
  - `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor` (Lombok)
- [ ] Thêm callbacks:
  - `@PrePersist` - Set createdAt và updatedAt khi tạo mới
  - `@PreUpdate` - Update updatedAt khi cập nhật

### 2. Tạo TodoRepository (repository/TodoRepository.java)
- [ ] Tạo interface extends `JpaRepository<Todo, Long>`
- [ ] Thêm annotation `@Repository`
- [ ] Thêm custom query methods:
  - `findByCompleted(Boolean completed)` - Tìm theo trạng thái
  - `findByTitleContainingIgnoreCase(String title)` - Tìm kiếm theo title
  - `countByCompleted(Boolean completed)` - Đếm theo trạng thái

### 3. Thêm comments chi tiết
- [ ] Comment giải thích từng field trong Entity
- [ ] Comment giải thích các JPA annotations
- [ ] Comment giải thích query methods trong Repository

## 📚 Kiến thức cần có
- JPA/Hibernate
- Spring Data JPA
- Query methods naming convention
- Lombok annotations

## 🔗 Tài liệu tham khảo
- [Spring Data JPA Documentation](https://spring.io/projects/spring-data-jpa)
- [JPA Annotations](https://docs.oracle.com/javaee/7/api/javax/persistence/package-summary.html)
- [Query Methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods)

## ✅ Tiêu chí hoàn thành
- [ ] Entity được tạo với đầy đủ fields và annotations
- [ ] Repository có đầy đủ CRUD methods và custom queries
- [ ] Application start thành công và tạo table trong PostgreSQL
- [ ] Có thể insert và query dữ liệu thành công
- [ ] Code có comments tiếng Việt đầy đủ

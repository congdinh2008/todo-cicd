package com.todoapp.controller;

import com.todoapp.model.Todo;
import com.todoapp.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TodoController - REST API Controller cho Todo
 * 
 * @RestController: Kết hợp @Controller và @ResponseBody
 * Tự động serialize response thành JSON
 * 
 * @RequestMapping: Định nghĩa base path cho tất cả endpoints trong controller
 * @CrossOrigin: Cho phép CORS từ các origins chỉ định
 * @RequiredArgsConstructor: Lombok tự động tạo constructor với final fields
 */
@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"})
@RequiredArgsConstructor
public class TodoController {

    // Inject TodoService để xử lý business logic
    private final TodoService todoService;

    /**
     * GET /api/todos - Lấy tất cả Todos
     * Có thể filter theo status hoặc tìm kiếm theo title
     * 
     * @param completed - (Optional) Filter theo trạng thái completed
     * @param search - (Optional) Tìm kiếm theo title
     * @return ResponseEntity chứa List todos
     */
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos(
            @RequestParam(required = false) Boolean completed,
            @RequestParam(required = false) String search) {
        
        List<Todo> todos;
        
        // Nếu có search query, tìm kiếm theo title
        if (search != null && !search.trim().isEmpty()) {
            todos = todoService.searchTodos(search);
        }
        // Nếu có filter completed, lọc theo status
        else if (completed != null) {
            todos = todoService.getTodosByStatus(completed);
        }
        // Nếu không có filter, lấy tất cả
        else {
            todos = todoService.getAllTodos();
        }
        
        return ResponseEntity.ok(todos);
    }

    /**
     * GET /api/todos/{id} - Lấy Todo theo ID
     * 
     * @param id - ID của Todo
     * @return ResponseEntity chứa Todo
     */
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Todo todo = todoService.getTodoById(id);
        return ResponseEntity.ok(todo);
    }

    /**
     * POST /api/todos - Tạo mới Todo
     * 
     * @param todo - Todo object từ request body
     * @return ResponseEntity chứa Todo đã tạo với HTTP 201 Created
     */
    @PostMapping
    public ResponseEntity<Todo> createTodo(@Valid @RequestBody Todo todo) {
        Todo createdTodo = todoService.createTodo(todo);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdTodo);
    }

    /**
     * PUT /api/todos/{id} - Cập nhật Todo
     * 
     * @param id - ID của Todo cần cập nhật
     * @param todo - Todo object chứa thông tin mới
     * @return ResponseEntity chứa Todo đã cập nhật
     */
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable Long id,
            @Valid @RequestBody Todo todo) {
        Todo updatedTodo = todoService.updateTodo(id, todo);
        return ResponseEntity.ok(updatedTodo);
    }

    /**
     * DELETE /api/todos/{id} - Xóa Todo
     * 
     * @param id - ID của Todo cần xóa
     * @return ResponseEntity với HTTP 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * PATCH /api/todos/{id}/complete - Đánh dấu Todo là completed
     * 
     * @param id - ID của Todo
     * @return ResponseEntity chứa Todo đã cập nhật
     */
    @PatchMapping("/{id}/complete")
    public ResponseEntity<Todo> completeTodo(@PathVariable Long id) {
        Todo todo = todoService.completeTodo(id);
        return ResponseEntity.ok(todo);
    }

    /**
     * PATCH /api/todos/{id}/incomplete - Đánh dấu Todo là chưa completed
     * 
     * @param id - ID của Todo
     * @return ResponseEntity chứa Todo đã cập nhật
     */
    @PatchMapping("/{id}/incomplete")
    public ResponseEntity<Todo> incompleteTodo(@PathVariable Long id) {
        Todo todo = todoService.incompleteTodo(id);
        return ResponseEntity.ok(todo);
    }

    /**
     * GET /api/todos/stats - Lấy thống kê về Todos
     * 
     * @return ResponseEntity chứa Map với các thống kê
     */
    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getStats() {
        Map<String, Object> stats = new HashMap<>();
        
        long total = todoService.getAllTodos().size();
        long completed = todoService.countTodosByStatus(true);
        long incomplete = todoService.countTodosByStatus(false);
        
        stats.put("total", total);
        stats.put("completed", completed);
        stats.put("incomplete", incomplete);
        stats.put("completionRate", total > 0 ? (completed * 100.0 / total) : 0);
        
        return ResponseEntity.ok(stats);
    }
}

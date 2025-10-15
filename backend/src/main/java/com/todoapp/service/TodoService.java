package com.todoapp.service;

import com.todoapp.exception.ResourceNotFoundException;
import com.todoapp.model.Todo;
import com.todoapp.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TodoService - Service layer chứa business logic cho Todo
 * 
 * @Service: Đánh dấu đây là một Service component
 * @RequiredArgsConstructor: Lombok tự động tạo constructor với các final fields
 * @Transactional: Quản lý transaction cho các operations với database
 */
@Service
@RequiredArgsConstructor
@Transactional
public class TodoService {

    // Inject TodoRepository để tương tác với database
    private final TodoRepository todoRepository;

    /**
     * Lấy tất cả Todo
     * @Transactional(readOnly = true): Tối ưu performance cho read operations
     * 
     * @return List tất cả Todo
     */
    @Transactional(readOnly = true)
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    /**
     * Lấy Todo theo ID
     * 
     * @param id - ID của Todo cần tìm
     * @return Todo nếu tìm thấy
     * @throws ResourceNotFoundException nếu không tìm thấy Todo
     */
    @Transactional(readOnly = true)
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Không tìm thấy Todo với ID: " + id));
    }

    /**
     * Tạo mới Todo
     * 
     * @param todo - Todo object cần tạo
     * @return Todo đã được lưu vào database
     */
    public Todo createTodo(Todo todo) {
        // Đảm bảo ID = null để tạo mới (không update)
        todo.setId(null);
        // Đặt completed = false nếu không được set
        if (todo.getCompleted() == null) {
            todo.setCompleted(false);
        }
        return todoRepository.save(todo);
    }

    /**
     * Cập nhật Todo
     * 
     * @param id - ID của Todo cần cập nhật
     * @param todoDetails - Thông tin mới của Todo
     * @return Todo đã được cập nhật
     * @throws ResourceNotFoundException nếu không tìm thấy Todo
     */
    public Todo updateTodo(Long id, Todo todoDetails) {
        // Tìm Todo hiện tại trong database
        Todo todo = getTodoById(id);

        // Cập nhật các fields
        if (todoDetails.getTitle() != null) {
            todo.setTitle(todoDetails.getTitle());
        }
        if (todoDetails.getDescription() != null) {
            todo.setDescription(todoDetails.getDescription());
        }
        if (todoDetails.getCompleted() != null) {
            todo.setCompleted(todoDetails.getCompleted());
        }

        // Lưu và trả về Todo đã cập nhật
        return todoRepository.save(todo);
    }

    /**
     * Xóa Todo theo ID
     * 
     * @param id - ID của Todo cần xóa
     * @throws ResourceNotFoundException nếu không tìm thấy Todo
     */
    public void deleteTodo(Long id) {
        // Kiểm tra Todo có tồn tại không
        Todo todo = getTodoById(id);
        // Xóa Todo
        todoRepository.delete(todo);
    }

    /**
     * Lấy danh sách Todo theo trạng thái completed
     * 
     * @param completed - Trạng thái cần lọc (true/false)
     * @return List các Todo có trạng thái tương ứng
     */
    @Transactional(readOnly = true)
    public List<Todo> getTodosByStatus(Boolean completed) {
        return todoRepository.findByCompleted(completed);
    }

    /**
     * Tìm kiếm Todo theo title
     * 
     * @param title - Từ khóa tìm kiếm
     * @return List các Todo có title chứa từ khóa
     */
    @Transactional(readOnly = true)
    public List<Todo> searchTodos(String title) {
        return todoRepository.findByTitleContainingIgnoreCase(title);
    }

    /**
     * Đánh dấu Todo là completed
     * 
     * @param id - ID của Todo
     * @return Todo đã được cập nhật
     */
    public Todo completeTodo(Long id) {
        Todo todo = getTodoById(id);
        todo.setCompleted(true);
        return todoRepository.save(todo);
    }

    /**
     * Đánh dấu Todo là chưa completed
     * 
     * @param id - ID của Todo
     * @return Todo đã được cập nhật
     */
    public Todo incompleteTodo(Long id) {
        Todo todo = getTodoById(id);
        todo.setCompleted(false);
        return todoRepository.save(todo);
    }

    /**
     * Đếm số lượng Todo theo trạng thái
     * 
     * @param completed - Trạng thái cần đếm
     * @return Số lượng Todo
     */
    @Transactional(readOnly = true)
    public Long countTodosByStatus(Boolean completed) {
        return todoRepository.countByCompleted(completed);
    }
}

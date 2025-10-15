package com.todoapp.repository;

import com.todoapp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TodoRepository - Interface để tương tác với database cho Todo entity
 * 
 * @Repository: Đánh dấu đây là một Repository component
 * Extends JpaRepository: Kế thừa các methods CRUD sẵn có:
 * - save(): Lưu hoặc cập nhật Todo
 * - findById(): Tìm Todo theo ID
 * - findAll(): Lấy tất cả Todo
 * - deleteById(): Xóa Todo theo ID
 * - count(): Đếm số lượng Todo
 * và nhiều methods khác...
 * 
 * JpaRepository<Todo, Long>:
 * - Todo: Entity type
 * - Long: Primary key type
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    /**
     * Tìm tất cả Todo theo trạng thái completed
     * Spring Data JPA tự động implement method này dựa trên tên method
     * Quy tắc: findBy + TênThuộcTính
     * 
     * @param completed - Trạng thái hoàn thành (true/false)
     * @return List các Todo có trạng thái tương ứng
     */
    List<Todo> findByCompleted(Boolean completed);

    /**
     * Tìm Todo theo title (không phân biệt hoa thường)
     * Spring Data JPA tự động tạo query:
     * SELECT * FROM todos WHERE LOWER(title) LIKE LOWER('%keyword%')
     * 
     * @param title - Từ khóa tìm kiếm
     * @return List các Todo có title chứa từ khóa
     */
    List<Todo> findByTitleContainingIgnoreCase(String title);

    /**
     * Đếm số lượng Todo theo trạng thái completed
     * 
     * @param completed - Trạng thái hoàn thành
     * @return Số lượng Todo có trạng thái tương ứng
     */
    Long countByCompleted(Boolean completed);
}

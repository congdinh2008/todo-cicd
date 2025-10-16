package com.todoapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Todo - Entity class đại diện cho một Todo item trong database
 * 
 * Annotations:
 * @Entity: Đánh dấu đây là một JPA entity
 * @Table: Chỉ định tên bảng trong database
 * @Data: Lombok tự động tạo getter, setter, toString, equals, hashCode
 * @NoArgsConstructor: Tạo constructor không tham số
 * @AllArgsConstructor: Tạo constructor với tất cả tham số
 */
@Entity
@Table(name = "todos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    /**
     * ID - Primary key của Todo
     * @Id: Đánh dấu đây là primary key
     * @GeneratedValue: Tự động sinh giá trị cho ID
     * IDENTITY: Sử dụng cơ chế auto-increment của database
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Title - Tiêu đề của Todo
     * @NotBlank: Validation - không được để trống
     * @Column: Cấu hình chi tiết cho cột trong database
     */
    @NotBlank(message = "Tiêu đề không được để trống")
    @Column(nullable = false, length = 255)
    private String title;

    /**
     * Description - Mô tả chi tiết của Todo
     * @Column: columnDefinition = "TEXT" cho phép lưu text dài
     */
    @Column(columnDefinition = "TEXT")
    private String description;

    /**
     * Completed - Trạng thái hoàn thành của Todo
     * Mặc định là false (chưa hoàn thành)
     */
    @Column(nullable = false)
    private Boolean completed = false;

    /**
     * CreatedAt - Thời gian tạo Todo
     * @Column: updatable = false nghĩa là không cho phép cập nhật sau khi tạo
     */
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    /**
     * UpdatedAt - Thời gian cập nhật Todo lần cuối
     */
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /**
     * PrePersist - Callback method được gọi trước khi entity được lưu vào database lần đầu
     * Tự động set createdAt và updatedAt khi tạo mới
     */
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    /**
     * PreUpdate - Callback method được gọi trước khi entity được cập nhật
     * Tự động cập nhật updatedAt khi có thay đổi
     */
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}

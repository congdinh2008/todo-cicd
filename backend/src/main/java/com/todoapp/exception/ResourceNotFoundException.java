package com.todoapp.exception;

/**
 * ResourceNotFoundException - Exception được throw khi không tìm thấy resource
 * Kế thừa từ RuntimeException
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructor với message
     * @param message - Thông báo lỗi
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructor với message và cause
     * @param message - Thông báo lỗi
     * @param cause - Nguyên nhân gốc rễ của lỗi
     */
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

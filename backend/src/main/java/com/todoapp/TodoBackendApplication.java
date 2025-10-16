package com.todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TodoBackendApplication - Class chính để khởi động ứng dụng Spring Boot
 * 
 * @SpringBootApplication: Annotation tổng hợp bao gồm:
 * - @Configuration: Đánh dấu đây là class cấu hình Spring
 * - @EnableAutoConfiguration: Tự động cấu hình Spring dựa trên dependencies
 * - @ComponentScan: Tự động quét và đăng ký các components trong package
 */
@SpringBootApplication
public class TodoBackendApplication {

    /**
     * Main method - Điểm khởi đầu của ứng dụng
     * @param args - Tham số dòng lệnh
     */
    public static void main(String[] args) {
        SpringApplication.run(TodoBackendApplication.class, args);
    }
}

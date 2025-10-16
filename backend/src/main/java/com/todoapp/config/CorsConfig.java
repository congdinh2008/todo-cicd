package com.todoapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * CorsConfig - Cấu hình CORS cho ứng dụng
 * 
 * CORS (Cross-Origin Resource Sharing) cho phép Frontend từ domain khác
 * có thể gọi API của Backend
 * 
 * @Configuration: Đánh dấu đây là class cấu hình Spring
 */
@Configuration
public class CorsConfig {

    /**
     * Tạo CorsFilter bean để xử lý CORS
     * 
     * @return CorsFilter đã được cấu hình
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        
        // Cho phép gửi credentials (cookies, authorization headers)
        config.setAllowCredentials(true);
        
        // Cho phép các origins (domains) sau được truy cập API
        // Trong development: localhost:3000 (React default), localhost:5173 (Vite default)
        // Trong production: nên thay bằng domain thật của frontend
        config.setAllowedOrigins(Arrays.asList(
                "http://localhost:3000",
                "http://localhost:5173"
        ));
        
        // Cho phép tất cả headers
        config.addAllowedHeader("*");
        
        // Cho phép các HTTP methods
        config.setAllowedMethods(Arrays.asList(
                "GET",      // Lấy dữ liệu
                "POST",     // Tạo mới
                "PUT",      // Cập nhật toàn bộ
                "PATCH",    // Cập nhật một phần
                "DELETE",   // Xóa
                "OPTIONS"   // Pre-flight request
        ));
        
        // Áp dụng cấu hình cho tất cả các endpoints
        source.registerCorsConfiguration("/**", config);
        
        return new CorsFilter(source);
    }
}

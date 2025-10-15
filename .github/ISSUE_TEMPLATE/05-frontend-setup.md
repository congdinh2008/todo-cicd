---
name: "Bước 5: Thiết lập Frontend React"
about: Hướng dẫn tạo React application với Vite
title: "[Frontend] Thiết lập React với Vite"
labels: frontend, setup, step-5
assignees: ''
---

## 🎯 Mục tiêu
Tạo React application với Vite và cấu hình kết nối với Backend API.

## 📋 Các công việc cần làm

### 1. Khởi tạo project
- [ ] Tạo thư mục `frontend/`
- [ ] Tạo `package.json` với dependencies:
  - react, react-dom
  - axios (HTTP client)
  - vite (build tool)
  - @vitejs/plugin-react
  - eslint plugins

### 2. Tạo cấu trúc thư mục
- [ ] Tạo `src/` folder
- [ ] Tạo `src/components/` cho React components
- [ ] Tạo `src/services/` cho API services
- [ ] Tạo `public/` cho static assets

### 3. Cấu hình Vite (vite.config.js)
- [ ] Import React plugin
- [ ] Cấu hình server:
  - Port: 3000
  - Host: true (cho phép access từ bên ngoài)
  - Proxy: forward /api/* đến http://localhost:8080
- [ ] Cấu hình build:
  - Output directory: dist
  - Minify: terser

### 4. Tạo index.html
- [ ] HTML template với:
  - Meta tags (charset, viewport)
  - Title: Todo App
  - Root div với id="root"
  - Script tag import main.jsx

### 5. Tạo entry point (src/main.jsx)
- [ ] Import React, ReactDOM
- [ ] Import App component
- [ ] Import global CSS
- [ ] Render App vào root element với StrictMode

### 6. Tạo global styles
- [ ] `src/index.css` - Global styles, CSS reset
- [ ] `src/App.css` - App component styles

### 7. Thêm comments chi tiết
- [ ] Comment giải thích Vite config
- [ ] Comment giải thích proxy configuration
- [ ] Comment giải thích entry point

## 📚 Kiến thức cần có
- React basics
- Vite build tool
- npm/package management
- ES6 modules

## 🔗 Tài liệu tham khảo
- [Vite Documentation](https://vitejs.dev/)
- [React Documentation](https://react.dev/)
- [Vite Proxy Configuration](https://vitejs.dev/config/server-options.html#server-proxy)

## 🧪 Testing
- [ ] Chạy `npm install` thành công
- [ ] Chạy `npm run dev` thành công
- [ ] Frontend accessible tại http://localhost:3000
- [ ] Proxy hoạt động (forward /api/* đến backend)

## ✅ Tiêu chí hoàn thành
- [ ] Project structure được tạo đúng
- [ ] Dependencies được install thành công
- [ ] Dev server chạy được
- [ ] Có thể build thành công với `npm run build`
- [ ] Code có comments tiếng Việt đầy đủ

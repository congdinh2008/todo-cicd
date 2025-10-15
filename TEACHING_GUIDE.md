# Hướng dẫn Giảng dạy - Todo App với CI/CD

Tài liệu này cung cấp hướng dẫn chi tiết cho giảng viên để dạy dự án Todo App với CI/CD.

## 📚 Mục lục

1. [Tổng quan dự án](#tổng-quan-dự-án)
2. [Chuẩn bị môi trường](#chuẩn-bị-môi-trường)
3. [Lộ trình giảng dạy](#lộ-trình-giảng-dạy)
4. [Kế hoạch bài giảng](#kế-hoạch-bài-giảng)
5. [Bài tập và đánh giá](#bài-tập-và-đánh-giá)
6. [Tài liệu tham khảo](#tài-liệu-tham-khảo)

## 🎯 Tổng quan dự án

### Mục tiêu học tập
Học viên sẽ học được:
- Xây dựng ứng dụng Full Stack với Spring Boot và React
- Làm việc với PostgreSQL database
- Containerize ứng dụng với Docker
- Orchestrate services với Docker Compose
- Thiết lập CI/CD với GitHub Actions
- Best practices trong phát triển phần mềm

### Kiến thức yêu cầu
- Java cơ bản
- JavaScript/ES6 basics
- HTML/CSS cơ bản
- Git basics
- Command line basics

### Thời lượng khóa học
- **Tổng thời gian**: 40-60 giờ
- **12 buổi học** (mỗi buổi 3-5 giờ)
- Bao gồm lý thuyết, thực hành và làm bài tập

## 🛠️ Chuẩn bị môi trường

### Phần mềm cần cài đặt

#### 1. Java Development
- JDK 17 hoặc mới hơn
- Maven 3.8+
- IDE: IntelliJ IDEA hoặc Eclipse

#### 2. Frontend Development
- Node.js 20 LTS
- npm 10+
- VS Code hoặc WebStorm

#### 3. Database
- PostgreSQL 16
- pgAdmin (optional)

#### 4. Container & Orchestration
- Docker Desktop
- Docker Compose (included in Docker Desktop)

#### 5. Version Control
- Git
- GitHub account

#### 6. Tools
- Postman hoặc Insomnia (để test API)
- Terminal/Command Prompt

### Kiểm tra môi trường

```bash
# Check Java
java -version

# Check Maven
mvn -version

# Check Node.js và npm
node -v
npm -v

# Check Docker
docker --version
docker-compose --version

# Check Git
git --version

# Check PostgreSQL
psql --version
```

## 📅 Lộ trình giảng dạy

### Phase 1: Backend Development (4 buổi)

#### Buổi 1: Giới thiệu và Setup Backend
- **Thời lượng**: 4 giờ
- **Nội dung**:
  - Giới thiệu kiến trúc dự án
  - Spring Boot fundamentals
  - Maven dependency management
  - Cấu hình project và database connection
- **Thực hành**: [Issue #1 - Backend Setup](/.github/ISSUE_TEMPLATE/01-backend-setup.md)
- **Bài tập**: Tạo project Spring Boot, cấu hình PostgreSQL

#### Buổi 2: Database Layer
- **Thời lượng**: 4 giờ
- **Nội dung**:
  - JPA/Hibernate overview
  - Entity mapping
  - Spring Data JPA
  - Repository pattern
- **Thực hành**: [Issue #2 - Entity và Repository](/.github/ISSUE_TEMPLATE/02-entity-repository.md)
- **Bài tập**: Tạo Todo entity và repository với custom queries

#### Buổi 3: Service Layer
- **Thời lượng**: 4 giờ
- **Nội dung**:
  - Service layer pattern
  - Business logic
  - Transaction management
  - Exception handling
- **Thực hành**: [Issue #3 - Service Layer](/.github/ISSUE_TEMPLATE/03-service-layer.md)
- **Bài tập**: Implement TodoService với đầy đủ operations

#### Buổi 4: REST API
- **Thời lượng**: 5 giờ
- **Nội dung**:
  - REST principles
  - Spring MVC
  - Controllers và endpoints
  - CORS configuration
  - API testing với Postman
- **Thực hành**: [Issue #4 - REST API](/.github/ISSUE_TEMPLATE/04-rest-api.md)
- **Bài tập**: Tạo REST API endpoints và test

### Phase 2: Frontend Development (3 buổi)

#### Buổi 5: React Setup
- **Thời lượng**: 4 giờ
- **Nội dung**:
  - React fundamentals
  - Vite build tool
  - Project structure
  - Component basics
- **Thực hành**: [Issue #5 - Frontend Setup](/.github/ISSUE_TEMPLATE/05-frontend-setup.md)
- **Bài tập**: Setup React project với Vite

#### Buổi 6: API Integration
- **Thời lượng**: 4 giờ
- **Nội dung**:
  - Axios library
  - HTTP requests
  - API service pattern
  - Error handling
- **Thực hành**: [Issue #6 - API Service](/.github/ISSUE_TEMPLATE/06-api-service.md)
- **Bài tập**: Tạo API service để gọi Backend

#### Buổi 7: React Components
- **Thời lượng**: 5 giờ
- **Nội dung**:
  - React Hooks (useState, useEffect)
  - Component composition
  - Props và state
  - Event handling
  - CSS styling
- **Thực hành**: [Issue #7 - React Components](/.github/ISSUE_TEMPLATE/07-react-components.md)
- **Bài tập**: Tạo tất cả components cho Todo app

### Phase 3: Docker & Containerization (3 buổi)

#### Buổi 8: Docker Basics
- **Thời lượng**: 4 giờ
- **Nội dung**:
  - Docker fundamentals
  - Images vs Containers
  - Dockerfile syntax
  - Multi-stage builds
  - Dockerize Backend
- **Thực hành**: [Issue #8 - Docker Backend](/.github/ISSUE_TEMPLATE/08-docker-backend.md)
- **Bài tập**: Tạo Dockerfile cho Backend

#### Buổi 9: Dockerize Frontend
- **Thời lượng**: 4 giờ
- **Nội dung**:
  - Nginx for serving static files
  - Frontend Dockerfile
  - Build optimization
- **Thực hành**: [Issue #9 - Docker Frontend](/.github/ISSUE_TEMPLATE/09-docker-frontend.md)
- **Bài tập**: Tạo Dockerfile cho Frontend

#### Buổi 10: Docker Compose
- **Thời lượng**: 5 giờ
- **Nội dung**:
  - Docker Compose overview
  - Service orchestration
  - Networks và volumes
  - Health checks
  - Environment variables
- **Thực hành**: [Issue #10 - Docker Compose](/.github/ISSUE_TEMPLATE/10-docker-compose.md)
- **Bài tập**: Tạo docker-compose.yml cho toàn bộ stack

### Phase 4: CI/CD (2 buổi)

#### Buổi 11: GitHub Actions CI
- **Thời lượng**: 5 giờ
- **Nội dung**:
  - CI/CD concepts
  - GitHub Actions basics
  - Workflow syntax
  - Build automation
  - Testing automation
- **Thực hành**: [Issue #11 - GitHub Actions CI](/.github/ISSUE_TEMPLATE/11-github-actions-ci.md)
- **Bài tập**: Tạo CI workflow

#### Buổi 12: GitHub Actions CD
- **Thời lượng**: 5 giờ
- **Nội dung**:
  - Deployment strategies
  - Docker registry
  - Secrets management
  - Environment configuration
  - Production considerations
- **Thực hành**: [Issue #12 - GitHub Actions CD](/.github/ISSUE_TEMPLATE/12-github-actions-cd.md)
- **Bài tập**: Tạo CD workflow

## 📖 Kế hoạch bài giảng chi tiết

### Cấu trúc mỗi buổi học

#### 1. Warm-up (15 phút)
- Review bài trước
- Q&A về homework
- Giới thiệu nội dung buổi học

#### 2. Lý thuyết (60-90 phút)
- Giảng giải concepts
- Demos và ví dụ
- Best practices
- Common pitfalls

#### 3. Break (15 phút)

#### 4. Live Coding (90-120 phút)
- Instructor coding với giải thích
- Students follow along
- Giải thích từng dòng code
- Answer questions

#### 5. Hands-on Practice (60-90 phút)
- Students làm exercises
- Instructor hỗ trợ cá nhân
- Peer programming (optional)

#### 6. Wrap-up (30 phút)
- Review key points
- Q&A
- Assign homework
- Preview next session

## 📝 Bài tập và đánh giá

### Bài tập hàng tuần
- Hoàn thành issue tương ứng với buổi học
- Code review và feedback
- Push code lên GitHub personal repo

### Bài tập lớn (Midterm)
**Sau buổi 7 - Frontend hoàn thành**
- Mở rộng Todo app với features mới:
  - Thêm categories/tags
  - Thêm due dates
  - Thêm priority levels
  - Improve UI/UX

### Đồ án cuối khóa (Final Project)
**Sau buổi 12 - CI/CD hoàn thành**
- Deploy Todo app lên cloud (AWS/Azure/GCP)
- Hoặc tạo một ứng dụng mới với kiến trúc tương tự
- Presentation và demo

### Tiêu chí đánh giá
- **Participation**: 10%
- **Homework**: 30%
- **Midterm Project**: 20%
- **Final Project**: 30%
- **Code Quality**: 10%

## 🎓 Tips cho Giảng viên

### Preparation
1. Chạy qua toàn bộ dự án trước khi dạy
2. Chuẩn bị môi trường backup nếu có issues
3. Có sẵn solutions cho các vấn đề thường gặp
4. Record sessions để students có thể review

### During Class
1. Khuyến khích students hỏi questions
2. Use live coding thay vì slides
3. Giải thích "why" không chỉ "how"
4. Share real-world experiences
5. Khuyến khích peer learning

### Common Issues và Solutions

#### Backend Issues
- **Maven dependencies không download**: Check internet, try mvn clean
- **Database connection failed**: Check PostgreSQL running, credentials
- **Port already in use**: Kill process or change port

#### Frontend Issues
- **npm install fails**: Clear npm cache, delete node_modules
- **CORS errors**: Check backend CORS config
- **Proxy not working**: Check vite.config.js

#### Docker Issues
- **Build slow**: Use layer caching, .dockerignore
- **Container cannot connect**: Check networks
- **Port conflicts**: Change port mappings

## 📚 Tài liệu tham khảo

### Official Documentation
- [Spring Boot](https://spring.io/projects/spring-boot)
- [React](https://react.dev/)
- [Docker](https://docs.docker.com/)
- [GitHub Actions](https://docs.github.com/en/actions)

### Tutorials
- [Spring Boot Tutorial](https://www.baeldung.com/spring-boot)
- [React Tutorial](https://react.dev/learn)
- [Docker Tutorial](https://docker-curriculum.com/)

### Books
- "Spring in Action" by Craig Walls
- "Learning React" by Alex Banks & Eve Porcello
- "Docker Deep Dive" by Nigel Poulton

### Videos
- [Spring Boot Full Course](https://www.youtube.com/watch?v=9SGDpanrc8U)
- [React Full Course](https://www.youtube.com/watch?v=bMknfKXIFA8)
- [Docker Full Course](https://www.youtube.com/watch?v=fqMOX6JJhGo)

## 🤝 Support

### Student Resources
- GitHub repository với code mẫu
- Slack/Discord channel để discussion
- Office hours để 1-on-1 help
- FAQ document

### Feedback
Thu thập feedback sau mỗi phase:
- Survey về nội dung và tốc độ
- Suggestions để improve
- Difficulties encountered

---

**Happy Teaching! 🎉**

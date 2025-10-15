# Contributing Guide

Hướng dẫn đóng góp và làm bài tập cho dự án Todo App.

## 🎓 Dành cho Học viên

### Cách làm bài tập

1. **Fork repository**
   - Fork repository này về GitHub account của bạn
   - Clone fork về máy local

2. **Chọn issue để làm**
   - Xem danh sách issues trong tab Issues
   - Chọn issue phù hợp với buổi học của bạn
   - Comment vào issue để báo bạn đang làm

3. **Tạo branch mới**
```bash
git checkout -b feature/issue-number-description

# Ví dụ:
git checkout -b feature/01-backend-setup
```

4. **Làm bài tập theo checklist trong issue**
   - Follow từng bước trong issue template
   - Check off các items khi hoàn thành
   - Commit thường xuyên với message rõ ràng

5. **Commit changes**
```bash
git add .
git commit -m "feat: implement backend setup"

# Hoặc theo từng phần:
git add backend/pom.xml
git commit -m "feat: add Maven dependencies"

git add backend/src/main/java/com/todoapp/TodoBackendApplication.java
git commit -m "feat: create main application class"
```

6. **Push lên GitHub**
```bash
git push origin feature/01-backend-setup
```

7. **Tạo Pull Request**
   - Tạo Pull Request từ branch của bạn về `main`
   - Viết description rõ ràng về những gì đã làm
   - Link đến issue tương ứng
   - Request review từ giảng viên

8. **Code Review**
   - Đọc comments từ reviewer
   - Fix issues nếu có
   - Push updates vào cùng branch

9. **Merge**
   - Sau khi được approve, merge Pull Request
   - Delete branch đã merge

## 📝 Commit Message Convention

Sử dụng [Conventional Commits](https://www.conventionalcommits.org/):

### Format
```
<type>(<scope>): <subject>

<body>

<footer>
```

### Types
- `feat`: Tính năng mới
- `fix`: Sửa bug
- `docs`: Thay đổi documentation
- `style`: Format code, không thay đổi logic
- `refactor`: Refactor code
- `test`: Thêm hoặc sửa tests
- `chore`: Công việc maintenance

### Examples
```bash
feat(backend): add Todo entity with JPA annotations

fix(frontend): resolve CORS error when calling API

docs: update README with setup instructions

style(backend): format code with Google Java Style

refactor(frontend): extract TodoItem to separate component

test(backend): add unit tests for TodoService

chore: update dependencies to latest versions
```

## 🎨 Code Style

### Java (Backend)
- Follow [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
- Use 4 spaces for indentation
- Maximum line length: 120 characters
- Thêm comments tiếng Việt giải thích logic

### JavaScript/React (Frontend)
- Follow [Airbnb JavaScript Style Guide](https://github.com/airbnb/javascript)
- Use 2 spaces for indentation
- Use single quotes cho strings
- Thêm comments tiếng Việt giải thích logic

### General
- Write meaningful variable và function names
- Avoid magic numbers, use constants
- Keep functions small and focused
- Comment giải thích "why", không chỉ "what"

## 🧪 Testing

### Backend Tests
```bash
cd backend
mvn test
```

### Frontend Tests (nếu có)
```bash
cd frontend
npm test
```

### Integration Test với Docker
```bash
docker-compose up -d
# Test manually hoặc với automated tests
docker-compose down
```

## 📋 Pull Request Checklist

Trước khi tạo Pull Request, đảm bảo:

- [ ] Code compile/build thành công
- [ ] Tests pass (nếu có)
- [ ] Code có comments tiếng Việt đầy đủ
- [ ] Không có console.log/System.out.println debug còn sót
- [ ] Tuân thủ code style guidelines
- [ ] README/docs được update nếu cần
- [ ] Commit messages theo convention
- [ ] Checklist trong issue đã hoàn thành

## ❓ Questions & Help

### Khi gặp vấn đề:

1. **Tự research trước**
   - Google error message
   - Check Stack Overflow
   - Đọc documentation

2. **Ask for help**
   - Comment vào issue
   - Hỏi trên chat group
   - Đăng ký office hours với giảng viên

3. **Khi post question, cung cấp:**
   - Error message đầy đủ
   - Steps để reproduce
   - Những gì đã thử
   - Environment info (OS, versions)

## 🏆 Best Practices

### Do's ✅
- Commit thường xuyên với small changes
- Write clear commit messages
- Test code trước khi commit
- Thêm comments giải thích code phức tạp
- Follow coding standards
- Ask questions khi stuck
- Help teammates
- Learn from code reviews

### Don'ts ❌
- Không commit code không test
- Không commit sensitive info (passwords, keys)
- Không push binary files lớn
- Không hardcode values, use environment variables
- Không ignore review comments
- Không copy-paste code không hiểu

## 📚 Learning Resources

### Khi học Backend
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Baeldung Spring Tutorials](https://www.baeldung.com/spring-boot)
- [Spring Boot YouTube Course](https://www.youtube.com/watch?v=9SGDpanrc8U)

### Khi học Frontend
- [React Documentation](https://react.dev/)
- [React Tutorial](https://react.dev/learn)
- [React YouTube Course](https://www.youtube.com/watch?v=bMknfKXIFA8)

### Khi học Docker
- [Docker Documentation](https://docs.docker.com/)
- [Docker Tutorial](https://docker-curriculum.com/)
- [Docker YouTube Course](https://www.youtube.com/watch?v=fqMOX6JJhGo)

### Khi học CI/CD
- [GitHub Actions Documentation](https://docs.github.com/en/actions)
- [CI/CD Concepts](https://www.atlassian.com/continuous-delivery/principles/continuous-integration-vs-delivery-vs-deployment)

## 🎯 Extra Credit

Muốn thách thức bản thân? Thử những advanced tasks:

- [ ] Thêm unit tests với JUnit và Jest
- [ ] Setup code coverage reporting
- [ ] Thêm Docker health checks
- [ ] Implement caching với Redis
- [ ] Thêm authentication với JWT
- [ ] Setup monitoring với Prometheus/Grafana
- [ ] Deploy lên cloud (AWS/Azure/GCP)
- [ ] Setup SSL/HTTPS
- [ ] Implement rate limiting
- [ ] Add API documentation với Swagger

## 🤝 Code Review Guidelines

### Khi review code của người khác:

- Be respectful và constructive
- Focus vào code, không phải người
- Suggest improvements, không chỉ point out problems
- Explain "why" khi comment
- Recognize good work

### Khi nhận review:

- Don't take it personally
- Consider feedback objectively
- Ask questions nếu không hiểu
- Thank reviewers
- Learn from feedback

---

**Happy Coding! 🚀**

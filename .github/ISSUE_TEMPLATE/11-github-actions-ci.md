---
name: "Bước 11: GitHub Actions CI"
about: Hướng dẫn setup CI workflow với GitHub Actions
title: "[CI/CD] Setup GitHub Actions CI"
labels: cicd, github-actions, step-11
assignees: ''
---

## 🎯 Mục tiêu
Tạo GitHub Actions workflow để tự động build và test khi có code changes.

## 📋 Các công việc cần làm

### 1. Tạo CI Workflow (.github/workflows/ci.yml)
- [ ] Workflow name: "CI - Build and Test"
- [ ] Trigger on:
  - push to main, develop branches
  - pull_request to main, develop branches

### 2. Job 1: Test Backend
- [ ] Job name: test-backend
- [ ] Runs on: ubuntu-latest
- [ ] Steps:
  - Checkout code (actions/checkout@v4)
  - Setup JDK 17 (actions/setup-java@v4)
    - Distribution: temurin
    - Cache: maven
  - Build and test:
    - cd backend
    - mvn clean verify
  - Upload test results (actions/upload-artifact@v4)
    - Name: backend-test-results
    - Path: backend/target/surefire-reports/

### 3. Job 2: Build Frontend
- [ ] Job name: build-frontend
- [ ] Runs on: ubuntu-latest
- [ ] Steps:
  - Checkout code
  - Setup Node.js 20 (actions/setup-node@v4)
    - Cache: npm
    - Cache dependency path: frontend/package-lock.json
  - Install dependencies:
    - cd frontend
    - npm ci
  - Build frontend:
    - npm run build
  - Upload build artifacts
    - Name: frontend-build
    - Path: frontend/dist/

### 4. Job 3: Build Docker Images
- [ ] Job name: build-docker
- [ ] Runs on: ubuntu-latest
- [ ] Needs: [test-backend, build-frontend]
- [ ] Steps:
  - Checkout code
  - Setup Docker Buildx (docker/setup-buildx-action@v3)
  - Build backend image:
    - docker build -t todo-backend:latest ./backend
  - Build frontend image:
    - docker build -t todo-frontend:latest ./frontend
  - Test docker-compose:
    - docker-compose config

### 5. Thêm comments chi tiết
- [ ] Comment giải thích workflow triggers
- [ ] Comment giải thích từng job
- [ ] Comment giải thích dependencies giữa jobs
- [ ] Comment giải thích caching
- [ ] Comment giải thích artifacts

## 📚 Kiến thức cần có
- GitHub Actions basics
- YAML syntax
- CI/CD concepts
- Build automation
- Testing automation

## 🔗 Tài liệu tham khảo
- [GitHub Actions Documentation](https://docs.github.com/en/actions)
- [Workflow Syntax](https://docs.github.com/en/actions/using-workflows/workflow-syntax-for-github-actions)
- [GitHub Actions Marketplace](https://github.com/marketplace?type=actions)

## 🧪 Testing

### Test workflow locally (với act - optional)
```bash
# Install act
# https://github.com/nektos/act

# List workflows
act -l

# Run CI workflow
act push
```

### Test trên GitHub
- [ ] Push code lên branch
- [ ] Mở tab Actions trên GitHub
- [ ] Verify workflow runs
- [ ] Check job logs
- [ ] Download artifacts (nếu có)

## 🎯 Expected Behavior
- [ ] Workflow trigger khi push code
- [ ] Workflow trigger khi tạo pull request
- [ ] Backend tests chạy thành công
- [ ] Frontend build thành công
- [ ] Docker images build thành công
- [ ] Artifacts được upload
- [ ] Status badge có thể thêm vào README

## ✅ Tiêu chí hoàn thành
- [ ] Workflow file syntax đúng
- [ ] Tất cả jobs chạy thành công
- [ ] Tests pass
- [ ] Builds thành công
- [ ] Caching hoạt động (giảm thời gian build)
- [ ] Artifacts có thể download
- [ ] File có comments tiếng Việt đầy đủ

## 📝 Optional Enhancements
- [ ] Thêm code coverage reports
- [ ] Thêm linting checks
- [ ] Thêm security scanning
- [ ] Thêm status badges vào README

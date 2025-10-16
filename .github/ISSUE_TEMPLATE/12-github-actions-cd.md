---
name: "Bước 12: GitHub Actions CD"
about: Hướng dẫn setup CD workflow để deploy application
title: "[CI/CD] Setup GitHub Actions CD"
labels: cicd, github-actions, deployment, step-12
assignees: ''
---

## 🎯 Mục tiêu
Tạo GitHub Actions workflow để tự động deploy application khi có release mới.

## 📋 Các công việc cần làm

### 1. Tạo CD Workflow (.github/workflows/cd.yml)
- [ ] Workflow name: "CD - Deploy"
- [ ] Trigger on:
  - push tags: v*.*.*
  - workflow_dispatch (manual trigger)
    - Input: environment (staging/production)

### 2. Job 1: Build and Push Images
- [ ] Job name: build-and-push
- [ ] Runs on: ubuntu-latest
- [ ] Steps:
  - Checkout code
  - Setup Docker Buildx
  - (Optional) Login to Docker Hub
    - Use secrets: DOCKER_USERNAME, DOCKER_PASSWORD
  - Get version:
    - Từ tag nếu là tag push
    - Hoặc từ commit SHA
    - Set output: VERSION
  - Build và tag backend image:
    - Build với version tag
    - Tag với latest
    - (Optional) Push to registry
  - Build và tag frontend image:
    - Build với version tag
    - Tag với latest
    - (Optional) Push to registry

### 3. Job 2: Deploy
- [ ] Job name: deploy
- [ ] Runs on: ubuntu-latest
- [ ] Needs: build-and-push
- [ ] Environment: staging/production (từ input)
- [ ] Steps:
  - Checkout code
  - (Placeholder) Deploy step:
    - Comment hướng dẫn deploy với SSH
    - Comment hướng dẫn deploy với cloud providers
    - Echo deployment info

### 4. Thêm comments chi tiết
- [ ] Comment giải thích workflow triggers
- [ ] Comment giải thích workflow_dispatch
- [ ] Comment giải thích version tagging
- [ ] Comment giải thích Docker registry login
- [ ] Comment giải thích deployment strategies
- [ ] Comment hướng dẫn cấu hình secrets

## 📚 Kiến thức cần có
- GitHub Actions workflows
- Docker registries (Docker Hub, GitHub Container Registry)
- Deployment strategies
- Secrets management
- Version tagging

## 🔗 Tài liệu tham khảo
- [GitHub Actions Deployment](https://docs.github.com/en/actions/deployment/about-deployments/about-continuous-deployment)
- [Docker Build and Push Action](https://github.com/marketplace/actions/build-and-push-docker-images)
- [GitHub Secrets](https://docs.github.com/en/actions/security-guides/encrypted-secrets)

## 🔒 Setup Secrets (Optional)

### Docker Hub
1. Tạo Docker Hub account
2. Tạo access token
3. Thêm secrets vào GitHub repo:
   - DOCKER_USERNAME
   - DOCKER_PASSWORD (hoặc access token)

### Deployment Server (Optional)
1. Tạo SSH key pair
2. Thêm secrets:
   - SERVER_HOST
   - SERVER_USERNAME
   - SERVER_SSH_KEY

## 🧪 Testing

### Test với workflow_dispatch
1. Vào tab Actions trên GitHub
2. Chọn CD workflow
3. Click "Run workflow"
4. Chọn environment
5. Xem logs và verify

### Test với tag push
```bash
# Tạo và push tag
git tag v1.0.0
git push origin v1.0.0

# Xem workflow chạy trên GitHub
```

## 📝 Deployment Options

### Option 1: Deploy to Server với SSH
```yaml
- name: Deploy to server
  uses: appleboy/ssh-action@master
  with:
    host: ${{ secrets.SERVER_HOST }}
    username: ${{ secrets.SERVER_USERNAME }}
    key: ${{ secrets.SERVER_SSH_KEY }}
    script: |
      cd /path/to/app
      docker-compose pull
      docker-compose up -d
```

### Option 2: Deploy to Cloud
- AWS ECS
- Azure Container Instances
- Google Cloud Run
- Heroku
- DigitalOcean App Platform

### Option 3: Kubernetes
```yaml
- name: Deploy to Kubernetes
  uses: azure/k8s-deploy@v1
  with:
    manifests: |
      k8s/deployment.yml
      k8s/service.yml
```

## ✅ Tiêu chí hoàn thành
- [ ] Workflow file syntax đúng
- [ ] Workflow có thể trigger manually
- [ ] Workflow có thể trigger bởi tag
- [ ] Docker images được build với đúng version
- [ ] (Optional) Images được push lên registry
- [ ] Deployment placeholder có hướng dẫn rõ ràng
- [ ] File có comments tiếng Việt đầy đủ

## 🎯 Next Steps (Advanced)
- [ ] Setup staging và production environments
- [ ] Thêm approval gates cho production
- [ ] Thêm rollback mechanism
- [ ] Thêm health checks sau deploy
- [ ] Thêm notifications (Slack, email)
- [ ] Thêm deployment metrics

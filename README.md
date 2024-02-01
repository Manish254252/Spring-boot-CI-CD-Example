# CI/CD Workflow for Spring Boot Application

This project showcases a Continuous Integration and Continuous Deployment (CI/CD) workflow for a Spring Boot application. The workflow is implemented using GitHub Actions, and it includes building a Docker image and pushing it to Docker Hub.

## Workflow Overview

The CI/CD workflow involves the following steps:

1. **Build and Test:**
   - The project is built and tested whenever changes are pushed to the `master` branch or when pull requests are created.

2. **Docker Image Build:**
   - Upon successful build and tests, a Docker image of the Spring Boot application is created.

3. **Push to Docker Hub:**
   - The Docker image is pushed to Docker Hub, making it available for deployment.

## CI/CD Configuration

The CI/CD workflow is configured using GitHub Actions. The workflow file (`.github/workflows/maven.yml`) defines the sequence of steps to be executed.

```yaml
name: CI/CD Workflow

on:
  push:
    branches:
      - master

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
    - name: Checkout Repository
      uses: actions/checkout@v2

    - name: Set up JDK 17
      uses: actions/setup-java@v2
      with:
        java-version: '17'

    - name: Build and Test
      run: mvn clean install

    - name: Build Docker Image
      run: docker build -t your-dockerhub-username/spring-boot-app:latest .

    - name: Push to Docker Hub
      run: |
        docker login -u ${{ secrets.DOCKERHUB_USERNAME }} -p ${{ secrets.DOCKERHUB_PASSWORD }}
        docker push your-dockerhub-username/spring-boot-app:latest

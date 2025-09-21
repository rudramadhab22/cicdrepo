pipeline {
    agent any

    environment {
        IMAGE_NAME = 'rudra1java/my-rest-api'     // Docker Hub repo name
        APP_PORT = '8989'                         // Spring Boot port
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/rudramadhab22/cicdrepo.git'
            }
        }

        stage('Build JAR') {
            steps {
                echo "Building JAR..."
                sh 'mvn clean package -DskipTests'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Build Docker Image') {
            steps {
                echo "Building Docker image..."
                script {
                    docker.build("${IMAGE_NAME}:${env.BUILD_NUMBER}")
                }
            }
        }

        stage('Tag Docker Image as Latest') {
            steps {
                echo "Tagging image as latest..."
                script {
                    docker.image("${IMAGE_NAME}:${env.BUILD_NUMBER}").tag("latest")
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                echo "Pushing Docker image to Docker Hub..."
                script {
                    // Using the exact credential ID: 'dockerhubcred'
                    docker.withRegistry('https://index.docker.io/v1/', 'dockerhubcred') {
                        docker.image("${IMAGE_NAME}:${env.BUILD_NUMBER}").push()
                        docker.image("${IMAGE_NAME}:latest").push()
                    }
                }
            }
        }
    }

    post {
        success {
            echo "Build and Docker push completed successfully!"
        }
        failure {
            echo "Build failed!"
        }
    }
}

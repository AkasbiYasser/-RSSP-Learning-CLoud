pipeline {
    agent any
    environment {
        ACR_NAME = 'PFSAcr'
        ACR_URL = "${ACR_NAME}.azurecr.io"
        SONARQUBE_ENV = 'sonar'
        SONARQUBE_TOKEN = credentials('sonar-token')
        SLACK_CHANNEL = '#pfa'
        SLACK_WEBHOOK_URL = credentials('slack-webhook')
        JAVA_HOME = "/usr/lib/jvm/java-17-openjdk-amd64"
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/AkasbiYasser/-RSSP-Learning-CLoud.git', credentialsId: 'github-token'
            }
        }

        stage('Build Project') {
            steps {
                script {
                    sh '''
                        echo "Building the project..."
                        cd Backend/Z-Learning
                        mvn clean install -DskipTests
                    '''
                }
            }
        }

        stage('SonarQube Analysis') {
    steps {
        withSonarQubeEnv("${SONARQUBE_ENV}") { 
            // Analyse pour le Backend
            dir('Backend/Z-Learning') {
                sh '''
                    sonar-scanner \
                        -Dsonar.projectKey=Backend \
                        -Dsonar.sources=src/main/java \
                        -Dsonar.java.binaries=target/classes \
                        -Dsonar.host.url=http://4.222.19.92:9000 \
                        -Dsonar.login=${SONARQUBE_TOKEN}
                '''
            }
            
            // Analyse pour le FrontEnd (si nécessaire)
            dir('FrontEnd') {
                sh '''
                    sonar-scanner \
                        -Dsonar.projectKey=FrontEnd \
                        -Dsonar.sources=. \
                        -Dsonar.host.url=http://4.222.19.92:9000 \
                        -Dsonar.login=${SONARQUBE_TOKEN}
                '''
            }
        }
    }
}


        stage('Build Docker Images') {
            steps {
                script {
                    sh '''
                        echo "Building Docker Images..."
                        docker-compose build
                    '''
                }
            }
        }

        stage('Push Docker Images to ACR') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'acr-token', usernameVariable: 'ACR_USERNAME', passwordVariable: 'ACR_PASSWORD')]) {
                        sh '''
                            docker login ${ACR_URL} -u ${ACR_USERNAME} -p ${ACR_PASSWORD}
                    
                            # Utiliser les noms d'image en minuscules
                            docker tag frontend ${ACR_URL}/frontend:latest
                            docker tag backend ${ACR_URL}/backend:latest

                            docker push ${ACR_URL}/frontend:latest
                            docker push ${ACR_URL}/backend:latest
                        '''
                    }
                }
            }
        }
        
        stage('Scan Docker Images with Trivy') {
    steps {
        script {
            sh '''
                echo "Scanning Docker Images with Trivy..."
                trivy image --exit-code 1 --severity HIGH --format json --output trivy-frontend-report.json ${ACR_URL}/frontend:latest || true
                trivy image --exit-code 1 --severity HIGH --format json --output trivy-backend-report.json ${ACR_URL}/backend:latest || true
            '''
        }
    }
}

        
        stage('Deploy to AKS') {
            steps {
                script {
                    withCredentials([file(credentialsId: 'aks-token', variable: 'KUBECONFIG')]) {
                        sh '''
                            echo "Deploying to AKS..."

                            kubectl apply -f k8s-manifests/frontend-deployment.yaml --kubeconfig=$KUBECONFIG
                            kubectl apply -f k8s-manifests/backend-deployment.yaml --kubeconfig=$KUBECONFIG
                            kubectl apply -f k8s-manifests/mongodb-deployment.yaml --kubeconfig=$KUBECONFIG
                        '''
                    }
                }
            }
        }
    }
     post {
        success {
            script {
                sh '''
                    curl -X POST -H "Content-type: application/json" \
                        --data '{"text":"Build and deployment successful."}' \
                        ${SLACK_WEBHOOK_URL}
                '''
            }
        }
        failure {
            script {
                sh '''
                    curl -X POST -H "Content-type: application/json" \
                        --data '{"text":"Build and deployment failed."}' \
                        ${SLACK_WEBHOOK_URL}
                '''
            }
        }
    }
}
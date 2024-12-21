pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'ibtihalamarate/gestion-etudiants:latest' // Nom de l'image Docker
    }

    stages {
        stage('Build') {
            steps {
                script {
                    echo 'Building project with Maven'
                    sh 'mvn clean install' // Commande Maven pour compiler et tester
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    echo 'Running unit tests'
                    sh 'mvn test' // Exécution des tests unitaires
                }
            }
        }
        

            stage('Docker Build') {
            steps {
                script {
                    echo 'Building Docker image'
                    sh 'docker build -t $DOCKER_IMAGE .' // Utilise le Dockerfile pour construire l'image
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    echo 'Pushing Docker image to Docker Hub'
                    withCredentials([usernamePassword(credentialsId: 'docker-hub', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                        sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
                        sh 'docker push $DOCKER_IMAGE'
                    }
                }
            }
            /*
        stage('Deploy to Remote Server') {
            steps {
                script {
                    echo 'Deploying to remote server'
                    // Commande pour déployer votre projet, par exemple via SCP
                    sh 'scp -r ./target/* user@remote-server:/path/to/deployment'
                }
            }
        }*/
    }
}

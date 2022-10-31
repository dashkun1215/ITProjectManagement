pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat "mvn compile"
                bat "mvn clean package"
            }
            post {
                success {
                    bat 'java -jar target/UIT1-APP.jar'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}

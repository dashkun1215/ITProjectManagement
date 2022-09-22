pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh "mvn compile"
                sh "mvn test"
                junit allowEmptyResults: true, keepLongStdio: true, testResults: 'test-report'
                sh "mvn compile"
                sh "mvn clean package"

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

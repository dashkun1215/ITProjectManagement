pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
//                 git 'https://github.com/dashkun1215/ITProjectManagement.git'
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

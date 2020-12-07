pipeline {
    agent { label 'SweTest || SweTestMac' }
    tools {
        maven 'M3'
    }
    tools {
        maven 'Apache Maven 3.3.9'
//        jdk 'jdk8'
    }
    stages {
        stage ('Build') {
            steps {
                bat 'mvn clean install'
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }
    }
}

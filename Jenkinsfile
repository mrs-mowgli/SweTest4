pipeline {
    agent any
    tools {
        maven 'M3'
    }
    stages {
        stage("build") {
            steps {
                echo 'building the application'
                sh "mvn -B integration-test"
            }
        }

        stage("test") {
            steps {
                echo 'testing the application...'
            }
        }

        stage("deploy") {
            steps{
                echo 'deploying the application...'
            }
        }
    }
    post {
        always {
            echo 'This will always run'
            junit '**/target/surefire-reports/TEST-*.xml'
        }
        success {
            echo 'This will run only if successful'
        }
        failure {
            echo 'This will run only if failed'
        }
        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipeline has changed'
            echo 'For example, if the Pipeline was previously failing but is now successful'
        }
    }
}
pipeline {
    agent { label "SweTest || SweTestMac" }
   
    tools {
        maven "Apache Maven 3.3.9"
    }
    stages {
        stage ("Build") {
         //   steps {
         //       sh "mvn clean install"
         //   }
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

            post {
                success {
                    junit "target/surefire-reports/**/*.xml"
                }
            }
        }
    }
}

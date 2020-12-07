pipeline {
    agent { label "SweTest || SweTestMac" }
   
    tools {
        maven "Apache Maven 3.3.9"
    }
    stages {
        stage ("Build") {
            steps {
                sh "mvn clean install"
            }
            post {
                success {
                    junit "target/surefire-reports/**/*.xml"
                }
            }
        }
    }
}

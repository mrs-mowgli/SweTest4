pipeline {
    
    
    agent {label 'SweTestMac'}

 

    tools {
      maven 'M3'
      
    }
    options { timestamps () }

 

    stages {
        stage("build") {
            steps {

 

                sh "mvn -Dmaven.test.failure.ignore=true clean compile"
            }
        }
 

        stage("deploy") {
            steps {
                echo 'deploying the application...'
                sh "mvn -Dmaven.test.failure.ignore=true clean install"
            }
        }
    }
     post {
        always {
            echo 'This will always run'
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            junit '**/target/surefire-reports/TEST-*.xml'
        }
    
     }
    
    
}

    
  


pipeline {
    
    
    agent {label 'test'}

 

    tools {
      maven 'M3'
      
    }
    options { timestamps () }

// environment {
//    PATH = "C:\\WINDOWS\\SYSTEM32"
}

    //triggers{ cron('H/5 * * * *') }

 

    stages {
        stage("build") {
            steps {

 

                sh "mvn -Dmaven.test.failure.ignore=true clean compile"
            }
        }
 

        stage("deploy") {
            steps {
                echo 'deploying the application...'
                sh "mvn -Dmaven.test.failure.ignore=true install"
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

    
  


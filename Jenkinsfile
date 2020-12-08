pipeline {
    
    agent {label 'test'}

 

    tools {
      maven 'M3'
      
    }
    options { timestamps () }

 

    //triggers{ cron('H/5 * * * *') }

 

    stages {
        stage("build") {
            steps {

 

                bat "mvn -Dmaven.test.failure.ignore=true clean compile"
            }
        }

 

        stage("test") {
            steps {
                echo 'testing the application...'
                bat "mvn -Dmaven.test.failure.ignore=true test"
            }
        }

 
  


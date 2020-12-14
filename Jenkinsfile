
  pipeline {
      environment {
          PATH = "C:\\WINDOWS\\SYSTEM32;C:\\Tools\\Java\\jdk-14.0.2\\bin"
      }
      agent {
          node { label "test" }
      }
      tools {
          maven 'M3'
      }
      options {
            timestamps ()
      }
      stages {
          stage ('Run Jmeter tests') {
             steps {
                  bat 'C:\\Tools\\apache-jmeter-5.4\\bin\\jmeter.bat -Jjmeter.save.saveservice.output_format=xml -n -t C:\\Tools\\Projects\\SweTestPerformance\\TwentyUsers.jmx -l jmeter_report.jtl'
                  perfReport 'jmeter_report.jtl'
             }
          }
          stage ('Build') {
             steps {
                  bat 'mvn clean install'
              }
              post {
                  always {
                      junit 'target/surefire-reports/**/*.xml'
                  }
              }
          }

      }
  }


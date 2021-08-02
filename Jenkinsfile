pipeline {
    agent any
    options {
        ansiColor('xterm')
    }
    stages {
        stage('Test') {
            steps {
                 echo 'Testing..'
                 withGradle {
                    sh './gradlew clean test'
                 }

                 //sh './gradlew test'
                 //archiveArtifacts artifacts: 'build/test-results/test/binary/*.xml'

                 //junit skipPublishingChecks: true, testResults: 'build/test-results/test/TEST-*.xml'

            }
            post {
               aways {
                     junit skipPublishingChecks: true, testResults: 'build/test-results/test/TEST-*.xml'
               }
            }
        }

        stage('Build') {
            steps {
		        sh './gradlew assemble'
		        //sh 'docker-compose build'
            }
            /*post {
        		success {
		        	archiveArtifacts artifacts: 'build/libs/*.jar'
		        }
	        }*/
        }

        stage('Deploy') {
            steps {
                echo 'Deploying....'
                //sh 'docker-compose up -d'
                //sh 'java -jar build/libs/hello-spring-0.0.1-SNAPSHOT.jar'
            }
        }
    }
}

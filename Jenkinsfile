pipeline {
    agent any
    options {
        ansiColor('xterm')
    }
    stages {
        stage('Build') {
            steps {
		        //sh "./gradlew assemble"
		        sh 'docker-compose build'
            }
            /*post {
        		success {
		        	archiveArtifacts artifacts: 'build/libs/*.jar'
		        }
	        }*/
        }

        /*stage('Test') {
            steps {
                echo 'Testing..'
                sh 'java -jar build/libs/hello-spring-0.0.1-SNAPSHOT.jar'
            }
        }*/

        stage('Deploy') {
            steps {
                echo 'Deploying....'
                sh 'docker-compose up -d'
            }
        }
    }
}

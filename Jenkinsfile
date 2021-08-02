pipeline {
    agent any
    options {
        ansiColor('xterm')
    }
    stages {
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

        stage('Test') {
            steps {
                echo 'Testing..'
                sh "./gradlew test"
                junit skipPublishingChecks: true, testResults: 'build/test-results/test/binary/TEST-com.example.hellospring.HelloSpringApplicationTests.xml'

            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying....'
                //sh 'docker-compose up -d'
                sh 'java -jar build/libs/hello-spring-0.0.1-SNAPSHOT.jar'
            }
        }
    }
}

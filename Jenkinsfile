pipeline {
    agent any
    options {
        ansiColor('xterm')
    }
    stages {
        stage('Build .jar') {
            steps {
		sh "./gradlew assemble"

            }
            post {
		success {
			archiveArtifacts artifacts: 'build/libs/*.jar'
		}
	    }
        }

        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'java -jar build/libs/hello-spring-0.0.1-SNAPSHOT.jar'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}

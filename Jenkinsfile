pipeline {
	agent any
	stages {
		stage('git repo & clean') {
			steps{
				bat "rmdir /s /q Automatizacion_Web_Api_Mobile"
                		bat "git clone https://github.com/efsolora/Automatizacion_Web_Api_Mobile"
			}
		}
		stage('test') {
			steps{
				bat "cd C:/ProgramData/Jenkins/.jenkins/workspace/jenk/AutomatizacionWebExito && gradlew clean test aggregate"
				
			}
		}	

	}
}

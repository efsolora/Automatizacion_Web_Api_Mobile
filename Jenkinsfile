pipeline {
	agent any
	stages {
		stage('git repo & clean') {
			steps{
				//sh "rmdir /s /q jenk"
                		sh "git clone https://github.com/efsolora/Automatizacion_Web_Api_Mobile"
			}
		}
		stage('test') {
			steps{
				sh "cd C:/ProgramData/Jenkins/.jenkins/workspace/Automatizacion_Web_Api_Mobile/AutomatizacionWebExito"
				sh "gradlew clean test aggregate"
				
			}
		}	

	}
}

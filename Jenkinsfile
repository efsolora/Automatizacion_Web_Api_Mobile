pipeline {
	agent any
	stages {
		stage('git repo & clean') {
			steps{
				//bat "rmdir /s /q Prueba"
				sh "git clone https://github.com/Jamesmb06/Automatizacion_Web_Api_Mobile.git"
			}
		}
		stage('test') {
			steps{
				sh "cd C:/ProgramData/Jenkins/.jenkins/workspace/RetoExito/Automatizacion_Web_Api_Mobile/AutomatizacionWebExito && gradlew clean test aggregate"
			}
		}	
	}
}

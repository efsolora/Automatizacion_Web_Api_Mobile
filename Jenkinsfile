pipeline {
	agent any
	stages {
		stage('git repo & clean') {
			steps{
				//sh "rmdir /s /q PruebaJenkings"
                		sh "git clone https://github.com/Jamesmb06/Automatizacion_Web_Api_Mobile"
			}
		}
		stage('test') {
			steps{
				sh "cd C:\Users\James\Desktop\Automatizacion_Web_Api_Mobile\AutomatizacionWebExito"
				sh "gradlew clean test aggregate"
				
			}
		}	

	}
}

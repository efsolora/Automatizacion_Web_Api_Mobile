pipeline {
    agent any
    
    stages {
        stage('Clonar Repositorio') {
            steps {
                // Clonar el repositorio
                git 'https://github.com/Jamesmb06/Automatizacion_Web_Api_Mobile.git'
            }
        }
        
        stage('Cambiar al directorio de AutomatizacionWebExito') {
            steps {
                // Cambiar al directorio que contiene el código que queremos probar
                dir('Automatizacion_Web_Api_Mobile/AutomatizacionWebExito') {
                    // Ejecutar el comando gradle clean test
                    sh 'gradle clean test'
                }
            }
        }
    }
}

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
    
    post {
        always {
            // Esta etapa se ejecutará siempre, independientemente del resultado del pipeline.
            // Aquí puedes agregar acciones de limpieza, notificaciones, etc.
        }
        
        success {
            // Esta etapa se ejecutará solo si el pipeline se completa con éxito.
            // Puedes agregar acciones específicas en caso de éxito.
        }
        
        failure {
            // Esta etapa se ejecutará solo si el pipeline falla.
            // Puedes agregar acciones de notificación o manejo de errores.
        }
    }
}
